package Dao;

import java.sql.*;
import java.sql.Date;
import java.util.*;

import com.Hospital.*;

import model.TbGoodinfo;
import model.TbtradeDetail;
import model.TbtradeMain;
import user.User;

//
public class Dao {
//	protected static String dbClassName = "com.hxtt.sql.access.AccessDriver";
//	protected static String url = "jdbc:Access:///E:/JAVAst/DataBase.accdb";
//	//protected static String dbUser = "root";
//	//protected static String dbPwd = "root";
//	//protected static String dbName = "db_jxcms";
//	protected static String second = null;
//	public static Connection conn = null;
//
//	static {//在静态代码段中初始化ConnectAccess类，实现数据库的驱动和链接
//		try {
//			if(conn==null)
//			{
//				Class.forName(dbClassName);//安装驱动
//				conn=DriverManager.getConnection(url);//连接数据库
//				System.out.println("数据库连接成功");
//			}
//		}catch(Exception ee) {
//			ee.printStackTrace();
//		}	
//	}
	public Dao() {

	}

	/**
	 * 商品入库
	 * 
	 * @param con
	 * @param goodInfo
	 * @return
	 */
	public static boolean addGood(Connection con, TbGoodinfo goodInfo) throws Exception {
		if (goodInfo == null)
			return false;
		String sql2 = "insert into good_tb values(null,?,?,?,?,?,?)";
		PreparedStatement wstmt = con.prepareStatement(sql2);
		wstmt.setString(1, goodInfo.getGood_ID());
		wstmt.setString(2, goodInfo.getGood_name());
		wstmt.setString(3, goodInfo.getGood_tag());
		wstmt.setString(4, goodInfo.getGood_manufacturer());
		wstmt.setDouble(5, goodInfo.getGood_price());
		wstmt.setInt(6, goodInfo.getGood_store());
		int i = wstmt.executeUpdate();
		System.out.print(i);
		if (i != 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 商品删除
	 * 
	 * @param goodInfo
	 * @return
	 */
	public static int DeleteGood(Connection con, TbGoodinfo good) throws Exception {
		String sql = "delete from good_tb where Good_Name=?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, good.getGood_name());
		int i = stmt.executeUpdate();
		return i;
	}

	/**
	 * \ 查询商品库存
	 * 
	 * @param goodInfo
	 * @return
	 */
	public static ResultSet SearchGood(Connection con, TbGoodinfo good) throws Exception {
		TbGoodinfo info = new TbGoodinfo();
		String sql = "select * from good_tb where Good_ID=? ";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, good.getGood_ID());
		ResultSet re = stmt.executeQuery();
		if (re.next()) {
			info.setGood_name(re.getString("name"));
			info.setGood_price(re.getDouble("price"));
			info.setGood_tag(re.getString("tag"));
			info.setGood_store(re.getInt("store"));
			info.setGood_manufacturer(re.getString("manufacturer"));
		}
		return re;
	}

	/**
	 * 修改商品信息
	 * 
	 * @param con
	 * @param good
	 * @return
	 */
	public static int update(Connection con, TbGoodinfo good) throws Exception {
		String sql = "update good_tb set Good_ID=?,Good_name=?,Good_tag=?,Good_price=?"
				+ "Good_store=?,Good_manufacturer=?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, good.getGood_ID());
		stmt.setString(2, good.getGood_name());
		stmt.setString(3, good.getGood_tag());
		stmt.setDouble(4, good.getGood_price());
		stmt.setInt(5, good.getGood_store());
		stmt.setString(6, good.getGood_manufacturer());
		return stmt.executeUpdate();
	}

	/**
	 * \ 查询商品 by name
	 * 
	 * @param goodInfo
	 * @return
	 */
	public static ResultSet SearchGood_name(Connection con, String name) throws Exception {
		TbGoodinfo info = new TbGoodinfo();
		String sql = "select * from good_tb where Good_name=? ";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, name);
		ResultSet re = stmt.executeQuery();
		if (re.next()) {
			info.setGood_name(re.getString("Good_name"));
			info.setGood_price(re.getDouble("Good_price"));
			info.setGood_tag(re.getString("Good_tag"));
			info.setGood_store(re.getInt("Good_store"));
			info.setGood_manufacturer(re.getString("Good_manufacturer"));
		}
		return re;
	}

