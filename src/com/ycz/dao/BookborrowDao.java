package com.ycz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.ycz.Ubtil.Library_dbUtil;
import com.ycz.model.*;

import user.*;

public class BookborrowDao {

	// 查找
	public static TbBookborrowinfo SearchBookborrowinfo(Connection con, TbBookborrowinfo bookborrow) throws Exception {
		TbBookborrowinfo Dtemp = new TbBookborrowinfo();
		String sql = "select * from tb_bookborrowinfo where ISBN=? and card=? ";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, bookborrow.getISBN());
		stmt.setString(2, bookborrow.getCard());
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			Dtemp.setCard(rs.getString("card"));
			Dtemp.setBookName(rs.getString("bookName"));
			Dtemp.setISBN(rs.getString("ISBN"));
			Dtemp.setWriter(rs.getString("writer"));
			Dtemp.setTypeld(rs.getString("typeld"));
			Dtemp.setLibrarianId(rs.getString("librarianID"));
			Dtemp.setIsback(rs.getString("isback"));
			Dtemp.setBorrowDate(rs.getString("borrowDate"));
			Dtemp.setBackDate(rs.getString("backDate"));
		}
		return Dtemp;
	}

	// 插入
	public static int InsertBookborrowinfo(Connection con, TbBookborrowinfo bookborrow) throws Exception {
		String sql2 = "insert into tb_bookborrowinfo values(null,?,?,?,?,?,?,?,?,?)";
		PreparedStatement wstmt = con.prepareStatement(sql2);
		wstmt.setString(1, bookborrow.getCard());
		wstmt.setString(2, bookborrow.getBookName());
		wstmt.setString(3, bookborrow.getISBN());
		wstmt.setString(4, bookborrow.getWriter());
		wstmt.setString(5, bookborrow.getTypeld());
		wstmt.setString(6, bookborrow.getLibrarianId());
		wstmt.setString(7, bookborrow.getIsback());
		wstmt.setString(8, bookborrow.getBorrowDate());
		wstmt.setString(9, bookborrow.getBackDate());
		return wstmt.executeUpdate();
	}

	// 修改
	public static int UpdateBookborrowinfo(Connection con, TbBookborrowinfo bookborrow) throws Exception {
		String sql = "Update tb_bookborrowinfo set isback=? where card=? and ISBN=?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, bookborrow.getIsback());
		stmt.setString(2, bookborrow.getCard());
		stmt.setString(3, bookborrow.getISBN());
		return stmt.executeUpdate();
	}

	// 删除
	public static int DeleteBookborrowinfo(Connection con, TbBookborrowinfo bookborrow) throws Exception {
		String sql = "delete from tb_bookborrowinfo where card=? and ISBN=?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, bookborrow.getCard());
		stmt.setString(2, bookborrow.getISBN());
		return stmt.executeUpdate();
	}

	public static Vector<TbBookborrowinfo> showCurrentBorrow(Connection con, User person) throws SQLException {
		String sql = "select * from tb_bookborrowinfo where card=? and isback=? ";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, person.card);
		stmt.setString(2, "false");
		Vector<TbBookborrowinfo> TbB=new Vector<TbBookborrowinfo>();
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			TbBookborrowinfo t=new TbBookborrowinfo();
			t.setCard(rs.getString("card"));
			t.setBookName(rs.getString("bookName"));
			t.setISBN(rs.getString("ISBN"));
			t.setWriter(rs.getString("writer"));
			t.setTypeld(rs.getString("typeld"));
			t.setLibrarianId(rs.getString("librarianID"));
			t.setIsback(rs.getString("isback"));
			t.setBorrowDate(rs.getString("borrowDate"));
			t.setBackDate(rs.getString("backDate"));
			TbB.add(t);
		}
		return TbB;
	}

//	public static ResultSet showCurrentBorrow(Connection con) throws SQLException {
//		String sql = "select * from tb_bookborrowinfo where card=? and isback=false";
//		PreparedStatement stmt = con.prepareStatement(sql);
//		stmt.setString(1, "213183069");
//		ResultSet rs = stmt.executeQuery();
//		return rs;
//	}

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
		
//		// 测试读出借书详细信息：通过
//		TbBookborrowinfo a = new TbBookborrowinfo();
//		a.setISBN("978-7-302-44454-1");
//		a.setCard("213183069");
//		try {
//			a=SearchBookborrowinfo(con, a);
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		System.out.println(a);
		
//		//测试显示当前读者当前借阅信息：通过
//		User user1 = new User("213183069", "喻慈舟", "student");		
//		try {
//			ResultSet rs = showCurrentBorrow(con, user1);
//			while (rs.next()) {
//				System.out.println(rs.getString("card"));
//				System.out.println(rs.getString("bookName"));
//				System.out.println(rs.getString("ISBN"));
//				System.out.println(rs.getString("writer"));
//				System.out.println(rs.getString("typeld"));
//				System.out.println(rs.getString("LibrarianID"));
//				System.out.println(rs.getString("isback"));
//				System.out.println(rs.getString("borrowDate"));
//				System.out.println(rs.getString("backDate"));
//				System.out.println("\n");
//			} 
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		//测试添加借阅记录功能：通过
//		TbBookborrowinfo new_bookborrow = new TbBookborrowinfo();
//		new_bookborrow.setCard("213183069");
//		new_bookborrow.setISBN("321-7-302-44454-2");
//		new_bookborrow.setTypeld("3");
//		new_bookborrow.setBookName("现代小说鉴赏");
//		new_bookborrow.setLibrarianId("213183000");
//		new_bookborrow.setWriter("佚名");
//		new_bookborrow.setIsback("false");
//		new_bookborrow.setBorrowDate("2020/9/18");
//		new_bookborrow.setBackDate("2020/9/29");
//		try {
//			System.out.println("新增借书信息的结果为：" + InsertBookborrowinfo(con, new_bookborrow));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		try {
			D.CloseConnection(con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
