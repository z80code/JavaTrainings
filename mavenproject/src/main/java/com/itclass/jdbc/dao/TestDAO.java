package com.itclass.jdbc.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestDAO extends AbstractDAO<TestEntity> {

    private final String SELECT_QUERY = "select * from test";
    private final String INSERT_QUERY =
            "insert into test(name, number) values(?,?)";
    private final String DELETE_QUERY = "delete from test where id = ?";

    private final String UPDATE_QUERY =
            "update test set name=?, number=? where id=?";

    private final String GET_BY_ID_QUERY =
            "select * from test where id = ?";

    public TestDAO() throws SQLException {
    }

    @Override
    public List<TestEntity> getAll() {

        List<TestEntity> entities = new ArrayList<>();

        try(PreparedStatement statement
                    = connection.prepareStatement(SELECT_QUERY)) {

            ResultSet dataSet = statement.executeQuery();
            while (dataSet.next()) {
                int id = dataSet.getInt("id");
                String text = dataSet.getString("name");
                double number = dataSet.getDouble("number");

                TestEntity entity = new TestEntity(id,text, number);
                entities.add(entity);
            }
        } catch (SQLException e) {
            // log
            e.printStackTrace();
        }

        return entities;
    }

    @Override
    public TestEntity get(int id) {

        TestEntity entity = null;

        try(PreparedStatement statement
                    = connection.prepareStatement(GET_BY_ID_QUERY)) {

            statement.setInt(1,id);

            ResultSet dataSet = statement.executeQuery();

            // exception
            dataSet.first();

            int entityId = dataSet.getInt("id");
            String text = dataSet.getString("name");
            double number = dataSet.getDouble("number");

            entity = new TestEntity(entityId,text, number);

        } catch (SQLException e) {
            // log
            e.printStackTrace();
        }

        return entity;
    }

    @Override
    public boolean delete(int id) {

        boolean isDelete = false;
        try(PreparedStatement statement
                    = connection.prepareStatement(DELETE_QUERY)) {

            statement.setInt(1,id);

            if(statement.executeUpdate()!=0) {
                isDelete = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isDelete;
    }

    @Override
    public boolean update(TestEntity entity) {

        boolean isUpdate = false;
        try(PreparedStatement statement
                    = connection.prepareStatement(UPDATE_QUERY)) {

            statement.setString(1, entity.getName());
            statement.setDouble(2, entity.getNumber());

            statement.setInt(3, entity.getId());

            if(statement.executeUpdate()!=0) {
                isUpdate = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isUpdate;

    }

    @Override
    public boolean insert(TestEntity entity) {

        boolean isInsert = false;
        try(PreparedStatement statement
                    = connection.prepareStatement(INSERT_QUERY)) {

            statement.setString(1, entity.getName());
            statement.setDouble(2, entity.getNumber());

            if(statement.executeUpdate()!=0) {
                isInsert = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isInsert;
    }

}
