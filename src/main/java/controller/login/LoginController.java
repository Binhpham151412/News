package controller.login;

import dao.login.LoginDAO;
import model.UsersModel;
import model.admin.news.NewsModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(value = "/login")
public class LoginController
    extends HttpServlet {
    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp)
        throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        req.getRequestDispatcher("/view/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(final HttpServletRequest req, final HttpServletResponse resp)
        throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        UsersModel usersModel = new LoginDAO().login(username, password);

        if (usersModel != null) {
            if (usersModel.getRole() == 0) {

                HttpSession  session =req.getSession();
                session.setAttribute("userLogin",usersModel);

                resp.sendRedirect(req.getContextPath() + "/admin/dashboard");
                return;
            } else if (usersModel.getRole() == 1) {

                HttpSession session = req.getSession();
                session.setAttribute("userLogin", usersModel);
                int userId= new LoginDAO().findOne(username).get(0).getId();
                session.setAttribute("userId",userId);

                resp.sendRedirect(req.getContextPath()+"/user/news/list");
                return;
            }
        }
        req.setAttribute("loginFailed","tên đăng nhập hoặc mật khẩu không đúng!");
        resp.sendRedirect(req.getContextPath()+"/login");
    }
}
