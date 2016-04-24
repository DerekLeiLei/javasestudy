package jdbc.study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/* JDBC简介
 * JDBC:Java Database Connection,表示数据库连接，是java中专门提供的一组用于
 * 操作数据库的标准,所有的数据库生产商如果要想为java提供支持，则必须支持此标
 * 准，既然是标准的话，所以说JDBC实际上是一套类库的接口。
 * 
 * 主要的操作类和接口:Connection接口,Statement接口，PreapredStatement接口,
 * ResultSet接口，CallableStatement接口,DriverManager类
 */

/*导入MySQL数据库驱动
 * 1，在项目中新建libs文件夹，将解压后的驱动包的.jar文件复制到libs文件夹中.
 * 2,选中复制到文件夹中的.jar右键"Build Path"选择"Add to Build Path"
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
 * stmt.executeQuery(sql);
 * 6,关闭连接
 * stmt.close();
 * conn.close();
 */

public class JDBCDemo1 {
	// 数据库连接地址
	public final static String URL = "jdbc:mysql://localhost:3306/jdbcstudy";
	// 用户名
	public final static String USERNAME = "root";
	// 密码
	public final static String PASSWORD = "MirandaKerr615";
	// 驱动
	public final static String DRIVER = "com.mysql.jdbc.Driver";

	/*
	 * 插入操作
	 */
	public static void insert() {
		Connection con = null;
		Statement state = null;
		try {
			// 1，加载数据库驱动程序
			Class.forName(DRIVER);
			// 2, 获取数据库连接
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			// 3, 构造SQL语句
			String sql = "insert into person(name,age,description) values('王嘉昀',30,'一个迷人的人')";
			// 4, 创建Statement接口实例
			state = con.createStatement();
			// 5, 执行SQL语句
			state.executeUpdate(sql);
			// 6, 关闭连接
			System.out.println("插入成功!");
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
	 * 更新操作
	 */
	public static void update() {
		Connection con = null;
		Statement state = null;
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			state = con.createStatement();
			String sql = "update person set description='一个要成功的人!' where name='雷磊'";
			System.out.println("更新成功!");
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
	 * 删除操作
	 */
	
	public static void delete(){
		Connection con = null;
		Statement state = null;
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "delete from person where name='王嘉昀'";
			state = con.createStatement();
			state.executeUpdate(sql);
			System.out.println("删除成功!");
			
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
	
	//在SQL中用变量替换插入值,拼接SQL语句
	public static void insert1() {
		Connection con = null;
		Statement state = null;
		String name = "宋慧乔";
		int age = 33;
		String description = "雷磊初中喜欢的人";
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			//注意SQL语句!
			String sql = "insert into person(name,age,description) values('"+name+"',"+age+",'"+description+"')";
			state = con.createStatement();
			state.executeUpdate(sql);
			System.out.println("插入成功!");
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
