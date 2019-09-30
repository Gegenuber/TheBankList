package by.gerasimov.net;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.gerasimov.dao.AccountDao;
import by.gerasimov.dao.AccountDaoImpl;

import java.io.IOException;

public class RichestUserServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private String message;

    public void init() throws ServletException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/richest.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("sum", getAccountSum());
        req.getRequestDispatcher("/jsp/richest.jsp").forward(req, resp);
    }

    public void destroy() {

    }

    private int getAccountSum()
    {
        AccountDao accountDao = new AccountDaoImpl();
        return accountDao.getAccountSum();
    }

}
