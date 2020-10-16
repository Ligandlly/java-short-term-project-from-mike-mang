package arcdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Arcmodel.Archive;
import Arcmodel.Manager;

public class Managerdao {

	private Managerdao() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * ��ѯ����Ա��Ϣ
	 * 
	 * @param con
	 * @param manager
	 * @return
	 * @throws Exception
	 */
	public static Manager SearchManager(Connection con, Manager manager) throws Exception {
		Manager Stemp = new Manager();
		String sql = "select * from tblmanager where Name=? ";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, manager.getName());
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			Stemp.setCard(rs.getString("Card"));
			Stemp.setName(rs.getString("Name"));
			Stemp.setPassword(rs.getString("Password"));
			
		}
		return Stemp;
	}

	/**
	 * ���ӹ���Ա
	 * 
	 * @param con
	 * @param drug
	 * @return
	 * @throws Exception
	 */
	public static int InsertManager(Connection con, Manager manager) throws Exception {
		String sql2 = "insert into tblmanager values(null,?,?,?)";
		PreparedStatement wstmt = con.prepareStatement(sql2);
		wstmt.setString(1, manager.getCard());
		wstmt.setString(2, manager.getName());
		wstmt.setString(3, manager.getPassword());
		return wstmt.executeUpdate();
	}

	
	/**
	 * ����Ա��Ϣ����
	 * 
	 * @param con
	 * @param drug
	 * @return
	 * @throws Exception
	 */
	public static int UpdateManager(Connection con, Manager manager) throws Exception {
		String sql = "Update tblmanager set Card=?,Name=?,Password=?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, manager.getCard());
		stmt.setString(2, manager.getName());
		stmt.setString(3, manager.getPassword());
		
		return stmt.executeUpdate();
	}

	/**
	 * �������й���Ա��Ϣ
	 * 
	 * @param con
	 * @return
	 * @throws Exception
	 */
	public static ResultSet Managerlist(Connection con) throws Exception {
		String sql = "select * from tblmanager";
		PreparedStatement stmt = con.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		return rs;
	}

	/**
	 * �鿴ѧ������
	 * @param con
	 * @param Manager
	 * @throws Exception
	 */
	

	/**
	 * �޸�ѧ������
	 * @param con
	 * @param Manager
	 * @throws Exception
	 */
	

//	
//	public static void main(String[] args) {
//		Manager manager1 = new Manager("113181101","111","��ΰ");
//		//Manager manager1 = new Manager();
//		System.out.println(manager1.getName());
//		Connection con = null;
//		ConnectAccess d = new ConnectAccess();
//		try {
//			con = d.getCon();
//
//			InsertManager(con, manager1);
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
}
