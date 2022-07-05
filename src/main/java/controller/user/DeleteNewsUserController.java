package controller.user;

import dao.user.DeleteNewsUserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(value = "/user/news/delete")
public class DeleteNewsUserController extends HttpServlet {
    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp)
        throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.getAttribute("userLogin");

//        int id = (int) session.getAttribute("userId"); // vì sao vẫn tìm được id mà ko thực hiện xóa đc?
        int id = Integer.parseInt(req.getParameter("id"));
        new DeleteNewsUserDAO().deleteNews(id);
        resp.sendRedirect(req.getContextPath()+"/user/news/list");
    }
}
