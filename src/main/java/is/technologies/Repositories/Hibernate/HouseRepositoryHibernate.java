package is.technologies.Repositories.Hibernate;

import is.technologies.Utilities.HibernateSessionFactoryUtil;
import is.technologies.Entities.HouseEntity;
import is.technologies.Interfaces.Repository;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class HouseRepositoryHibernate implements Repository<HouseEntity> {
    @Override
    public HouseEntity save(HouseEntity entity) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction newTransaction = session.beginTransaction();

        session.save(entity);

        newTransaction.commit();
        session.close();

        return entity;
    }

    @Override
    public void deleteById(long id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction newTransaction = session.beginTransaction();

        var houseEntity = session.get(HouseEntity.class, id);

        session.delete(houseEntity);

        newTransaction.commit();
        session.close();
    }

    @Override
    public void deleteByEntity(HouseEntity entity) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction newTransaction = session.beginTransaction();

        session.delete(entity);

        newTransaction.commit();
        session.close();
    }

    @Override
    public void deleteAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction newTransaction = session.beginTransaction();

        session.createQuery("DELETE FROM HouseEntity").executeUpdate(); ;

        newTransaction.commit();
        session.close();
    }

    @Override
    public HouseEntity update(HouseEntity entity) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction newTransaction = session.beginTransaction();

        session.update(entity);

        newTransaction.commit();
        session.close();

        return entity;
    }

    @Override
    public HouseEntity getById(long id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction newTransaction = session.beginTransaction();

        var entity = session.get(HouseEntity.class, id);

        newTransaction.commit();
        session.close();

        return entity;
    }

    @Override
    public List<HouseEntity> getAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction newTransaction = session.beginTransaction();

        List<HouseEntity> houses = session.createNativeQuery("SELECT * FROM house", HouseEntity.class).getResultList();

        newTransaction.commit();
        session.close();

        return houses;
    }

    @Override
    public List<HouseEntity> getAllByVId(long id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction newTransaction = session.beginTransaction();

        List<HouseEntity> houses = session.createNativeQuery("SELECT * FROM house WHERE street = :id", HouseEntity.class).setParameter("id", id).getResultList();

        newTransaction.commit();
        session.close();

        return houses;
    }
}
