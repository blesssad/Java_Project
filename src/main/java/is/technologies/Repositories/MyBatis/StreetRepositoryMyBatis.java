package is.technologies.Repositories.MyBatis;

import is.technologies.Interfaces.Mappers.StreetMapper;
import is.technologies.Entities.StreetEntity;
import is.technologies.Interfaces.Repository;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class StreetRepositoryMyBatis implements Repository<StreetEntity> {

    private SqlSession session = null;
    private StreetMapper streetMapper = null;

    public StreetRepositoryMyBatis() {
        SqlSessionFactory sqlSessionFactory;
        Reader reader;
        try {
            reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            session = sqlSessionFactory.openSession();
            streetMapper = session.getMapper(StreetMapper.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public StreetEntity save(StreetEntity entity) {
        streetMapper.save(entity);
        session.commit();

        return entity;
    }

    @Override
    public void deleteById(long id) {
        streetMapper.deleteById(id);
        session.commit();
    }

    @Override
    public void deleteByEntity(StreetEntity entity) {
        streetMapper.deleteByEntity(entity);
        session.commit();
    }

    @Override
    public void deleteAll() {
        streetMapper.deleteAll();
        session.commit();
    }

    @Override
    public StreetEntity update(StreetEntity entity) {
        streetMapper.update(entity);
        session.commit();

        return entity;
    }

    @Override
    public StreetEntity getById(long id) {
        StreetEntity entity = streetMapper.getById(id);
        session.commit();

        return entity;
    }

    @Override
    public List<StreetEntity> getAll() {
        List<StreetEntity> entities = streetMapper.getAll();
        session.commit();

        return entities;
    }

    @Override
    public List<StreetEntity> getAllByVId(long id) {
        return null;
    }
}
