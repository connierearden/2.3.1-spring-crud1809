package crud.controllers;

import crud.models.User;
import crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping()
    public String getAllUsers(Model model) {
        List list = userService.getAllUsers();
        model.addAttribute("users", list);
        return "admin";
    }

    @GetMapping("/new")
    public String newPerson (Model model) {
        model.addAttribute("user", new User());
        return "new";
    }
    @PostMapping()
    public String create (@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/users";
    }


/*    @GetMapping("/update")
    public String updatePerson (Model model) {
        model.addAttribute("user", new User());
        return "update";
    }
    @PostMapping()
    public String update (@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }*/



    @GetMapping("/{id}")
    public String deleteUser (@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }




}
