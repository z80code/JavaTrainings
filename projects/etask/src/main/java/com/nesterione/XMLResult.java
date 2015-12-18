package com.nesterione;

public class XMLResult implements ResultDAO, AutoCloseable {
    @Override
    public DecimalResult nextResult() throws LoaderException {
        return null;
    }

    @Override
    public boolean hasResult() {
        return false;
    }

    @Override
    public void close() {

    }
}
