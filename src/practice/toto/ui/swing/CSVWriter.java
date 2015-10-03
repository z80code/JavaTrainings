package practice.toto.ui.swing;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;

public class CSVWriter implements AutoCloseable{

    private BufferedWriter writer;

    public CSVWriter(Writer writer) {
        this.writer = new BufferedWriter(writer);
    }

    public void writeLine(String ... fields )
            throws IOException {

        if(fields!=null) {

            for(String s: fields) {
                writer.write(s);
                writer.write(";");
            }

            writer.write("\n");
        }
    }

    public void flush() throws IOException {
        writer.flush();
    }



    public void close() throws Exception {
        writer.close();
    }
}
