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

@WebServlet(value = "/admin/categories/add")
public class AddCategoryController
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

        req.getRequestDispatcher("/view/admin/category/add-categories.jsp").forward(req, resp);
    }
//them
    @Override
    protected void doPost(final HttpServletRequest req, final HttpServletResponse resp)
        throws ServletException, IOException {
        String name = req.getParameter("category");
        if (!name.equals("")) {
            List<CategoriesModel> check = new CategoriesDAO().check(name);
            if (check.isEmpty()) {
                new CategoriesDAO().addCategory(CategoriesModel.builder()
                                                                       .name(name)
                                                                       .build());
                req.setAttribute("add-success","them category thanh cong");
                req.getRequestDispatcher("/view/admin/category/add-categories.jsp").forward(req,resp);
//                String msg  = "them category thanh cong";
//                resp.sendRedirect(req.getContextPath()+"/admin/categories?msg="+msg);
                return;
            }
//            String msg  = "them category that bai";
//            resp.sendRedirect(req.getContextPath()+"/admin/categories?msg="+msg);
            req.setAttribute("add-failed","them category THAT BAI !!!");
            req.getRequestDispatcher("/view/admin/category/add-categories.jsp").forward(req,resp);
            return;
        }
//        String msg  = "them category that bai";
//        resp.sendRedirect(req.getContextPath()+"/admin/categories?msg="+msg);
        req.setAttribute("add-none","category khong duoc de trong !!!");
        req.getRequestDispatcher("/view/admin/category/add-categories.jsp").forward(req,resp);
    }
}
