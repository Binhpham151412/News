package controller.login;

import dao.login.AddUserDAO;
import model.UsersModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(value = "/add-user")
public class AddUserController
    extends HttpServlet {
    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp)
        throws ServletException, IOException {
        req.getRequestDispatcher("/view/add-user.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(final HttpServletRequest req, final HttpServletResponse resp)
        throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String repassword = req.getParameter("re-password");
        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        String gender = req.getParameter("gender");
        if (password.equals(repassword)) {
            List<UsersModel> check = new AddUserDAO().check(username);
            if (check.isEmpty()) {
                new AddUserDAO().addUser(UsersModel.builder()
                                                   .userName(username)
                                                   .firstName(firstname)
                                                   .lastName(lastname)
                                                   .gender(gender)
                                                   .passWord(password)
                                                   .build());
                req.setAttribute("success","Tạo tài khoản thành công");
                req.getRequestDispatcher("/view/add-user.jsp").forward(req,resp);


                return;
            }
            req.setAttribute("failed","Tạo tài khoản thất bại !!!");
            req.getRequestDispatcher("/view/add-user.jsp").forward(req,resp);

            return;
        }
        req.setAttribute("failed","Tạo tài khoản thất bại !!!");
        req.getRequestDispatcher("/view/add-user.jsp").forward(req,resp);
    }
}
