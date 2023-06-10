package is.technologies.Interfaces.Mappers;

import is.technologies.Entities.StreetEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface StreetMapper {
    @Insert("INSERT INTO street(street_id, street_name, postal_code) VALUES (#{streetId}, #{streetName}, #{postalCode})")
    void save(StreetEntity entity);

    @Delete("DELETE FROM street WHERE street_id = #{id}")
    void deleteById(long id);

    @Delete("DELETE FROM street WHERE street_id = #{streetId} AND street_name = #{streetName} AND postal_code = #{postalCode}")
    void deleteByEntity(StreetEntity entity);

    @Delete("DELETE FROM street")
    void deleteAll();

    @Update("UPDATE street SET street_name = #{streetName}, postal_code = #{postalCode} WHERE street_id = #{streetId}")
    void update(StreetEntity entity);

    @Select("SELECT * FROM street WHERE street_id = #{id}")
    @Results(value = {
            @Result(property = "streetId", column = "street_id"),
            @Result(property="streetName", column = "street_name"),
            @Result(property = "postalCode", column = "postal_code")
    })
    StreetEntity getById(long id);

    @Select("SELECT * FROM street")
    @Results(value = {
            @Result(property = "streetId", column = "street_id"),
            @Result(property="streetName", column = "street_name"),
            @Result(property = "postalCode", column = "postal_code")
    })
    List<StreetEntity> getAll();

}
