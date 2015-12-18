package com.nesterione;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Result {
    private String login;
    private String test;
    private Date date;
    private int mark;

    public Result() { }

    public Result(String login, String test, Date date, int mark) {
        this.login = login;
        this.test = test;
        this.date = date;
        this.mark = mark;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
    public String getStringDate() {
        return dateFormat.format(new java.util.Date(date.getTime()));
    }

    @Override
    public String toString() {
        return login + ";" + test + ";" + getStringDate() + ";" + mark;
    }
}
