package com.oracle.POJO;

public class StudentPOJO {
	private int studentid;
	private String studentName;

	public int getStudentid() {
		return studentid;
	}

	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((studentName == null) ? 0 : studentName.hashCode());
		result = prime * result + studentid;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentPOJO other = (StudentPOJO) obj;
		if (studentName == null) {
			if (other.studentName != null)
				return false;
		} else if (!studentName.equals(other.studentName))
			return false;
		if (studentid != other.studentid)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "StudentPOJO [studentid=" + studentid + ", studentName=" + studentName + "]";
	}

	public StudentPOJO(int studentid, String studentName) {
		super();
		this.studentid = studentid;
		this.studentName = studentName;
	}

	public StudentPOJO() {
		super();
	}

}
