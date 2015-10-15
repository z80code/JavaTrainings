package com.itclass.jdbc.form;

import java.sql.SQLException;
import java.util.List;

public class UI {

    public static void main(String[] args)  {

       try {
           TestTable testTable = new TestTable();
           List<RecordEntity> records = testTable.getAll();

           for (RecordEntity entity : records) {
               System.out.println(entity);
           }
       } catch (SQLException ex) {
           System.out.println("Подключение не установлено: "+ex.getMessage());
       }

    }
}
