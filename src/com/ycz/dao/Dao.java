// package com.ycz.dao;
// /*
//  * copyright:pomelo
//  * 
//  * 数据库类Dao，进行对图书馆有关数据的所有操作
//  * boolean getLogin(String card,String password)传入card和password，表内有对应信息返回1，无对应信息返回0
//  * TbBookinfo getBookinfo(Connection con,TbBookinfo book)根据ISBN查询，传入有ISBN的对象，查得到返回所有信息，查不到返回all NULL信息
//  */

// import com.ycz.Ubtil.*;
// import com.ycz.model.*;

// import java.sql.*;
// import java.text.SimpleDateFormat;
// import java.io.*;
// import java.util.*;
// import java.util.Date;

// public class Dao {

// 	public Dao() {

// 	}

// 	/**
// 	 * 修改tb_readerinfo表格对应读者信息
// 	 * 
// 	 * @param con
// 	 * @param reader
// 	 * @return
// 	 * @throws SQLException
// 	 */
// 	public static int changeReaderinfo(Connection con, TbReaderinfo reader) throws SQLException {
// 		String sql = "Update tb_readerinfo set Bmaxnum=?,Smaxnum=?,reputation=? where Drug_Name=?";
// 		PreparedStatement stmt = con.prepareStatement(sql);
// 		stmt.setString(1, reader.getBmaxnum());
// 		stmt.setString(2, reader.getSmaxnum());
// 		stmt.setDouble(3, reader.getReputation());
// 		return stmt.executeUpdate();
// 	}

// 	/**
// 	 * 将指定日期加上指定天数
// 	 * 注意day 必须是long类型 否者会超精度影响结果
// 	 * @param date
// 	 * @param day
// 	 * @return
// 	 */
// 	public static Date addDate(Date date, long day) {
// 		long time = date.getTime(); // 得到指定日期的毫秒数
// 		day = day * 24 * 60 * 60 * 1000; // 要加上的天数转换成毫秒数
// 		time += day; // 相加得到新的毫秒数
// 		return new Date(time); // 将毫秒数转换成日期
// 	}

// 	/**
// 	 * 新增借书信息
// 	 * 1.不清楚boolean类型插入是否成功
// 	 * 2.不清楚date类型插入是否成功
// 	 * 3.不清楚adddate（）增加借阅日期是否成功
// 	 * @param con
// 	 * @param book
// 	 * @param reader
// 	 * @return
// 	 * @throws SQLException
// 	 */
// 	public static int insertBookborrow(Connection con, TbLibrarianinfo librarian, TbBookinfo book, TbReaderinfo reader)
// 			throws SQLException {
// 		String sql = "insert into tb_bookborrowinfo values(null,?,?,?,?,?,?,?)";
// 		PreparedStatement wstmt = con.prepareStatement(sql);
// 		wstmt.setString(1, book.getISBN());
// 		wstmt.setString(2, book.getTypeld());
// 		wstmt.setString(3, reader.getCard());
// 		wstmt.setString(4, librarian.getLibrarianId());
// 		wstmt.setBoolean(5, false);
// 		// 获取本地时间
// 		wstmt.setDate(6, (java.sql.Date) new Date());
// 		long day = Long.parseLong(book.getDate());
// 		Date newDate = addDate((java.sql.Date) new Date(), day); // 指定日期加上20天
// 		wstmt.setDate(7, (java.sql.Date) newDate);
// 		return wstmt.executeUpdate();
// 	}
	
// 	/**
// 	 * 修改tb_bookborrowinfo表格，把对应的Isback改成1。 True表示成功，false表示失败。
// 	 * 
// 	 * @param con
// 	 * @param book
// 	 * @return
// 	 * @throws SQLException
// 	 */
// 	public static int changeIsbackinfo(Connection con, TbBookborrowinfo book) throws SQLException {
// 		String sql = "Update tb_bookborrowinfo set isback=? where card=? and ISBN=?";
// 		PreparedStatement stmt = con.prepareStatement(sql);
// 		stmt.setBoolean(1, true);
// 		stmt.setString(2, book.getCard());
// 		stmt.setString(3, book.getISBN());
// 		return stmt.executeUpdate();
// 	}

