package com.Hospital.Ubtil;

import java.sql.*;
/**
 * ���ݿ⹤����
 */
public class Hospital_dbUtil {

	private static String dbClassName="com.hxtt.sql.access.AccessDriver";
	private static String dbUrl="jdbc:Access:///C:/Users/91261/Desktop/ALLDATA.accdb";//"jdbc:Access:///C:/Users/91261/Desktop/1/database/Hospital1.accdb"
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
	public void CloseConnection(Connection con)throws Exception{
		if(con!=null) {
			con.close();
			System.out.print("���ݿ�ر�");
		}
	}
	
}
