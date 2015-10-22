package db.dao.simple;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by igor on 22.10.2015.
 */
public class Run {

    public static void main(String[] args) {

        try(TestDAO test = new TestDAO()) {

//            List<TestEntity> entities = test.getAll();
//
//            for(TestEntity entity :entities) {
//                System.out.println(entity);
//            }

            TestEntity entity =test.get(5);
            entity.setName("QQQQQ");
            entity.setNumber(1111111);
            test.update(entity);
            //test.remove(entity);

            List<TestEntity> entities = test.getAll();

            for(TestEntity e :entities) {
                System.out.println(e);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
