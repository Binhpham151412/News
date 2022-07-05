package controller.admin.users;

import dao.admin.UsersDAO;
import model.UsersModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet(value = "/admin/users")
public class ListUsersController extends HttpServlet {
    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp)
        throws ServletException, IOException {
        HttpSession session = req.getSession();
        UsersModel usersModel = (UsersModel) session.getAttribute("userLogin");
        if (usersModel == null){
            resp.sendRedirect(req.getContextPath()+"/login");
            return;
        }

        List<UsersModel> listUser = new UsersDAO().findAll();
        req.setAttribute("listUser",listUser);
        req.getRequestDispatcher("/view/admin/user/users.jsp").forward(req,resp);
    }
}
