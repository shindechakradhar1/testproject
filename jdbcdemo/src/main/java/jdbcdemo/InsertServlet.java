package jdbcdemo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbcdemo.dao.StudentDao;
import jdbcdemo.entities.Student;

@WebServlet("/product/insert")
public class InsertServlet extends HttpServlet{
	StudentDao studentDao;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("sid"));
		String name = req.getParameter("sname");
		Integer age = Integer.parseInt(req.getParameter("sage"));
		Student student = new Student(id,name,age);
		studentDao = new StudentDao();
		resp.setContentType("text/html");
		resp.getWriter().write(studentDao.insertStudent(student));
		resp.getWriter().write("<a href=\"/jdbcdemo\">home</a>");
	}
}
