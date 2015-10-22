package db.dao.simple;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public abstract class AbstractDAO<K, E> implements AutoCloseable {

    protected Connection connection;

    public AbstractDAO() throws SQLException {
        ResourceBundle resource = ResourceBundle.getBundle("database");
        String url = resource.getString("db.url");
        String user = resource.getString("db.user");
        String password = resource.getString("db.password");
        connection = DriverManager.getConnection(url,user,password);
    }

    public abstract boolean add(E entity);
    public abstract boolean update(E entity);
    public abstract boolean remove(E entity);
    public abstract E get(K key);
    public abstract List<E> getAll();

    @Override
    public void close() throws Exception {
        if(connection!=null) {
            connection.close();
        }
    }

}
