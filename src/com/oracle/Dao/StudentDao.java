package com.oracle.Dao;

import java.util.List;

import com.oracle.POJO.StudentPOJO;

public interface StudentDao {
	public List<StudentPOJO> queryStudents();
	public int addStudent(StudentPOJO student);
	public int deleteStudent(int studentID);
	public int modifyStudent(StudentPOJO student);
	public StudentPOJO queryStudent(int studentID);
}
