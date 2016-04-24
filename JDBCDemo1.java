package jdbc.study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/* JDBC���
 * JDBC:Java Database Connection,��ʾ���ݿ����ӣ���java��ר���ṩ��һ������
 * �������ݿ�ı�׼,���е����ݿ����������Ҫ��Ϊjava�ṩ֧�֣������֧�ִ˱�
 * ׼����Ȼ�Ǳ�׼�Ļ�������˵JDBCʵ������һ�����Ľӿڡ�
 * 
 * ��Ҫ�Ĳ�����ͽӿ�:Connection�ӿ�,Statement�ӿڣ�PreapredStatement�ӿ�,
 * ResultSet�ӿڣ�CallableStatement�ӿ�,DriverManager��
 */

/*����MySQL���ݿ�����
 * 1������Ŀ���½�libs�ļ��У�����ѹ�����������.jar�ļ����Ƶ�libs�ļ�����.
 * 2,ѡ�и��Ƶ��ļ����е�.jar�Ҽ�"Build Path"ѡ��"Add to Build Path"
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
 * stmt.executeQuery(sql);
 * 6,�ر�����
 * stmt.close();
 * conn.close();
 */

public class JDBCDemo1 {
	// ���ݿ����ӵ�ַ
	public final static String URL = "jdbc:mysql://localhost:3306/jdbcstudy";
	// �û���
	public final static String USERNAME = "root";
	// ����
	public final static String PASSWORD = "MirandaKerr615";
	// ����
	public final static String DRIVER = "com.mysql.jdbc.Driver";

	/*
	 * �������
	 */
	public static void insert() {
		Connection con = null;
		Statement state = null;
		try {
			// 1���������ݿ���������
			Class.forName(DRIVER);
			// 2, ��ȡ���ݿ�����
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			// 3, ����SQL���
			String sql = "insert into person(name,age,description) values('������',30,'һ�����˵���')";
			// 4, ����Statement�ӿ�ʵ��
			state = con.createStatement();
			// 5, ִ��SQL���
			state.executeUpdate(sql);
			// 6, �ر�����
			System.out.println("����ɹ�!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
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

	/*
	 * ���²���
	 */
	public static void update() {
		Connection con = null;
		Statement state = null;
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			state = con.createStatement();
			String sql = "update person set description='һ��Ҫ�ɹ�����!' where name='����'";
			System.out.println("���³ɹ�!");
			state.executeUpdate(sql);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
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
    
	/*
	 * ɾ������
	 */
	
	public static void delete(){
		Connection con = null;
		Statement state = null;
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "delete from person where name='������'";
			state = con.createStatement();
			state.executeUpdate(sql);
			System.out.println("ɾ���ɹ�!");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				state.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	//��SQL���ñ����滻����ֵ,ƴ��SQL���
	public static void insert1() {
		Connection con = null;
		Statement state = null;
		String name = "�λ���";
		int age = 33;
		String description = "���ڳ���ϲ������";
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			//ע��SQL���!
			String sql = "insert into person(name,age,description) values('"+name+"',"+age+",'"+description+"')";
			state = con.createStatement();
			state.executeUpdate(sql);
			System.out.println("����ɹ�!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				state.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		// insert();
		//update();
		//delete();
		insert1();
	}

}
