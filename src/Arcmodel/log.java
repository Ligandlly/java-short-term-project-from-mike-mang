package Arcmodel;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class log implements Serializable{
	//public String CCard;//被修改的一卡通号
	//public String CName;//被修改的学生姓名
	public Archive Carc;
	public String Changer;//修改人姓名
	public String Change_Time;//修改时间

	public log(){
		SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间 
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss a");// a为am/pm的标记  
        
		this.Changer=null;
		//this.CCard=null;
		//this.CName=null;
		this.Carc=null;
		this.Change_Time=new String();
	}
	
	public log(String Changer,Archive Carc,String Change_Time){
		this.Changer=Changer;
		this.Carc=Carc;
		this.Change_Time=Change_Time;
	}
	
	public void setChanger(String name) {
		Changer = name;
	}
	
	public String getChanger() {
		return Changer;
	}
	
//	public void setCCard(String ccard) {
//		CCard = ccard;
//	}
//	
//	public String getCCard() {
//		return CCard;
//	}
//	public void setCName(String cname) {
//		CName = cname;
//	}
//	
//	public String getCName() {
//		return CName;
//	}
	public void setArchive(Archive carc) {
		Carc = carc;
	}
	
	public Archive getCarc() {
		return Carc;
	}
	
	public void setChange_Time(String change_Time) {
		Change_Time = change_Time;
	}
	public String getChange_Time() {
		return Change_Time;
	}

}
