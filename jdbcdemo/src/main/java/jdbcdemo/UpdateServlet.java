package jdbcdemo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbcdemo.dao.StudentDao;
import jdbcdemo.entities.Student;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet{
	StudentDao studentDao = new StudentDao();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		Student student=studentDao.selectById(id);
		req.setAttribute("student", student);
		if(student!=null)
			req.getRequestDispatcher("product/update.jsp").include(req, resp);
		else
			resp.getWriter().write("Record not found..");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("sid"));
		Integer age = Integer.parseInt(req.getParameter("sage"));
		String name = req.getParameter("sname");
		
		
		Student student = new Student(id,name,age);
		String msg = studentDao.update(student);
		resp.setContentType("text/html");
		resp.getWriter().println(msg);
		resp.getWriter().println("<a href=/jdbcdemo>home</a>");		
	}
}
