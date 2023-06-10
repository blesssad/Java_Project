package is.technologies.Repositories.Hibernate;

import is.technologies.Entities.StreetEntity;
import is.technologies.Interfaces.Repository;
import is.technologies.Utilities.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class StreetRepositoryHibernate implements Repository<StreetEntity> {
    @Override
    public StreetEntity save(StreetEntity entity) {
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

        var streetEntity = session.get(StreetEntity.class, id);

        session.delete(streetEntity);

        newTransaction.commit();
        session.close();
    }

    @Override
    public void deleteByEntity(StreetEntity entity) {
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

        session.createQuery("DELETE FROM StreetEntity").executeUpdate();

        newTransaction.commit();
        session.close();
    }

    @Override
    public StreetEntity update(StreetEntity entity) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction newTransaction = session.beginTransaction();

        session.update(entity);

        newTransaction.commit();
        session.close();

        return entity;
    }

    @Override
    public StreetEntity getById(long id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction newTransaction = session.beginTransaction();

        var entity = session.get(StreetEntity.class, id);

        newTransaction.commit();
        session.close();

        return entity;
    }

    @Override
    public List<StreetEntity> getAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction newTransaction = session.beginTransaction();

        List<StreetEntity> streets = session.createNativeQuery("SELECT * FROM street", StreetEntity.class).getResultList();

        newTransaction.commit();
        session.close();

        return streets;
    }

    @Override
    public List<StreetEntity> getAllByVId(long id) {
        return null;
    }
}
