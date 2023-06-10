package is.technologies.Interfaces.Mappers;

import is.technologies.Entities.HouseEntity;
import is.technologies.Entities.StreetEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface HouseMapper {
    @Insert("INSERT INTO house(house_id, house_name, date_of_construction, number_of_floors, house_type, street) VALUES (#{houseId}, #{houseName}, #{dateOfConstruction}, #{numberOfFloors}, #{houseType}, #{street.streetId})")
    void save(HouseEntity entity);

    @Delete("DELETE FROM house WHERE house_id = #{id}")
    void deleteById(long id);

    @Delete("DELETE FROM house WHERE house_id = #{houseId} AND house_name = #{houseName} AND date_of_construction = #{dateOfConstruction} AND number_of_floors = #{numberOfFloors} AND house_type = #{houseType} AND street = #{street.streetId}")
    void deleteByEntity(HouseEntity entity);

    @Delete("DELETE FROM house")
    void deleteAll();

    @Update("UPDATE house SET house_name = #{houseName}, date_of_construction = #{dateOfConstruction}, number_of_floors = #{numberOfFloors}, house_type = #{houseType}, street = #{street.streetId} WHERE house_id = #{houseId}")
    void update(HouseEntity entity);

    @Select("SELECT * FROM house WHERE house_id = #{id}")
    @Results(value = {
            @Result(property = "houseId", column = "house_id"),
            @Result(property="houseName", column = "house_name"),
            @Result(property = "dateOfConstruction", column = "date_of_construction"),
            @Result(property = "numberOfFloors", column = "number_of_floors"),
            @Result(property = "houseType", column = "house_type"),
            @Result(property = "street", column = "street",
                    javaType = StreetEntity.class,
                    one = @One(select = "Interfaces.Mappers.StreetMapper.getById"))
    })
    HouseEntity getById(long id);

    @Select("SELECT * FROM house")
    @Results(value = {
            @Result(property = "houseId", column = "house_id"),
            @Result(property="houseName", column = "house_name"),
            @Result(property = "dateOfConstruction", column = "date_of_construction"),
            @Result(property = "numberOfFloors", column = "number_of_floors"),
            @Result(property = "houseType", column = "house_type"),
            @Result(property = "street", column = "street",
                    javaType = StreetEntity.class,
                    one = @One(select = "Interfaces.Mappers.StreetMapper.getById"))
    })
    List<HouseEntity> getAll();

    @Select("SELECT * FROM house WHERE street = #{id}")
    @Results(value = {
            @Result(property = "houseId", column = "house_id"),
            @Result(property="houseName", column = "house_name"),
            @Result(property = "dateOfConstruction", column = "date_of_construction"),
            @Result(property = "numberOfFloors", column = "number_of_floors"),
            @Result(property = "houseType", column = "house_type"),
            @Result(property = "street", column = "street",
                    javaType = StreetEntity.class,
                    one = @One(select = "Interfaces.Mappers.StreetMapper.getById"))
    })
    public List<HouseEntity> getAllByVId(long id);
}
