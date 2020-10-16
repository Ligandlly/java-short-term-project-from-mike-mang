package com.jakey.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.jakey.model.Course;
import com.jakey.model.Selection;
import com.jakey.util.DbUtil;

public class SelectionDao {
	public int SelectionAdd(Connection con,Selection selection)throws Exception{
		String sql="insert into t_selection( courseId, Sno) values (?,?)";
		PreparedStatement  pstmt=con.prepareStatement(sql);
		pstmt.setInt(1,selection.getCourseId());
		pstmt.setInt(2, selection.getSno());

		return pstmt.executeUpdate();

	}
	public int NumSelectedAdd(Connection con,int courseId)throws Exception{
		String sql="update t_course set numSelected=numSelected+1 where courseId=?";
		PreparedStatement  pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, courseId);
		return pstmt.executeUpdate();
	}
	public ResultSet SelectedList(Connection con,int sno)throws Exception{
		String sql="select  * from t_selection s,t_course c where s.Sno=? and s.courseId=c.courseId ";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setInt(1,sno);
		return pstmt.executeQuery();
	}
	public int SelectionCancel(Connection con,Selection selection)throws Exception{
		String sql="delete from t_selection where courseId=? and Sno=?";
		PreparedStatement  pstmt=con.prepareStatement(sql);
		pstmt.setInt(1,selection.getCourseId());
		pstmt.setInt(2, selection.getSno());
		return pstmt.executeUpdate();
	}
	public int NumSelectedMinus(Connection con,int courseId)throws Exception{
		String sql="update t_course set numSelected=numSelected-1 where courseId=?";
		PreparedStatement  pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, courseId);
		return pstmt.executeUpdate();
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
		SelectionDao add = new SelectionDao();
		Course course=new Course(" 233","zhousan","秦始皇",20);
		Selection bb = new Selection(12,9018125);
		try {
			add.SelectionAdd(con, bb);
			add.NumSelectedAdd( con,22);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}
}
