package com.ycz.Server;
import com.ycz.dao.*;
import com.ycz.model.*;

import Message.*;

import com.ycz.dao.*;

import UserDAO.UserDAO;
import UserModel.UserModel;
//import HospitalModel.*;
//import HospitalDAO.*;
import user.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Vector;

import com.ycz.Ubtil.*;
//import coursesystemmodel.*;

public class DealProblem {
	private DealProblem() {

	}

	/**
	 * �̵�
	 * 
	 * @param con
	 * @param message
	 * @return
	 * @throws Exception
	 */
//	public static Message Shop(Connection con, Message message) throws Exception {
//		Message messageToSend = new Message();
//		TbGoodinfo tbg = new TbGoodinfo();
//		TbtradeMain tbm = new TbtradeMain();
//		switch (message.getType()) {
//		case "ADDGOOD":
//			tbg = (TbGoodinfo) message.getAllembracing();
//			messageToSend.setResponse(addGood(con, tbg));
//			break;
//
//		case "DELETEGOOD":
//			tbg = (TbGoodinfo) message.getAllembracing();
//			if (DeleteGood(con, tbg) != 0) {
//				messageToSend.setResponse(true);
//			} else {
//				messageToSend.setResponse(false);
//			}
//			messageToSend.setResponse();
//			break;
//		case "SEARCHGOOD":// ����
//			tbg = (TbGoodinfo) message.getAllembracing();
//			tbg = SearchGood(con, tbg);
//			messageToSend.setAllembracing(tbg);
//			break;
//
//		case "MODIFY":
//			tbg = (TbGoodinfo) message.getAllembracing();
//			tbg = modifyGoodinfo(con, tbg);
//			messageToSend.setAllembracing(tbg);
//			break;
//
//		case "SEARCH_GOODNAME":
//			tbg = (TbGoodinfo) message.getAllembracing();
//			tbg = SearchGood_name(con, tbg);
//			messageToSend.setAllembracing(tbg);
//			break;
//
//		case "SEARCH_TAG":
//			TbGoodinfo tbg = new TbGoodinfo();
//			tbg = (TbGoodinfo) message.getAllembracing();
//			tbg = SearchGood_tag(con, tbg);
//			messageToSend.setAllembracing(tbg);
//			break;
//
//		case "ONLINESHOP":
//			tbm = (TbtradeMain) message.getAllembracing();
//			messageToSend.setResponse(onlineshop(con, tbm));
//			break;
//
//		case "SEARCHSP":
//			tbm = (TbtradeMain) message.getAllembracing();
//			tbm = SearchSp(con, tbm);
//			messageToSend.setAllembracing(tbm);
//			break;
//
//		case "FEE":
//			tbm = (TbtradeMain) message.getAllembracing();
//			tbm = SearchSp(con, tbm);
//			messageToSend.getAllembracing(tbm);
//			if (fee(con, tbm)) {
//				messageToSend.setResponse(true);
//			} else {
//				messageToSend.setResponse(false);
//			}
//			break;
//
//		default:
//			break;
//		}
//	}

