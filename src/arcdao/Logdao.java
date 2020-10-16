package arcdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import Arcmodel.Archive;
import Arcmodel.log;
// import connect.ConnectAccess;

/**
 * 监听修改按钮，生成修改人，修改时间
 * @author DELL
 *
 */
public class Logdao {
	private Logdao() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 查询日志
	 * 
	 * @param con
	 * @param lg
	 * @return
	 * @throws Exception
	 */
	public static log SearchLog(Connection con, log lg,Archive arc) throws Exception {
		log Stemp = new log();
		String sql = "select * from tbllog where Changer=? ";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, lg.getChanger());
		ResultSet re = stmt.executeQuery();
		if (re.next()) {
			Stemp.setChanger(re.getString("Changer"));
			Stemp.setChanger(re.getString("CStudent"));
			Stemp.setChanger(re.getString("Changer"));
			Stemp.setChange_Time(re.getString("Change_Time"));
			
		}
		return Stemp;
	}
	
	/**
	 * 增加日志
	 * 
	 * @param con
	 * @param drug
	 * @return
	 * @throws Exception
	 */
	public static int InsertLog(Connection con, log lg) throws Exception {
		String sql2 = "insert into tbllog values(null,?,?,?,?)";
		PreparedStatement wstmt = con.prepareStatement(sql2);
		
		wstmt.setString(1, lg.getChanger());
		wstmt.setString(2, lg.Carc.getCard());
		wstmt.setString(3, lg.Carc.getName());
		wstmt.setString(4, lg.getChange_Time());
		return wstmt.executeUpdate();
	}

	
	/**
	 * 日志更新
	 * 
	 * @param con
	 * @param drug
	 * @return
	 * @throws Exception
	 */
	public static int UpdateLog(Connection con, log lg) throws Exception {
		String sql = "Update tbllog set Card=?,Name=?,Password=?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, lg.getChanger());
		stmt.setString(2, lg.getChange_Time());
		
		return stmt.executeUpdate();
	}
	
	/**
	 * 返回所有日志信息
	 * 
	 * @param con
	 * @return
	 * @throws Exception
	 */
	public static Vector<log> Loglist(Connection con) throws Exception {
		String sql = "select * from tbllog";
		PreparedStatement stmt = con.prepareStatement(sql);
		Vector<log> TbB = new Vector<log>();
		ResultSet rt = stmt.executeQuery();
		while(rt.next()) {
			log temp = new log();
			temp.setChanger(rt.getString("Changer"));
			temp.Carc.setCard(rt.getString("Card"));
			temp.Carc.setName(rt.getString("Name"));
			temp.setChange_Time(rt.getString("Change_Time"));
			TbB.add(temp);
		}
		return TbB;
	}
	
// 	public static void main(String[] args) {
// 		log lg1 = new log();
// 		//Manager manager1 = new Manager();
// 		System.out.println(lg1.getChanger());
// 		Connection con = null;
// 		ConnectAccess d = new ConnectAccess();
// 		try {
// 			con = d.getCon();

// 			Loglist(con);
			
// 		} catch (Exception e) {
// 			// TODO Auto-generated catch block
// 			e.printStackTrace();
// 		}
		
// 	}
}
