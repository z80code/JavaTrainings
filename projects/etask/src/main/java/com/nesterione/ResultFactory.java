package com.nesterione;

import java.sql.Date;

public class ResultFactory {

    public Result getResultFromFactory(String login, String test, Date date, int mark){
        return new Result(login, test, date, mark);
    }

}
