package controller.user;

import dao.user.ViewNewsUserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(value = "/user/news/view")
public class ViewUserController extends HttpServlet {
    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp)
        throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.getAttribute("userLogin");
        int id = Integer.parseInt(req.getParameter("id"));

        session.setAttribute("news",new ViewNewsUserDAO().findOne(id));

        req.getRequestDispatcher("/view/user/view.jsp").forward(req,resp);
    }
}
