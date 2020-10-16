package coursedao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import coursesystemmodel.*;
import com.Hospital.Ubtil.*;

public class CourseDao {
	public static int courseAdd(Connection con, Course course) throws Exception {
		String sql = "insert into t_course (courseId,courseName,courseTime,courseTeacher,capacity,numSelected) values (null,?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, course.getCourseName());
		pstmt.setString(2, course.getCourseTime());
		pstmt.setString(3, course.getCourseTeacher());
		pstmt.setInt(4, course.getCapacity());
		pstmt.setInt(5, 0);
		return pstmt.executeUpdate();

	}

	public ResultSet courseLista(Connection con, Course course) throws SQLException {
		/*
		 * StringBuffer sb=new StringBuffer("select * from t_course");
		 * if(StringUtil.isNotEmpty(course.getCourseName())){
		 * sb.append(" and courseName like '%"+course.getCourseName()+"%'"); }
		 * if(StringUtil.isNotEmpty(course.getCourseTime())){
		 * sb.append(" and courseTime like '%"+course.getCourseTime()+"%'"); }
		 * if(StringUtil.isNotEmpty(course.getCourseTeacher())){
		 * sb.append(" and courseTeacher like '%"+course.getCourseTeacher()+"%'"); }
		 */
		String sql = "select * from t_course";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		return rs;
	}

	public static ResultSet courseList(Connection con, Course course) throws SQLException {
		StringBuffer sb = new StringBuffer("select * from t_course");
		if (StringUtil.isNotEmpty(course.getCourseName())) {
			sb.append(" and courseName like '%" + course.getCourseName() + "%'");
		}
		if (StringUtil.isNotEmpty(course.getCourseTime())) {
			sb.append(" and courseTime like '%" + course.getCourseTime() + "%'");
		}
		if (StringUtil.isNotEmpty(course.getCourseTeacher())) {
			sb.append(" and courseTeacher like '%" + course.getCourseTeacher() + "%'");
		}
		PreparedStatement pstmt = con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}

	public static int courseDelete(Connection con, String courseId) throws Exception {
		String sql = "delete from t_course where courseId=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, courseId);
		return pstmt.executeUpdate();

	}

	public static int courseModify(Connection con, Course course) throws Exception {
		String sql = "update t_course set courseName=?,courseTime=?,courseTeacher=?,capacity=? where courseId=? ";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, course.getCourseName());
		pstmt.setString(2, course.getCourseTime());
		pstmt.setString(3, course.getCourseTeacher());
		pstmt.setInt(4, course.getCapacity());
		pstmt.setInt(5, course.getCourseId());
		return pstmt.executeUpdate();

	}

	public static ResultSet UnderFullList(Connection con, Course course) throws SQLException {
		String sql = "select * from t_course where capacity>numSelected";
		PreparedStatement pstmt = con.prepareStatement(sql);
		return pstmt.executeQuery();
	}

//public static void main(String[] args){
//	Connection con=null;
//	DbUtil aa = new DbUtil();
//	try {
//		con =aa.getCon();
//	} catch (Exception e) {
//		// TODO 自动生成的 catch 块
//		e.printStackTrace();
//	}
//	CourseDao add = new CourseDao();
//	Course course=new Course(" 233","zhousan","秦始皇",20);
//	try {
//		add.courseAdd(con, course);
//		add.courseList(con, course);
//		add.courseDelete(con, "18");
//	} catch (Exception e) {
//		// TODO 自动生成的 catch 块
//		e.printStackTrace();
//	}
//	
//}
}
