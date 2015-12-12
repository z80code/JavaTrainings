package com.nesterione;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

public class Runner {

    public static void main(String[] args) throws LoaderException, SQLException, ClassNotFoundException {

        ResultDAO resultDAO = new CsvResult("e:/students.csv");
        ResultLoader.loadResults(resultDAO);

    }
}