// 	/**
// 	 * 修改tb_bookinfo表格，把对应的书籍的amount加一。
// 	 * 
// 	 * @param con
// 	 * @param book
// 	 * @return
// 	 * @throws SQLException
// 	 */
// 	public static long changeAmountinfo(Connection con, TbBookborrowinfo book) throws SQLException {
// 		String sql1 = "select * from tb_bookinfo where ISBN=? ";
// 		PreparedStatement stmt1 = con.prepareStatement(sql1);
// 		stmt1.setString(1, book.getISBN());
// 		ResultSet rs1 = stmt1.executeQuery();
// 		long amount = 0;
// 		try {// 封装数据到数据模型中
// 			if (rs1.next()) {
// 				amount = rs1.getLong("amount");
// 			}
// 		} catch (SQLException e) {
// 			e.printStackTrace();
// 		}
// 		amount = amount + 1;
// 		String sql2 = "Update tb_bookinfo set amount=? where ISBN=?";
// 		PreparedStatement stmt2 = con.prepareStatement(sql2);
// 		stmt2.setLong(1, amount);
// 		stmt2.setString(2, book.getISBN());
// 		int rs2 = stmt2.executeUpdate();
// 		return amount;
// 	}

// 	/**
// 	 * 修改tb_bookinfo表格，把对应的书籍的amount减一。
// 	 * 
// 	 * @param con
// 	 * @param book
// 	 * @return
// 	 * @throws SQLException
// 	 */
// 	public static long changeAmountinfo(Connection con, TbBookinfo book) throws SQLException {
// 		String sql1 = "select * from tb_bookinfo where ISBN=? ";
// 		PreparedStatement stmt1 = con.prepareStatement(sql1);
// 		stmt1.setString(1, book.getISBN());
// 		ResultSet rs1 = stmt1.executeQuery();
// 		long amount = 0;
// 		try {// 封装数据到数据模型中
// 			if (rs1.next()) {
// 				amount = rs1.getLong("amount");
// 			}
// 		} catch (SQLException e) {
// 			e.printStackTrace();
// 		}

// 		amount = amount - 1;
// 		String sql2 = "Update tb_bookinfo set amount=? where ISBN=?";
// 		PreparedStatement stmt2 = con.prepareStatement(sql2);
// 		stmt2.setLong(1, amount);
// 		stmt2.setString(2, book.getISBN());
// 		int rs2 = stmt2.executeUpdate();
// 		return amount;
// 	}

// 	/**
// 	 * 借书（修改借书信息、库存）,
// 	 * 返回值true表示还书成功，
// 	 * 返回值为false表示发生错误，弹出“借书失败！请联系管理员。”
// 	 * @param con
// 	 * @param book
// 	 * @return
// 	 * @throws SQLException 
// 	 */
// 	public static int borrowBook(Connection con, TbLibrarianinfo librarian, TbBookinfo book, TbReaderinfo reader) throws SQLException {
// 		long now_amount = changeAmountinfo(con,book);
// 		int result = insertBookborrow(con,librarian,book,reader);
// 		if(result > 0) {
// 			System.out.println("借书成功！"+"现在该书库存为"+now_amount);
// 			return 1;
// 		}
			
// 		else {
// 			System.out.println("借书失败，请联系管理员！");
// 			return 0;
// 		}			
// 	}
	
// 	//下面实现还书功能
// 	/**
// 	 * 用唯一标识typeld获得图书类别详细信息
// 	 * @param con
// 	 * @param book
// 	 * @return
// 	 * @throws SQLException
// 	 */
// 	public static TbBookclassificationinfo getBookclassinfo (Connection con, TbBookinfo book) throws SQLException {
// 		TbBookclassificationinfo temp = new TbBookclassificationinfo();
// 			String sql = "select * from tb_bookclassificationinfo where typeld=? ";
// 			PreparedStatement stmt = con.prepareStatement(sql);
// 			stmt.setString(1, book.getTypeld());
// 			ResultSet rs = stmt.executeQuery();
// 			try {// 封装数据到数据模型中
// 				if (rs.next()) {
// 					temp.setTypeld(rs.getString("typeld").trim());
// 					temp.setTypename(rs.getString("typename").trim());
// 					temp.setDays(rs.getString("days").trim());
// 					temp.setPunish_money(rs.getFloat("punishmoney"));
// 					temp.setPunish_repu(rs.getFloat("punishrepu"));
// 				}					
// 			} catch (SQLException e) {
// 				e.printStackTrace();
// 			}
// 			return temp;
// 	}

	
	
