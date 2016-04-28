package jdbc.study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * PreparedStatement接口
 * #表示预编译的SQL语句对象
 * #SQL语句被预编译并存储在PreparedStatement对象中,
 * 让后可以使用此对象多次高效地执行该语句。
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
			// 注意SQL语句用占位符"?"代替了原来的值
			String sql = "insert into person(name,age,description) values(?,?,?)";
			// 获取PreparedStatement接口的实例，注意要将sql作为参数传入
			pstate = con.prepareStatement(sql);
			// 设置要传入的值代替上文sql语句中的"?"
			// 注意索引从1开始
			pstate.setString(1, p.getName());
			pstate.setInt(2, p.getAge());
			pstate.setString(3, p.getDescription());
			// 执行sql语句，注意不要传递参数
			pstate.executeUpdate();
			System.out.println("插入成功!");
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
			// 注意SQL语句用占位符"?"代替了原来的值
			String sql = "update person set description = ? where name =?";
			// 获取PreparedStatement接口的实例，注意要将sql作为参数传入
			pstate = con.prepareStatement(sql);
			// 设置要传入的值代替上文sql语句中的"?"
			// 注意索引从1开始
			pstate.setString(1, p.getDescription());
			pstate.setString(2, p.getName());
			// 执行sql语句，注意不要传递参数
			pstate.executeUpdate();
			System.out.println("更新成功!");
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
			// 注意SQL语句用占位符"?"代替了原来的值
			String sql = "delete from person where name = ?";
			// 获取PreparedStatement接口的实例，注意要将sql作为参数传入
			pstate = con.prepareStatement(sql);
			// 设置要传入的值代替上文sql语句中的"?"
			// 注意索引从1开始
			pstate.setString(1, name);
			// 执行sql语句，注意不要传递参数
			pstate.executeUpdate();
			System.out.println("删除成功!");
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
			// 注意SQL语句用占位符"?"代替了原来的值
			String sql = "select id, name, age, description from person where name=?";
			// 获取PreparedStatement接口的实例，注意要将sql作为参数传入
			pstate = con.prepareStatement(sql);
			// 设置要传入的值代替上文sql语句中的"?"
			// 注意索引从1开始
			pstate.setString(1, name);
			// 执行sql语句，注意不要传递参数
			result = pstate.executeQuery();
			System.out.println("查询结果为:");
			if (result.next()) {
				System.out.println(result.getInt("id") + "\t" + result.getString("name") + "\t" + result.getInt("age")
						+ "\t" + result.getString("description"));
			}
			System.out.println("查询成功!");
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
		p1.setDescription("澳大利亚超模");
		Person p2 = new Person();
		p2.setName("王佳文");
		p2.setDescription("雷磊的初恋");
		// insertPrepared(p1);
		// updatePrepared(p2);
		// deletePrepared("雷磊");
		selectPrepared("王佳文");
	}

}
