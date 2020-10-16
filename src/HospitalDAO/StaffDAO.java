package HospitalDAO;

import java.awt.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import com.Hospital.Ubtil.Hospital_dbUtil;
import com.Hospital.Ubtil.StringUtil;

import HospitalModel.DrugModel;
import HospitalModel.DrugTrade;
import HospitalModel.FeeModel;
import HospitalModel.MedHistoryModel;
import HospitalModel.Regist;
import HospitalModel.StaffModel;
import HospitalModel.Transfer;
import UserModel.UserModel;
import UserDAO.UserDAO;

/**
 * 待查bug，连接数据库成功，但是表没信息
 * 
 * @author 91261
 *
 */
public class StaffDAO {

	private StaffDAO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 查询职工信息
	 * 
	 * @param con
	 * @param staff
	 * @return
	 * @throws Exception
	 */
	public static StaffModel SearchStaff(Connection con, StaffModel staff){
		System.out.println("进入查找函数");
		StaffModel Stemp = new StaffModel();
		String sql = "select * from tbldoctor where Staff_Name=? ";
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("要查找的医生姓名是："+staff.getStaff_Name());
		try {
			stmt.setString(1, staff.getStaff_Name());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		try {
//			System.out.println("查找结果是："+rs.next());
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		try {
			if (rs.next()) {
				Stemp.setCard(rs.getString("Staff_Card"));
				Stemp.setStaff_Name(rs.getString("Staff_Name"));
				Stemp.setStaff_Sex(rs.getString("Staff_Sex"));
				Stemp.setStaff_Identity(rs.getString("Staff_Identity"));
				Stemp.setStaff_WorkTime(rs.getString("Staff_WorkTime"));
				Stemp.setStaff_Department(rs.getString("Staff_Department"));
				Stemp.setStaff_Fee(rs.getDouble("Regist_Fee"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Stemp;
	}

	/**
	 * 增加职工
	 * 
	 * @param con
	 * @param drug
	 * @return
	 * @throws Exception
	 */
	public static int InsertStaff(Connection con, StaffModel staff) throws Exception {
		String sql2 = "insert into tbldoctor values(null,?,?,?,?,?,?,?)";
		PreparedStatement wstmt = con.prepareStatement(sql2);
		wstmt.setString(1, staff.getCard());
		wstmt.setString(2, staff.getStaff_Name());
		wstmt.setString(3, staff.getStaff_Sex());
		wstmt.setString(4, staff.getStaff_Identity());
		wstmt.setString(5, staff.getStaff_WorkTime());
		wstmt.setString(6, staff.getStaff_Department());
		wstmt.setDouble(7, staff.getStaff_Fee());
		return wstmt.executeUpdate();
	}

	/**
	 * 删除职工
	 * 
	 * @param con
	 * @param staff
	 * @return
	 * @throws Exception
	 */
	public static int DeleteStaff(Connection con, StaffModel staff) throws Exception {
		String sql = "delete from tbldoctor where Staff_Card=?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, staff.getCard());
		int i=stmt.executeUpdate();
		return i;
	}

	/**
	 * 职工信息更新
	 * 
	 * @param con
	 * @param drug
	 * @return
	 * @throws Exception
	 */
	public static int UpdateStaff(Connection con, StaffModel staff) throws Exception {
		String sql = "Update tbldoctor set Staff_Card=?,Staff_Name=?,Staff_Sex=?,Staff_Identity=?,Staff_WorkTime=?,Staff_Department=?,Regist_Fee=? where Staff_Card=?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, staff.getCard());
		stmt.setString(2, staff.getStaff_Name());
		stmt.setString(3, staff.getStaff_Sex());
		stmt.setString(4, staff.getStaff_Identity());
		stmt.setString(5, staff.getStaff_WorkTime());
		stmt.setString(6, staff.getStaff_Department());
		stmt.setDouble(7, staff.getStaff_Fee());
		stmt.setString(8, staff.getCard());
		return stmt.executeUpdate();
	}

	/**
	 * 返回所有职工信息
	 * 
	 * @param con
	 * @return
	 * @throws Exception
	 */
	public static ResultSet Stafflist(Connection con) throws Exception {
		String sql = "select * from tbldoctor";
		Vector<StaffModel> staff = new Vector<StaffModel>();
		PreparedStatement stmt = con.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
//		while(rs.next()) {
//			StaffModel st=new StaffModel();
//			st.setCard(rs.getString("Card"));
//			st.setStaff_Name(rs.getString("Staff_Name"));
//			st.setStaff_Sex(rs.getString("Staff_Sex"));
//			st.setStaff_Identify(rs.getString("Staff_Identity"));
//			st.setStaff_WorkTime(rs.getString("Staff_Worktime"));
//			st.setStaff_Department(rs.getString("Staff_Department"));
//			st.setStaff_Fee(rs.getDouble("Regist_Fee"));
//			staff.add(st);
//		}
		return rs;
	}

	/**
	 * 职工入院管理
	 * 
	 * @param con
	 * @param staff
	 * @return
	 * @throws Exception
	 */
	public static boolean inStaff(Connection con, StaffModel staff) throws Exception {
		StaffModel s = SearchStaff(con, staff);
		s=SearchStaff(con, s);
		if(s.getStaff_Name()==null) {
			InsertStaff(con, staff);
			return true;
		}else {
			return false;
		}
	}

	/**
	 * 模糊搜索
	 * @param con
	 * @param staff
	 * @return
	 */
	public static Vector<StaffModel> dimSearchStaff(Connection con, StaffModel staff) {
		StringBuffer sb = new StringBuffer("select * from tbldoctor");
		Vector<StaffModel> v = new Vector<StaffModel>();
		if (StringUtil.isNotEmpty(staff.getStaff_Name())) {
			sb.append(" and Staff_Name like '%" + staff.getStaff_Name() + "%'");
		}
		if (StringUtil.isNotEmpty(staff.getStaff_Department())) {
			sb.append(" and Staff_Department like '%" + staff.getStaff_Department() + "%'");
		}
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(sb.toString().replaceFirst("and", "where"));
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				StaffModel st = new StaffModel();
				st.setCard(rs.getString("Staff_Card"));
				st.setStaff_Name(rs.getString("Staff_Name"));
				st.setStaff_Sex(rs.getString("Staff_Sex"));
				st.setStaff_Identity(rs.getString("Staff_Identity"));
				st.setStaff_WorkTime(rs.getString("Staff_Worktime"));
				st.setStaff_Department(rs.getString("Staff_Department"));
				st.setStaff_Fee(rs.getDouble("Regist_Fee"));
				v.add(st);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return v;

	}
	
	public static void main(String[] args) {
		StaffModel staff=new StaffModel();
		StaffModel staff2=new StaffModel("213180111","测试3","男","医生","12","骨科",12.0);
		staff.setCard("213180798");
		staff.setStaff_Name("苗宇航");
		System.out.println(staff.getCard());
		System.out.println("查找之前的医生信息是："+staff);
		Connection con=null;
		Hospital_dbUtil db=new Hospital_dbUtil();
		try {
			con=db.getCon();
			System.out.println(DeleteStaff(con, staff));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//关闭与表的连接
		try {
			db.CloseConnection(con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

