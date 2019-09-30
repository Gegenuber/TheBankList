package by.gerasimov.dao;

import by.gerasimov.domain.Account;

import java.sql.SQLException;
import java.util.List;

public interface AccountDao {
    List<Account> getAllAccounts() throws SQLException;
    int getAccountSum();
}
