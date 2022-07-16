package jm.task.core.jdbc;

import com.mysql.cj.jdbc.MysqlDataSourceFactory;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.sql.Connection;
import java.sql.Driver;

public class Main {
     static  UserService userService = new UserServiceImpl();
    static  User user1 = new User("Vasya", "Pupkin", (byte) 15);
    static User user2 = new User("Petr", "Petkin", (byte) 18);
    static User user3 = new User("Masha", "Mashkina", (byte) 21);
    static  User user4 = new User("Don", "Karleone", (byte) 88);

    public static void main(String[] args) {
        userService.createUsersTable();
 //      userService.saveUser(user1.getName(), user1.getLastName(), user1.getAge());
//        userService.saveUser(user2.getName(), user2.getLastName(), user2.getAge());
//        userService.saveUser(user3.getName(), user3.getLastName(), user3.getAge());
//        userService.saveUser(user4.getName(), user4.getLastName(), user4.getAge());
//        userService.getAllUsers();
//        userService.cleanUsersTable();
 //         userService.dropUsersTable();

    }
}
