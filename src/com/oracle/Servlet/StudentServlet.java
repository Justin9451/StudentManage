package com.oracle.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.POJO.StudentPOJO;
import com.oracle.Service.StudentService;
import com.oracle.ServiceImpl.StudentServiceImpl;

@WebServlet("/studentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String temp = request.getParameter("submit");
		switch (temp) {
		case "queryo":
			new StudentServiceImpl().queryStudent(request, response);
			break;
		case "querys":
			new StudentServiceImpl().queryStudents(request, response);
			break;
		case "add":
			new StudentServiceImpl().addStudent(request, response);
			break;
		case "modify":
			new StudentServiceImpl().modifyStudent(request, response);
			break;
		case "delete":
			new StudentServiceImpl().deleteStudent(request, response);
			break;
		}
		// UserService userservice = new UserServiceImpl();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
