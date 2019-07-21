package com.oracle.ServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.Dao.StudentDao;
import com.oracle.DaoImpl.StudentDaoImpl;
import com.oracle.POJO.StudentPOJO;
import com.oracle.Service.StudentService;
import com.oracle.utils.PageUtils;

public class StudentServiceImpl implements StudentService {

	@Override
	public void queryStudents(HttpServletRequest request, HttpServletResponse response) {
		StudentDao userDaoImpl = new StudentDaoImpl();
		List<StudentPOJO> students = userDaoImpl.queryStudents();
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw;
		try {
			pw = response.getWriter();
			pw.write("<!DOCTYPE html>");
			pw.write("<html>");
			pw.write("<head>");
			pw.write("<meta charset=\"UTF-8\">");
			pw.write("<title>学生信息</title>");
			pw.write("</head>");
			pw.write("<body>");
			pw.write("<h1>查询到的学生信息</h1>");
			pw.write("Studentid" + "StudentName");
			pw.write("</br>");
			for (StudentPOJO student : students) {
				pw.write(student.getStudentid() + student.getStudentName());
				pw.write("</br>");
			}
			pw.write("</table>");
			pw.write("</body>");
			pw.write("</html>");
			pw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void queryStudent(HttpServletRequest request, HttpServletResponse response) {
		int studentID = Integer.parseInt(request.getParameter("studentID"));
		StudentDao userDaoImpl = new StudentDaoImpl();
		StudentPOJO student = userDaoImpl.queryStudent(studentID);
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw;
		try {
			pw = response.getWriter();
			pw.write("<!DOCTYPE html>");
			pw.write("<html>");
			pw.write("<head>");
			pw.write("<meta charset=\"UTF-8\">");
			pw.write("<title>学生信息</title>");
			pw.write("</head>");
			pw.write("<body>");
			pw.write("<h1>查询到的学生信息</h1>");
			pw.write("Studentid" + "StudentName");
			pw.write("</br>");
			pw.write(student.getStudentid() + student.getStudentName());
			pw.write("</br>");
			pw.write("</table>");
			pw.write("</body>");
			pw.write("</html>");
			pw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void addStudent(HttpServletRequest request, HttpServletResponse response) {
		String studentName = request.getParameter("studentName");
		int studentID = Integer.parseInt(request.getParameter("studentID"));
		StudentPOJO student = new StudentPOJO(studentID, studentName);
		StudentDao userDaoImpl = new StudentDaoImpl();
		int middle = userDaoImpl.addStudent(student);
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw;
		try {
			pw = response.getWriter();
			pw.write("<!DOCTYPE html>");
			pw.write("<html>");
			pw.write("<head>");
			pw.write("<meta charset=\"UTF-8\">");
			pw.write("<title>学生信息</title>");
			pw.write("</head>");
			pw.write("<body>");
			if (middle == 1) {
				pw.write("<h1>添加成功</h1>");
			} else {
				pw.write("<h1>添加失败</h1>");
			}
			pw.write("</body>");
			pw.write("</html>");
			pw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteStudent(HttpServletRequest request, HttpServletResponse response) {
		int studentID = Integer.parseInt(request.getParameter("studentID"));
		StudentDao userDaoImpl = new StudentDaoImpl();
		int middle = userDaoImpl.deleteStudent(studentID);
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw;
		try {
			pw = response.getWriter();
			pw.write("<!DOCTYPE html>");
			pw.write("<html>");
			pw.write("<head>");
			pw.write("<meta charset=\"UTF-8\">");
			pw.write("<title>学生信息</title>");
			pw.write("</head>");
			pw.write("<body>");
			if (middle == 1) {
				pw.write("<h1>删除成功</h1>");
			} else {
				pw.write("<h1>删除失败</h1>");
			}
			pw.write("</body>");
			pw.write("</html>");
			pw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void modifyStudent(HttpServletRequest request, HttpServletResponse response) {
		String studentName = request.getParameter("studentName");
		int studentID = Integer.parseInt(request.getParameter("studentID"));
		StudentPOJO student = new StudentPOJO(studentID, studentName);
		StudentDao userDaoImpl = new StudentDaoImpl();
		int middle = userDaoImpl.modifyStudent(student);
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw;
		try {
			pw = response.getWriter();
			pw.write("<!DOCTYPE html>");
			pw.write("<html>");
			pw.write("<head>");
			pw.write("<meta charset=\"UTF-8\">");
			pw.write("<title>学生信息</title>");
			pw.write("</head>");
			pw.write("<body>");
			if (middle == 1) {
				pw.write("<h1>修改成功</h1>");
			} else {
				pw.write("<h1>修改失败</h1>");
			}
			pw.write("</body>");
			pw.write("</html>");
			pw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
