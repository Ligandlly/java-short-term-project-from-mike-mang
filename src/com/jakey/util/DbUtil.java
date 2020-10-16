package com.jakey.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.*;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DbUtil {
	private static String dbClassName="com.hxtt.sql.access.AccessDriver";
	private static String dbUrl="jdbc:Access:///E:/xuanke.accdb";
	private static String dbUser = "";
	private static String dbPwd = "";
	
	
	/**
	 * 获取数据库连接
	 * @return
	 * @throws Exception
	 */
	public Connection getCon() throws Exception{
		Class.forName(dbClassName);
		Connection con=DriverManager.getConnection(dbUrl,dbUser,dbPwd);
		System.out.println("连接成功");
		return con;
	}
	
	/**
	 * 关闭数据库
	 * @param con
	 * @throws Exception
	 */
	public void closeCon(Connection con)throws Exception{
		if(con!=null) {
			con.close();
			System.out.print("数据库关闭");
		}
	}
	

	public static void main(String[] args){
		Connection con=null;
		DbUtil aa = new DbUtil();
		try {
			con =aa.getCon();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

		
		
	}
	}