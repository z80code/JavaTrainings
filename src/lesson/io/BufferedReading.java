package lesson.io;


import java.io.*;

public class BufferedReading {

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {

//        FileInputStream inputStream = new FileInputStream("file.txt");
//        InputStreamReader inputStreamReader = new InputStreamReader(inputStream,"UTF-8");
//        Reader reader= new BufferedReader(inputStreamReader);

        try(BufferedReader reader = new BufferedReader(new FileReader("src/lesson.io/file.txt"));) {

            StringBuilder stringBuilder = new StringBuilder();
            String s;

            while ( (s = reader.readLine()) != null) {
                stringBuilder.append(s+"\n");
            }
            System.out.println(stringBuilder);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
