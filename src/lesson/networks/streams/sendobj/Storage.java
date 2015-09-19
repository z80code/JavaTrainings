package lesson.networks.streams.sendobj;

import java.io.*;

public class Storage {

    private File file;

    public Storage( String path ) {
        file = new File(path);
    }

    public synchronized void writeRecord( Record record ) {

        try( PrintWriter writer
                     = new PrintWriter(new FileWriter(file, true)) ) {

            writer.println(record);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
