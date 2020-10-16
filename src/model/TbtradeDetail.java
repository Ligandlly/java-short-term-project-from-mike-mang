package model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import javax.xml.crypto.Data;

public class TbtradeDetail implements Serializable {
	private String Name;		//商品名称
	private String Uer_ID;		//购买人
	private int num;			//购买数量
	private Date data;			//购买日期
	private int xuhao;			//序号
	
	public int getXuhao() {
		return xuhao;
	}
	public TbtradeDetail() {
		super();
	}
	public void setXuhao(int xuhao) {
		this.xuhao = xuhao;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getUer_ID() {
		return Uer_ID;
	}
	public void setUer_ID(String uer_ID) {
		Uer_ID = uer_ID;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public void setData(Date date) {
		this.data = date;
	}
	public Date getData() {
		return data;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Name == null) ? 0 : Name.hashCode());
		result = prime * result + ((Uer_ID == null) ? 0 : Uer_ID.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + num;
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
		TbtradeDetail other = (TbtradeDetail) obj;
		if (Name == null) {
			if (other.Name != null)
				return false;
		} else if (!Name.equals(other.Name))
			return false;
		if (Uer_ID == null) {
			if (other.Uer_ID != null)
				return false;
		} else if (!Uer_ID.equals(other.Uer_ID))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (num != other.num)
			return false;
		return true;
	}
	public Set<TbtradeDetail> getTbtradeDetails() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String toString() {
		return "TbtradeDetail [Name=" + Name + ", Uer_ID=" + Uer_ID + ", num=" + num + ", data=" + data + ", xuhao="
				+ xuhao + "]";
	}
	
	

}
