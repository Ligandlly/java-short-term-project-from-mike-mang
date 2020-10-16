package model;

import java.io.Serializable;

public class TbGoodinfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String Good_ID;
	private String Good_name;
	private String Good_tag;
	private double Good_price;
	private int Good_store;
	private String Good_manufacturer;
	private String UserName;
	private String UserID;
	
	//public String toString(){
		//return getSpname();
		
	//}
	
	public String getGood_ID() {
		return Good_ID;
	}
	public TbGoodinfo() {
		super();
	}
	public TbGoodinfo(String good_ID, String good_name, String good_tag, double good_price, int good_store,
			String good_manufacturer, String userName, String userID) {
		super();
		Good_ID = good_ID;
		Good_name = good_name;
		Good_tag = good_tag;
		Good_price = good_price;
		Good_store = good_store;
		Good_manufacturer = good_manufacturer;
		UserName = userName;
		UserID = userID;
	}
	public TbGoodinfo(String good_ID, String good_name, String good_tag, double good_price, int good_store,
			String good_manufacturer) {
		super();
		Good_ID = good_ID;
		Good_name = good_name;
		Good_tag = good_tag;
		Good_price = good_price;
		Good_store = good_store;
		Good_manufacturer = good_manufacturer;
	}
	public TbGoodinfo(String good_name, String good_tag) {
		super();
		Good_name = good_name;
		Good_tag = good_tag;
	}
	public TbGoodinfo(String good_ID) {
		super();
		Good_ID = good_ID;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getUserID() {
		return UserID;
	}
	public void setUserID(String userID) {
		UserID = userID;
	}
	public void setGood_ID(String good_ID) {
		Good_ID = good_ID;
	}
	public String getGood_name() {
		return Good_name;
	}
	public void setGood_name(String good_name) {
		Good_name = good_name;
	}
	public String getGood_tag() {
		return Good_tag;
	}
	public void setGood_tag(String good_tag) {
		Good_tag = good_tag;
	}
	public double getGood_price() {
		return Good_price;
	}
	public void setGood_price(double good_price) {
		Good_price = good_price;
	}
	public int getGood_store() {
		return Good_store;
	}
	public void setGood_store(int good_store) {
		Good_store = good_store;
	}
	public String getGood_manufacturer() {
		return Good_manufacturer;
	}
	public void setGood_manufacturer(String good_manufacturer) {
		Good_manufacturer = good_manufacturer;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Good_ID == null) ? 0 : Good_ID.hashCode());
		result = prime * result + ((Good_manufacturer == null) ? 0 : Good_manufacturer.hashCode());
		result = prime * result + ((Good_name == null) ? 0 : Good_name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(Good_price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + Good_store;
		result = prime * result + ((Good_tag == null) ? 0 : Good_tag.hashCode());
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
		TbGoodinfo other = (TbGoodinfo) obj;
		if (Good_ID == null) {
			if (other.Good_ID != null)
				return false;
		} else if (!Good_ID.equals(other.Good_ID))
			return false;
		if (Good_manufacturer == null) {
			if (other.Good_manufacturer != null)
				return false;
		} else if (!Good_manufacturer.equals(other.Good_manufacturer))
			return false;
		if (Good_name == null) {
			if (other.Good_name != null)
				return false;
		} else if (!Good_name.equals(other.Good_name))
			return false;
		if (Double.doubleToLongBits(Good_price) != Double.doubleToLongBits(other.Good_price))
			return false;
		if (Good_store != other.Good_store)
			return false;
		if (Good_tag == null) {
			if (other.Good_tag != null)
				return false;
		} else if (!Good_tag.equals(other.Good_tag))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TbGoodinfo [Good_ID=" + Good_ID + ", Good_name=" + Good_name + ", Good_tag=" + Good_tag
				+ ", Good_price=" + Good_price + ", Good_store=" + Good_store + ", Good_manufacturer="
				+ Good_manufacturer + ", UserName=" + UserName + ", UserID=" + UserID + "]";
	}
	
}
	