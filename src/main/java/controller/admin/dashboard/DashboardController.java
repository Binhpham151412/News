package controller.admin.dashboard;

import model.UsersModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(value = "/admin/dashboard")
public class DashboardController extends HttpServlet {
    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp)
        throws ServletException, IOException {
        HttpSession session = req.getSession();
        UsersModel usersModel = (UsersModel) session.getAttribute("userLogin");
        if (usersModel == null){
            resp.sendRedirect(req.getContextPath()+"/login");
            return;
        }

        req.getRequestDispatcher("/view/dashboard.jsp").forward(req,resp);
    }
}
