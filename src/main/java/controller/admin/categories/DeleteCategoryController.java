package controller.admin.categories;

import dao.admin.CategoriesDAO;
import model.admin.CategoriesModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(value = "/admin/categories/delete")
public class DeleteCategoryController
    extends HttpServlet {
    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp)
        throws ServletException, IOException {

        HttpSession session = req.getSession();
        session.getAttribute("userLogin");
        int id = Integer.parseInt(req.getParameter("id"));
        new CategoriesDAO().deleteCategory(CategoriesModel.builder()
                                                          .id(id)
                                                          .build());
        resp.sendRedirect(req.getContextPath()+"/admin/categories");
    }
}
