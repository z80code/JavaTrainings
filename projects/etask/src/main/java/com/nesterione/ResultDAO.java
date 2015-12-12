package com.nesterione;

import java.io.IOException;
import java.text.ParseException;

public interface ResultDAO {
    Result nextResult() throws LoaderException;
    boolean hasResult();
    void close();
}