	/**
	 * ͼ���
	 * 
	 * @param con
	 * @param message
	 * @return
	 * @throws Exception
	 */
	public static Message Library(Connection con, Message message) throws Exception {
		Message messageToSend = new Message();
		TbBookinfo TbB = new TbBookinfo();
		TbReaderinfo TbR = new TbReaderinfo();
		TbBookborrowinfo TbK = new TbBookborrowinfo();
		TbLibrarianinfo lib = new TbLibrarianinfo();
		Vector<TbBookinfo> TbBvector = new Vector<TbBookinfo>();
		Vector<TbReaderinfo> TbRvector = new Vector<TbReaderinfo>();
		Vector<TbBookborrowinfo> TbBBvector = new Vector<TbBookborrowinfo>();
		User person = new User();
		switch (message.getType()) {
		/*
		 * case:"UPDATE_BOOKINFO"
		 * "INSERT_BOOKBORROWINFO"
		 * "SEARCH_BOOKINFO2"
		 * "SHOW_BOOKS"
		 * 属于SearchBook馆藏查询前端
		 */
		case "UPDATE_BOOKINFO":
			TbBookinfo bookinfo=(TbBookinfo)message.getAllembracing();
			if(BookDao.UpdateBookinfo(con, bookinfo)!=0) {
				messageToSend.setResponse(true);
			}else {
				messageToSend.setResponse(false);
			}
			break;
			
		case "INSERT_BOOKBORROWINFO":			
			TbBookborrowinfo bookborrowinfo = (TbBookborrowinfo)message.getAllembracing();
			System.out.println("将要插入的借书信息为："+bookborrowinfo);//没有进入这个函数
			if(BookborrowDao.InsertBookborrowinfo(con, bookborrowinfo)!= 0) {
				messageToSend.setResponse(true);
			}else {
				messageToSend.setResponse(false);
			}
			break;
			
		case "SEARCH_BOOKINFO2":
			TbBvector=new Vector<TbBookinfo>();
			TbBookinfo book = (TbBookinfo)message.getAllembracing();
			TbBvector = BookDao.SearchBookinfo2(con, book);
			messageToSend.setTbBookinfovector(TbBvector);
			break;
			
			
		case "SHOW_BOOKS":
			System.out.println("将要打印馆藏图书");
			TbBvector=new Vector<TbBookinfo>();
			TbBvector = BookDao.showBooks(con);
			messageToSend.setTbBookinfovector(TbBvector);
			break;
			
			
		/*
		 * case:"GET_READERINFO"
		 * 
		 * 属于MyCard证件信息前端
		 */
			
		case "GET_READERINFO":
			System.out.println("将要获得详细的证件信息");
			TbR = (TbReaderinfo) message.getAllembracing();
			TbR = ReaderDao.getReaderinfo(con, TbR);
			messageToSend.setAllembracing(TbR);
			break;
	
		/*
		* case:"CHANGE_READERINFO"
		* "SHOW_READERS"
		* 
		* 属于ReaderInfo读者信息前端
		*/		
		case "CHANGE_READERINFO":
			System.out.println("将要改变读者信息：");
			TbReaderinfo update_reader = (TbReaderinfo)message.getAllembracing();
			if(ReaderDao.changeReaderinfo(con, update_reader)!=0) {
				messageToSend.setResponse(true);
			}else {
				messageToSend.setResponse(false);
			}
			con.close();
			break;
			
		case "SHOW_READERS":
			System.out.println("将要打印读者信息:");
			TbRvector = ReaderDao.showReaders(con);
			System.out.println("获取到的读者信息为"+TbRvector.get(0));
			messageToSend.setTbReaderinfovector(TbRvector);
			con.close();
			break;
			
			/*
			 * case:"GET_READERINFO"(已经有了)
			 * "UPDATE_READERINFO"
			 * "UPDATE_BOOKBORROWINFO"
			 * "SEARCH_BOOKINFO"
			 * "UPDATE_BOOKINFO"(已经有了)
			 * "SHOW_CURRENTBORROW"
			 * 属于CurrentBorrow前端
			 */
		case "SHOW_CURRENTBORROW":
			System.out.println("将要打印当前借阅信息");
			person = (User)message.getAllembracing();
			TbBBvector=BookborrowDao.showCurrentBorrow(con, person);
			messageToSend.setTbBookborrowinfovector(TbBBvector);
			break;

		case "SEARCH_BOOKINFO":
			System.out.println("将要获得详细的书籍信息");
			TbB = (TbBookinfo)message.getAllembracing();
			BookDao.SearchBookinfo(con, TbB);
			messageToSend.setAllembracing(TbB);
			break;
			
		case "UPDATE_BOOKBORROWINFO":
			System.out.println("将要更新书籍借阅信息");
			TbBookborrowinfo update_bookborrow = (TbBookborrowinfo)message.getAllembracing();
			if(BookborrowDao.UpdateBookborrowinfo(con, update_bookborrow)!=0) {
				messageToSend.setResponse(true);
			}else {
				messageToSend.setResponse(false);
			}
			con.close();
			break;
			
		case "UPDATE_READERINFO":
			System.out.println("将要更新读者信息");
			TbReaderinfo reader = (TbReaderinfo)message.getAllembracing();
			if(ReaderDao.UpdateReaderinfo(con, reader)!=0) {
				messageToSend.setResponse(true);
			}else {
				messageToSend.setResponse(false);
			}
			con.close();
			break;
			
//		case "GET_BOOKINFO":
//			TbB = (TbBookinfo) message.getAllembracing();
//			TbB = getBookinfo(con, TbB);
//			messageToSend.setAllembracing(TbB);
//			break;
//

//
//		case "GET_BORROWBOOKINFO":
//			tbR = (TbReaderinfo) message.getAllembracing();
//			ResultSet rs1 = getBorrowbookinfo(con, TbR);
//			messageToSend.setRs(rs1);
//			break;
//
//		case "RETURN_BOOK":
//			tbK = (TbBookborrowinfo) message.getAllembracing();
//			if (returnBook(con, TbK)) {
//				messageToSend.setResponse(true);
//			} else {
//				messageToSend.setResponse(false);
//			}
//			break;
//
//		case "GET_BORROWHISTORYINFO":
//			tbR = message.getAllembracing();
//			ResultSet rs11 = getBorrowhistoryinfo(con, tbR);
//			messageToSend.setRs(rs11);
//			break;
//
//		case "GET_LIBRARIANINFO":
//			lib = message.getAllembracing();
//			lib = getLibrarianinfo(con, lib);
//			messageToSend.setAllembracing(lib);
//			break;
//
//		case "SHOW_READERS":
//			ResultSet rs2 = showReaders(con);
//			messageToSend.setRs(rs2);
//			break;
//
//		case "CHANGE_READERINFO":
//			tbR = (TbReaderinfo) message.getAllembracing();
//			if (changeReaderinfo(con, tbR)) {
//				messageToSend.setResponse(true);
//			} else {
//				messageToSend.setResponse(false);
//			}
//			break;
//
//		case "SHOW_BOOKORDERS":
//			ResultSet rs3 = showBookoders(con);
//			messageToSend.setRs(rs3);
//			break;
//
//		case "CHANGE_BOOKORDERINFO":
//			tbR = (TbReaderinfo) message.getAllembracing();
//			if (changeReaderinfo(con, tbR)) {
//				messageToSend.setResponse(true);
//			} else {
//				messageToSend.setResponse(false);
//			}
//			break;
//		// ����

		default:
			break;
		}
		
		return messageToSend;
	}// δ���

