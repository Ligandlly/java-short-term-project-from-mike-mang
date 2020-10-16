package HospitalDAO;

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

/**
 * 有关药房的函数操作
 * 
 * @author 91261
 *
 */
public class DrugDAO {

	private DrugDAO() {

	}

//————————————————————————药品库存管理——————————————————————//
	/**
	 * 查询药品库存
	 * 
	 * @param con
	 * @param drug
	 * @return
	 * @throws Exception
	 */
	public static DrugModel SearchDrug(Connection con, DrugModel drug) throws Exception {
		DrugModel Dtemp = new DrugModel();
		String sql = "select * from tblDrug where Drug_Name=? ";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, drug.getDrug_Name());
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			Dtemp.setDrug_ApporovalNumber(rs.getString("Drug_AppovalNumber"));
			Dtemp.setDrug_Name(rs.getString("Drug_Name"));
			Dtemp.setDrug_Amount(rs.getInt("Drug_Amount"));
			Dtemp.setDrug_Price(rs.getDouble("Drug_Price"));
			Dtemp.setDrug_Sort(rs.getString("Drug_Sort"));
		}
		return Dtemp;
	}

	/**
	 * 药品插入
	 * 
	 * @param con
	 * @param drug
	 * @throws Exception
	 */

	public static int InsertDrug(Connection con, DrugModel drug) throws Exception {
		String sql2 = "insert into tblDrug values(null,?,?,?,?,?)";
		PreparedStatement wstmt = con.prepareStatement(sql2);
		wstmt.setString(1, drug.getDrug_ApporovalNumber());
		wstmt.setString(2, drug.getDrug_Name());
		wstmt.setInt(3, drug.getDrug_Amount());
		wstmt.setDouble(4, drug.getDrug_Price());
		wstmt.setString(5, drug.getDrug_Sort());
		return wstmt.executeUpdate();
	}

	/**
	 * 药品删除
	 * 
	 * @param con
	 * @param drug
	 * @return
	 * @throws Exception
	 */
	public static int DeleteDrug(Connection con, DrugModel drug) throws Exception {
		String sql = "delete from tblDrug where Drug_Name=?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, drug.getDrug_Name());
		return stmt.executeUpdate();
	}

	/**
	 * 药品库存更新
	 * 
	 * @param con
	 * @param drug
	 * @return
	 * @throws Exception
	 */
	public static int UpdateDrug(Connection con, DrugModel drug) throws Exception {
		String sql = "Update tblDrug set Drug_Amount=? where Drug_Name=?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, drug.getDrug_Amount());
		stmt.setString(2, drug.getDrug_Name());
		return stmt.executeUpdate();
	}

	/**
	 * 药品入库
	 * 
	 * @param con
	 * @param drug
	 * @throws Exception
	 */
	public static boolean inDrug(Connection con, DrugModel drug) throws Exception {
		DrugModel D = new DrugModel();
		D = SearchDrug(con, drug);
		if (drug.getDrug_Name().equals(D.getDrug_Name())) {
			drug.setDrug_Amount(drug.getDrug_Amount() + D.getDrug_Amount());
			UpdateDrug(con, drug);
			return true;
		} else {
			InsertDrug(con, drug);
			return true;
		}
	}

	/**
	 * 药品出库
	 * @param con
	 * @param drug
	 * @return
	 * @throws Exception
	 */
	public static boolean OutDrug(Connection con, DrugModel drug) throws Exception {
		DrugModel D = new DrugModel();
		D = SearchDrug(con, drug);
		if (drug.getDrug_Name().equals(D.getDrug_Name())) {
			if (drug.getDrug_Amount() > D.getDrug_Amount()) {
				return false;
			} else if (drug.getDrug_Amount() == D.getDrug_Amount()) {
				DeleteDrug(con, drug);
				return true;
			} else if (drug.getDrug_Amount() < D.getDrug_Amount()) {
				D.setDrug_Amount(D.getDrug_Amount() - drug.getDrug_Amount());
				UpdateDrug(con, D);
				return true;
			}
		}
		return false;

	}

	/**
	 * 返回所有药品库存
	 * 
	 * @param con
	 * @param drug
	 * @return
	 * @throws Exception
	 */
	public static ResultSet Druglist(Connection con) throws Exception {
		String sql = "select * from tblDrug";
		Vector<DrugModel> a=new Vector<DrugModel>();
		PreparedStatement stmt = con.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
//		while(rs.next()) {
//			DrugModel Dtemp=new DrugModel();
//			Dtemp.setDrug_ApporovalNumber(rs.getString("Drug_AppovalNumber"));
//			Dtemp.setDrug_Name(rs.getString("Drug_Name"));
//			Dtemp.setDrug_Amount(rs.getInt("Drug_Amount"));
//			Dtemp.setDrug_Price(rs.getDouble("Drug_Price"));
//			Dtemp.setDrug_Sort(rs.getString("Drug_Sort"));
//			a.add(Dtemp);
//		}
		return rs;
	}

	// ————————————————————扣费——————————————————————————//

	/**
	 * 处方扣费
	 * 
	 * @param con
	 * @param patient
	 * @return
	 * @throws Exception
	 */
	public static boolean DetectFee(Connection con, FeeModel patient) throws Exception {
		String sql1 = "select * from tblDrugTrade where Patient_Card=?";
		PreparedStatement stmt1 = con.prepareStatement(sql1);
		stmt1.setString(1, patient.getCard());
		ResultSet rs = stmt1.executeQuery();
		while (rs.next()) {
			String status = rs.getString("DrugTrade_Status");
			if (status == "新开") {
				String CardNumber = rs.getString("Patient_Card");
				String DrugName = rs.getString("DrugTrade_Name");
				String Doctor = rs.getString("DrugTrade_Doctor");
				int amount = rs.getInt("DrugTrade_Amount");
				// 读出处方的所有信息
				DrugModel Dtemp = new DrugModel(DrugName);
				Dtemp = SearchDrug(con, Dtemp);// 进药房搜索对应药库存
				if (Dtemp.getDrug_Amount() > amount) {
					double Fee = Dtemp.getDrug_Price() * amount;// 计算药品费用
					Dtemp.setDrug_Amount(Dtemp.getDrug_Amount() - amount);// 减少药品库存
					UpdateDrug(con, Dtemp);
					/**
					 * 留出操作余额的方法和生成交易记录的方法
					 */
					status = "完成";// 修改处方状态
					DrugTrade Dee = new DrugTrade(CardNumber, DrugName, amount, Doctor, status);
					return true;
				} else {
					return false;// 药房库存不够
				}
			} else
				return false;// 单据状态为已完成
		}
		return true;
	}

//————————————————————测试——————————————————————————//	
//	public static void main(String[] args) {
//		Connection con=null;
//		Hospital_dbUtil bd=new Hospital_dbUtil();
//		try {
//			con=bd.getCon();
//			ArrayList<Object> a=Druglist(con);
//			for(int i=0;i<a.size();i++) {
//				
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
}
