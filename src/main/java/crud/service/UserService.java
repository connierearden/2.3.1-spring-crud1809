package crud.service;

import crud.models.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();
    void add(User user);
}
