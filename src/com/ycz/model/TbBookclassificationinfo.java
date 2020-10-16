package com.ycz.model;

import java.io.Serializable;

public class TbBookclassificationinfo implements Serializable{
	private String typeld;
	private String typename;
	private String days;
	private float punish_money;
	private float punish_repu;

	public TbBookclassificationinfo()
	{
		
	}

	public String getTypeld() {
		return typeld;
	}

	public void setTypeld(String typeld) {
		this.typeld = typeld;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public String getDays() {
		return days;
	}

	public void setDays(String days) {
		this.days = days;
	}

	public float getPunish_money() {
		return punish_money;
	}

	public void setPunish_money(float punish_money) {
		this.punish_money = punish_money;
	}

	public float getPunish_repu() {
		return punish_repu;
	}

	public void setPunish_repu(float punish_repu) {
		this.punish_repu = punish_repu;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((days == null) ? 0 : days.hashCode());
		result = prime * result + Float.floatToIntBits(punish_money);
		result = prime * result + Float.floatToIntBits(punish_repu);
		result = prime * result + ((typeld == null) ? 0 : typeld.hashCode());
		result = prime * result + ((typename == null) ? 0 : typename.hashCode());
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
		TbBookclassificationinfo other = (TbBookclassificationinfo) obj;
		if (days == null) {
			if (other.days != null)
				return false;
		} else if (!days.equals(other.days))
			return false;
		if (Float.floatToIntBits(punish_money) != Float.floatToIntBits(other.punish_money))
			return false;
		if (Float.floatToIntBits(punish_repu) != Float.floatToIntBits(other.punish_repu))
			return false;
		if (typeld == null) {
			if (other.typeld != null)
				return false;
		} else if (!typeld.equals(other.typeld))
			return false;
		if (typename == null) {
			if (other.typename != null)
				return false;
		} else if (!typename.equals(other.typename))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TbBookclassificationinfo [typeld=" + typeld + ", typename=" + typename + ", days=" + days
				+ ", punish_money=" + punish_money + ", punish_repu=" + punish_repu + "]";
	}

	
	
}
