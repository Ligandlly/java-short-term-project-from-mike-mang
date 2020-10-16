package com.ycz.model;

import java.io.Serializable;

public class TbLibrarianinfo implements Serializable{
	private String librarianId;
	private String name;
	private String sex;
	
	public TbLibrarianinfo()
	{
		
	}

	public String getLibrarianId() {
		return librarianId;
	}

	public void setLibrarianId(String librarianId) {
		this.librarianId = librarianId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((librarianId == null) ? 0 : librarianId.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		TbLibrarianinfo other = (TbLibrarianinfo) obj;
		if (librarianId == null) {
			if (other.librarianId != null)
				return false;
		} else if (!librarianId.equals(other.librarianId))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
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
		return "TbLibrarianinfo [librarianId=" + librarianId + ", name=" + name + ", sex=" + sex + "]";
	}
	
	

}
