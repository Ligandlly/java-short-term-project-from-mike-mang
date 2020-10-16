package com.jakey.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.jakey.model.Course;
import com.jakey.model.Sinfo;
import com.jakey.util.StringUtil;

public class StudentDao {
	public ResultSet StudentList(Connection con,Sinfo sinfo) throws SQLException{
		StringBuffer sb=new StringBuffer("select * from t_sinfo ");
if(sinfo.getSno()!=-1){
	sb.append(" and Sno="+sinfo.getSno());
}
if(StringUtil.isNotEmpty(sinfo.getSname())){
	sb.append(" and Sname like '%"+sinfo.getSname()+"%'");
}
PreparedStatement pstmt=con.prepareStatement(sb.toString().replaceFirst("and", "where"));
return pstmt.executeQuery();
		}

}

