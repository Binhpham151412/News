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

@WebServlet(value = "/admin/categories/edit")
public class EditCategoryController
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

        int id = Integer.parseInt(req.getParameter("id"));
        List<CategoriesModel> list = new CategoriesDAO().findOne(id);
        CategoriesModel categoriesModel = list.get(0);
        req.setAttribute("category", categoriesModel);
        req.getRequestDispatcher("/view/admin/category/edit-categories.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(final HttpServletRequest req, final HttpServletResponse resp)
        throws ServletException, IOException {
        String name = req.getParameter("name");
        int id = Integer.parseInt(req.getParameter("id"));
        new CategoriesDAO().updateCategory(CategoriesModel.builder()
                                                       .name(name)
                                                       .id(id)
                                                       .build());
        resp.sendRedirect(req.getContextPath() + "/admin/categories");
    }
}
