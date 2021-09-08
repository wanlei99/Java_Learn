package com.wl.jdbc;

import java.sql.*;
import java.util.ConcurrentModificationException;

/**
 * @author WL
 * @description: JDBC数据库连接
 * @date 2021/9/8 10:45
 */
public class JDBCConnect {
	/**
	 * JDBC 驱动和数据库URL
	 */
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/mybatis?useSSl=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
	/**
	 * 数据库用户名和密码
	 */
	static final String USER = "root";
	static final String PASSWORD = "";

	public static void main(String[] args) throws SQLException {
		Connection connection = null;
		Statement statement = null;
		try {
			//注册JDBC驱动
			Class.forName(JDBC_DRIVER);

			//打开链接
			System.out.println("连接数据库...");
			connection = DriverManager.getConnection(DB_URL,USER,PASSWORD);

			//执行查询
			System.out.println("实例化Statement对象...");
			statement = connection.createStatement();
			String sql;
			sql = "SELECT * FROM user";
			ResultSet resultSet = statement.executeQuery(sql);

			//展开结果集
			while (resultSet.next()){
				//通过字段检索
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String password = resultSet.getString("pwd");
				//输出
				System.out.println("id:"+id+";name："+name+";pwd："+password);
			}
			//关闭与数据库的链接
			resultSet.close();
			statement.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			//关闭数据源
			try{
				if (statement!=null){
					statement.close();
				}
			}catch (SQLException sqlException){
				sqlException.printStackTrace();
			}
			try {
				if (connection!=null){
					connection.close();
				}
			}catch (SQLException sqlException){
				sqlException.printStackTrace();
			}
		}
		System.out.println("再见！");
	}
}
