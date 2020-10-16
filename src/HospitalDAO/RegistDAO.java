package HospitalDAO;
import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import com.Hospital.Ubtil.Hospital_dbUtil;

import HospitalModel.DrugModel;
import HospitalModel.DrugTrade;
import HospitalModel.FeeModel;
import HospitalModel.MedHistoryModel;
import HospitalModel.Regist;
import HospitalModel.StaffModel;
import HospitalModel.Transfer;

public class RegistDAO {
	
	
	// —————————————————————————挂号——————————————————————————//

		private RegistDAO() {
		// TODO Auto-generated constructor stub
	}

		/**
		 * 查询挂号单据
		 * 
		 * @param con
		 * @param regist
		 * @return
		 * @throws Exception
		 */
		public static Regist SearchRegist(Connection con, Regist regist) throws Exception {
			Regist Rtemp = null;
			String sql = "select * from tblRegist where Card=? ";
			PreparedStatement stmt = null;
			try {
				stmt = con.prepareStatement(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				stmt.setString(1, regist.getCard());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			ResultSet rs=null;
			try {
				rs = stmt.executeQuery();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				if (rs.next()) {
					Rtemp = new Regist();
					Rtemp.setCard(rs.getString("Card"));
					Rtemp.setRegist_Name(rs.getString("Regist_Name"));
					Rtemp.setRegist_Department(rs.getString("Regist_Department"));
					Rtemp.setRegist_Doctor(rs.getString("Regist_Doctor"));
					Rtemp.setRegist_Fee(rs.getDouble("Regist_Fee"));
					Rtemp.setRegist_Time(rs.getString("Regist_Time"));
					Rtemp.setRegist_Status(rs.getString("Regist_Status"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return Rtemp;
		}

		/**
		 * 给病人挂号用（初始传参默认设单据状态为"新开"）
		 * 
		 * @param con
		 * @param regist
		 * @return
		 * @throws Exception
		 */
		public static int InsertRegist(Connection con, Regist regist) throws Exception {
			String sql2 = "insert into tblRegist values(null,?,?,?,?,?,?,?)";
			PreparedStatement wstmt = con.prepareStatement(sql2);
			wstmt.setString(1, regist.getCard());
			wstmt.setString(2, regist.getRegist_Name());
			wstmt.setString(3, regist.getRegist_Department());
			wstmt.setString(4, regist.getRegist_Doctor());// 前端应该可以选择下拉框
			wstmt.setDouble(5, regist.getRegist_Fee());
			wstmt.setString(6, regist.getRegist_Time());
			wstmt.setString(7, regist.getRegist_Status());
			return wstmt.executeUpdate();
		}

		/**
		 * 修改挂号单状态
		 * 
		 * @param con
		 * @param regist
		 * @return
		 * @throws Exception
		 */
		public static int UpdateRegist(Connection con, Regist regist) throws Exception {
			String sql = "Update tblRegist set Regist_Status=? where Card=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, regist.getRegist_Status());
			stmt.setString(2, regist.getCard());
			return stmt.executeUpdate();
		}

		/**
		 * 查看当前医生所有挂号信息
		 * 
		 * @param con
		 * @return
		 * @throws Exception
		 */
		public static ResultSet Reigstlist(Connection con, StaffModel staff) throws Exception {
			//Vector<Regist> temp=new Vector<Regist>();
			String sql = "select * from tblRegist where Regist_Doctor=? and Regist_Status=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, staff.getStaff_Name());
			stmt.setString(2, "新开");
			ResultSet rs = stmt.executeQuery();
//			while(rs.next()) {
//				Regist Rtemp=new Regist();
//				Rtemp.setCard(rs.getString("Card"));
//				Rtemp.setRegist_Name(rs.getString("Regist_Name"));
//				Rtemp.setRegist_Department(rs.getString("Regist_Department"));
//				Rtemp.setRegist_Doctor(rs.getString("Regist_Doctor"));
//				Rtemp.setRegist_Fee(rs.getDouble("Regist_Fee"));
//				Rtemp.setRegist_Time(rs.getString("Regist_Time"));
//				Rtemp.setRegist_Status(rs.getString("Regist_Status"));
//				temp.add(Rtemp);
//			}
			return rs;
		}
		
		

		public static void main(String[] args) {
			StaffModel staff=new StaffModel();
			staff.setStaff_Name("花常");
			Regist rg=new Regist();
			rg.setCard("213180315");
			Connection con=null;
			Hospital_dbUtil db=new Hospital_dbUtil();
			try {
				con=db.getCon();
				System.out.println(InsertRegist(con, rg));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		

}
