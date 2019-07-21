package com.oracle.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface StudentService {
	public void queryStudents(HttpServletRequest request, HttpServletResponse response);
	public void addStudent(HttpServletRequest request, HttpServletResponse response);
	public void deleteStudent(HttpServletRequest request, HttpServletResponse response);
	public void modifyStudent(HttpServletRequest request, HttpServletResponse response);
	public void queryStudent(HttpServletRequest request, HttpServletResponse response);
}
