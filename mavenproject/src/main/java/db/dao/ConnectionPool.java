package db.dao;

import org.h2.jdbcx.JdbcConnectionPool;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPool {

    public static void main(String[] args) throws SQLException {
        JdbcConnectionPool cp = JdbcConnectionPool.
                create("jdbc:h2:~/test", "sa", "sa");
        Connection conn = cp.getConnection();

        conn.close();
        cp.dispose();
    }
}
