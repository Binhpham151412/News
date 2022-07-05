package controller.admin.news;

import dao.admin.NewsDAO;
import model.UsersModel;
import model.admin.news.ListNewsModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet(value = "/admin/news")
public class ListNewsController
    extends HttpServlet {

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp)
        throws ServletException, IOException {

        HttpSession session = req.getSession();
        UsersModel usersModel = (UsersModel) session.getAttribute("userLogin");
        if (usersModel == null){
            resp.sendRedirect(req.getContextPath()+"/login");
            return;
        }

        List<ListNewsModel> list = new NewsDAO().findAll();
        req.setAttribute("list",list);
        req.getRequestDispatcher("/view/admin/new/list-news.jsp").forward(req, resp);
    }
}