// 	/**
// 	 * 修改tb_readerinfo表格对应读者信誉，并返回当前信誉
// 	 * @param con
// 	 * @param dertarepu
// 	 * @return
// 	 * @throws SQLException 
// 	 */
// 	public static double changeReaderrepu(Connection con,TbBookborrowinfo book) throws SQLException {
// 		//根据card查找reader
// 		/*
// 		 * TbReaderinfo getReaderinfo (Connection con, TbReaderinfo reader)
// 		 */
// 		//根据typeld查找bookclass
// 		/*
// 		 * TbBookclassificationinfo getBookclassinfo (Connection con, TbBookinfo book)
// 		 */
// 		//若本地日期超过还书日期，
// 		//则在（根据card查找）tb_readerinfo表中的reputation一项，减去（根据typeld查找）tb_bookclassification表中的pubishrepu
// 		//若没有超过本地日期
// 		//则在（根据card查找）tb_readerinfo表中的reputation一项，加上1
// 		Date d=new Date();
// 		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
// 		String ds=df.format(d);
// 		TbReaderinfo reader = new TbReaderinfo();
// 		reader.setCard(book.getCard());
// 		reader = getReaderinfo (con, reader);
// 		TbBookclassificationinfo bookclass = new TbBookclassificationinfo();
// 		bookclass.setTypeld(book.getTypeld());
// 		TbBookinfo temp = new TbBookinfo();
// 		temp.setTypeld(book.getTypeld());
// 		bookclass = getBookclassinfo (con, temp);
// 		if(ds.compareTo(book.getBackDate()) > 0) {
			
// 		}
// 		else {
			
// 		}
// 	}


// 	/*
// 	 * 用唯一标识ISBN获得图书详细信息 如若找不到,返回一个所有成员都为NULL的值
// 	 */
// 	public static TbBookinfo getBookinfo(Connection con, TbBookinfo book) throws SQLException {
// 		TbBookinfo temp = new TbBookinfo();
// 		String sql = "select * from tb_bookinfo where ISBN=? ";
// 		PreparedStatement stmt = con.prepareStatement(sql);
// 		stmt.setString(1, book.getISBN());
// 		ResultSet rs = stmt.executeQuery();
// 		System.out.println("正确的查询语句为" + sql);
// 		try {// 封装数据到数据模型中
// 			if (rs.next()) {
// 				temp.setISBN(rs.getString("ISBN").trim());
// 				temp.setTypeld(rs.getString("typeld").trim());
// 				temp.setBookName(rs.getString("bookName").trim());
// 				temp.setWriter(rs.getString("writer").trim());
// 				temp.setPublisher(rs.getString("publisher").trim());
// 				temp.setDate(rs.getString("date").trim());
// 				temp.setPrice(rs.getDouble("price"));
// 				temp.setAmount(rs.getInt("amount"));
// 			}
// 		} catch (SQLException e) {
// 			e.printStackTrace();
// 		}
// 		return temp;
// 	}

// 	/*
// 	 * 用唯一标识card获得读者详细信息
// 	 */
// 	public static TbReaderinfo getReaderinfo(Connection con, TbReaderinfo reader) throws SQLException {
// 		TbReaderinfo temp = new TbReaderinfo();
// 		String sql = "select * from tb_readerinfo where card =? ";
// 		PreparedStatement stmt = con.prepareStatement(sql);
// 		stmt.setString(1, reader.getCard());
// 		ResultSet rs = stmt.executeQuery();
// 		try {// 封装数据到数据模型中
// 			if (rs.next()) {
// 				temp.setBmaxnum(rs.getString("Bmaxnum").trim());
// 				temp.setCard(rs.getString("card").trim());
// 				temp.setInstitude(rs.getString("Institude").trim());
// 				temp.setName(rs.getString("name").trim());
// 				temp.setReputation(rs.getDouble("reputation"));
// 				temp.setSex(rs.getString("sex").trim());
// 				temp.setSmaxnum(rs.getString("Smaxnum").trim());
// 			}
// 		} catch (SQLException e) {
// 			e.printStackTrace();
// 		}
// 		return temp;
// 	}

