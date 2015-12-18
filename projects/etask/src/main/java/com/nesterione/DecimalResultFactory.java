package com.nesterione;

import java.sql.Date;

/**
 * Created by igor on 12.12.2015.
 */
public class DecimalResultFactory extends ResultFactory {

    public Result getResultFromFactory(String login, String test, Date date, int mark){
        return new DecimalResult(login, test, date, mark);
    }

}
