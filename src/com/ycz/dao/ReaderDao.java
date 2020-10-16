/*
 * 与读者表有关的底层操作
 */
package com.ycz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.ycz.Ubtil.*;
import com.ycz.model.TbBookborrowinfo;
import com.ycz.model.TbReaderinfo;

public class ReaderDao {

	/*
	 * 用唯一标识card获得读者详细信息
	 */
	public static TbReaderinfo getReaderinfo(Connection con, TbReaderinfo reader) throws SQLException {
		TbReaderinfo temp = new TbReaderinfo();
		String sql = "select * from tb_readerinfo where card =? ";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, reader.getCard());
		ResultSet rs = stmt.executeQuery();
		try {// 封装数据到数据模型中
			if (rs.next()) {				
				temp.setCard(rs.getString("card"));
				temp.setReaderName(rs.getString("readerName"));
				temp.setSex(rs.getString("sex"));
				temp.setBmaxnum(rs.getString("Bmaxnum"));
				temp.setSmaxnum(rs.getString("Smaxnum"));
				temp.setReputation(rs.getDouble("reputation"));
				temp.setInstitude(rs.getString("Institude"));		
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return temp;
	}


	//插入
	public static int InsertReaderinfo(Connection con, TbReaderinfo reader) throws Exception {
		String sql2 = "insert into tb_readerinfo values(null,?,?,?,?,?,?,?)";
		PreparedStatement wstmt = con.prepareStatement(sql2);
		wstmt.setString(1, reader.getCard());
		wstmt.setString(2, reader.getReaderName());
		wstmt.setString(3, reader.getSex());
		wstmt.setString(4, reader.getBmaxnum());
		wstmt.setString(5, reader.getSmaxnum());
		wstmt.setDouble(6, reader.getReputation());
		wstmt.setString(7, reader.getInstitude());
		return wstmt.executeUpdate();
	}


	/**
	 * 管理员修改读者信息：最大可借图书数量，最大可预约图书数量，读者信誉
	 * @param con
	 * @param reader
	 * @return
	 * @throws SQLException
	 */
	public static int changeReaderinfo(Connection con, TbReaderinfo reader) throws SQLException {
		String sql = "Update tb_readerinfo set Bmaxnum=?,Smaxnum=?,reputation=? where card=?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, reader.getBmaxnum());
		stmt.setString(2, reader.getSmaxnum());
		stmt.setDouble(3, reader.getReputation());
		stmt.setString(4, reader.getCard());
		return stmt.executeUpdate();
	}


	// 修改
	public static int UpdateReaderinfo(Connection con, TbReaderinfo reader) throws Exception {
		String sql = "Update tb_readerinfo set reputation=? where card=?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setDouble(1, reader.getReputation());
		stmt.setString(2, reader.getCard());
		return stmt.executeUpdate();
	}
	
	//删除
	public static int DeleteReaderinfo(Connection con, TbReaderinfo reader) throws Exception {
		String sql = "delete from tb_readerinfo where card=?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, reader.getCard());
		return stmt.executeUpdate();
	}
	
	/**
	 * 显示所有读者
	 * 
	 * @param con
	 * @return
	 * @throws SQLException
	 */
	public static Vector<TbReaderinfo> showReaders(Connection con) throws SQLException {
		System.out.println("进入打印读者信息的函数！");
		String sql = "select * from tb_readerinfo";
		PreparedStatement stmt = con.prepareStatement(sql);
		Vector<TbReaderinfo> TbB = new Vector<TbReaderinfo>();
		ResultSet rs = stmt.executeQuery();
		//System.out.println("连接数据表的结果为："+rs.next());
		while(rs.next()) {
			TbReaderinfo temp = new TbReaderinfo();
			temp.setCard(rs.getString("card"));
			temp.setReaderName(rs.getString("readerName"));
			temp.setSex(rs.getString("sex"));
			temp.setBmaxnum(rs.getString("Bmaxnum"));
			temp.setSmaxnum(rs.getString("Smaxnum"));
			temp.setReputation(rs.getDouble("reputation"));
			temp.setInstitude(rs.getString("institude"));
			TbB.add(temp);
		}
		return TbB;
	}
	
	//测试
	public static void main(String[] args) {
		//先建立与数据库的连接
		Library_dbUtil D = new Library_dbUtil();
		Connection con = null;
		try {
			con = D.getCon();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		TbReaderinfo a = new TbReaderinfo();
		a.setCard("213183069");
		TbReaderinfo b = new TbReaderinfo();
		b.setCard("213183068");
		
		//测试显示全部读者信息:通过
		try {	
			System.out.println("显示全部读者信息");
			Vector<TbReaderinfo> TbB = showReaders(con);
			for(int i =0; i<TbB.size();i++) {
				TbReaderinfo temp = new TbReaderinfo();
				temp = TbB.get(i);
				System.out.println(temp.getCard());
				System.out.println(temp.getReaderName());
				System.out.println(temp.getSex());
				System.out.println(temp.getBmaxnum());
				System.out.println(temp.getSmaxnum());
				System.out.println(temp.getReputation());
				System.out.println(temp.getInstitude());
				System.out.println("\n");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		
//		//测试读取读者详细信息：通过
//		try {
//			System.out.println("读取读者详细信息");
//			a = getReaderinfo(con, a);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println(a);
		
//		//测试修改读者信誉：通过
//		b.setReputation(99.9);
//		try {
//			System.out.println("修改读者信誉");
//			UpdateReaderinfo(con, b);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		//关闭数据库的连接
		try {
			D.CloseConnection(con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
