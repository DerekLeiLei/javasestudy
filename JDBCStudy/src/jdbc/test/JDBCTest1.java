package jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest1 {

	private final static String URL = "jdbc:mysql://localhost:3306/jdbcstudy";
	private final static String USERNAME = "root";
	private final static String PASSWORD = "MirandaKerr615";

	public static void insert() {
		Connection con = null;
		Statement state = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "insert into person(name,age,description) values('王佳文',21,'一个美丽的人')";
			state = con.createStatement();
			state.executeUpdate(sql);
			System.out.println("执行成功!");

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				state.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		insert();
       
	}

}
