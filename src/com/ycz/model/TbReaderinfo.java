package com.ycz.model;

import java.io.Serializable;

public class TbReaderinfo implements Serializable{
	private String card;
	private String readerName;
	private String sex;
	private String Bmaxnum;
	private String Smaxnum;
	private double reputation;
	private String institude;
	
	public TbReaderinfo()
	{		
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public String getReaderName() {
		return readerName;
	}

	public void setReaderName(String readerName) {
		this.readerName = readerName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBmaxnum() {
		return Bmaxnum;
	}

	public void setBmaxnum(String bmaxnum) {
		Bmaxnum = bmaxnum;
	}

	public String getSmaxnum() {
		return Smaxnum;
	}

	public void setSmaxnum(String smaxnum) {
		Smaxnum = smaxnum;
	}

	public double getReputation() {
		return reputation;
	}

	public void setReputation(double reputation) {
		this.reputation = reputation;
	}

	public String getInstitude() {
		return institude;
	}

	public void setInstitude(String institude) {
		this.institude = institude;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Bmaxnum == null) ? 0 : Bmaxnum.hashCode());
		result = prime * result + ((Smaxnum == null) ? 0 : Smaxnum.hashCode());
		result = prime * result + ((card == null) ? 0 : card.hashCode());
		result = prime * result + ((institude == null) ? 0 : institude.hashCode());
		result = prime * result + ((readerName == null) ? 0 : readerName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(reputation);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
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
		TbReaderinfo other = (TbReaderinfo) obj;
		if (Bmaxnum == null) {
			if (other.Bmaxnum != null)
				return false;
		} else if (!Bmaxnum.equals(other.Bmaxnum))
			return false;
		if (Smaxnum == null) {
			if (other.Smaxnum != null)
				return false;
		} else if (!Smaxnum.equals(other.Smaxnum))
			return false;
		if (card == null) {
			if (other.card != null)
				return false;
		} else if (!card.equals(other.card))
			return false;
		if (institude == null) {
			if (other.institude != null)
				return false;
		} else if (!institude.equals(other.institude))
			return false;
		if (readerName == null) {
			if (other.readerName != null)
				return false;
		} else if (!readerName.equals(other.readerName))
			return false;
		if (Double.doubleToLongBits(reputation) != Double.doubleToLongBits(other.reputation))
			return false;
		if (sex == null) {
			if (other.sex != null)
				return false;
		} else if (!sex.equals(other.sex))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TbReaderinfo [card=" + card + ", readerName=" + readerName + ", sex=" + sex + ", Bmaxnum=" + Bmaxnum
				+ ", Smaxnum=" + Smaxnum + ", reputation=" + reputation + ", institude=" + institude + "]";
	}
	

}
