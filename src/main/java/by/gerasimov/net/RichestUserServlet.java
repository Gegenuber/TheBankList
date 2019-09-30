package by.gerasimov.net;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.gerasimov.dao.AccountDao;
import by.gerasimov.dao.AccountDaoImpl;
import by.gerasimov.dao.UserDaoImpl;
import by.gerasimov.dao.UserDao;

import java.io.IOException;
import java.sql.SQLException;

public class RichestUserServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public void init() throws ServletException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/richest.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("users", getRichestUsersToString());
        req.setAttribute("sum", getAccountSum());
        req.getRequestDispatcher("/jsp/richest.jsp").forward(req, resp);
    }

    public void destroy() {

    }

    private String getRichestUsersToString() {
        UserDao userDao = new UserDaoImpl();
        String richestUsers = new String();
        try {
            richestUsers = userDao.getRichestUsersToString();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return richestUsers;
    }

    private int getAccountSum()
    {
        AccountDao accountDao = new AccountDaoImpl();
        return accountDao.getAccountSum();
    }

}
