package is.technologies.Repositories.JDBC;

import is.technologies.Entities.StreetEntity;
import is.technologies.Interfaces.Repository;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class StreetRepositoryJDBC implements Repository<StreetEntity> {

    private static final String URL = "jdbc:postgresql://localhost:5432/forjavalab2";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "12345";
    private Connection connection = null;
    public StreetRepositoryJDBC(){
        try{
            Driver driver = new org.postgresql.Driver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public StreetEntity save(StreetEntity entity) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO street(street_id, street_name, postal_code) VALUES (?, ?, ?)");

            preparedStatement.setLong(1, entity.getStreetId());
            preparedStatement.setString(2, entity.getStreetName());
            preparedStatement.setInt(3, entity.getPostalCode());

            preparedStatement.execute();

            return entity;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(long id) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM street WHERE street_id = ?");

            preparedStatement.setLong(1, id);

            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteByEntity(StreetEntity entity) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM street WHERE street_id = ? AND street_name = ? AND postal_code = ?");

            preparedStatement.setLong(1, entity.getStreetId());
            preparedStatement.setString(2, entity.getStreetName());
            preparedStatement.setInt(3, entity.getPostalCode());

            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteAll() {
        try{

            Statement statement = connection.createStatement();

            statement.execute("DELETE FROM street");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public StreetEntity update(StreetEntity entity) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE street SET street_name = ?, postal_code = ? WHERE street_id = ?");


            preparedStatement.setString(1, entity.getStreetName());
            preparedStatement.setInt(2, entity.getPostalCode());
            preparedStatement.setLong(3, entity.getStreetId());

            preparedStatement.execute();

            return entity;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public StreetEntity getById(long id) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM street WHERE street_id = ?");

            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();

            StreetEntity entity = new StreetEntity();
            entity.setStreetId(resultSet.getLong("street_id"));
            entity.setStreetName(resultSet.getString("street_name"));
            entity.setPostalCode(resultSet.getInt("postal_code"));

            return entity;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<StreetEntity> getAll() {
        try{

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM street");

            ArrayList<StreetEntity> streetEntities = new ArrayList<>();

            while(resultSet.next()){
                StreetEntity entity = new StreetEntity();

                entity.setStreetId(resultSet.getLong("street_id"));
                entity.setStreetName(resultSet.getString("street_name"));
                entity.setPostalCode(resultSet.getInt("postal_code"));

                streetEntities.add(entity);
            }

            return  streetEntities;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<StreetEntity> getAllByVId(long id) {
        return null;
    }
}