	/**
	 * ��¼
	 * 
	 * @param con
	 * @param message
	 * @return
	 * @throws Exception
	 */
//	public static Message Login(Connection con, Message message) throws Exception {
//		Message messageToSend = new Message();
//		UserModel user = new UserModel();
//		switch (message.getType()) {
//		case "LOGIN":
//			user = (UserModel) message.getAllembracing();
//			UserModel u = UserDAO.SearchUser(con, user);
//			if (u.getPassword() == user.getPassword()) {
//				messageToSend.setResponse(true);
//			} else {
//				messageToSend.setResponse(false);
//			}
//			break;
//
//		case "SEARCH_INFO":
//			user = (UserModel) message.getAllembracing();
//			UserModel u1 = UserDAO.SearchUser(con, user);
//			messageToSend.setAllembracing(u1);
//			break; // ����
//
//		case "UPDATE_INFO":
//			user = (UserModel) message.getAllembracing();
//			if (UserDAO.AllUpdateUser(con, user)) {
//				messageToSend.setResponse(true);
//			} else {
//				messageToSend.setResponse(false);
//			}
//			break;
//
//		default:
//			break;
//		}
//		return messageToSend;
//	}

	/**
	 * ҽԺ
	 * 
	 * @param con
	 * @param message
	 * @return
	 * @throws Exception
	 */
//	public static Message Hospital(Connection con, Message message) throws Exception {
//		Message messageToSend = new Message();
//		DrugModel drug = new DrugModel();
//		StaffModel staff = new StaffModel();
//		Regist regist = new Regist();
//		MedHistoryModel medHistory = new MedHistoryModel();
//		Transfer transfer = new Transfer();
//		DrugTrade drugTrade = new DrugTrade();
//		switch (message.getType()) {
//		case "RETURN_ALLDRUG":
//			Vector<DrugModel> a = new Vector<DrugModel>();
//			ResultSet rs = HospitalDAO.DrugDAO.Druglist(con);
//			while (rs.next()) {
//				DrugModel Dtemp = new DrugModel();
//				Dtemp.setDrug_ApporovalNumber(rs.getString("Drug_AppovalNumber"));
//				Dtemp.setDrug_Name(rs.getString("Drug_Name"));
//				Dtemp.setDrug_Amount(rs.getInt("Drug_Amount"));
//				Dtemp.setDrug_Price(rs.getDouble("Drug_Price"));
//				Dtemp.setDrug_Sort(rs.getString("Drug_Sort"));
//				a.add(Dtemp);
//			}
//			messageToSend.setVector(a);//
//			break;
//
//		case "SEARCH_DRUG":
//			drug = (DrugModel) message.getAllembracing();
//			drug = HospitalDAO.DrugDAO.SearchDrug(con, drug);
//			messageToSend.setAllembracing(drug);
//			break;
//
//		case "ADD_DRUG":
//			drug = (DrugModel) message.getAllembracing();
//			if (HospitalDAO.DrugDAO.InsertDrug(con, drug) != 0) {
//				messageToSend.setResponse(true);
//			} else {
//				messageToSend.setResponse(false);
//			}
//			break;
//
//		case "OUT_DRUG":
//			drug = (DrugModel) message.getAllembracing();
//			if (HospitalDAO.DrugDAO.OutDrug(con, drug)) {
//				messageToSend.setResponse(true);
//			} else {
//				messageToSend.setResponse(false);
//			}
//			break;
//
//		case "RETURN_DPLIST":
//			messageToSend.setDvector(HospitalDAO.DepartmentDAO.DepartmentList(con));
//			break;
//
//		case "RETURN_STAFFLIST":
//			Vector<StaffModel> s = new Vector<StaffModel>();
//			ResultSet rs1 = HospitalDAO.StaffDAO.Stafflist(con);
//			while (rs1.next()) {
//				StaffModel st = new StaffModel();
//				st.setCard(rs1.getString("Staff_Card"));
//				st.setStaff_Name(rs1.getString("Staff_Name"));
//				st.setStaff_Sex(rs1.getString("Staff_Sex"));
//				st.setStaff_Identity(rs1.getString("Staff_Identity"));
//				st.setStaff_WorkTime(rs1.getString("Staff_Worktime"));
//				st.setStaff_Department(rs1.getString("Staff_Department"));
//				st.setStaff_Fee(rs1.getDouble("Regist_Fee"));
//				s.add(st);
//			}
//			messageToSend.setSvector(s);
//			break;
//
//		case "SEARCH_STAFF":
//			staff = (StaffModel) message.getAllembracing();
//			Vector<StaffModel> temp = new Vector<StaffModel>();
//			temp = HospitalDAO.StaffDAO.dimSearchStaff(con, staff);
//			messageToSend.setSvector(temp);
//			break;
//
//		case "ADD_STAFF":
//			staff = (StaffModel) message.getAllembracing();
//			UserModel utemp = new UserModel();
//			utemp.setCard(staff.getCard());
//			utemp = UserDAO.SearchUser(con, utemp);
//			System.out.println(utemp.getUser_Name());
//			System.out.println(utemp.getCard());
//			System.out.println(utemp.getIdentity());
//			System.out.println(staff.getCard());
//			System.out.println(staff.getStaff_Name());
//			if (utemp.getCard().equals(staff.getCard()) && utemp.getUser_Name().equals(staff.getStaff_Name())
//					&& utemp.getIdentity().equals("ҽ��")) {
//				if (HospitalDAO.StaffDAO.InsertStaff(con, staff) != 0) {
//					messageToSend.setResponse(true);
//				} else {
//					messageToSend.setResponse(false);
//				}
//			} else {
//				messageToSend.setResponse(false);
//			}
//			break;
//
//		case "ADD_REGIST":
//			regist = (Regist) message.getAllembracing();
//			System.out.println(regist.getCard());
//			if (HospitalDAO.RegistDAO.InsertRegist(con, regist) != 0) {
//				messageToSend.setResponse(true);
//			} else {
//				messageToSend.setResponse(false);
//			}
//			break;
//
//		case "COM_REGIST":
//			regist = (Regist) message.getAllembracing();
//			if(HospitalDAO.RegistDAO.UpdateRegist(con, regist)!=0) {
//				messageToSend.setResponse(true);
//			}
//			break;
//			
//		case "REGIST_MYLIST":
//			staff=(StaffModel)message.getAllembracing();
//			rs=HospitalDAO.RegistDAO.Reigstlist(con, staff);
//			Vector<Regist>tempss=new Vector<Regist>();
//			while(rs.next()) {
//				Regist Rtemp=new Regist();
//				Rtemp.setCard(rs.getString("Card"));
//				Rtemp.setRegist_Name(rs.getString("Regist_Name"));
//				Rtemp.setRegist_Department(rs.getString("Regist_Department"));
//				Rtemp.setRegist_Doctor(rs.getString("Regist_Doctor"));
//				Rtemp.setRegist_Fee(rs.getDouble("Regist_Fee"));
//				Rtemp.setRegist_Time(rs.getString("Regist_Time"));
//				Rtemp.setRegist_Status(rs.getString("Regist_Status"));
//				tempss.add(Rtemp);
//			}
//			messageToSend.setRegistvectot(tempss);
//			break;
//
//		case"ADD_TRANSFER":
//			Transfer tran=(Transfer)message.getAllembracing();
//			if(HospitalDAO.TransferDAO.InsertTransfer(con, tran)!=0) {
//				messageToSend.setResponse(true);
//			}
//			break;
//			
//			
//		default:
//			break;
//		}
//
//		return messageToSend;
//	}

