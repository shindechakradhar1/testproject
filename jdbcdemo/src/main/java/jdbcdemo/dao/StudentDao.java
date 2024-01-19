package jdbcdemo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbcdemo.entities.Student;

public class StudentDao {
	private Connection connection() {
		Connection connection=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root", "root");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
		return connection;
	}
	public String insertStudent(Student student) {
		try {
			PreparedStatement ps = connection().prepareStatement("insert into student values (?, ?, ?)");
			
			ps.setInt( 1, student.getId());
			ps.setString(2, student.getName());
			ps.setInt(3, student.getAge());
			ps.execute();
		} catch (SQLException e) {
			return "unsuccessfull";
		}
		
		return "Successfull";
	}
	public List<Student> selectAll() {
		List<Student> studentList = new ArrayList<>();
		Integer id,age;
		String name;
		try {
			PreparedStatement ps = connection().prepareStatement("select * from student;");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				id=rs.getInt("id");
				name=rs.getString("name");
				age=rs.getInt("age");
				studentList.add(new Student(id,name,age));
				System.out.println(studentList);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return studentList;
	}
	
	public Student selectById(Integer id) {
		Integer id1=null,age=null;
		String name=null;
		try {
			PreparedStatement pStatement = connection().prepareCall("Select * from student where id=?");
			pStatement.setInt(1, id);
			ResultSet rSet = pStatement.executeQuery();
			while(rSet.next()) {
				id1 = rSet.getInt(1);
				name = rSet.getString(2);
				age = rSet.getInt(3);
			}
			return new Student(id1,name,age);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
			
		}
	}
	
	
	public String update(Student student) {
		PreparedStatement pStatement;
		try {
			pStatement = connection().prepareStatement("update student set name=?, age=? where id=?");
			pStatement.setString(1, student.getName());
			pStatement.setInt(2, student.getAge());
			pStatement.setInt(3, student.getId());
			pStatement.execute();
			return "Successfull...";
		} catch (SQLException e) {
			e.printStackTrace();
			return "unSuccessfull...";
		}
		
	}
	
	public String deleteStudent(Integer id) {
		String DELETE_STUDENT = "DELETE FROM student WHERE id=?";
		
		try(
				PreparedStatement pStatement = connection().prepareStatement(DELETE_STUDENT);
				){
			pStatement.setInt(1, id);
			pStatement.execute();
			return "Successfull";
		} catch (SQLException e) {
			e.printStackTrace();
			return "Not Successfull";
		}
	}
}
