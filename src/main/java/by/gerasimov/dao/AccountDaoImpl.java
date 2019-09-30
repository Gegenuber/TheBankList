package by.gerasimov.dao;

import by.gerasimov.domain.Account;
import by.gerasimov.domain.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccountDaoImpl implements AccountDao {
    private Connection connection;

    public AccountDaoImpl() {
        connection = ConnectionManager.getConnection();
    }

    @Override
    public List<Account> getAllAccounts() throws SQLException {
        List<Account> accounts = new ArrayList<>();
        Statement st = connection.createStatement();
        ResultSet result = st.executeQuery("select account.id, account.account, user.id, user.name, user.surname " +
                "from account, user where account.user_Id = user.id");
        while (result.next()) {
            Account account = new Account();
            account.setId(result.getInt(1));
            account.setAccount(result.getInt(2));
            User user = new User();
            user.setId(result.getInt(3));
            user.setName(result.getString(4));
            user.setSurName(result.getString(5));
            account.setUser(user);
            accounts.add(account);
        }
        return accounts;
    }

    @Override
    public int getAccountSum() {
        int sum = 0;
        try (Statement st = connection.createStatement();
             ResultSet result = st.executeQuery("select sum(account) total from account"))
        {
            result.next();
            sum = result.getInt(1);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return sum;
    }
}
