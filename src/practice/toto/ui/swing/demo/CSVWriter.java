package practice.toto.ui.swing.demo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;

public class CSVWriter implements AutoCloseable{

    final BufferedWriter writer;

    public CSVWriter(Writer out) {
        writer = new BufferedWriter(out);
    }

    public void writeLine(String ... fields) throws IOException {

        for(String s: fields) {
            writer.write(s);
            writer.write(";");
        }
        writer.newLine();
    }

    public void flush() throws IOException {
        writer.flush();
    }

    public void close() throws IOException {
        writer.close();
    }
}
