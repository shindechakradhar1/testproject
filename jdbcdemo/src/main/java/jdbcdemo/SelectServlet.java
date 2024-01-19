package jdbcdemo;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbcdemo.dao.StudentDao;
import jdbcdemo.entities.Student;

@WebServlet("/select")
public class SelectServlet extends HttpServlet{
	StudentDao studentDao;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		studentDao = new StudentDao();
		List<Student> studentList = studentDao.selectAll();
		if(!studentList.isEmpty()) {
		req.setAttribute("studentList", studentList);
		req.getRequestDispatcher("product/select.jsp").include(req, resp);
		}else {
			resp.getWriter().write("No Record Found");
		}
		
	}
}
