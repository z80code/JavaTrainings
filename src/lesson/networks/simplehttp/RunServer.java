package lesson.networks.simplehttp;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import jdk.internal.util.xml.impl.Input;
import sun.security.ssl.SSLSocketFactoryImpl;

import javax.imageio.ImageIO;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocketFactory;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class RunServer {

    public static void getQuery(BufferedWriter res) throws IOException {
        System.out.println("get");
        res.write("HTTP/1.1 200 OK\r\n");
        res.write("Date: Mon, 23 May 2005 22:38:34 GMT\r\n");
        res.write("Server: HApache/1.3.3.7 (Unix) (Red-Hat/Linux)\r\n");
        res.write("ETag: \"3f80f-1b6-3e1cb03b\"\r\n");
        res.write("Content-Type: text/html; charset=UTF-8\r\n");
        res.write("Content-Length: 254\r\n");
        res.write("Accept-Ranges: bytes\r\n");
        res.write("Connection: close\r\n");
        res.write("\r\n");
        res.write("<html>\r\n");
        res.write("<head>\r\n");
        res.write(" <title>Median filter</title>\r\n");
        res.write("</head>\r\n");
        res.write("<body>\r\n");
        res.write("d Upload your image\r\n");
        res.write(" <form action=\"/\" enctype=\"multipart/form-data\" method=\"post\">\r\n");
        res.write(" <input type=\"file\" name=\"myimg\"></input>\r\n");
        res.write(" <input type=\"submit\" > </input>\r\n");
        res.write(" </form>\r\n");
        res.write("</body>\r\n");
        res.write("</html>\r\n");
    }


    /**
     * Structure query
     * POST / HTTP/1.1
     * Host: localhost:8882
     * Connection: keep-alive
     * Content-Length: 125423
     * Cache-Control: max-age=0
     * Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*//*;q=0.8
     * Origin: http://localhost:8882
     * Upgrade-Insecure-Requests: 1
     * User-Agent: Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.101 Safari/537.36
     * Content-Type: multipart/form-data; boundary=----WebKitFormBoundaryDbG5nXgbTXl557xn
     * Referer: http://localhost:8882/
     * Accept-Encoding: gzip, deflate
     * Accept-Language: ru-RU,ru;q=0.8,en-US;q=0.6,en;q=0.4
     * Cookie: _ga=GA1.1.455496043.1440249132
     *  ------WebKitFormBoundaryDbG5nXgbTXl557xn
     * Content-Disposition: form-data; name="myimg"; filename="15622402-Set-of-icons-for-markers-on-maps-Stock-Photo-icons-icon-map.jpg"
     * Content-Type: image/jpeg
     * <empty row>
     * <binary data>
     * ------WebKitFormBoundaryDbG5nXgbTXl557xn--
     *
     * @param headers
     * @param req
     * @param res
     * @throws IOException
     */
    public static void postQuery(List<String> headers, InputStream req, OutputStream res) throws IOException {

        String boundary = null;
        for(String h: headers) {
            if(h.contains("Content-Type: multipart/form-data")) {
                //Content-Type: multipart/form-data; boundary=----WebKitFormBoundaryDbG5nXgbTXl557xn
                boundary = h.trim().split("boundary=")[1];
            }
        }
        System.out.println("find boundary! :"+boundary);
        if(boundary==null) {
            res.write(notFoundResponse().getBytes());
            System.out.println("Bad request");
            return;
        }

        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();

        //--boundary--
        boolean isReading = true;
        while ( isReading ) {

            arrayOutputStream.reset();
            readLineBytes(arrayOutputStream, req);
            String s = arrayOutputStream.toString();

            if(s.equals("--"+boundary+"--")) {
                isReading = false;
                continue;
            }

            System.out.println(">>>>"+s);
            // if true, start image data
            if(s.trim().isEmpty()) {


                byte[] data = readImage(req, boundary);
                System.out.println("try save image");
                // convert byte array back to BufferedImage
                InputStream in = new ByteArrayInputStream(data);
                BufferedImage bImageFromConvert = ImageIO.read(in);
                //ImageIO.write(bImageFromConvert, "png", new File("D:/new_dark_souls.png"));

                Filter.medianFilter(bImageFromConvert);


                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ImageIO.write( bImageFromConvert, "jpg", baos );
                baos.flush();
                byte[] imageInByte = baos.toByteArray();
                baos.close();

                res.write("HTTP/1.1 200 OK\r\n".getBytes());
                res.write("Date: Mon, 23 May 2005 22:38:34 GMT\r\n".getBytes());
                res.write("Server: HApache/1.3.3.7 (Unix) (Red-Hat/Linux)\r\n".getBytes());
                res.write("Content-Type: image/jpg\r\n".getBytes());
                res.write("Content-Disposition: attachment; filename=home.jpg\r\n".getBytes());
                res.write(String.format("Content-Length: %d\r\n",imageInByte.length).getBytes());
                res.write("Accept-Ranges: bytes\r\n".getBytes());
                res.write("Connection: close\r\n".getBytes());
                res.write("\r\n".getBytes());
                res.write(imageInByte);

               // end receiving
               break;
            }
        }
    }

    /**
     * Not miss \n
     * @param outputStream
     * @param in
     * @throws IOException
     */
    public static void readLineBytes(ByteArrayOutputStream outputStream, InputStream in) throws IOException {
        int c;
        while ( (c = in.read())!='\n' && c!=-1 ) {
            outputStream.write(c);
        }
        outputStream.write('\n');
    }

    public static byte[]  readImage(InputStream req, String boundary ) throws IOException {

        System.out.println("start read image");

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ByteArrayOutputStream tempForString = new ByteArrayOutputStream();

        boolean isReading = true;
        while ( isReading) {
            tempForString.reset();
            readLineBytes(tempForString, req);

            if(tempForString.toString().trim().equals("--" + boundary + "--") ) {
                isReading = false;
                continue;
            }

            outputStream.write(tempForString.toByteArray());
        }

        System.out.println("end read image");
        return outputStream.toByteArray();
    }

    public static String notFoundResponse() {

        String msg = "Command not found";
        StringBuilder sb = new StringBuilder();
        sb.append("HTTP/1.1 404 NotFound\r\n");
        sb.append("Server: HApache/1.3.3.7 (Unix) (Red-Hat/Linux)\r\n");
        sb.append("ETag: \"3f80f-1b6-3e1cb03b\"\r\n");
        sb.append("Content-Type: text/html; charset=UTF-8\r\n");
        sb.append( String.format("Content-Length: %d\r\n", msg.length()) );
        sb.append("Accept-Ranges: bytes\r\n");
        sb.append("Connection: close\r\n");
        sb.append("\r\n");
        sb.append(msg);

        return sb.toString();
    }

    // send attachment files
    public static void postQueryImage(BufferedReader req, OutputStream res) throws IOException {

        FileInputStream stream = new FileInputStream("src/lesson/networks/simplehttp/testImg.jpg");
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        int b =0;
        while ( (b=stream.read())!=-1 ) {
            output.write(b);
        }

        res.write("HTTP/1.1 200 OK\r\n".getBytes());
        res.write("Date: Mon, 23 May 2005 22:38:34 GMT\r\n".getBytes());
        res.write("Server: HApache/1.3.3.7 (Unix) (Red-Hat/Linux)\r\n".getBytes());
        res.write("Content-Type: image/jpg\r\n".getBytes());
        res.write("Content-Disposition: attachment; filename=home.jpg\r\n".getBytes());
        res.write(String.format("Content-Length: %d\r\n",output.size()).getBytes());
        res.write("Accept-Ranges: bytes\r\n".getBytes());
        res.write("Connection: close\r\n".getBytes());
        res.write("\r\n".getBytes());
        res.write(output.toByteArray());
    }

    public static List<String> getHeaders(InputStream in) throws IOException {
        List<String> headers = new ArrayList<>();

        ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();

        while (true) {

            byteOutputStream.reset();
            readLineBytes(byteOutputStream, in);

            String s = byteOutputStream.toString().trim();
            System.out.println(">>" + s);

            if (s.isEmpty()) {
                break;
            }

            headers.add(s);
        }

        return headers;
    }

    public static void main(String[] args) {

        int port = 8882;
        try (ServerSocket serverSocket = new ServerSocket(port)) {

            System.out.println("server have started on port: " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New user connect");


                List<String> headers = getHeaders(clientSocket.getInputStream());

                for(String h: headers) {
                    System.out.println(h);
                }

                String queryType = headers.get(0).trim().split(" ")[0];
                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

                switch (queryType) {
                    case "GET":
                        getQuery(out);
                        break;
                    case "POST":
                        postQuery(headers,clientSocket.getInputStream(),clientSocket.getOutputStream());
                        //postQueryImage(in, clientSocket.getOutputStream());
                        break;
                    default:
                        break;
                }

                out.close();
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
