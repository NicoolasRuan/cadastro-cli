package Controller;

import Model.User;
import Service.UserService;
import View.UserView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserController {
    private User model;
    private static UserService service;
    private final List<User> users;

    public UserController(UserView view, UserService service, List<User> users ) {
        UserController.service = service;
        this.users = users;
    }

    public void createUser() throws IOException {
        //reading response from form
        Map<String, String> map = service.readQuestions("formulario.txt");

        //adding user
        User user = new User(map.get("name"), map.get("email"), map.get("age"), map.get("height"));
        List<User> dbUsers = service.readFromDb("usuarios.txt");
        if (dbUsers.isEmpty()) {
            users.add(user);
            service.saveOnDb("usuarios.txt", user);
        } else {
            service.saveOnDb("usuarios.txt", user);
            users.addAll(dbUsers);
        }
        //log user in terminal
        System.out.println(user);
    }

    public void deleteUser() {

    }

    public void updateUser() {}

    public void listUsers() {
        List <User> users = service.readFromDb("usuarios.txt");
        //System.out.println(users);
        if(users != null && !users.isEmpty()) {
            int i = 1;
            for(User user: users) {
                System.out.println("=====USER #"+i+"=====");
                System.out.println(user.toString());
                System.out.println("================");
                System.out.println();
                i++;
            }
        }
    }

    public void saveUsers() throws IOException {
        service.saveOnDb("usuarios.txt", getUsers());
    }


    public List<User> getUsers() {
        return users;
    }
}
