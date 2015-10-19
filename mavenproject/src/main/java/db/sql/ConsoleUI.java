package db.sql;

import java.sql.SQLException;
import java.util.List;

public class ConsoleUI {

    public static void main(String[] args) throws SQLException {


        TestTable testTable = new TestTable();

        List<User> users = testTable.getAll();

        for(User user: users) {
            System.out.println(user);
        }


    }

}
