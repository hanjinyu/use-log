package cn.tietou.ssh.repository.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.tietou.ssh.entity.Person;
import cn.tietou.ssh.repository.PersonRepository;

/**
 * Created by XRom
 * On 11/16/2017.11:55 PM
 */
@Repository
public class PersonRepositoryImpl implements PersonRepository {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return this.sessionFactory.openSession();
    }

    @Override
    public Person load(Long id) {
        return (Person) getCurrentSession().load(Person.class, id);
    }

    @Override
    public Person get(Long id) {
        return (Person) getCurrentSession().get(Person.class, id);
    }

    @Override
    public List<Person> findAll() {
        return null;
    }

    @Override
    public void persist(Person entity) {
        getCurrentSession().persist(entity);
    }

    @Override
    public Long save(Person entity) {
        Long success = 0L;
        
        Session sess = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = sess.beginTransaction();
            sess.save(entity);
//            success = (Long) getCurrentSession().save(entity);
            tx.commit();
        }
        catch (Exception e) {
            if (tx!=null) tx.rollback();
            throw e;
        }
        finally {
            sess.close();
        }
        return success;
    }

    @Override
    public void saveOrUpdate(Person entity) {
        getCurrentSession().saveOrUpdate(entity);
    }

    @Override
    public void delete(Long id) {
        Person person = load(id);
        getCurrentSession().delete(person);
    }

    @Override
    public void flush() {
        getCurrentSession().flush();
    }
}
