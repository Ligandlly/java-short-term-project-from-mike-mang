package com.ycz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ycz.model.*;

public class BookclassificationDao {

	//查找
	public static TbBookclassificationinfo SearchBookclassificationinfo(Connection con, TbBookclassificationinfo book) throws Exception {
		TbBookclassificationinfo Dtemp = new TbBookclassificationinfo();
		String sql = "select * from tb_bookclassificationinfo where typeld=? ";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, book.getTypeld());
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			Dtemp.setTypeld(rs.getString("typeld"));
			Dtemp.setTypename(rs.getString("typename"));
			Dtemp.setDays(rs.getString("days"));
			Dtemp.setPunish_money(rs.getFloat("punishmoney"));
			Dtemp.setPunish_repu(rs.getFloat("punishrepu"));
		}
		return Dtemp;
	}


	//插入
	public static int InsertBookclassificationinfo(Connection con, TbBookclassificationinfo book) throws Exception {
		String sql2 = "insert into tb_bookborrowinfo values(null,?,?,?,?,?)";
		PreparedStatement wstmt = con.prepareStatement(sql2);
		wstmt.setString(1,book.getTypeld());
		wstmt.setString(2, book.getTypename());
		wstmt.setString(3, book.getDays());
		wstmt.setFloat(4, book.getPunish_money());
		wstmt.setFloat(5, book.getPunish_repu());
		return wstmt.executeUpdate();
	}


	/*
	 * 似乎不需要修改
	//修改
	public static int UpdateBookclassificationinfo(Connection con, TbBookclassificationinfo book) throws Exception {
		String sql = "Update tb_bookborrowinfo set isback=? where card=? and ISBN=?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setBoolean(1, bookborrow.isIsback());
		stmt.setString(2, bookborrow.getCard());
		stmt.setString(3, bookborrow.getISBN());
		return stmt.executeUpdate();
	}*/


	//删除
	public static int DeleteBookclassificationinfo(Connection con, TbBookclassificationinfo book) throws Exception {
		String sql = "delete from tb_bookborrowinfo where typeld=?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, book.getTypeld());
		return stmt.executeUpdate();
	}

}

