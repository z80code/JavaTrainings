package com.nesterione;

import java.sql.Date;

/**
 * Created by igor on 12.12.2015.
 */
public class DecimalResult extends Result {

    public DecimalResult() {
    }

    public DecimalResult(String login, String test, Date date, int mark) {
        super(login, test, date, mark);
    }

    @Override
    public String toString() {
        return getLogin() + ";" + getTest() + ";" + getStringDate() + ";" + getMark()/10 + "." + getMark()%10;
    }

}
