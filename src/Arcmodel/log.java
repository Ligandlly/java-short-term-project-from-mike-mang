package Arcmodel;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class log implements Serializable{
	//public String CCard;//���޸ĵ�һ��ͨ��
	//public String CName;//���޸ĵ�ѧ������
	public Archive Carc;
	public String Changer;//�޸�������
	public String Change_Time;//�޸�ʱ��

	public log(){
		SimpleDateFormat sdf = new SimpleDateFormat();// ��ʽ��ʱ�� 
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss a");// aΪam/pm�ı��  
        
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
