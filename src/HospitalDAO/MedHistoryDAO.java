package HospitalDAO;
import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.Hospital.Ubtil.Hospital_dbUtil;

import HospitalModel.DrugModel;
import HospitalModel.DrugTrade;
import HospitalModel.FeeModel;
import HospitalModel.MedHistoryModel;
import HospitalModel.Regist;
import HospitalModel.StaffModel;
import HospitalModel.Transfer;

public class MedHistoryDAO {

	private MedHistoryDAO() {
		// TODO Auto-generated constructor stub
	}

	// —————————————————————————病历——————————————————————————//

	/**
	 * 新建病历(有BUG)
	 * 
	 * @param con
	 * @param regist
	 * @return
	 * @throws Exception
	 */
	public static int InsertMedHistory(Connection con, MedHistoryModel medhistory) throws Exception {
		String sql2 = "insert into tblMedHistory values(null,?,?,?,?,?,?)";
		PreparedStatement wstmt = con.prepareStatement(sql2);
		wstmt.setString(1, medhistory.getCard());
		wstmt.setString(2, medhistory.getPerson_Name());
		wstmt.setString(3, medhistory.getMedHistory_History());
		wstmt.setString(4, medhistory.getMedHistory_MainSuit());
		wstmt.setString(5, medhistory.getMedHistory_Diagnose());
		wstmt.setString(6, medhistory.getMedHistory_Time());
		return wstmt.executeUpdate();
	}

	/**
	 * 查询病历
	 * 
	 * @param con
	 * @param medhistory
	 * @return
	 * @throws Exception
	 */
	public static MedHistoryModel SearchMedHistory(Connection con, MedHistoryModel medhistory) throws Exception {
		MedHistoryModel MHtemp = null;
		String sql = "select * from tblMedHistory where Card=? ";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, medhistory.getCard());
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			MHtemp = new MedHistoryModel();
			MHtemp.setCard(rs.getString("Card"));
			MHtemp.setPerson_Name(rs.getString("Person_Name"));
			MHtemp.setMedHistory_History(rs.getString("MedHistory_History"));
			MHtemp.setMedHistory_MainSuit(rs.getString("MedHistory_MainSuit"));
			MHtemp.setMedHistory_Diagnose(rs.getString("MedHistory_Diagnose"));
			MHtemp.setMedHistory_Time(rs.getString("MedHistory_Time"));
		}
		return MHtemp;
	}

	/**
	 * 修改病历
	 * 
	 * @param con
	 * @param medhistory
	 * @return
	 * @throws Exception
	 */
	public static int UpdateMedHistory(Connection con, MedHistoryModel medhistory) throws Exception {
		String sql = "Update tblMedHistory set Card=?,Person_Name=?,MedHistory_History=?,MedHistory_MainSuit=?,MedHistory_Diagnose=?,MedHistory_Time=? where Card=?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, medhistory.getCard());
		stmt.setString(2, medhistory.getPerson_Name());
		stmt.setString(3, medhistory.getMedHistory_History());
		stmt.setString(4, medhistory.getMedHistory_MainSuit());
		stmt.setString(5, medhistory.getMedHistory_Diagnose());
		stmt.setString(6, medhistory.getMedHistory_Time());
		stmt.setString(7, medhistory.getCard());
		return stmt.executeUpdate();
	}
	/**
	 * 按日期和一卡通查询
	 * @param con
	 * @param medHistory
	 * @return
	 * @throws Exception
	 */
	public static ResultSet MedhistoryList(Connection con,MedHistoryModel medHistory)throws Exception{
		String sql="select * from tblMedHistory where Card=? and MedHistory_Time=?";
		PreparedStatement stmt=con.prepareStatement(sql);
		stmt.setString(1, medHistory.getCard());
		stmt.setString(2, medHistory.getMedHistory_Time());
		ResultSet rs=stmt.executeQuery();
		return rs;
	}
	
	public static void main(String[] args) {
		Connection con=null;
		Hospital_dbUtil b=new Hospital_dbUtil();
		try {
			con=b.getCon();
			MedHistoryModel medHistory=new MedHistoryModel();
			medHistory.setCard("213180000");
			medHistory.setMedHistory_Time("2019/2/1");
			ResultSet rs=MedhistoryList(con, medHistory);
			while(rs.next()) {
				System.out.println(rs.getString("MedHistory_MainSuit"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
