package com.jakey.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jakey.model.Grade;
import com.jakey.util.DbUtil;
import com.jakey.util.StringUtil;


public class GradeDao {
	public int gradeAdd(Connection con,Grade grade)throws Exception{
		String sql="insert into t_grade (gradeId,gradeName,gradeTime,gradeTeacher,capacity,numSelected) values (null,?,?,?,?,?)";
		PreparedStatement  pstmt=con.prepareStatement(sql);
		pstmt.setString(1,grade.getGradeName());
		pstmt.setString(2, grade.getGradeTime());
		pstmt.setString(3, grade.getGradeTeacher());
		pstmt.setInt(4, grade.getCapacity());
		pstmt.setInt(5, 0);
		return pstmt.executeUpdate();

	}
	public ResultSet gradeLista(Connection con,Grade grade) throws SQLException{
		/*StringBuffer sb=new StringBuffer("select * from t_grade");
		if(StringUtil.isNotEmpty(grade.getGradeName())){
			sb.append(" and gradeName like '%"+grade.getGradeName()+"%'");
		}
		if(StringUtil.isNotEmpty(grade.getGradeTime())){
			sb.append(" and gradeTime like '%"+grade.getGradeTime()+"%'");
		}
		if(StringUtil.isNotEmpty(grade.getGradeTeacher())){
			sb.append(" and gradeTeacher like '%"+grade.getGradeTeacher()+"%'");
		}*/
		String sql = "select * from t_grade";
PreparedStatement pstmt=con.prepareStatement(sql);
ResultSet rs = pstmt.executeQuery();
        return rs;
		}
	
	public ResultSet gradeList(Connection con,Grade grade) throws SQLException{
		StringBuffer sb=new StringBuffer("select * from t_grade");
		if(StringUtil.isNotEmpty(grade.getGradeName())){
			sb.append(" and gradeName like '%"+grade.getGradeName()+"%'");
		}
		if(StringUtil.isNotEmpty(grade.getGradeTime())){
			sb.append(" and gradeTime like '%"+grade.getGradeTime()+"%'");
		}
		if(StringUtil.isNotEmpty(grade.getGradeTeacher())){
			sb.append(" and gradeTeacher like '%"+grade.getGradeTeacher()+"%'");
		}
PreparedStatement pstmt=con.prepareStatement(sb.toString().replaceFirst("and", "where"));
return pstmt.executeQuery();
		}
	public int gradeDelete(Connection con,String gradeId)throws Exception{
		String sql="delete from t_grade where gradeId=?";
		PreparedStatement  pstmt=con.prepareStatement(sql);
		pstmt.setString(1, gradeId);
		return pstmt.executeUpdate();

	}
	public int gradeModify(Connection con,Grade grade)throws Exception{
		String sql="update t_grade set gradeName=?,gradeTime=?,gradeTeacher=?,capacity=? where gradeId=? ";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, grade.getGradeName());
		pstmt.setString(2, grade.getGradeTime());
		pstmt.setString(3, grade.getGradeTeacher());
		pstmt.setInt(4,grade.getCapacity() );
		pstmt.setInt(5, grade.getGradeId());
		return pstmt.executeUpdate();
		
	}
	public ResultSet UnderFullList(Connection con,Grade grade) throws SQLException{
		String sql="select * from t_grade where capacity>numSelected";
		PreparedStatement pstmt=con.prepareStatement(sql);
		return pstmt.executeQuery();
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
	GradeDao add = new GradeDao();
	Grade grade=new Grade(" 233","zhousan","秦始皇",20);
	try {
		add.gradeAdd(con, grade);
		add.gradeList(con, grade);
		add.gradeDelete(con, "18");
	} catch (Exception e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	}
	
}
}
