package arcdao;
import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Arcmodel.Archive;
import Arcmodel.log;
import Arcmodel.Manager;
import Arcmodel.Student;


public class Arcdao {

	private Arcdao() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 查询学生档案
	 * 
	 * @param con
	 * @param student
	 * @return
	 * @throws Exception
	 */
	public static Archive SearchStudent(Connection con, Archive student) throws Exception {
		Archive Stemp = new Archive();
		String sql = "select * from tblarchive where Card=? ";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, student.getCard());
		ResultSet rs = stmt.executeQuery();

		if (rs.next()) {
			Stemp.setCard(rs.getString("Card"));
			Stemp.setName(rs.getString("Name"));
			Stemp.setAge(rs.getString("Age"));
			Stemp.setSex(rs.getString("Sex"));
			Stemp.setBirthDate(rs.getString("BirthDate"));
			Stemp.setIDnumber(rs.getString("IDnumber"));
			Stemp.setNationality(rs.getString("Nationality"));
			Stemp.setNativeplace(rs.getString("Nativeplace"));
			Stemp.setMarriaged(rs.getString("Marriaged"));
			Stemp.setPolitical_status(rs.getString("Political_status"));
			Stemp.setEducation(rs.getString("Education"));
			Stemp.setCollege(rs.getString("College"));
			Stemp.setMajor(rs.getString("Major"));
			Stemp.setEnrollment_date(rs.getString("Enrollment_date"));
			Stemp.setTelephone(rs.getString("Telephone"));
		}
		return Stemp;
	}

	/**
	 * 增加学生
	 * 
	 * @param con
	 * @param drug
	 * @return
	 * @throws Exception
	 */
	public static int Insertstudent(Connection con, Archive student) throws Exception {
		String sql2 = "insert into tblarchive values(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement wstmt = con.prepareStatement(sql2);
		wstmt.setString(1, student.getCard());
		wstmt.setString(2, student.getName());
		wstmt.setString(3, student.getAge());
		wstmt.setString(4, student.getSex());

		wstmt.setString(5, student.getBirthDate());
		wstmt.setString(6, student.getIDnumber());
		wstmt.setString(7, student.getNationality());
		wstmt.setString(8, student.getNativeplace());
		wstmt.setString(9, student.getMarriaged());
		wstmt.setString(10, student.getPolitical_status());
		wstmt.setString(11, student.getEducation());
		wstmt.setString(12, student.getCollege());
		wstmt.setString(13, student.getMajor());
		wstmt.setString(14, student.getEnrollment_date());
		wstmt.setString(15, student.getTelephone());
		return wstmt.executeUpdate();
	}

	/***********************************
	 * 删除学生（不可做）
	 * 
	 * @param con
	 * @param student
	 * @return
	 * @throws Exception
	 */


	/**
	 * 学生信息更新
	 * 
	 * @param con
	 * @param drug
	 * @return
	 * @throws Exception
	 */
	public static int Updatestudent(Connection con, Archive student) throws Exception {
		String sql = "Update tblarchive set Name=?,Age=?,Sex=?,BirthDate=?,IDnumber=?,Nationality=?,Nativeplace=?,Marriaged=?,Political_status=?,Education=?,College=?,Major=?,Enrollment_date=?,Telephone=? where Card=?";
		PreparedStatement stmt = con.prepareStatement(sql);
		
		stmt.setString(1, student.getName());
		stmt.setString(2, student.getAge());
		stmt.setString(3, student.getSex());
		stmt.setString(4, student.getBirthDate());
		stmt.setString(5, student.getIDnumber());
		stmt.setString(6, student.getNationality());
		stmt.setString(7, student.getNativeplace());
		stmt.setString(8, student.getMarriaged());
		stmt.setString(9, student.getPolitical_status());
		stmt.setString(10, student.getEducation());
		stmt.setString(11, student.getCollege());
		stmt.setString(12, student.getMajor());
		stmt.setString(13, student.getEnrollment_date());
		stmt.setString(14, student.getTelephone());
		stmt.setString(15, student.getCard());
		return stmt.executeUpdate();
	}

	/**
	 * 返回所有学生信息
	 * 
	 * @param con
	 * @return
	 * @throws Exception
	 */
	public static ResultSet studentlist(Connection con) throws Exception {
		String sql = "select * from tblarchive";
		PreparedStatement stmt = con.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		return rs;
	}

	/**
	 * 学生注册
	 * 
	 * @param con
	 * @param Archive
	 * @throws Exception
	 */
	public static boolean registered(Connection con, Archive arc) throws Exception {
		Archive D = new Archive();
		D = SearchStudent(con, arc);
		if (arc.getCard()==(D.getCard())) {//判断一卡通号是否相同
			Updatestudent(con, arc);
			return true;
		} else {
			Insertstudent(con, arc);
			return true;
		}
	}

}
