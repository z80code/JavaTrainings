package lesson.networks.simplehttp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class RunServer {

    public static void main(String[] args) {
        int port = 8882;

        try (ServerSocket serverSocket = new ServerSocket(port)) {

            System.out.println("server have raned. Port: " + port);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New user connect");
                //BufferedReader in = new BufferedReader(new InputStreamReader(
                //        clientSocket.getInputStream()));
                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
                        clientSocket.getOutputStream()));
                //String s;


                ByteArrayOutputStream stream  = new ByteArrayOutputStream();

                BufferedReader in =  new BufferedReader( new InputStreamReader(clientSocket.getInputStream()));

                // Read headers

                StringBuilder header = new StringBuilder();
                String s=null;
                while ((s = in.readLine())!=null) {
                    if (s.isEmpty()) {
                        break;
                    }
                    header.append(s);
                }

                String head = header.toString();
                System.out.println(header);

                if(head.startsWith("POST")) {
                    System.out.println("PPPPPPPPPPPPPPPOOOOOOOOOOSSSSSSSTTTTTTTTTTT");
                }

                System.out.println("end recv header ");

                //s.getBytes("ASCII");
                //ASCII
                //
                //
                //


                //new String(b, "US-ASCII");


                // answer
                System.out.println("************");

                System.out.println("Begin response");
                out.write("HTTP/1.1 200 OK\r\n");
                out.write("Date: Mon, 23 May 2005 22:38:34 GMT\r\n");
                out.write("Server: HApache/1.3.3.7 (Unix) (Red-Hat/Linux)\r\n");
                // out.write("Last-Modified: Wed, 08 Jan 2003 23:11:55 GMT\r\n");
                out.write("ETag: \"3f80f-1b6-3e1cb03b\"\r\n");
                out.write("Content-Type: text/html; charset=UTF-8\r\n");
                out.write("Content-Length: 320\r\n");
                out.write("Accept-Ranges: bytes\r\n");
                out.write("Connection: close\r\n");
                out.write("\r\n");
                out.write("<html>\r\n");
                out.write("<head>\r\n");
                out.write(" <title>An Example Page</title>\r\n");
                out.write("</head>\r\n");
                out.write("<body>\r\n");
                out.write("d Hello World, this is a very simple HTML document.\r\n");
                out.write("d Hello World, this is a very simple HTML document.\r\n");
                out.write(" <form action=\"/\" enctype=\"multipart/form-data\" method=\"post\">\r\n");
                out.write(" <input type=\"file\" name=\"myimg\"></input>\r\n");
                out.write(" <input type=\"submit\" > </input>\r\n");
                out.write(" </form>\r\n");
                out.write("</body>\r\n");
                out.write("</html>\r\n");


                System.out.println("End response");


                out.close();
                in.close();
                clientSocket.close();
                System.out.println("----------------------------------");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
