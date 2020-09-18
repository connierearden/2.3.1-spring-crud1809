package crud.service;


import crud.dao.UserDao;
import crud.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements  UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public List<User> getAllUser() {
        return userDao.getAllUsers();
    }

    @Override
    public void add(User user) { userDao.add(user); }
}
