package crud.dao;

import crud.models.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();
    void add(User user);

}
