package crud.controllers;

import crud.models.User;
import crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping(value = "users")
    public String getAllUsers(Model model) {
        List<User> list = userService.getAllUser();
        list.add(new User("asdf", 50, "asdfaf", "user"));
        model.addAttribute("users", list);

        return "admin";
    }

}
