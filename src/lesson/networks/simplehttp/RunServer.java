package lesson.networks.simplehttp;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class RunServer {

    public static void getQuery(BufferedReader req, BufferedWriter res) throws IOException {
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

    public static void postQuery(BufferedReader req, BufferedWriter res) throws IOException {

        String s = null;
        while (  (s = req.readLine())!=null) {
            System.out.println(s);
        }




        /*res.write("HTTP/1.1 200 OK\r\n");
        res.write("Date: Mon, 23 May 2005 22:38:34 GMT\r\n");
        res.write("Server: HApache/1.3.3.7 (Unix) (Red-Hat/Linux)\r\n");
        res.write("ETag: \"3f80f-1b6-3e1cb03b\"\r\n");
        res.write("Content-Type: text/xml;charset=UTF-8\r\n");
        res.write("Content-Disposition: attachment; filename=FILENAME\r\n");
        res.write("Content-Length: 452\r\n");
        res.write("Accept-Ranges: bytes\r\n");
        res.write("Connection: close\r\n");
        res.write("\r\n");
        res.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n");
        res.write("<quiz>\n\r\n");
        res.write("<question type=\"category\">\r\n");
        res.write("    <category>\r\n");
        res.write("        <text>$course$/df</text>\r\n");
        res.write("    </category>\r\n");
        res.write("</question>\r\n");
        res.write("</quiz>\n\r\n");
        //ByteArrayOutputStream stream  = new ByteArrayOutputStream();*/

        //s.getBytes("ASCII");
        //ASCII
        //
        //
        //


        //new String(b, "US-ASCII");

    }

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

        /*byte[] bytes = output.toByteArray();
        for(Byte bt:bytes) {
            res.write(bt);
        }*/


        //res.write(imgText);
        //ByteArrayOutputStream stream  = new ByteArrayOutputStream();

        //s.getBytes("ASCII");
        //ASCII
        //
        //
        //


        //new String(b, "US-ASCII");

    }

    public static void main(String[] args) {

        int port = 8882;

        try (ServerSocket serverSocket = new ServerSocket(port)) {

            System.out.println("server have raned. Port: " + port);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New user connect");

                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                StringBuilder header = new StringBuilder();
                String s = null;
                while ((s = in.readLine()) != null) {
                    if (s.isEmpty()) {
                        break;
                    }
                    header.append(s).append("\n");
                }

                String head = header.toString();
                System.out.println(header);

                if (head.startsWith("GET")) {
                    getQuery(in, out);
                } else if (head.startsWith("POST")) {
                    postQuery(in,out);
                    //postQueryImage(in, clientSocket.getOutputStream());
                }

                out.close();
                in.close();
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