// 	/*
// 	 * 获得管理员详细信息
// 	 */
// 	public static TbLibrarianinfo getLibrarianinfo(Connection con, TbLibrarianinfo librarian) throws SQLException {
// 		TbLibrarianinfo temp = new TbLibrarianinfo();
// 		String sql = "select * from tb_librarianinfo where librarianID=? ";
// 		PreparedStatement stmt = con.prepareStatement(sql);
// 		stmt.setString(1, librarian.getLibrarianId());
// 		ResultSet rs = stmt.executeQuery();
// 		try {// 封装数据到数据模型中
// 			if (rs.next()) {
// 				temp.setLibrarianId(rs.getString("librarianID").trim());
// 				temp.setName(rs.getString("name").trim());
// 				temp.setSex(rs.getString("sex").trim());
// 			}
// 		} catch (SQLException e) {
// 			e.printStackTrace();
// 		}
// 		return temp;
// 	}

// 	/**
// 	 * 
// 	 * @param con
// 	 * @param book
// 	 * @return
// 	 * @throws SQLException
// 	 */
// 	public static ResultSet findBooks(Connection con, TbBookinfo book) throws SQLException {
// 		String goal = null;
// 		int flag = 0;
// 		System.out.println(book.getBookName());
// 		System.out.println(book.getISBN());
// 		if (book.getBookName() != null && flag == 0) {
// 			goal = "bookName=" + book.getBookName() + " ";// name=后面有无一个空格？
// 			flag = 1;
// 		} else if (book.getBookName() != null && flag == 1) {
// 			goal = goal + "and bookName= " + book.getBookName() + " ";// name=后面有无一个空格？
// 		}
// 		if (book.getISBN() != null && flag == 0) {
// 			goal = "ISBN=" + book.getISBN() + " ";
// 			flag = 1;
// 		} else if (book.getISBN() != null && flag == 1) {
// 			goal = goal + "and ISBN= " + book.getISBN() + " ";
// 		}
// 		if (book.getPublisher() != null && flag == 0) {
// 			goal = "publisher= " + book.getPublisher() + " ";
// 			flag = 1;
// 		} else if (book.getPublisher() != null && flag == 1) {
// 			goal = goal + "and publisher= " + book.getPublisher() + " ";
// 		}
// 		if (book.getWriter() != null && flag == 0) {
// 			goal = "writer= " + book.getWriter() + " ";
// 			flag = 1;
// 		} else if (book.getWriter() != null && flag == 1) {
// 			goal = goal + "and writer= " + book.getWriter() + " ";
// 		}
// 		if (book.getTypeld() != null && flag == 0) {
// 			goal = "typeld= " + book.getTypeld() + " ";
// 			flag = 1;
// 		} else if (book.getTypeld() != null && flag == 1) {
// 			goal = goal + "and typeld= " + book.getTypeld() + " ";
// 		}
// 		String sql = "select * from tb_bookinfo where " + goal;
// 		System.out.println("现在的查询语句为：" + sql);
// 		Statement stmt = con.createStatement();
// 		ResultSet rs = stmt.executeQuery(sql);
// 		return rs;

// 	}

// 	/*
// 	 * 查tb_bookborrowinfo表，根据card和isback=0获得该读者当前所有借阅书籍。
// 	 */
// 	public static ResultSet getBorrowbookinfo(Connection con, TbReaderinfo reader) throws SQLException {
// 		String sql = "select * from tb_bookborrowinfo where card=? and isback=0";
// 		PreparedStatement stmt = con.prepareStatement(sql);
// 		stmt.setString(1, reader.getCard());
// 		ResultSet rs = stmt.executeQuery();
// 		return rs;
// 	}

// 	/*
// 	 * 查tb_bookborrowinfo表，根据card和isback=1获得该读者历史借阅书籍。
// 	 */
// 	public static ResultSet getBorrowhistoryinfo(Connection con, TbReaderinfo reader) throws SQLException {
// 		String sql = "select * from tb_bookborrowinfo where card=? and isback=1";
// 		PreparedStatement stmt = con.prepareStatement(sql);
// 		stmt.setString(1, reader.getCard());
// 		ResultSet rs = stmt.executeQuery();
// 		return rs;
// 	}