	/**
	 * \ 查询商品 by tag
	 * 
	 * @param goodInfo
	 * @return
	 */
	public static ResultSet SearchGood_tag(Connection con, String tag) throws Exception {
		TbGoodinfo info = new TbGoodinfo();
		String sql = "select * from good_tb where Good_tag=? ";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, tag);
		ResultSet re = stmt.executeQuery();
		if (re.next()) {
			info.setGood_name(re.getString("Good_name").trim());
			info.setGood_price(re.getDouble("Good_price"));
			info.setGood_tag(re.getString("Good_tag").trim());
			info.setGood_store(re.getInt("Good_store"));
			info.setGood_manufacturer(re.getString("Good_manufacturer").trim());
		}
		return re;
	}

	/**
	 * 在线购买(加入到购物车)
	 * 
	 * @param con
	 * @param good
	 * @return
	 * @throws Exception
	 */
	public static boolean onlineshop(Connection con, TbtradeMain trade) throws Exception {
//		User user=new User();
		String UserID = "123";
		String UserName = "CHY";
		String sql2 = "insert into transaction_tb values(null,?,?,?,?,?,?,?,?,?)";
		PreparedStatement wstmt = con.prepareStatement(sql2);
		wstmt.setString(1, trade.getName());
		wstmt.setDouble(2, trade.getPrice());
		wstmt.setInt(3, trade.getState());// 1代表购买，默认购买
		wstmt.setString(4, trade.getTag());
		wstmt.setString(5, trade.getManufacturer());
		wstmt.setInt(6,trade.getStore());
		wstmt.setInt(7, trade.getNum());// 默认购买一件
		wstmt.setString(8, UserID);
		wstmt.setString(9, UserName);
//		wstmt.setDate(10, trade.getData());
		int i = wstmt.executeUpdate();
		System.out.print(i);
		if (i != 0)
			return true;
		else
			return false;

	}

	/**
	 * 我的订单
	 * 
	 * @param con
	 * @param trade
	 * @return
	 * @throws Exception
	 */
	public static boolean Mylist(Connection con, TbtradeMain trade) throws Exception {
		String sql2 = "insert into transction_records_tb values(?,?,?,?)";
		User user = new User();
		String UserID = user.card;
		PreparedStatement wstmt = con.prepareStatement(sql2);
		wstmt.setString(1, trade.getName());
		wstmt.setString(2, UserID);
		wstmt.setInt(3, trade.getNum());
		wstmt.setDate(4, (Date) trade.getData());
		return true;
	}

	/**
	 * 显示购物车
	 * 
	 * @param con
	 * @param User_ID
	 * @return
	 * @throws Exception
	 */
	public static ResultSet ShowMylist(Connection con, User User_ID) throws Exception {
		TbtradeMain info = new TbtradeMain();
		String sql = "select * from transaction_tb where User_ID=? ";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, User_ID.card);
		ResultSet re = stmt.executeQuery();
		if (re.next()) {
			info.setState(re.getInt("state"));
			info.setName(re.getString("name"));
			info.setTag(re.getString("tag"));
			info.setStore(re.getInt("store"));
			info.setPrice(re.getDouble("price"));
			info.setNum(re.getInt("num"));
		}
		return re;
	}

	/**
	 * 商品信息
	 * 
	 * @param con
	 * @param trade
	 * @return
	 * @throws Exception
	 */
	public static ResultSet list(Connection con, TbGoodinfo goodinfo) throws Exception {
		StringBuffer sb = new StringBuffer("select * from good_tb");
		if (goodinfo.getGood_ID().isEmpty()) {
			sb.append("and Good_ID like '&" + goodinfo.getGood_ID() + "&'");
		}
		PreparedStatement pstmt = con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}

	/**
	 * \ 查询购物车
	 * 
	 * @param goodInfo
	 * @return
	 */
	public static TbtradeMain SearchSp(Connection con, TbtradeMain trade) throws Exception {
		TbtradeMain info = new TbtradeMain();
		String sql = "select * from transaction_tb where Good_name=? ";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, trade.getName());
		ResultSet re = stmt.executeQuery();
		if (re.next()) {

			info.setName(re.getString("name"));
			info.setPrice(re.getDouble("price"));
			info.setNum(re.getInt("num"));
			info.setState(re.getInt("state"));
		}
		return info;
	}

	/**
	 * 显示我的订单
	 * 
	 * @param con
	 * @param userID
	 * @return
	 * @throws Exception
	 */
	public static ResultSet showlist(Connection con, User user) throws Exception {
//		System.out.print("进入打印函数");
		
		TbtradeDetail info = new TbtradeDetail();
		String sql = "select * from transction_records_tb where Uer_ID=? ";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, user.card);
