package web;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpGet {

    public static void main(String[] args) {
        //Image img;
        BufferedImage img= null;
        try {
            URL url = new URL("http://content.onliner.by/widget/catalog/popularsections/1x2/62a49e2565ce4acc275e480293ae598c.png");
            img = ImageIO.read(url);
        } catch (IOException e) {
        }

        JFrame frame = new JFrame("FrameDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new Label(), BorderLayout.CENTER);
        JLabel picLabel = new JLabel(new ImageIcon( img ));
        frame.add(picLabel);
        frame.pack();
        frame.setVisible(true);
    }

    public static String getHTML(String urlString) {
        URL url;
        HttpURLConnection connection;
        BufferedReader reader;
        String result="";
        String line="";
        try {
            url = new URL(urlString);
            connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while ((line=reader.readLine())!=null) {

                result +=line+"\n";
            }
            reader.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static void saveImage(String imageUrl, String destinationFile) throws IOException {
        URL url = new URL(imageUrl);
        InputStream is = url.openStream();
        OutputStream os = new FileOutputStream(destinationFile);

        byte[] b = new byte[2048];
        int length;

        while ((length = is.read(b)) != -1) {
            os.write(b, 0, length);
        }

        is.close();
        os.close();
    }
}


