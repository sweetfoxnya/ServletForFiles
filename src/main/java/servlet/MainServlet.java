package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/files")
public class MainServlet extends HttpServlet {

    File  file = new File("C:/Users");
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String path = "C:/Users";
        if (req.getParameterValues("btn") != null) {

            if(req.getParameterValues("btn")[0].equals(" ")) {
                file = file.getParentFile();
                path = file.getAbsolutePath();
            } else {
                path = req.getParameterValues("btn")[0];
                file = new File(path);
            }

        }

        req.setAttribute("path", path);

        String parentDirectory = file.getParent();

        req.setAttribute("parentDirectory", parentDirectory);

        if(file.isDirectory()){
            File folder = new File(path);
            File[] files = folder.listFiles();

            req.setAttribute("file", file);
            req.setAttribute("files", files);

        }

        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.getWriter().write("POST method isn't available");

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }
}