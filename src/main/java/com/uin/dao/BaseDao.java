package com.uin.dao;

import com.uin.util.ConfigManager;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// 基类：数据库操作通用类
public class BaseDao {
	protected Connection conn;
	protected PreparedStatement ps;
	protected Statement stmt;
	protected ResultSet rs;

	// 获取数据库连接
	public boolean getConnection() {
		String driver = ConfigManager.getInstance().getString("driverClassName");
		String url = ConfigManager.getInstance().getString("url");
		String username = ConfigManager.getInstance().getString("username");
		String password = ConfigManager.getInstance().getString("password");
		// 加载驱动
		try {
			Class.forName(driver);
			// 获取数据库连接
			conn = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean getConnection2() {
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/news");
			conn = ds.getConnection();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	// 增、删、改： 如 delete from news_detail where id=? and title=?
	public int executeUpdate(String sql, Object... params) {
		int updateRows = 0;
		if(getConnection2()){
			try {
				ps=conn.prepareStatement(sql);
				// 占位符设置参数
				for(int i=0;i<params.length;i++){
					ps.setObject(i+1, params[i]);
				}
				updateRows=ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return updateRows;
	}

	// 查询
	public ResultSet executeSQL(String sql,Object... params) {
		if(getConnection2()){
			try {
				ps=conn.prepareStatement(sql);
				// 占位符设置参数
				for(int i=0;i<params.length;i++){
					ps.setObject(i+1, params[i]);
				}
				rs=ps.executeQuery();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rs;
	}

	// 关闭资源
	public boolean closeResource() {
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		if(ps!=null){
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		if(stmt!=null){
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}

}
