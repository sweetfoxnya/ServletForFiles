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

    File  file = new File("C:/students");
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.getRequestDispatcher("files.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String path = null;
        String name = req.getParameter("name");

        if (req.getParameterValues("btnExit") != null ) {
            File newfile = file.getParentFile();
            File parent = new File("C:\\students");
            if(!newfile.getPath().equals(parent.getPath())){
                file = file.getParentFile();
                path = file.getPath();
            }
        } else if (req.getParameterValues("btnName") != null){
            file = new File(req.getParameterValues("btnName")[0]);
            path = file.getPath();
        } else {
            file = new File("C:\\students\\" + name);
            path = file.getPath();
        }

        req.setAttribute("path", path);

        if(file.isDirectory()){

            req.setAttribute("path", path);

            File folder = new File(path);
            File[] files = folder.listFiles();

            req.setAttribute("file", file);
            req.setAttribute("files", files);

            req.getRequestDispatcher("files.jsp").forward(req, resp);

        }

        req.getRequestDispatcher("files.jsp").forward(req, resp);
        resp.sendRedirect("/files");

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }
}
