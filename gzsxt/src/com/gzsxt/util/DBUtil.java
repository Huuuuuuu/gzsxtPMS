package com.gzsxt.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
	//创建数据库属性
	private static String DB_DRIVER;
	private static String DB_URL;
	private static String DB_USER;
	private static String DB_PASSWORD;
	//获取数据库的配置信息
	static {
		InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties");
		Properties prop = new Properties();
		try {
			prop.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		DB_DRIVER = prop.getProperty("driver");
		DB_URL = prop.getProperty("url");
		DB_USER = prop.getProperty("user");
		DB_PASSWORD = prop.getProperty("password");
	}
	//初始化对象
	private static Connection conn = null;
	private static PreparedStatement stmt = null;
	private static ResultSet rs = null;
	//创建数据库连接
	public static Connection open(boolean autoCommit) {
		try {
			//加载数据库驱动
			Class.forName(DB_DRIVER);
			//获取数据库连接
			conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
			//是否开启自动提交
			conn.setAutoCommit(autoCommit);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//返回数据库连接
		return conn;		
	}
	//查询专用的封装
	public static ResultSet dbExecuteQuery(Connection conn,String sql,Object[] obj) {
		//判断是否存在Connection
		if(conn == null) {
			open(true);
		}
		try {
			//绑定参数
			stmt = conn.prepareStatement(sql);
			//判断是否存在Object[]
			if(obj != null) {
				for(int i=0;i<obj.length;i++) {
					stmt.setObject(i+1,obj[i]);
				}
			}
			//发送sql
			rs = stmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;		
	}
	public static int dbExecuteUpdata(Connection conn,String sql,Object[] obj,boolean autoCommit) {
		//初始化结果集
		int rs2 = 0;
		//判断是否存在Connection
		if(conn == null) {
			open(autoCommit);
		}
		try {
			//绑定参数
			stmt = conn.prepareStatement(sql);
			//判断是否存在Object[]
			if(obj != null) {
				for(int i=0;i<obj.length;i++) {
					stmt.setObject(i+1,obj[i]);
				}
			}
			//发送sql
			rs2 = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return rs2;		
	}
	//关闭数据库连接
	public static void close2(Connection conn,PreparedStatement stmt,ResultSet rs) {
		try {
			if(conn != null) {
				conn.close();
			}
			if(stmt != null) {
				stmt.close();
			}
			if(rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
