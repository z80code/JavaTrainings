package com.nesterione;

import java.io.*;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class CsvResult implements ResultDAO, AutoCloseable {

    private final static String DATE_FORMANT = "dd.MM.yyyy";

    private final BufferedReader reader;
    private String current;
    private SimpleDateFormat dateFormant;

    public CsvResult(String path, boolean isSkipHeaders) throws LoaderException {

        try {
            reader = new BufferedReader(new FileReader(path));
            dateFormant = new SimpleDateFormat(DATE_FORMANT);

            if (isSkipHeaders) {
                next();
            }
            next();

        } catch (IOException e ) {
            throw new LoaderException(e);
        }
    }


    public CsvResult(String path) throws LoaderException {
        this(path,true);
    }

    /**
     * @return return next Result object or null if results end
     */
    public Result nextResult() throws LoaderException {
        Result result = parseResult(current);
        next();
        return result;
    }

    public boolean hasResult() {
        return (current!=null);
    }

    private void next() throws LoaderException {
        try {
            current = reader.readLine();
        } catch (IOException e) {
            throw new LoaderException(e);
        }
    }

    private Result parseResult(String line) throws LoaderException {

        String[] columns = line.split(";");
        Result result = null;

        try {

            if(columns.length!=4) {
                // TODO better to create other type exception
                throw new Exception("Invalid count of columns");
            }

            String login = columns[0].trim();
            String test = columns[1].trim();

            java.util.Date dateValue = dateFormant.parse(columns[2].trim());
            Date date = new Date(dateValue.getTime());

            int mark = Integer.parseInt(columns[3].trim());

            result = new Result(login, test, date, mark);

        } catch (Exception e) {
            throw new LoaderException(e);
        }

        return result;
    }

    public void close() {

        if(reader!=null) {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