	/**
	 * �γ���Ϣ����
	 * 
	 * @param con
	 * @param message
	 * @return
	 * @throws Exception
	 */
//	public static Message Course(Connection con, Message message) throws Exception {
//		Message messageToSend = new Message();
//		Selection select = new Selection();
//		Course course = new Course();
//		switch (message.getType()) {
//		case "SELECTION_ADD":
//			select = (Selection) message.getAllembracing();
//			if (coursedao.SelectionDao.SelectionAdd(con, select) != 0) {
//				messageToSend.setResponse(true);
//			} else {
//				messageToSend.setResponse(false);
//			}
//			break;
//
//		case "SELECTION_LIST":
//			int sno = message.getNumber();
//			ResultSet rs = coursedao.SelectionDao.SelectedList(con, sno);
//			messageToSend.setRs(rs);
//
//		case "NUM_SELECTIONADD":
//			int courseId = message.getNumber();
//			if (coursedao.SelectionDao.NumSelectedAdd(con, courseId) != 0) {
//				messageToSend.setResponse(true);
//			} else {
//				messageToSend.setResponse(false);
//			}
//			break;
//
//		case "SELECTION_CANCEL":
//			select = (Selection) message.getAllembracing();
//			if (coursedao.SelectionDao.SelectionCancel(con, select) != 0) {
//				messageToSend.setResponse(true);
//			} else {
//				messageToSend.setResponse(false);
//			}
//			break;
//
//		case "NUMSELECTION_MINUS":
//			int t = message.getNumber();
//			if (coursedao.SelectionDao.NumSelectedMinus(con, t) != 0) {
//				messageToSend.setResponse(true);
//			} else {
//				messageToSend.setResponse(false);
//			}
//			break;
//
//		case "STUDENT_LIST":
//			Sinfo sinfo = (Sinfo) message.getAllembracing();
//			ResultSet rs1 = coursedao.StudentDao.StudentList(con, sinfo);
//			messageToSend.setRs(rs1);
//			break;
//
//		case "COURSE_ADD":
//			course = (Course) message.getAllembracing();
//			if (coursedao.CourseDao.courseAdd(con, course) != 0) {
//				messageToSend.setResponse(true);
//			} else {
//				messageToSend.setResponse(false);
//			}
//			break;
//
//		case "SHOW_READERS":
//			course = (Course) message.getAllembracing();
//			ResultSet rs2 = coursedao.CourseDao.courseList(con, course);
//			messageToSend.setRs(rs2);
//			break;
//
//		case "COURSE_DELETE":
//			String s = message.getS();
//			if (coursedao.CourseDao.courseDelete(con, s) != 0) {
//				messageToSend.setResponse(true);
//			} else {
//				messageToSend.setResponse(false);
//			}
//			break;
//
//		case "COURSE_MODIFY":
//			course = (Course) message.getAllembracing();
//			if (coursedao.CourseDao.courseModify(con, course) != 0) {
//				messageToSend.setResponse(true);
//			} else {
//				messageToSend.setResponse(false);
//			}
//			break;
//
//		case "UNDERFULL_LIST":
//			course = (Course) message.getAllembracing();
//			ResultSet rs3 = coursedao.CourseDao.UnderFullList(con, course);
//			messageToSend.setRs(rs3);
//			break;
//
//		default:
//			break;
//		}
//		return messageToSend;
//	}

