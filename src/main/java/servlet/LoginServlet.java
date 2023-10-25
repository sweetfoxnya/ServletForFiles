package servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        String name = req.getParameter("name");
        String password = req.getParameter("password");

        User user = UserMethods.getUserByName(name);
        if (user == null) {
            resp.getWriter().write("Уou need to register");
        } else if (!user.getName().equals(name)) {
            resp.getWriter().write("Incorrect name");
        } else if (!user.getPassword().equals(password)) {
            resp.getWriter().write("Incorrect password");
        }

        UserMethods.addSession(session.getId(),user);

        if (req.getParameterValues("btnLogin") != null ) {
            String path = "/files" + "?path=C:\\students" + name;
            ServletContext servletContext = getServletContext();
            RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path);
            requestDispatcher.forward(req, resp);
        }
        req.getRequestDispatcher("login.jsp").forward(req, resp);


    }
}
