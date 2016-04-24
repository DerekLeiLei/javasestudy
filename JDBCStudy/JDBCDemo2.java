package jdbc.study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * Result�ӿ�
 * #�����ݿ�Ĳ�ѯ������һ����Ҫ���ز�ѯ������ڳ�����,JDBCΪ�����ṩ��
 * Result�ӿ��������ѯ�Ľ����
 * #Statementͨ��һ�·���ִ�в�ѯ����:
 * ResultSet executeQuery(String sql) throws SQLException
 * 
 * #ResultSet�ӿڳ��õķ���:
 * boolean next();
 * int getInt(String columnLabel);
 * int getInt(int columnIndex);
 * Date getDate(String columnLabel);
 * Date getDate(int columnIndex);
 * String getString(String columnLabel);
 * String getString(String columnIndex);
 * 
 */

/*ʵ�ֲ���
 * 1,�������ݿ�����
 * Class.forName("����������");
 * 2,ͨ���û�����������ӵ�ַ��ȡ���ݿ����
 * DriverManager.getConnection(���ӵ�ַ,�û���,����);
 * 3,��������SQL���
 * 4,statementʵ��
 * Statement stmt = conn.createStatement();
 * 5,ִ�в���SQL���
 * ResultSet rs = stmt.executeQuery(sql);
 * 6,������
 * 7,�ر�����
 * rs.close();
 * stmt.close();
 * conn.close();
 */
public class JDBCDemo2 {

	private final static String URL = "jdbc:mysql://localhost:3306/jdbcstudy";
	private final static String USERNAME = "root";
	private final static String PASSWORD = "MirandaKerr615";
	private final static String DRIVER = "com.mysql.jdbc.Driver";

	public static void select() {
		Connection con = null;
		Statement state = null;
		ResultSet result = null;
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "select id, name, age, description from person";
			state = con.createStatement();
			result = state.executeQuery(sql);
			System.out.println("id\tname\tage\tdescription");
			while (result.next()) {
				int id = result.getInt("id");
				String name = result.getString("name");
				int age = result.getInt("age");
				String desc = result.getString("description");
				System.out.println(id + "\t" + name + "\t" + age + "\t" + desc);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				result.close();
				state.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		select();

	}

}
