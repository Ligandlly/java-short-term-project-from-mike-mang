package com.ycz.model;

import java.io.Serializable;

public class TbBookorderinfo implements Serializable{
	private String orderDate;
	private String buyDate;
	private String ISBN;
	private int number;
	private String librarianId;
	private String checkAndAccept;
	private String cards;
	
	public TbBookorderinfo()
	{
		orderDate = null;
		buyDate = null;
		ISBN= null;
		number = 0;
		librarianId = null;
		checkAndAccept = null;
		cards = null;
		
	}
	
	
	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getBuyDate() {
		return buyDate;
	}

	public void setBuyDate(String buyDate) {
		this.buyDate = buyDate;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getLibrarianId() {
		return librarianId;
	}

	public void setLibrarianId(String librarianId) {
		this.librarianId = librarianId;
	}

	public String getCheckAndAccept() {
		return checkAndAccept;
	}

	public void setCheckAndAccept(String checkAndAccept) {
		this.checkAndAccept = checkAndAccept;
	}

	public String getCards() {
		return cards;
	}

	public void setCards(String cards) {
		this.cards = cards;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ISBN == null) ? 0 : ISBN.hashCode());
		result = prime * result + ((buyDate == null) ? 0 : buyDate.hashCode());
		result = prime * result + ((cards == null) ? 0 : cards.hashCode());
		result = prime * result + ((checkAndAccept == null) ? 0 : checkAndAccept.hashCode());
		result = prime * result + ((librarianId == null) ? 0 : librarianId.hashCode());
		result = prime * result + number;
		result = prime * result + ((orderDate == null) ? 0 : orderDate.hashCode());
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
		TbBookorderinfo other = (TbBookorderinfo) obj;
		if (ISBN == null) {
			if (other.ISBN != null)
				return false;
		} else if (!ISBN.equals(other.ISBN))
			return false;
		if (buyDate == null) {
			if (other.buyDate != null)
				return false;
		} else if (!buyDate.equals(other.buyDate))
			return false;
		if (cards == null) {
			if (other.cards != null)
				return false;
		} else if (!cards.equals(other.cards))
			return false;
		if (checkAndAccept == null) {
			if (other.checkAndAccept != null)
				return false;
		} else if (!checkAndAccept.equals(other.checkAndAccept))
			return false;
		if (librarianId == null) {
			if (other.librarianId != null)
				return false;
		} else if (!librarianId.equals(other.librarianId))
			return false;
		if (number != other.number)
			return false;
		if (orderDate == null) {
			if (other.orderDate != null)
				return false;
		} else if (!orderDate.equals(other.orderDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TbBookorderinfo [orderDate=" + orderDate + ", buyDate=" + buyDate + ", ISBN=" + ISBN + ", number="
				+ number + ", librarianId=" + librarianId + ", checkAndAccept=" + checkAndAccept + ", cards=" + cards
				+ "]";
	}

	
}
