package db.dao;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by igor on 22.10.2015.
 */
public class ClassLevelADAO {
    protected Connector connector;
    public void close() {
        connector.close();

    }

    protected void closeStatement(Statement statement) throws SQLException {
        if(statement!=null) {
            statement.close();
        }
    }
}

class Connector {
    public void close() {}
}
