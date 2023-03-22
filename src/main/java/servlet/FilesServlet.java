package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;


@WebServlet("/files")
public class FilesServlet extends HttpServlet {

    File  file = new File("C:/Users");
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.getRequestDispatcher("files.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String path = req.getParameter("path");
        HttpSession session = req.getSession();
        File file = new File(path);
        String parentDirectory = file.getParent();
        String name = session.getAttribute("name").toString();

        if (path == null || !path.startsWith("C:\\students\\" + name)) {
            path = "C:\\students\\" + name;
        }

        if (parentDirectory == null || !parentDirectory.startsWith("C:\\students\\" + name) ){
            parentDirectory = "C:\\students\\" + name;
            file = new File(parentDirectory);
        }

        req.setAttribute("path", path);

        if(file.isDirectory()){

            req.setAttribute("path", path);
            req.setAttribute("parentDirectory", parentDirectory);

            File folder = new File(path);
            File[] files = folder.listFiles();

            req.setAttribute("file", file);
            req.setAttribute("files", files);

        }

        resp.sendRedirect("/files");

        req.getRequestDispatcher("files.jsp").forward(req, resp);

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }
}
