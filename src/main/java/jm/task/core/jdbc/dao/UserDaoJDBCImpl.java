package jm.task.core.jdbc.dao;

import com.mysql.cj.protocol.Resultset;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    private final Connection connection = Util.getConnection();
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS maven.users" +
                    "(id int not null auto_increment," +
                    "name VARCHAR(30)," +
                    "lastname VARCHAR(30)," +
                    "age int," +
                    "PRIMARY KEY (id))");
            System.out.println("Таблица создана");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void dropUsersTable() {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("DROP TABLE IF EXISTS maven.users");
            System.out.println("Таблица удалена");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void saveUser(String name, String lastName, byte age) {
        String sql = "INSERT INTO maven.users (name, lastname, age) VALUES(?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.executeUpdate();
            System.out.println("User с именем – " + name + " и возрастом -"+age+ " добавлен в базу данных");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void removeUserById(long id) {
        try (Statement statement = connection.createStatement()) {
            String sql = "DELETE FROM maven.users WHERE id= " + id + " LIMIT 1 ";

            statement.executeUpdate(sql);
            System.out.println("User c id- "+id+ " удален");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> allUsers = new ArrayList<>();
        String sql = "Select id, name, lastName, age From maven.users";
        try (Statement statement = connection.createStatement()) {
           ResultSet rs=statement.executeQuery(sql);
            while(rs.next()){
                User user= new User();
                user.setId(rs.getLong(1));
                user.setName(rs.getString(2));
                user.setLastName(rs.getString(3));
                user.setAge(rs.getByte(4));
                //System.out.printf("%d. %s. %s. %d \n", user.getId(),user.getName(), user.getLastName(), user.getAge());
                allUsers.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return allUsers;
    }

    public void cleanUsersTable() {
        String sql = "TRUNCATE maven.users";
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
            System.out.println("Таблица полностью очищена");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Не удалось очистить таблицу");
        }

    }
}
