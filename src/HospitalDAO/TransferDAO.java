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

public class TransferDAO {

	private TransferDAO() {
		// TODO Auto-generated constructor stub
	}

	// —————————————————————————转诊——————————————————————————//

		/**
		 * 开转诊单
		 * 
		 * @param con
		 * @param transfer
		 * @return
		 * @throws Exception
		 */
		public static int InsertTransfer(Connection con, Transfer transfer) throws Exception {
			String sql2 = "insert into tblTransfer values(null,?,?,?,?,?)";
			PreparedStatement wstmt = con.prepareStatement(sql2);
			wstmt.setString(1, transfer.getCard());
			wstmt.setString(2, transfer.getTransfer_Name());
			wstmt.setString(3, transfer.getTransfer_Doctor());
			wstmt.setString(4, transfer.getTransfer_Diagnose());
			wstmt.setString(5, transfer.getTransfer_Status());
			return wstmt.executeUpdate();
		}

		/**
		 * 只能修改单据状态
		 * 
		 * @param con
		 * @param transfer
		 * @return
		 * @throws Exception
		 */
		public static int UpdateTransfer(Connection con, Transfer transfer) throws Exception {
			String sql = "Update tblTransfer set Transfer_Status=? where Card=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, transfer.getTransfer_Status());
			stmt.setString(2, transfer.getCard());
			return stmt.executeUpdate();
		}

		/**
		 * 搜索转诊信息
		 * 
		 * @param con
		 * @param transfer
		 * @return
		 * @throws Exception
		 */
		public static Transfer searchTransfer(Connection con, Transfer transfer) throws Exception {
			Transfer Ttemp = null;
			String sql = "select * from tblTransfer where Card=? ";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, transfer.getCard());
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				Ttemp = new Transfer();
				Ttemp.setCard(rs.getString("Card"));
				Ttemp.setTransfer_Name(rs.getString("Transfer_Name"));
				Ttemp.setTransfer_Doctor(rs.getString("Transfer_Doctor"));
				Ttemp.setTransfer_Diagnose(rs.getString("Transfer_Diagnose"));
				Ttemp.setTransfer_Status(rs.getString("Transfer_Status"));
			}
			return Ttemp;
		}

		/**
		 * 可视化所有转诊单
		 * 
		 * @param con
		 * @param staff
		 * @return
		 * @throws Exception
		 */
		public static ResultSet allTransferlist(Connection con) throws Exception {
			String sql = "select * from tblTransfer ";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			return rs;
		}

		/**
		 * 查询特定医生的转诊单
		 * 
		 * @param con
		 * @param staff
		 * @return
		 * @throws Exception
		 */
		public static ResultSet DoctorTransferlist(Connection con, StaffModel staff) throws Exception {
			String sql = "select * from tblTransfer where Transfer_Doctor=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, staff.getStaff_Name());
			ResultSet rs = stmt.executeQuery();
			return rs;
		}
	//}
}
