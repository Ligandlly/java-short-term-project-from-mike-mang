package UserDAO;

import java.awt.*;
import java.sql.*;
import com.Hospital.Ubtil.*;

import HospitalModel.DrugModel;

import java.util.*;
import UserModel.*;

public class UserDAO {

	public UserDAO() {
	}

	/**
	 * ��ѯһ��ͨ��Ϣ
	 * 
	 * @param con
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public static UserModel SearchUser(Connection con, UserModel user) throws Exception {
		UserModel Utemp = new UserModel();
		String sql = "select * from tblUserList where Card=?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, user.getCard());
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			Utemp.setCard(rs.getString("Card"));
			Utemp.setPassword(rs.getString("Password"));
			Utemp.setIdentity(rs.getString("Identity"));
			Utemp.setUser_Name(rs.getString("User_Name"));
			Utemp.setSex(rs.getString("Sex"));
			Utemp.setCollege(rs.getString("College"));
			Utemp.setStatus(rs.getString("Status"));
			Utemp.setEmail(rs.getString("Email"));
		}
		return Utemp;
	}

	/**
	 * ������ѧ����Ϣ
	 * 
	 * @param con
	 * @param drug
	 * @return
	 * @throws Exception
	 */
	public static int InsertUser(Connection con, UserModel user) throws Exception {
		String sql2 = "insert into tblDrug values(null,?,?,?,?,?,?,?,?)";
		PreparedStatement wstmt = con.prepareStatement(sql2);
		user.setStatus("δ����");
		wstmt.setString(1, user.getCard());
		wstmt.setString(2, user.getPassword());
		wstmt.setString(3, user.getIdentity());
		wstmt.setString(4, user.getUser_Name());
		wstmt.setString(5, user.getSex());
		wstmt.setString(6, user.getCollege());
		wstmt.setString(7, user.getStatus());
		wstmt.setString(8, user.getEmail());
		return wstmt.executeUpdate();
	}

	/**
	 * �޸����루�ǹ���Ա�ã�
	 * 
	 * @param con
	 * @param drug
	 * @return
	 * @throws Exception
	 */
	public static int SUpdateUser(Connection con, UserModel user) throws Exception {
		String sql = "Update tblUser set Password=? where Card=?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, user.getPassword());
		stmt.setString(2, user.getCard());
		return stmt.executeUpdate();
	}

	/**
	 * ��������
	 * 
	 * @param con
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public static boolean AllUpdateUser(Connection con, UserModel user) throws Exception {
		String sql = "Update tblUser set Card=?,Password=?,Identity=?,User_Name=?,Sex=?,College=?,Status=?,Email=? where Card=?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, user.getCard());
		stmt.setString(2, user.getPassword());
		stmt.setString(3, user.getIdentity());
		stmt.setString(4, user.getUser_Name());
		stmt.setString(5, user.getSex());
		stmt.setString(6, user.getCollege());
		stmt.setString(7, user.getStatus());
		stmt.setString(8, user.getEmail());
		stmt.setString(9, user.getCard());
		if (stmt.executeUpdate() != 0) {
			return true;
		}
		return false;
	}

}