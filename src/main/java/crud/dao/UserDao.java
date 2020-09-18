package crud.dao;

import crud.models.User;

import java.util.List;

public interface UserDao {
    List  getAllUsers();
    void addUser(User user);
    User findUserById (Long id);
    void deleteUser (Long id);
    void updateUser (User user);

}
