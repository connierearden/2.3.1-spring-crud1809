package crud.dao;

import crud.models.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List getAllUsers() {
        return sessionFactory.getCurrentSession().createQuery("from User ").list();
    }

    @Override
    public void addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public User findUserById(Long id) {
        return sessionFactory.getCurrentSession().load(User.class, id);
    }

    @Override
    public void deleteUser(Long id) {
        sessionFactory.getCurrentSession().delete(sessionFactory.getCurrentSession().get(User.class, id));
    }

    @Override
    public void updateUser(User user) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "update User u set u.id = :id, u.name = :name, u.age = :age,u.password = :pass,u.role = :role");
        query.setParameter("id", user.getId());
        query.setParameter("name", user.getName());
        query.setParameter("age", user.getAge());
        query.setParameter("pass", user.getPassword());
        query.setParameter("role", user.getRole());
        query.executeUpdate();
    }

}