	/**
	 * ѧ������
	 * 
	 * @param con
	 * @param message
	 * @return
	 * @throws Exception
	 */
//	public static Message StudentManagement(Connection con, Message message) throws Exception {
//		Message messageToSend = new Message();
//		TbArchiveinfo archive = new TbArchiveinfo();
//		switch (message.getType()) {
//		case "GET_ARCHIVEINFO":
//			archive = message.getAllembracing();
//			messageToSend.setAllembracing(getArchiveinfo(con, archive));
//			break;
//
//		case "CHANGE_ARCHIVEINFO":
//			archive = message.getAllembracing();
//			if (changeArchiveinfo(con, archive)) {
//				messageToSend.setResponse(true);
//			} else {
//				messageToSend.setResponse(false);
//			}
//			break;
//
//		case "INSERT_ARCHIVEINFO":
//			archive = message.getAllembracing();
//			if (Insertinfo(con, archive)) {
//				messageToSend.setResponse(true);
//			} else {
//				messageToSend.setResponse(false);
//			}
//			break;
//
//		case "SHOW_ARCHIVEINFO":
//			archive = message.getAllembracing();
//			ResultSet rs = showReaders(con, archive);
//			messageToSend.setRs(rs);
//			break;
//
//		case "GET_CHANGLOGINFO":
//			Tbchangeinfo student = new Tbchangeinfo();
//			student = message.getAllembracing();
//			ResultSet rs1 = getchangeloginfo(con, student);
//			messageToSend.setRs(rs1);
//			break;
//
//		case "GET_MANAGERINFO":
//			TbManagerinfo manager = new TbManagerinfo();
//			manager = message.getAllembracing();
//			ResultSet rs2 = getManagernfo(con, manager);
//			messageToSend.setRs(rs2);
//
//		}
//	}
}