//		System.out.print("card = "+user.card);
		ResultSet re = stmt.executeQuery();
//		if (re.next()) {
//			info.setXuhao(re.getInt("xuhao"));
//			info.setName(re.getString("Name"));
//			info.setUer_ID(re.getString("Uer_ID"));
//			info.setNum(re.getInt("num"));
//			info.setData(re.getDate("date"));
//		}
		return re;
//		String sql = "select * from transaction_records_tb";
//		PreparedStatement stmt = con.prepareStatement(sql);
//		ResultSet rs = stmt.executeQuery();
//		return rs;
	}

	/**
	 * 结算费用
	 * 
	 * @param con
	 * @param fee
	 * @return
	 * @throws Exception
	 */
	public static boolean fee(Connection con, TbtradeMain tradefee) throws Exception {
		TbtradeMain trade = new TbtradeMain();
		trade = SearchSp(con, trade);// 进购物车搜索购买的物品
		double fee = trade.getNum() * trade.getNum() * trade.getState();
		TbGoodinfo kucun = new TbGoodinfo();
		if (kucun.getGood_store() - trade.getNum() > 0)
			kucun.setGood_store(kucun.getGood_store() - trade.getNum());
		else
			return false;
		return true;
	}
	
//	public static void main(String args[]) {
////		TbGoodinfo info = new TbGoodinfo();
////		String tag="衣";
////		info.setGood_tag(tag);
////		Connection con=null;
////		dbUtil db=new dbUtil();
////		try {
////			con=db.getCon();
////			
////			ResultSet rs=Dao.SearchGood_tag(con,info.getGood_tag());
////			System.out.print("heyhey");
////			while (rs.next()) {
////				System.out.print(rs.getInt("Good_ID"));
////				System.out.print(rs.getString("Good_name"));
////				System.out.print(rs.getString("Good_tag"));
////				System.out.print(rs.getString("Good_manufacturer"));
////				System.out.print(rs.getDouble("Good_price"));
////			}
////		} catch (Exception e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////	}
//		TbtradeMain info = new TbtradeMain();
//		User user = new User();
//		user.card = "123";
//		Connection con = null;
//		dbUtil db = new dbUtil();
//		try {
//			con = db.getCon();
//			ResultSet rs = Dao.ShowMylist(con, user);
//			System.out.print("heyhey");
//			System.out.print("查询结果为：" + rs.next());
//			while (rs.next()) {
//				System.out.print(rs.getInt("state"));
//				System.out.print(rs.getString("Name"));
//				System.out.print(rs.getString("tag"));
//				System.out.print(rs.getInt("store"));
//				System.out.print(rs.getDouble("price"));
//				System.out.print(rs.getInt("num"));
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
}
