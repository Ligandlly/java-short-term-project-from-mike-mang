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
	 * ��ȡ���ݿ�����
	 * @return
	 * @throws Exception
	 */
	public Connection getCon() throws Exception{
		Class.forName(dbClassName);
		Connection con=DriverManager.getConnection(dbUrl,dbUser,dbPwd);
		System.out.println("���ӳɹ�");
		return con;
	}
	
	/**
	 * �ر����ݿ�
	 * @param con
	 * @throws Exception
	 */
	public void closeCon(Connection con)throws Exception{
		if(con!=null) {
			con.close();
			System.out.print("���ݿ�ر�");
		}
	}
	

	public static void main(String[] args){
		Connection con=null;
		DbUtil aa = new DbUtil();
		try {
			con =aa.getCon();
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}

		
		
	}
	}