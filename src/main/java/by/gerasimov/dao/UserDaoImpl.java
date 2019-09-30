package by.gerasimov.dao;

import by.gerasimov.domain.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private Connection connection;

    public UserDaoImpl() {
        connection = ConnectionManager.getConnection();
    }

    @Override
    public List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        Statement st = connection.createStatement();
        ResultSet result = st.executeQuery("select * from user");
        {
            while (result.next()) {
                User user = new User();
                user.setId(result.getInt(1));
                user.setName(result.getString(2));
                user.setSurName(result.getString(3));
                users.add(user);
            }
        }
        return users;
    }

    @Override
    public User getUserById(int id) throws SQLException {
        User user = new User();
        Statement st = connection.createStatement();
        ResultSet result = st.executeQuery("select name, surname from user where id = " + id);
        result.next();
        user.setId(id);
        user.setName(result.getString(1));
        user.setSurName(result.getString(2));
        return user;
    }

    @Override
    public List<User> getRichestUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        Statement st = connection.createStatement();
        ResultSet result = st.executeQuery("select u.id, u.name, u.surname " +
                "from (select sum(a1.account) sumacc, a1.user_id user_id from account a1 group by a1.user_id) s1, user u " +
                "where s1.sumacc=(select max(s.sumacc) " +
                "                from (select sum(a.account) sumacc, a.user_id user_id from account a group by a.user_id) s) " +
                "and u.id=s1.user_id");
        while(result.next()) {
            User user = new User();
            user.setId(result.getInt(1));
            user.setName(result.getString(2));
            user.setSurName(result.getString(3));
            users.add(user);
        }

        return users;
    }

    public String getRichestUsersToString() throws SQLException {
        String richestUsers = new String();
        Statement st = connection.createStatement();
        ResultSet result = st.executeQuery("select u.name, u.surname " +
                "from (select sum(a1.account) sumacc, a1.user_id user_id from account a1 group by a1.user_id) s1, user u " +
                "where s1.sumacc=(select max(s.sumacc) " +
                "                from (select sum(a.account) sumacc, a.user_id user_id from account a group by a.user_id) s) " +
                "and u.id=s1.user_id");
        result.next();
        richestUsers += result.getString(1) + result.getString(2);
        while(result.next()) {
            richestUsers += ", " + result.getString(1) + result.getString(2);
        }
        return richestUsers;
    }
}