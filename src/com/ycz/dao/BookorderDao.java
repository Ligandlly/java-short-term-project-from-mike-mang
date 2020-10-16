/*
 * 订购图书的底层操作
 */
package com.ycz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Vector;

import com.ycz.Ubtil.Library_dbUtil;
import com.ycz.model.TbBookborrowinfo;
import com.ycz.model.TbBookorderinfo;

import user.User;

public class BookorderDao {

	// 用ISBN查找荐购记录
	public static TbBookorderinfo SearchBookorderinfo(Connection con, TbBookorderinfo book) throws Exception {
		System.out.println("要查找的荐购信息为："+book);
		String sql = "select * from tb_bookorderinfo where ISBN=? ";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, book.getISBN());
		ResultSet rs = stmt.executeQuery();
		//System.out.println("查找结果为："+rs.next());
		if (rs.next()) {
			book.setOrderDate(rs.getString("orderDate"));
			book.setBuyDate(rs.getString("buyDate"));
			book.setISBN(rs.getString("ISBN"));
			book.setNumber(rs.getInt("number"));
			book.setLibrarianId(rs.getString("librarianID"));
			book.setCheckAndAccept(rs.getString("checkAndAccept"));
			book.setCards(rs.getString("cards"));			
		}
		return book;
	}

	// 插入新的荐购记录
	public static int InsertBookorderinfo(Connection con, TbBookorderinfo book) throws Exception {
		String sql2 = "insert into tb_bookorderinfo values(null,?,?,?,?,?,?,?)";
		PreparedStatement wstmt = con.prepareStatement(sql2);
		wstmt.setString(1, book.getOrderDate());
		wstmt.setString(2, book.getBuyDate());
		wstmt.setString(3, book.getISBN());
		wstmt.setInt(4, book.getNumber());
		wstmt.setString(5, book.getLibrarianId());
		wstmt.setString(6, book.getCheckAndAccept());
		wstmt.setString(7, book.getCards());
		return wstmt.executeUpdate();
	}

	// 修改荐购信息_增加荐购书籍数量
	public static int IncreaseBookordernumber(Connection con, TbBookorderinfo book) throws Exception {
		String sql1 = "Update tb_bookorderinfo set orderDate=? where ISBN=?";
		String sql2 = "Update tb_bookorderinfo set number=? where ISBN=?";
		PreparedStatement stmt1 = con.prepareStatement(sql1);
		stmt1.setString(1, book.getOrderDate());
		stmt1.setString(2, book.getISBN());
		PreparedStatement stmt2 = con.prepareStatement(sql2);
		stmt2.setInt(1, book.getNumber());
		stmt2.setString(2, book.getISBN());
		return (stmt1.executeUpdate() + stmt2.executeUpdate() -1);
	}
	
	// 修改荐购信息_管理员买书
	public static int FinishBookorderinfo(Connection con, TbBookorderinfo book) throws Exception {
		String sql1 = "Update tb_bookorderinfo set buyDate=? where ISBN=?";
		String sql2 = "Update tb_bookorderinfo set librarianID=? where ISBN=?";
		String sql3 = "Update tb_bookorderinfo set checkAndAccept=? where ISBN=?";
		PreparedStatement stmt1 = con.prepareStatement(sql1);
		stmt1.setString(1, book.getBuyDate());
		stmt1.setString(2, book.getISBN());
		PreparedStatement stmt2 = con.prepareStatement(sql2);
		stmt2.setString(1, book.getLibrarianId());
		stmt2.setString(2, book.getISBN());
		PreparedStatement stmt3 = con.prepareStatement(sql3);
		stmt3.setString(1, book.getCheckAndAccept());
		stmt3.setString(2, book.getISBN());
		
		return (stmt1.executeUpdate()+stmt2.executeUpdate()+stmt3.executeUpdate()-2);
	}
	
	// 删除
	public static int DeleteBookorderinfo(Connection con, TbBookorderinfo book) throws Exception {
		String sql = "delete from tb_bookorderinfo where ISBN=?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, book.getISBN());
		return stmt.executeUpdate();
	}

	//打印还未处理的荐购信息
	public static Vector<TbBookorderinfo> showCurrentOrder(Connection con) throws SQLException {
		String sql = "select * from tb_bookorderinfo where checkAndAccept=? ";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, "false");
		Vector<TbBookorderinfo> TbB=new Vector<TbBookorderinfo>();
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			TbBookorderinfo Dtemp=new TbBookorderinfo();
			Dtemp.setOrderDate(rs.getString("orderDate"));
			Dtemp.setBuyDate(rs.getString("buyDate"));
			Dtemp.setISBN(rs.getString("ISBN"));
			Dtemp.setNumber(rs.getInt("number"));
			Dtemp.setLibrarianId(rs.getString("librarianID"));
			Dtemp.setCheckAndAccept(rs.getString("checkAndAccept"));
			Dtemp.setCards(rs.getString("cards"));	
			TbB.add(Dtemp);
		}
		return TbB;
	}


	// 测试
	public static void main(String[] args){
		// 先连接好数据库
		Library_dbUtil D = new Library_dbUtil();
		Connection con = null;
		try {
			con = D.getCon();// 这句返回一个连接上了数据库的Connection对象
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		// 测试查找荐购详细信息：通过
//		TbBookorderinfo a = new TbBookorderinfo();
//		a.setISBN("789-7-302-44454-1");
//		try {
//			System.out.println("将进入查找特定荐购图书功能!加油，可以哒！");
//			a=SearchBookorderinfo(con, a);
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		System.out.println(a);
		
//		//测试打印还未处理的的荐购信息：通过
//		Vector<TbBookorderinfo> TbB = new Vector<TbBookorderinfo>();
//		try {
//			TbB = showCurrentOrder(con);
//			for(int i=0;i<TbB.size();i++) {
//				TbBookorderinfo temp = TbB.get(i);
//				System.out.println(temp);
//			} 
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		
//		//测试增加荐购信息:通过
//		TbBookorderinfo a = new TbBookorderinfo();
//		a.setISBN("789-7-302-44454-1");
//		Calendar cal = Calendar.getInstance();//借书日期：本地时间
//		a.setOrderDate(String.valueOf(cal.getTime()));
//		a.setCheckAndAccept("false");
//		a.setNumber(1);
//		try {
//			InsertBookorderinfo(con,a);
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		
//		//测试修改——增加荐购数量:通过
//		TbBookorderinfo new_book = new TbBookorderinfo();
//		new_book.setISBN("000-7-302-44454-1");
//		new_book.setNumber(2);
//		Calendar cal = Calendar.getInstance();//借书日期：本地时间
//		new_book.setOrderDate(String.valueOf(cal.getTime()));
//		try {
//			IncreaseBookordernumber(con, new_book);
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		
//		//测试修改——管理员购买书籍:通过
//		TbBookorderinfo new_book = new TbBookorderinfo();
//		new_book.setISBN("000-7-302-44454-1");
//		new_book.setLibrarianId("213183001");
//		new_book.setCheckAndAccept("true");
//		Calendar cal = Calendar.getInstance();//借书日期：本地时间
//		new_book.setBuyDate(String.valueOf(cal.getTime()));
//		try {
//			FinishBookorderinfo(con, new_book);
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		
		//关闭数据库
		try {
			D.CloseConnection(con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
