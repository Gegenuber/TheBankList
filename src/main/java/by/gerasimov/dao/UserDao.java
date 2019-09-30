package by.gerasimov.dao;

import by.gerasimov.domain.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    List<User> getAllUsers() throws SQLException;
    User getUserById(int id) throws SQLException;
    List<User> getRichestUsers() throws SQLException;
}
