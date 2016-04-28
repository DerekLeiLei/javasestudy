package jdbc.study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * Result接口
 * #对数据库的查询操作，一般需要返回查询结果，在程序中,JDBC为我们提供了
 * Result接口来处理查询的结果集
 * #Statement通过一下方法执行查询操作:
 * ResultSet executeQuery(String sql) throws SQLException
 * 
 * #ResultSet接口常用的方法:
 * boolean next();
 * int getInt(String columnLabel);
 * int getInt(int columnIndex);
 * Date getDate(String columnLabel);
 * Date getDate(int columnIndex);
 * String getString(String columnLabel);
 * String getString(String columnIndex);
 * 
 */

/*实现操作
 * 1,加载数据库驱动
 * Class.forName("驱动程序类");
 * 2,通过用户名密码很连接地址获取数据库对象
 * DriverManager.getConnection(连接地址,用户名,密码);
 * 3,构造插入的SQL语句
 * 4,statement实例
 * Statement stmt = conn.createStatement();
 * 5,执行插入SQL语句
 * ResultSet rs = stmt.executeQuery(sql);
 * 6,处理结果
 * 7,关闭连接
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
