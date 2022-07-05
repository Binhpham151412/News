package controller.user;

import dao.admin.CategoriesDAO;
import dao.user.AddNewsUserDAO;
import model.admin.CategoriesModel;
import model.UsersModel;
import model.user.AddNewsUserModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet(value = "/user/news/add")
public class AddNewsUserController
    extends HttpServlet {
    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp)
        throws ServletException, IOException {
        List<CategoriesModel> list = new CategoriesDAO().findAll();
        req.setAttribute("list", list);
        req.getRequestDispatcher("/view/user/add-news.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(final HttpServletRequest req, final HttpServletResponse resp)
        throws ServletException, IOException {

        HttpSession session = req.getSession();
        session.getAttribute("userLogin");
        int userid = (int) session.getAttribute("userId");

        String title = req.getParameter("title");
        String description = req.getParameter("description");
        String content = req.getParameter("content");
        int categoryId = Integer.parseInt(req.getParameter("categoryName"));
        new AddNewsUserDAO().addNews(AddNewsUserModel.builder()
                                                     .content(content)
                                                     .description(description)
                                                     .title(title)
                                                     .userName(UsersModel.builder().id(userid).build())
                                                     .categoryName(CategoriesModel.builder().id(categoryId).build())
                                                     .build());

        resp.sendRedirect(req.getContextPath() + "/user/news/list");
    }
}
