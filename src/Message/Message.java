package Message;
import java.io.Serializable;
import com.ycz.model.*;

import Arcmodel.log;
import BankModel.TradeRecode;

import java.sql.ResultSet;
import java.util.*;

import com.jakey.model.Course;
import com.jakey.model.Selection;

import HospitalModel.Department;
import HospitalModel.DrugModel;
import HospitalModel.DrugTrade;
import HospitalModel.MedHistoryModel;
import HospitalModel.Regist;
import HospitalModel.StaffModel;
import model.*;

import com.ycz.model.*;
public class Message implements Serializable{
	/**
	 * 前后端来回传数据
	 */
	private static final long serialVersionUID = 1L;
	public ResultSet getRs() {
		return rs;
	}
	public void setRs(ResultSet rs) {
		this.rs = rs;
	}
	private String type;//第一种方案，用直接字符串辨识
	private int CheckCode;//第二种方案，用标识码
	private Object allembracing;//传入对象
	private boolean response=false;
	private String theUsr;//暂时没懂，先不要涉及这个变量的操作
	private ArrayList<DrugModel>drugarray;
	private Vector<DrugModel> vector;
	private Vector<Department> Dvector;
	private Vector<StaffModel> Svector;
	private Vector<Course> csvecVector;
	private Vector<Selection>selectVector;
	private Vector<Regist>registvectot;
	private Double usedouble;
	private String s2;

	private Vector<TradeRecode>TradeRecodevector;
	private Vector<TbBookinfo>TbBookinfovector;
	private Vector<TbReaderinfo>TbReaderinfovector;
	private Vector<TbBookborrowinfo>TbBookborrowinfovector;
	private Vector<TbBookorderinfo>TbBookorderinfovector;
	private Vector<TbGoodinfo>TbGoodvector;
	private Vector<TbtradeDetail>TbtradeDetail;
	private Vector<TbtradeMain>TbtradeMain;
	private Vector<MedHistoryModel>medHistoryVector;
	private Vector<log> changeVector;
	private Vector<DrugTrade>drugtradeVector;
	
	public Vector<Course> getCsvecVector() {
		return csvecVector;
	}
	public void setCsvecVector(Vector<Course> csvecVector) {
		this.csvecVector = csvecVector;
	}
	public Vector<Selection> getSelectVector() {
		return selectVector;
	}
	public void setSelectVector(Vector<Selection> selectVector) {
		this.selectVector = selectVector;
	}
	public Vector<StaffModel> getSvector() {
		return Svector;
	}
	public void setSvector(Vector<StaffModel> svector) {
		Svector = svector;
	}
	private ResultSet rs;//返回结果集
	private int number;//传数字
	private String s;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getCheckCode() {
		return CheckCode;
	}
	public void setCheckCode(int checkCode) {
		CheckCode = checkCode;
	}
	public Object getAllembracing() {
		return allembracing;
	}
	public void setAllembracing(Object allembracing) {
		this.allembracing = allembracing;
	}
	public boolean isResponse() {
		return response;
	}
	public void setResponse(boolean response) {
		this.response = response;
	}
	public String getTheUsr() {
		return theUsr;
	}
	public void setTheUsr(String theUsr) {
		this.theUsr = theUsr;
	}
	
	
	public Message(String type, Object allembracing) {
		this.type = type;//前端预设的类型值，方便后端辨识什么功能
		this.allembracing = allembracing;//包罗万象
	}
	public Message() {
		// TODO Auto-generated constructor stub
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getS() {
		return s;
	}
	public void setS(String s) {
		this.s = s;
	}
	public ArrayList<DrugModel> getDrugarray() {
		return drugarray;
	}
	public void setDrugarray(ArrayList<DrugModel> drugarray) {
		this.drugarray = drugarray;
	}
	public Vector<DrugModel> getVector() {
		return vector;
	}
	public void setVector(Vector<DrugModel> vector) {
		this.vector = vector;
	}
	public Vector<Department> getDvector() {
		return Dvector;
	}
	public void setDvector(Vector<Department> dvector) {
		Dvector = dvector;
	}
	public Vector<Regist> getRegistvectot() {
		return registvectot;
	}
	public void setRegistvectot(Vector<Regist> registvectot) {
		this.registvectot = registvectot;
	}
	public Vector<TbBookinfo> getTbBookinfovector() {
		return TbBookinfovector;
	}
	public void setTbBookinfovector(Vector<TbBookinfo> tbBookinfovector) {
		TbBookinfovector = tbBookinfovector;
	}
	public Vector<TbReaderinfo> getTbReaderinfovector() {
		return TbReaderinfovector;
	}
	public void setTbReaderinfovector(Vector<TbReaderinfo> tbReaderinfovector) {
		TbReaderinfovector = tbReaderinfovector;
	}
	public Vector<TbBookborrowinfo> getTbBookborrowinfovector() {
		return TbBookborrowinfovector;
	}
	public void setTbBookborrowinfovector(Vector<TbBookborrowinfo> tbBookborrowinfovector) {
		TbBookborrowinfovector = tbBookborrowinfovector;
	}
	public Double getUsedouble() {
		return usedouble;
	}
	public void setUsedouble(Double usedouble) {
		this.usedouble = usedouble;
	}
	public String getS2() {
		return s2;
	}
	public void setS2(String s2) {
		this.s2 = s2;
	}
	public Vector<TradeRecode> getTradeRecodevector() {
		return TradeRecodevector;
	}
	public void setTradeRecodevector(Vector<TradeRecode> tradeRecodevector) {
		TradeRecodevector = tradeRecodevector;
	}
	public Vector<TbGoodinfo> getTbGoodvector() {
		return TbGoodvector;
	}
	public void setTbGoodvector(Vector<TbGoodinfo> tbGoodvector) {
		TbGoodvector = tbGoodvector;
	}
	public Vector<TbtradeDetail> getTbtradeDetail() {
		return TbtradeDetail;
	}
	public void setTbtradeDetail(Vector<TbtradeDetail> tbtradeDetail) {
		TbtradeDetail = tbtradeDetail;
	}
	public Vector<TbtradeMain> getTbtradeMain() {
		return TbtradeMain;
	}
	public void setTbtradeMain(Vector<TbtradeMain> tbtradeMain) {
		TbtradeMain = tbtradeMain;
	}
	public Vector<MedHistoryModel> getMedHistoryVector() {
		return medHistoryVector;
	}
	public void setMedHistoryVector(Vector<MedHistoryModel> medHistoryVector) {
		this.medHistoryVector = medHistoryVector;
	}
	public Vector<TbBookorderinfo> getTbBookorderinfovector() {
		return TbBookorderinfovector;
	}
	public void setTbBookorderinfovector(Vector<TbBookorderinfo> tbBookorderinfovector) {
		TbBookorderinfovector = tbBookorderinfovector;
	}
	public Vector<log> getChangeVector() {
		return changeVector;
	}
	public void setChangeVector(Vector<log> changeVector) {
		this.changeVector = changeVector;
	}
	public Vector<DrugTrade> getDrugtradeVector() {
		return drugtradeVector;
	}
	public void setDrugtradeVector(Vector<DrugTrade> drugtradeVector) {
		this.drugtradeVector = drugtradeVector;
	}


	
	
	
	
	
}
