package com.ycz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.Hospital.Ubtil.StringUtil;
// import com.mysql.cj.util.StringUtil;
import com.ycz.Ubtil.Library_dbUtil;
import com.ycz.model.TbBookborrowinfo;
import com.ycz.model.TbBookinfo;
import com.ycz.model.TbReaderinfo;

public class BookDao {


	/**
	 * 通过图书题名精确查找图书
	 * @param con
	 * @param book
	 * @return
	 * @throws Exception
	 */
	public static TbBookinfo SearchBookinfo(Connection con, TbBookinfo book) throws Exception {
		TbBookinfo Dtemp = new TbBookinfo();
		String sql = "select * from tb_bookinfo where bookName=? ";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, book.getBookName());
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			Dtemp.setISBN(rs.getString("ISBN"));
			Dtemp.setTypeld(rs.getString("typeld"));
			Dtemp.setBookName(rs.getString("bookName"));
			Dtemp.setWriter(rs.getString("writer"));
			Dtemp.setPublisher(rs.getString("publisher"));
			Dtemp.setPublicdate(rs.getString("publicdate"));
			Dtemp.setPrice(rs.getDouble("price"));
			Dtemp.setAmount(rs.getInt("amount"));
		}
		else{System.out.println("臣妾查不到哇！");}
		return Dtemp;
	}

	// 插入
	public static int InsertBookinfo(Connection con, TbBookinfo book) throws Exception {
		String sql2 = "insert into tb_bookinfo values(null,?,?,?,?,?,?,?,?)";
		PreparedStatement wstmt = con.prepareStatement(sql2);
		wstmt.setString(1, book.getISBN());
		wstmt.setString(2, book.getTypeld());
		wstmt.setString(3, book.getBookName());
		wstmt.setString(4, book.getWriter());
		wstmt.setString(5, book.getPublisher());
		wstmt.setString(6, book.getPublicdate());
		wstmt.setDouble(7, book.getPrice());
		wstmt.setDouble(8, book.getAmount());
		return wstmt.executeUpdate();
	}


	/**
	 * 修改：根据ISBN
	 * @param con
	 * @param book
	 * @return
	 * @throws Exception
	 */
	public static int UpdateBookinfo(Connection con, TbBookinfo book) throws Exception {
		String sql1 = "Update tb_bookinfo set amount=? where ISBN=?";
		PreparedStatement stmt1 = con.prepareStatement(sql1);
		stmt1.setInt(1, book.getAmount());
		stmt1.setString(2, book.getISBN());
		return stmt1.executeUpdate();
	}


	/**
	 * 删除图书：根据ISBN
	 * @param con
	 * @param book
	 * @return
	 * @throws Exception
	 */
	public static int DeleteBookinfo(Connection con, TbBookinfo book) throws Exception {
		String sql = "delete from tb_bookinfo where ISBN=?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, book.getISBN());
		return stmt.executeUpdate();
	}

	/**
	 * 展示所有图书
	 * @param con
	 * @return
	 * @throws SQLException
	 */
	public static Vector<TbBookinfo> showBooks(Connection con) throws SQLException {
		String sql = "select * from tb_bookinfo";
		PreparedStatement stmt = con.prepareStatement(sql);
		Vector<TbBookinfo> TbB = new Vector<TbBookinfo>();
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			TbBookinfo temp = new TbBookinfo();
			temp.setISBN(rs.getString("ISBN"));
			temp.setTypeld(rs.getString("typeld"));
			temp.setBookName(rs.getString("bookName"));
			temp.setWriter(rs.getString("writer"));
			temp.setPublisher(rs.getString("publisher"));
			temp.setPublicdate(rs.getString("publicdate"));
			temp.setPrice(rs.getDouble("price"));
			temp.setAmount(rs.getInt("amount"));
			TbB.add(temp);
		}
		return TbB;
	}
	
	/**
	 * 多关键词模糊查找
	 * 可能输入的值有：题名、作者、出版社、ISBN，模糊查询，（简直太棒啦！）
	 * @param con
	 * @param book
	 * @return
	 * @throws SQLException
	 */
	public static Vector<TbBookinfo> SearchBookinfo2(Connection con, TbBookinfo book) throws SQLException {
		// String sql = "select * from tb_bookinfo where";
		System.out.println("进入搜索函数");
		StringBuffer sb = new StringBuffer("select * from tb_bookinfo");
		if (StringUtil.isNotEmpty(book.getBookName())) {
			sb.append(" and bookName like '%" + book.getBookName() + "%'");
		}
		if (StringUtil.isNotEmpty(book.getWriter())) {
			sb.append(" and writer like '%" + book.getWriter() + "%'");
		}
		if (StringUtil.isNotEmpty(book.getPublisher())) {
			sb.append(" and publisher like '%" + book.getPublisher() + "%'");
		}
		if (StringUtil.isNotEmpty(book.getISBN())) {
			sb.append(" and ISBN like '%" + book.getISBN() + "%'");
		}
		System.out.println("现在的sql语句为：" + sb.toString().replaceFirst("and", "where"));
		PreparedStatement stmt = con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		Vector<TbBookinfo> TbB = new Vector<TbBookinfo>();
		// stmt.setString(1, book.getBookName());
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			TbBookinfo temp = new TbBookinfo();
			temp.setISBN(rs.getString("ISBN"));
			temp.setTypeld(rs.getString("typeld"));
			temp.setBookName(rs.getString("bookName"));
			temp.setWriter(rs.getString("writer"));
			temp.setPublisher(rs.getString("publisher"));
			temp.setPublicdate(rs.getString("publicdate"));
			temp.setPrice(rs.getDouble("price"));
			temp.setAmount(rs.getInt("amount"));
			TbB.add(temp);
		}
		return TbB;
	}

	// 测试
	public static void main(String[] args) {
		//先连接好数据库
		Library_dbUtil D = new Library_dbUtil();
		Connection con = null;
		try {
			con = D.getCon();//这句返回一个连接上了数据库的Connection对象
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TbBookinfo a = new TbBookinfo();
		a.setBookName("JAVA从入门到精通");
		
		try {
			System.out.println("正在测试查找特定图书功能");
			a = SearchBookinfo(con,a);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(a);
		
//		//测试插入功能
//		TbBookinfo new_book = new TbBookinfo();
//		new_book.setISBN("321-7-302-44454-2");
//		new_book.setTypeld("3");;
//		new_book.setBookName("现代小说鉴赏");
//		new_book.setWriter("佚名");
//		new_book.setPublisher("东南大学出版社");;
//		new_book.setPublicdate("2020/9/18");
//		new_book.setPrice(50.2);
//		new_book.setAmount(2);
//		try {
//			System.out.println("正在测试插入功能");
//			System.out.println(	InsertBookinfo(con, new_book));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}	
		
//		//测试修改功能
//		TbBookinfo new_book = new TbBookinfo();
//		new_book.setAmount(20);
//		new_book.setISBN("978-7-302-44454-1");
//		try {
//			System.out.println("正在测试修改功能");
//			System.out.println(UpdateBookinfo(con, new_book));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}		
		
//		//测试删除功能
//		TbBookinfo delete_book = new TbBookinfo();
//		delete_book.setISBN("978-7-302-44454-1");
//		try {
//			System.out.println("正在测试删除功能");
//			System.out.println(DeleteBookinfo(con, delete_book));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		//测试多关键词模糊查找功能
//		TbBookinfo b = new TbBookinfo();
//		b.setISBN("789-7-302-44454-2");
//		try {
//			System.out.println("正在测试多关键词模糊查找功能");
//			System.out.println("即将进入查找函数");
//			ResultSet rs = SearchBookinfo2(con,b);
//			while (rs.next()) {
//				System.out.println(rs.getString("ISBN"));
//				System.out.println(rs.getString("typeld"));
//				System.out.println(rs.getString("bookName"));
//				System.out.println(rs.getString("writer"));
//				System.out.println(rs.getString("publisher"));
//				System.out.println(rs.getString("publicdate"));
//				System.out.println(rs.getString("price"));
//				System.out.println(rs.getString("amount"));
//				System.out.println("\n");
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
