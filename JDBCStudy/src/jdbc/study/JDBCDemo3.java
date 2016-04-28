package jdbc.study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * PreparedStatement�ӿ�
 * #��ʾԤ�����SQL������
 * #SQL��䱻Ԥ���벢�洢��PreparedStatement������,
 * �ú����ʹ�ô˶����θ�Ч��ִ�и���䡣
 */
public class JDBCDemo3 {
	private final static String DRIVER = "com.mysql.jdbc.Driver";
	private final static String URL = "jdbc:mysql://localhost:3306/jdbcstudy";
	private final static String USERNAME = "root";
	private final static String PASSWORD = "MirandaKerr615";

	public static void insertPrepared(Person p) {
		Connection con = null;
		PreparedStatement pstate = null;
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			// ע��SQL�����ռλ��"?"������ԭ����ֵ
			String sql = "insert into person(name,age,description) values(?,?,?)";
			// ��ȡPreparedStatement�ӿڵ�ʵ����ע��Ҫ��sql��Ϊ��������
			pstate = con.prepareStatement(sql);
			// ����Ҫ�����ֵ��������sql����е�"?"
			// ע��������1��ʼ
			pstate.setString(1, p.getName());
			pstate.setInt(2, p.getAge());
			pstate.setString(3, p.getDescription());
			// ִ��sql��䣬ע�ⲻҪ���ݲ���
			pstate.executeUpdate();
			System.out.println("����ɹ�!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstate.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public static void updatePrepared(Person p) {
		Connection con = null;
		PreparedStatement pstate = null;
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			// ע��SQL�����ռλ��"?"������ԭ����ֵ
			String sql = "update person set description = ? where name =?";
			// ��ȡPreparedStatement�ӿڵ�ʵ����ע��Ҫ��sql��Ϊ��������
			pstate = con.prepareStatement(sql);
			// ����Ҫ�����ֵ��������sql����е�"?"
			// ע��������1��ʼ
			pstate.setString(1, p.getDescription());
			pstate.setString(2, p.getName());
			// ִ��sql��䣬ע�ⲻҪ���ݲ���
			pstate.executeUpdate();
			System.out.println("���³ɹ�!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstate.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void deletePrepared(String name) {
		Connection con = null;
		PreparedStatement pstate = null;
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			// ע��SQL�����ռλ��"?"������ԭ����ֵ
			String sql = "delete from person where name = ?";
			// ��ȡPreparedStatement�ӿڵ�ʵ����ע��Ҫ��sql��Ϊ��������
			pstate = con.prepareStatement(sql);
			// ����Ҫ�����ֵ��������sql����е�"?"
			// ע��������1��ʼ
			pstate.setString(1, name);
			// ִ��sql��䣬ע�ⲻҪ���ݲ���
			pstate.executeUpdate();
			System.out.println("ɾ���ɹ�!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstate.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void selectPrepared(String name) {
		Connection con = null;
		PreparedStatement pstate = null;
		ResultSet result = null;
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			// ע��SQL�����ռλ��"?"������ԭ����ֵ
			String sql = "select id, name, age, description from person where name=?";
			// ��ȡPreparedStatement�ӿڵ�ʵ����ע��Ҫ��sql��Ϊ��������
			pstate = con.prepareStatement(sql);
			// ����Ҫ�����ֵ��������sql����е�"?"
			// ע��������1��ʼ
			pstate.setString(1, name);
			// ִ��sql��䣬ע�ⲻҪ���ݲ���
			result = pstate.executeQuery();
			System.out.println("��ѯ���Ϊ:");
			if (result.next()) {
				System.out.println(result.getInt("id") + "\t" + result.getString("name") + "\t" + result.getInt("age")
						+ "\t" + result.getString("description"));
			}
			System.out.println("��ѯ�ɹ�!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				result.close();
				pstate.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		Person p1 = new Person();
		p1.setName("MirandaKerr");
		p1.setAge(33);
		p1.setDescription("�Ĵ����ǳ�ģ");
		Person p2 = new Person();
		p2.setName("������");
		p2.setDescription("���ڵĳ���");
		// insertPrepared(p1);
		// updatePrepared(p2);
		// deletePrepared("����");
		selectPrepared("������");
	}

}