// 	/**
// 	 * 显示所有读者
// 	 * 
// 	 * @param con
// 	 * @return
// 	 * @throws SQLException
// 	 */
// 	public static ResultSet showReaders(Connection con) throws SQLException {
// 		String sql = "select * from tb_readerinfo";
// 		PreparedStatement stmt = con.prepareStatement(sql);
// 		ResultSet rs = stmt.executeQuery();
// 		return rs;
// 	}

// 	/*
// 	 * 显示所有申请信息
// 	 */
// 	public static ResultSet showBookoders(Connection con) throws SQLException {
// 		String sql = "select * from tb_bookorderinfo";
// 		PreparedStatement stmt = con.prepareStatement(sql);
// 		ResultSet rs = stmt.executeQuery();
// 		return rs;
// 	}

// 	public static void main(String[] args) throws SQLException {
// 		// 初始化Connection con对象
// 		Connection con1 = null;
// 		Library_dbUtil D1 = new Library_dbUtil();
// 		try {
// 			con1 = D1.getCon();
// 			// 测试TbBookinfo getReaderinfo()
// 			TbReaderinfo reader1 = new TbReaderinfo();
// 			reader1.setCard("213183068");
// 			reader1 = getReaderinfo(con1, reader1);
// 			System.out.println(reader1);
// 			// 测试TbLibrarianinfo getLibrarianinfo(Connection con,TbLibrarianinfo librarian)
// 			TbLibrarianinfo librarian1 = new TbLibrarianinfo();
// 			librarian1.setLibrarianId("1234");
// 			librarian1 = getLibrarianinfo(con1, librarian1);
// 			System.out.println(librarian1);

// 			// 测试getBookinfo()
// 			TbBookinfo book1 = new TbBookinfo();
// 			book1.setISBN("978-7-302-44454-1");
// 			book1 = getBookinfo(con1, book1);
// 			System.out.println(book1);

// 		} catch (Exception e) {
// 			// TODO Auto-generated catch block
// 			e.printStackTrace();
// 		}

// 		// 测试changeIsbackinfo(Connection con,TbBookborrowinfo book)
// 		try {
// 			TbBookborrowinfo book = new TbBookborrowinfo();
// 			book.setISBN("978-7-302-44454-1");
// 			book.setCard("213183069");
// 			System.out.println("想要改变isback为1！");
// 			System.out.println(changeIsbackinfo(con1, book));
// 		} catch (Exception e) {
// 			// TODO Auto-generated catch block
// 			e.printStackTrace();
// 		}
// 		/*
// 		 * //测试changeAmountinfo(Connection con, TbBookinfo book)借书，amount-1 try { //
// 		 * 测试TbBookinfo getReaderinfo() TbBookinfo book = new TbBookinfo();
// 		 * book.setISBN("978-7-302-44454-1"); long number = changeAmountinfo(con1,book);
// 		 * System.out.println(number);
// 		 * System.out.println("ISBN为"+book.getISBN()+"的书籍现在的库存为："+ number);
// 		 * 
// 		 * 
// 		 * }catch(Exception e) { // TODO Auto-generated catch block e.printStackTrace();
// 		 * } //测试changeAmountinfo(Connection con, TbBookborrowinfo book)还书,amount+1
// 		 */
// 		// 测试findBooks(),现在还不能读到数据，应该是sql语句的问题
// 		/*
// 		 * try { TbBookinfo book = new TbBookinfo(); book.setBookName("JAVA从入门到精通");
// 		 * book.setISBN("978-7-302-44454-1"); ResultSet rs = findBooks(con1, book);
// 		 * while (rs.next()) { System.out.println(rs.getString("ID"));
// 		 * System.out.println(rs.getString("ISBN"));
// 		 * System.out.println(rs.getString("typeld"));
// 		 * System.out.println(rs.getString("bookName"));
// 		 * System.out.println(rs.getString("writer"));
// 		 * System.out.println(rs.getString("publisher"));
// 		 * System.out.println(rs.getString("date"));
// 		 * System.out.println(rs.getString("price")); System.out.println("\n"); } }
// 		 * catch (Exception e) { // TODO Auto-generated catch block e.printStackTrace();
// 		 * }
// 		 */

// 	}
// }
