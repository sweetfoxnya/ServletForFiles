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

    File  file = getUserDir();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.getRequestDispatcher("files.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {


        HttpSession session = req.getSession();


        if(UserMethods.getUserBySessionId(session.getId()) == null){return;}

        String name = UserMethods.getUserBySessionId(session.getId()).getName();

        String path = null;
       // String name = req.getParameter("name");

        if (req.getParameterValues("btnExit") != null ) {
            File newfile = file.getParentFile();
            File parent = getUserDir();
            if(!newfile.getPath().equals(parent.getPath())){
                file = file.getParentFile();
                path = file.getPath();
            }
        } else if (req.getParameterValues("btnName") != null){
            file = new File(req.getParameterValues("btnName")[0]);
            path = file.getPath();
        } else {
            file = new File(getUserDir().getPath() + "\\" + name);
            path = file.getPath();
        }

        String parentDirectory = file.getParent();

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

    private File getUserDir(){
        File file = new File(File.listRoots()[0] + "\\students");
        if(!file.exists()) {
            file.mkdirs();
        }
        return file;
    }
}
