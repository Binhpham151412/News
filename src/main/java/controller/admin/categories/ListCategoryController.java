package controller.admin.categories;

import dao.admin.CategoriesDAO;
import model.admin.CategoriesModel;
import model.UsersModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet(value = "/admin/categories")
public class ListCategoryController extends HttpServlet {
    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp)
        throws ServletException, IOException {
        HttpSession session = req.getSession();
        UsersModel usersModel = (UsersModel) session.getAttribute("userLogin");

        if (usersModel == null){
            resp.sendRedirect(req.getContextPath()+"/login");
            return;
        }

        List<CategoriesModel> list = new CategoriesDAO().findAll();
        req.setAttribute("list", list);
        req.getRequestDispatcher("/view/admin/category/categories.jsp").forward(req,resp);
    }
}
