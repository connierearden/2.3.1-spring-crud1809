package crud.service;


import crud.dao.UserDao;
import crud.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements  UserService {
    @Autowired
    private UserDao userDao;

    @Transactional
    @Override
    public List getAllUsers() { return userDao.getAllUsers();
    }

    @Transactional
    @Override
    public void addUser(User user) {
        if (!user.getName().isEmpty() || !user.getPassword().isEmpty()) {
            userDao.addUser(user);
        }
    }

    @Transactional
    @Override
    public User findUserById(Long id) {
        if (id!=null) {
            return userDao.findUserById(id);
        }
        return null;
    }

    @Transactional
    @Override
    public void deleteUser(Long id) {
        if (id!=null) {
            userDao.deleteUser(id);
        }
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        if (user.getName().isEmpty() && user.getPassword().isEmpty()){
            userDao.updateUser(user);
        }
    }
}
