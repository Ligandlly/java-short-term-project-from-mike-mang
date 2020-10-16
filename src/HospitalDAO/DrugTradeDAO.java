// package HospitalDAO;
// import java.awt.List;
// import java.sql.Connection;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.util.ArrayList;

// import com.Hospital.Ubtil.Hospital_dbUtil;

// import HospitalModel.DrugModel;
// import HospitalModel.DrugTrade;
// import HospitalModel.FeeModel;
// import HospitalModel.MedHistoryModel;
// import HospitalModel.Regist;
// import HospitalModel.StaffModel;
// import HospitalModel.Transfer;

// public class DrugTradeDAO {

// 	public DrugTradeDAO() {
// 		// TODO Auto-generated constructor stub
// 	}

// 	/**
// 	 * 搜索处方
// 	 * @param con
// 	 * @param drugtrade
// 	 * @return
// 	 * @throws Exception
// 	 */
// 	public static DrugTrade SearchTrade(Connection con, DrugTrade drugtrade) throws Exception {
// 		DrugTrade Dtemp = null;
// 		String sql = "select * from tblDrugTrade where Patient_Card=? ";
// 		PreparedStatement stmt = con.prepareStatement(sql);
// 		stmt.setString(1, drugtrade.getCard());
// 		ResultSet rs = stmt.executeQuery();
// 		if (rs.next()) {
// 			Dtemp = new DrugTrade();
// 			Dtemp.setCard(rs.getString("Patient_Card"));
// 			Dtemp.setDrugTrade_Name(rs.getString("DrugTrade_Name"));
// 			Dtemp.setDrugTrade_Amount(rs.getInt("DrugTrade_Amount"));
// 			Dtemp.setDrugTrade_Doctor(rs.getString("DrugTrade_Doctor"));
// 			Dtemp.setStatus(rs.getString("DrugTrade_Status"));
// 		}
// 		return Dtemp;
// 	}
	
// 	/**
// 	 * 新建处方
// 	 * @param con
// 	 * @param drugtrade
// 	 * @return
// 	 * @throws Exception
// 	 */
// 	public static int InsertDrugTrade(Connection con, DrugTrade drugtrade) throws Exception {
// 		String sql2 = "insert into tblDrugTrade values(null,?,?,?,?,?)";
// 		PreparedStatement wstmt = con.prepareStatement(sql2);
// 		wstmt.setString(1, drugtrade.getCard());
// 		wstmt.setString(2, drugtrade.getDrugTrade_Name());
// 		wstmt.setInt(3, drugtrade.getDrugTrade_Amount());
// 		wstmt.setString(4,drugtrade.getDrugTrade_Doctor());
// 		wstmt.setString(5, drugtrade.getStatus());
// 		return wstmt.executeUpdate();
// 	}
	
// 	/**
// 	 * 修改处方状态
// 	 * @param con
// 	 * @param drug
// 	 * @return
// 	 * @throws Exception
// 	 */
// 	public static int UpdateDrugTrade(Connection con, DrugTrade drugtrade) throws Exception {
// 		String sql = "Update tblDrugTrade set Drug_Status=? where Patient_Card?";
// 		PreparedStatement stmt = con.prepareStatement(sql);
// 		stmt.setString(1, drugtrade.getStatus());
// 		stmt.setString(2, drugtrade.getCard());
// 		return stmt.executeUpdate();
// 	}
	
	
// 	/**
// 	 * 删除处方
// 	 * @param con
// 	 * @param drugtrade
// 	 * @return
// 	 * @throws Exception
// 	 */
// 	public static int DeleteDrugTrade(Connection con, DrugTrade drugtrade) throws Exception {
// 		String sql = "delete from tblDrugTrade where Patient_Card?";
// 		PreparedStatement stmt = con.prepareStatement(sql);
// 		stmt.setString(1, drugtrade.getCard());
// 		return stmt.executeUpdate();
// 	}
	
	
// }
