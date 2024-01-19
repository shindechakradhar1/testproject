package jdbcdemo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbcdemo.dao.StudentDao;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet{
	StudentDao studentDao;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		req.setAttribute("id", id);
		req.getRequestDispatcher("product/delete.jsp").include(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		studentDao = new StudentDao();
		Integer id = Integer.parseInt(req.getParameter("id"));
		String msg = studentDao.deleteStudent(id);
		resp.setContentType("text/html");
		resp.getWriter().println(msg);
		resp.getWriter().println("<a href=/jdbcdemo>home</a>");
	}
}
