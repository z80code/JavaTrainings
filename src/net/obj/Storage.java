package net.obj;

import com.sun.javaws.exceptions.InvalidArgumentException;

import java.io.*;

public class Storage {

    File file;
    public Storage(String path) {
        file = new File(path);
        // if(!file.exists())
        //    throw new IllegalArgumentException("File not found");
    }

    public synchronized void writeRecord(Record record) throws FileNotFoundException {

        try( PrintWriter writer = new PrintWriter(
              new FileOutputStream(file,true)
        )
        ) {
            writer.println(record);
        }
    }

}
