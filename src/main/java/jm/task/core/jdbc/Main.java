package jm.task.core.jdbc;

import com.mysql.cj.jdbc.MysqlDataSourceFactory;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.sql.Connection;
import java.sql.Driver;

public class Main {
    private static final UserService userService = new UserServiceImpl();
    public static void main(String[] args) {
        userService.createUsersTable();


    }
}
