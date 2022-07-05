package controller.admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(value = "/logout")
public class LogoutController extends HttpServlet {
    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp)
        throws ServletException, IOException {
        HttpSession session =req.getSession();
        session.removeAttribute("userLogin");
        resp.sendRedirect(req.getContextPath()+"/login");
    }
}
