package is.technologies.Repositories.JDBC;

import is.technologies.Entities.HouseEntity;
import is.technologies.Entities.StreetEntity;
import is.technologies.Interfaces.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HouseRepositoryJDBC implements Repository<HouseEntity> {
    private static final String URL = "jdbc:postgresql://localhost:5432/forjavalab2";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "12345";
    private Connection connection = null;
    public HouseRepositoryJDBC(){
        try{
            Driver driver = new org.postgresql.Driver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public HouseEntity save(HouseEntity entity) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO house(house_id, house_name, date_of_construction, number_of_floors, house_type, street) VALUES (?, ?, ?, ?, ?, ?)");

            preparedStatement.setLong(1, entity.getHouseId());
            preparedStatement.setString(2, entity.getHouseName());
            preparedStatement.setDate(3, entity.getDateOfConstruction());
            preparedStatement.setInt(4, entity.getNumberOfFloors());
            preparedStatement.setString(5, entity.getHouseType());
            preparedStatement.setLong(6, entity.getStreet().getStreetId());

            preparedStatement.execute();

            return entity;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(long id) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM house WHERE house_id = ?");

            preparedStatement.setLong(1, id);

            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteByEntity(HouseEntity entity) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM house WHERE house_id = ? AND house_name = ? AND date_of_construction = ? AND number_of_floors = ? AND house_type = ? AND street = ?");

            preparedStatement.setLong(1, entity.getHouseId());
            preparedStatement.setString(2, entity.getHouseName());
            preparedStatement.setDate(3, entity.getDateOfConstruction());
            preparedStatement.setInt(4, entity.getNumberOfFloors());
            preparedStatement.setString(5, entity.getHouseType());
            preparedStatement.setLong(6, entity.getStreet().getStreetId());

            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteAll() {
        try{

            Statement statement = connection.createStatement();

            statement.execute("DELETE FROM house");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public HouseEntity update(HouseEntity entity) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE house SET house_name = ?, date_of_construction = ?, number_of_floors = ?, house_type = ?, street = ? WHERE house_id = ?");


            preparedStatement.setString(1, entity.getHouseName());
            preparedStatement.setDate(2, entity.getDateOfConstruction());
            preparedStatement.setInt(3, entity.getNumberOfFloors());
            preparedStatement.setString(4, entity.getHouseType());
            preparedStatement.setLong(5, entity.getStreet().getStreetId());
            preparedStatement.setLong(6, entity.getHouseId());

            preparedStatement.execute();

            return entity;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public HouseEntity getById(long id) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM house WHERE house_id = ?");

            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();

            HouseEntity houseEntity = new HouseEntity();

            houseEntity.setHouseId(resultSet.getLong("house_id"));
            houseEntity.setHouseName(resultSet.getString("house_name"));
            houseEntity.setDateOfConstruction(resultSet.getDate("date_of_construction"));
            houseEntity.setNumberOfFloors(resultSet.getInt("number_of_floors"));
            houseEntity.setHouseType(resultSet.getString("house_type"));

            PreparedStatement preparedStatement2 = connection.prepareStatement("SELECT * FROM street WHERE street_id = ?");
            preparedStatement2.setLong(1, resultSet.getLong("street"));

            ResultSet resultSet2 = preparedStatement2.executeQuery();
            resultSet2.next();

            StreetEntity streetEntity = new StreetEntity();

            streetEntity.setStreetId(resultSet2.getLong("street_id"));
            streetEntity.setStreetName(resultSet2.getString("street_name"));
            streetEntity.setPostalCode(resultSet2.getInt("postal_code"));

            houseEntity.setStreet(streetEntity);

            return houseEntity;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<HouseEntity> getAll() {
        try{

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM house");

            ArrayList<HouseEntity> houseEntities = new ArrayList<>();

            while(resultSet.next()){
                HouseEntity houseEntity = new HouseEntity();

                houseEntity.setHouseId(resultSet.getLong("house_id"));
                houseEntity.setHouseName(resultSet.getString("house_name"));
                houseEntity.setDateOfConstruction(resultSet.getDate("date_of_construction"));
                houseEntity.setNumberOfFloors(resultSet.getInt("number_of_floors"));
                houseEntity.setHouseType(resultSet.getString("house_type"));

                PreparedStatement preparedStatement2 = connection.prepareStatement("SELECT * FROM street WHERE street_id = ?");
                preparedStatement2.setLong(1, resultSet.getLong("street"));

                ResultSet resultSet2 = preparedStatement2.executeQuery();
                resultSet2.next();

                StreetEntity streetEntity = new StreetEntity();

                streetEntity.setStreetId(resultSet2.getLong("street_id"));
                streetEntity.setStreetName(resultSet2.getString("street_name"));
                streetEntity.setPostalCode(resultSet2.getInt("postal_code"));

                houseEntity.setStreet(streetEntity);

                houseEntities.add(houseEntity);
            }

            return  houseEntities;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<HouseEntity> getAllByVId(long id) {
        try{

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM house WHERE street = ?");

            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            ArrayList<HouseEntity> houseEntities = new ArrayList<>();

            while(resultSet.next()){
                HouseEntity houseEntity = new HouseEntity();

                houseEntity.setHouseId(resultSet.getLong("house_id"));
                houseEntity.setHouseName(resultSet.getString("house_name"));
                houseEntity.setDateOfConstruction(resultSet.getDate("date_of_construction"));
                houseEntity.setNumberOfFloors(resultSet.getInt("number_of_floors"));
                houseEntity.setHouseType(resultSet.getString("house_type"));

                PreparedStatement preparedStatement2 = connection.prepareStatement("SELECT * FROM street WHERE street_id = ?");
                preparedStatement2.setLong(1, resultSet.getLong("street"));

                ResultSet resultSet2 = preparedStatement2.executeQuery();
                resultSet2.next();

                StreetEntity streetEntity = new StreetEntity();

                streetEntity.setStreetId(resultSet2.getLong("street_id"));
                streetEntity.setStreetName(resultSet2.getString("street_name"));
                streetEntity.setPostalCode(resultSet2.getInt("postal_code"));

                houseEntity.setStreet(streetEntity);

                houseEntities.add(houseEntity);
            }

            return  houseEntities;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
