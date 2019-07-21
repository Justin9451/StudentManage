package com.oracle.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.oracle.Dao.StudentDao;
import com.oracle.JDBC.JDBCPool;
import com.oracle.POJO.StudentPOJO;

public class StudentDaoImpl implements StudentDao {
	@Test
	@Override
	public List<StudentPOJO> queryStudents() {
		Connection conn = null;
		PreparedStatement psmt = null;
		List<StudentPOJO> students = new ArrayList<>();
		try {
			conn = JDBCPool.getConnection();
			String sql = "SELECT * FROM Student";
			psmt = conn.prepareStatement(sql);
			ResultSet result = psmt.executeQuery();
			while (result.next()) {
				String studentName = result.getString(1);
				int studentID = result.getInt(2);
				StudentPOJO student = new StudentPOJO(studentID, studentName);
				students.add(student);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				psmt.close();
				JDBCPool.closeConnection(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return students;
	}
	
	@Override
	public StudentPOJO queryStudent(int studentID) {
		Connection conn = null;
		PreparedStatement psmt = null;
		try {
			conn = JDBCPool.getConnection();
			String sql = "SELECT * FROM Student WHERE STUDENT_ID = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, studentID);
			ResultSet result = psmt.executeQuery();
			while (result.next()) {
				String studentname = result.getString(1);
				int studentId = result.getInt(2);
				StudentPOJO student = new StudentPOJO(studentId, studentname);
				return student;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				psmt.close();
				JDBCPool.closeConnection(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public int addStudent(StudentPOJO student) {
		Connection conn = null;
		PreparedStatement psmt = null;
		try {
			conn = JDBCPool.getConnection();
			String studentName = student.getStudentName();
			int studentID = student.getStudentid();
			String sql = "INSERT INTO STUDENT VALUES (?,?) ";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1,studentName);
			psmt.setInt(2, studentID);
			int result = psmt.executeUpdate();
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				psmt.close();
				JDBCPool.closeConnection(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public int deleteStudent(int studentID) {
		Connection conn = null;
		PreparedStatement psmt = null;
		try {
			conn = JDBCPool.getConnection();
			String sql = "DELETE FROM STUDENT WHERE STUDENT_ID = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, studentID);
			int result = psmt.executeUpdate();
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				psmt.close();
				JDBCPool.closeConnection(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public int modifyStudent(StudentPOJO student) {
		//UPDATE 表名称 SET 列名称 = 新值 WHERE 列名称 = 某值
		Connection conn = null;
		PreparedStatement psmt = null;
		String studentName = student.getStudentName();
		int studentID = student.getStudentid();
		try {
			conn = JDBCPool.getConnection();
			String sql = "UPDATE STUDENT SET STUDENT_NAME = ? WHERE STUDENT_ID = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, studentName);
			psmt.setInt(2, studentID);
			int result = psmt.executeUpdate();
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				psmt.close();
				JDBCPool.closeConnection(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}


}
