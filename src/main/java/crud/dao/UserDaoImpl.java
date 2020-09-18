package crud.dao;

import crud.models.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<User>getAllUsers() {
        return sessionFactory.getCurrentSession().createQuery("from User ").list();
    }

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }


}
