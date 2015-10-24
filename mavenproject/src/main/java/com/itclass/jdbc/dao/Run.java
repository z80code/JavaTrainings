package com.itclass.jdbc.dao;

import java.sql.SQLException;
import java.util.List;

public class Run {

    public static void main(String[] args) {

        try( TestDAO testDAO = new TestDAO()){

           // TestEntity ent = testDAO.get(454);
           // System.out.println(ent);

            //TestEntity newEntity = new TestEntity("WWWW", 222);

            // boolean f = testDAO.insert(newEntity);
            //boolean f = testDAO.delete(4);
            //System.out.println(f);

            TestEntity ent = testDAO.get(794);

            ent.setName("WWW");
            ent.setNumber(111111111);

            testDAO.update(ent);

            List<TestEntity> entities = testDAO.getAll();

            for(TestEntity entity: entities) {
                System.out.println(entity);
            }

            // google guava

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
