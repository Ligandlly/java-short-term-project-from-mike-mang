package model;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.xml.crypto.Data;
import java.io.Serializable;

public class TbtradeMain implements Serializable {
	private String ID;			//商品ID
	private String Name;		//商品名称
	private double price;		//单价
	private int num;			//购买数量
	private String tag;			//商品标签
	private String manufacturer;//生产商
	private int store;			//库存
	private int state;			//购买状态(默认为1代表购买，0代表不购买)
	private String UserName;	//购买者
	private String UserID;		//购买者ID	
	private Date date;			//购买日期
	public TbtradeMain() {
		super();
	}
	public TbtradeMain(String name, Double good_Price, int state, String tag, String manufacturer,int store, int num,
			String userID, String userName) {
		super();
//		this.ID=id;
		this.Name = name;
		this.price = good_Price;
		this.num = num;
		this.tag = tag;
		this.manufacturer = manufacturer;
		this.store = store;
		this.state = state;
		UserName = userName;
		UserID = userID;
	//	this.date = date;
	}

	public String getUserID() {
		return UserID;
	}
	public void setUserID(String userID) {
		UserID = userID;
	}
	public Date getData() {
		return date;
	}
	public void setDate() {
		Calendar c=Calendar.getInstance();
		int year=c.get(Calendar.YEAR);
		int month=c.get(Calendar.MONTH);
		int date=c.get(Calendar.DATE);
        @SuppressWarnings("deprecation")
		Date now =new Date(year, month, date);// new Date()为获取当前系统时间
		this.date =now;
	}
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public int getStore() {
		return store;
	}
	public void setStore(int store) {
		this.store = store;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Name == null) ? 0 : Name.hashCode());
		result = prime * result + ((UserName == null) ? 0 : UserName.hashCode());
		result = prime * result + ((manufacturer == null) ? 0 : manufacturer.hashCode());
		result = prime * result + num;
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + state;
		result = prime * result + store;
		result = prime * result + ((tag == null) ? 0 : tag.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TbtradeMain other = (TbtradeMain) obj;
		if (Name == null) {
			if (other.Name != null)
				return false;
		} else if (!Name.equals(other.Name))
			return false;
		if (UserName == null) {
			if (other.UserName != null)
				return false;
		} else if (!UserName.equals(other.UserName))
			return false;
		if (manufacturer == null) {
			if (other.manufacturer != null)
				return false;
		} else if (!manufacturer.equals(other.manufacturer))
			return false;
		if (num != other.num)
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (state != other.state)
			return false;
		if (store != other.store)
			return false;
		if (tag == null) {
			if (other.tag != null)
				return false;
		} else if (!tag.equals(other.tag))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TbtradeMain [ID=" + ID + ", Name=" + Name + ", price=" + price + ", num=" + num + ", tag=" + tag
				+ ", manufacturer=" + manufacturer + ", store=" + store + ", state=" + state + ", UserName=" + UserName
				+ ", UserID=" + UserID + ", date=" + date + "]";
	}
	
	
}