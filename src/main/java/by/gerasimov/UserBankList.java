package by.gerasimov;

import by.gerasimov.dao.AccountDao;
import by.gerasimov.dao.AccountDaoImpl;
import by.gerasimov.dao.UserDao;
import by.gerasimov.dao.UserDaoImpl;
import by.gerasimov.domain.User;

import java.sql.SQLException;
import java.util.List;

public class UserBankList {
    public static void main(String[] args) throws SQLException {
        UserDao userDao = new UserDaoImpl();
        System.out.println(userDao.getAllUsers());
        System.out.println(userDao.getUserById(2));
        AccountDao accountDao = new AccountDaoImpl();
        System.out.println(accountDao.getAllAccounts());
        System.out.println(accountDao.getAccountSum());
        StringBuilder richestUsers = new StringBuilder();
        List<User> users = userDao.getRichestUsers();
        for (User u : users) {
            richestUsers.append(u.toUserString()).append(", ");
        }
        richestUsers = new StringBuilder(richestUsers.substring(0, richestUsers.length() - 2));
        System.out.println(richestUsers);
    }
}
