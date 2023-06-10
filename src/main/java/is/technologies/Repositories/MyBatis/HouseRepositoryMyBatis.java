package is.technologies.Repositories.MyBatis;

import is.technologies.Interfaces.Mappers.HouseMapper;
import is.technologies.Entities.HouseEntity;
import is.technologies.Interfaces.Repository;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class HouseRepositoryMyBatis implements Repository<HouseEntity> {

    private SqlSession session = null;
    private HouseMapper houseMapper = null;

    public HouseRepositoryMyBatis() {
        SqlSessionFactory sqlSessionFactory;
        Reader reader;
        try {
            reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            session = sqlSessionFactory.openSession();
            houseMapper = session.getMapper(HouseMapper.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public HouseEntity save(HouseEntity entity) {
        houseMapper.save(entity);
        session.commit();

        return entity;
    }

    @Override
    public void deleteById(long id) {
        houseMapper.deleteById(id);
        session.commit();
    }

    @Override
    public void deleteByEntity(HouseEntity entity) {
        houseMapper.deleteByEntity(entity);
        session.commit();
    }

    @Override
    public void deleteAll() {
        houseMapper.deleteAll();
        session.commit();
    }

    @Override
    public HouseEntity update(HouseEntity entity) {
        houseMapper.update(entity);
        session.commit();

        return entity;
    }

    @Override
    public HouseEntity getById(long id) {
        HouseEntity entity = houseMapper.getById(id);
        session.commit();

        return entity;
    }

    @Override
    public List<HouseEntity> getAll() {
        List<HouseEntity> entities = houseMapper.getAll();
        session.commit();

        return entities;
    }

    @Override
    public List<HouseEntity> getAllByVId(long id) {
        List<HouseEntity> entities = houseMapper.getAllByVId(id);
        session.commit();

        return entities;
    }
}
