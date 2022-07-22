package jm.task.core.jdbc.util;

import org.hibernate.SessionFactory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.nio.file.*;
import java.io.*;
import java.util.*;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import javax.servlet.http.HttpServlet;


public class Util extends HttpServlet {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String HOST = "jdbc:mysql://localhost/maven?serverTimezone=Europe/Moscow&useSSL=false";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "12345";

    public static Connection getConnection() {
        Connection connection = null;
        try {

           //Class.forName(DRIVER);
            //System.setProperty("jdbc.drivers","com.mysql.cj.jdbc.Driver");
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            try {
                connection = DriverManager.getConnection(HOST, LOGIN, PASSWORD);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

}
