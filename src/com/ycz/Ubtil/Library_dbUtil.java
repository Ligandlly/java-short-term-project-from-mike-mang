/*
 * 用于连接数据库的类
 * 调用Connection getCon()获得连接到库的con，（未连接到表）
 * 调用void CloseConnection(Connection con)关闭与数据库的链接
 */
package com.ycz.Ubtil;

import com.ycz.model.*;
import java.sql.*;
import java.io.*;
import java.util.*;

public class Library_dbUtil {
		private static String dbClassName="com.hxtt.sql.access.AccessDriver";
		private static String dbUrl="jdbc:Access:///E:/library_ku/图书信息管理.accdb";
		private static String dbUser = "";
		private static String dbPwd = "";
		

		public Connection getCon() throws Exception{
			Class.forName(dbClassName);
			Connection con=DriverManager.getConnection(dbUrl,dbUser,dbPwd);
			System.out.println("数据库连接成功！");
			return con;
		}
		

		public void CloseConnection(Connection con)throws Exception{
			if(con!=null) {
				con.close();
				System.out.print("数据库关闭成功！");
			}
		}
		
}
