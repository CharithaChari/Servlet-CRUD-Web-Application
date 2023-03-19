package org.manu.CRUDApp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.manu.CRUDApp.dto.Student;

public class StudentDao {
	static Connection connection;
	PreparedStatement preparedStatement;
	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/btm";
	public static final String USER = "root";
	public static final String PASSWORD = "admin";
	{
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public Student LoginStudent(String Email, String Pass) {
		System.out.println();
		String query = "SELECT * FROM CRUD WHERE EMAIL=? and PASS=?";
		Student student = new Student();
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, Email);
			preparedStatement.setString(2, Pass);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				student.setEmail(resultSet.getString(1));
				student.setName(resultSet.getString(2));
				student.setPhone(resultSet.getLong(3));
				student.setCollage(resultSet.getString(4));
				student.setDept(resultSet.getString(5));
				student.setYear(resultSet.getString(6));
				student.setPer10(resultSet.getDouble(7));
				student.setPerc12(resultSet.getDouble(8));
				student.setDegreePer(resultSet.getDouble(9));
				student.setGender(resultSet.getString(10));
				student.setPassword(resultSet.getString(11));
			} else {
				student = null;
			}

			System.out.println("Resource opened");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(connection, preparedStatement, resultSet);
			System.out.println("Resource Closed");
		}
		return student;
	}

	public boolean CheckRegistration(String Email, String Pass) {
		String query = "SELECT EMAIL,PASS FROM CRUD WHERE EMAIL=? and PASS=?";
		boolean result = true;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, Email);
			preparedStatement.setString(2, Pass);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next())
				result = true;
			else
				result = false;
			System.out.println("Resource opened");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(connection, preparedStatement, resultSet);
			System.out.println("Resource Closed");
		}
		return result;
	}
	public int InsertStudent(Student student) {
		String query = "INSERT INTO CRUD VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		int status = 0;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, student.getEmail());
			preparedStatement.setString(2, student.getName());
			preparedStatement.setLong(3, student.getPhone());
			preparedStatement.setString(4, student.getCollage());
			preparedStatement.setString(5, student.getDept());
			preparedStatement.setString(6, student.getYear());
			preparedStatement.setDouble(7, student.getPer10());
			preparedStatement.setDouble(8, student.getPerc12());
			preparedStatement.setDouble(9, student.getDegreePer());
			preparedStatement.setString(10, student.getGender());
			preparedStatement.setString(11, student.getPassword());
			status = preparedStatement.executeUpdate();
			System.out.println("Resource opened");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(connection, preparedStatement, null);
			System.out.println("Resource Closed");
		}
		return status;
	}

	public int updateStudent(Student student) {
		String query = "UPDATE CRUD SET EMAIL=?, NAME=?, COLLAGE=?, DEPT=?, YEAR=?, PER10=?, PERC12=?, DEGREEPER=?, GENDER=?,PASS=? WHERE PHONE=?";
		int status = 0;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, student.getEmail());
			preparedStatement.setString(2, student.getName());
			preparedStatement.setString(3, student.getCollage());
			preparedStatement.setString(4, student.getDept());
			preparedStatement.setString(5, student.getYear());
			preparedStatement.setDouble(6, student.getPer10());
			preparedStatement.setDouble(7, student.getPerc12());
			preparedStatement.setDouble(8, student.getDegreePer());
			preparedStatement.setString(9, student.getGender());
			preparedStatement.setString(10, student.getPassword());
			preparedStatement.setLong(11, student.getPhone());
			status = preparedStatement.executeUpdate();
			System.out.println("Resource opened");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(connection, preparedStatement, null);
			System.out.println("Resource Closed");
		}
		return status;
	}

	public int DeleteStudent(long phone) {
		String query = "DELETE FROM CRUD WHERE PHONE=?";
		int status = 0;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, phone);
			status = preparedStatement.executeUpdate();
			System.out.println("Resource opened");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(connection, preparedStatement, null);
			System.out.println("Resource Closed");
		}
		return status;
	}

	public void closeResources(Connection con, PreparedStatement pst, ResultSet rs) {
		try {
			if (con != null)
				con.close();
			if (pst != null)
				pst.close();
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
