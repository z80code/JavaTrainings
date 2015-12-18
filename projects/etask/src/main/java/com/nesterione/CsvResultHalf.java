package com.nesterione;

public class CsvResultHalf extends CsvResult {

    public CsvResultHalf(String path, boolean isSkipHeaders) throws LoaderException {
        super(path, isSkipHeaders);
    }

    public CsvResultHalf(String path) throws LoaderException {
        super(path);
    }


//    public HalfResult nextResult() throws LoaderException {
//        return super.nextResult();
//    }
}
