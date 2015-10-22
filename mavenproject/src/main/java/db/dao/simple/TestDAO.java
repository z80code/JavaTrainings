package db.dao.simple;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TestDAO extends AbstractDAO<Integer, TestEntity> {

    private final String SELECT_QUERY = "select * from test";
    private final String INSERT_QUERY = "insert into test(id, name, number) values(?,?,?) ";
    private final String GET_BY_ID_QUERY = "select * from test where id=?";
    private final String REMOVE_QUERY = "delete from test where id=?";
    private final String UPDATE_QUERY =
            "update test set name=?, number=? where id = ?;";

    public TestDAO() throws SQLException { }

    @Override
    public boolean add(TestEntity entity) {

        boolean isInsert = false;

        try(PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)) {

            statement.setInt(1, entity.getId());
            statement.setString(2, entity.getName());
            statement.setDouble(3, entity.getNumber());

            int countUpdate = statement.executeUpdate();
            if(countUpdate>0) {
                isInsert = true;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return isInsert;
    }

    @Override
    public List<TestEntity> getAll() {

        List<TestEntity> testEntities = new ArrayList<>();

        try(PreparedStatement statement = connection.prepareStatement(SELECT_QUERY)) {
            ResultSet dataSet = statement.executeQuery();

            while (dataSet.next()) {
                int id = dataSet.getInt("Id");
                String name = dataSet.getString("Name");
                double number = dataSet.getDouble("number");

                testEntities.add(new TestEntity(id,name,number));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return testEntities;
    }

    @Override
    public boolean update(TestEntity entity) {
        boolean isUpdate = false;

//        private final String UPDATE_QUERY =
//                "update test(name, number) values(?,?) where id = ?";
        try(PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY)) {

            statement.setString(1, entity.getName());
            statement.setDouble(2, entity.getNumber());
            statement.setInt(3, entity.getId());

            int countUpdate = statement.executeUpdate();
            if(countUpdate>0) {
                isUpdate = true;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return isUpdate;
    }

    @Override
    public boolean remove(TestEntity entity) {

        if(entity==null)
            return false;

        boolean isRemoved = false;

        try(PreparedStatement statement = connection.prepareStatement(REMOVE_QUERY)) {

            statement.setInt(1,entity.getId());

            int countUpdate = statement.executeUpdate();
            if(countUpdate>0) {
                isRemoved = true;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return isRemoved;
    }

    @Override
    public TestEntity get(Integer key) {

        TestEntity testEntity = null;

        try(PreparedStatement statement = connection.prepareStatement(GET_BY_ID_QUERY)) {
            statement.setInt(1,key);

            ResultSet dataSet = statement.executeQuery();

            dataSet.first();
            int id = dataSet.getInt("Id");
            String name = dataSet.getString("Name");
            double number = dataSet.getDouble("number");

            testEntity =  new TestEntity(id,name,number);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return testEntity;

    }

}
