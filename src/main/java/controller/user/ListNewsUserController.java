package controller.user;

import dao.user.ListNewsUserDAO;
import model.admin.news.ListNewsModel;
import model.user.ListNewsUserModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet(value = "/user/news/list")
public class ListNewsUserController
    extends HttpServlet {
    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp)
        throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.getAttribute("userLogin");

        int userId = (int) session.getAttribute("userId");

        List<ListNewsUserModel> list = new ListNewsUserDAO().findAll(userId);
        req.setAttribute("list", list);
        req.getRequestDispatcher("/view/user/list-news.jsp").forward(req, resp);
    }

}
