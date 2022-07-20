package controller.user;

import dao.admin.CategoriesDAO;
import dao.user.ListNewsUserDAO;
import dao.user.UpdateNewsUserDAO;
import model.admin.CategoriesModel;
import model.user.UpdateNewsUserModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet(value = "/user/news/update")
public class UpdateNewsUserController
    extends HttpServlet {
    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp)
        throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession();
        Object userLogin = session.getAttribute("userLogin");
        if (userLogin == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
        }

        int id = Integer.parseInt(req.getParameter("id"));
        UpdateNewsUserModel newsOld = new UpdateNewsUserDAO().findOne(id);
        req.setAttribute("news", newsOld);
        List<CategoriesModel> list = new CategoriesDAO().findAll();
        req.setAttribute("list", list);
        req.getRequestDispatcher("/view/user/update-news.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(final HttpServletRequest req, final HttpServletResponse resp)
        throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        int id = Integer.parseInt(req.getParameter("id"));
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        String content = req.getParameter("content");
        int categoryId = Integer.parseInt(req.getParameter("categoryId"));

        new UpdateNewsUserDAO().update(UpdateNewsUserModel.builder()
                                                          .id(id)
                                                          .title(title)
                                                          .description(description)
                                                          .content(content)
                                                          .categoriesModel(CategoriesModel.builder()
                                                                                     .id(categoryId)
                                                                                     .build())
                                                          .build());

        resp.sendRedirect(req.getContextPath() + "/user/news/list");
    }
}
