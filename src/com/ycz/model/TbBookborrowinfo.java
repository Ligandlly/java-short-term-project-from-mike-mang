package com.ycz.model;

import java.io.Serializable;

public class TbBookborrowinfo implements Serializable{
	private String card;
	private String bookName;
	private String ISBN;
	private String writer;
	private String typeld;
	private String librarianId;
	private String  isback;
	private String borrowDate;
	private String backDate;



	public TbBookborrowinfo() {

	}



	public String getCard() {
		return card;
	}



	public void setCard(String card) {
		this.card = card;
	}



	public String getBookName() {
		return bookName;
	}



	public void setBookName(String bookName) {
		this.bookName = bookName;
	}



	public String getISBN() {
		return ISBN;
	}



	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}



	public String getWriter() {
		return writer;
	}



	public void setWriter(String writer) {
		this.writer = writer;
	}



	public String getTypeld() {
		return typeld;
	}



	public void setTypeld(String typeld) {
		this.typeld = typeld;
	}



	public String getLibrarianId() {
		return librarianId;
	}



	public void setLibrarianId(String librarianId) {
		this.librarianId = librarianId;
	}



	public String getIsback() {
		return isback;
	}



	public void setIsback(String isback) {
		this.isback = isback;
	}



	public String getBorrowDate() {
		return borrowDate;
	}



	public void setBorrowDate(String borrowDate) {
		this.borrowDate = borrowDate;
	}



	public String getBackDate() {
		return backDate;
	}



	public void setBackDate(String backDate) {
		this.backDate = backDate;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ISBN == null) ? 0 : ISBN.hashCode());
		result = prime * result + ((backDate == null) ? 0 : backDate.hashCode());
		result = prime * result + ((bookName == null) ? 0 : bookName.hashCode());
		result = prime * result + ((borrowDate == null) ? 0 : borrowDate.hashCode());
		result = prime * result + ((card == null) ? 0 : card.hashCode());
		result = prime * result + ((isback == null) ? 0 : isback.hashCode());
		result = prime * result + ((librarianId == null) ? 0 : librarianId.hashCode());
		result = prime * result + ((typeld == null) ? 0 : typeld.hashCode());
		result = prime * result + ((writer == null) ? 0 : writer.hashCode());
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
		TbBookborrowinfo other = (TbBookborrowinfo) obj;
		if (ISBN == null) {
			if (other.ISBN != null)
				return false;
		} else if (!ISBN.equals(other.ISBN))
			return false;
		if (backDate == null) {
			if (other.backDate != null)
				return false;
		} else if (!backDate.equals(other.backDate))
			return false;
		if (bookName == null) {
			if (other.bookName != null)
				return false;
		} else if (!bookName.equals(other.bookName))
			return false;
		if (borrowDate == null) {
			if (other.borrowDate != null)
				return false;
		} else if (!borrowDate.equals(other.borrowDate))
			return false;
		if (card == null) {
			if (other.card != null)
				return false;
		} else if (!card.equals(other.card))
			return false;
		if (isback == null) {
			if (other.isback != null)
				return false;
		} else if (!isback.equals(other.isback))
			return false;
		if (librarianId == null) {
			if (other.librarianId != null)
				return false;
		} else if (!librarianId.equals(other.librarianId))
			return false;
		if (typeld == null) {
			if (other.typeld != null)
				return false;
		} else if (!typeld.equals(other.typeld))
			return false;
		if (writer == null) {
			if (other.writer != null)
				return false;
		} else if (!writer.equals(other.writer))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "TbBookborrowinfo [card=" + card + ", bookName=" + bookName + ", ISBN=" + ISBN + ", writer=" + writer
				+ ", typeld=" + typeld + ", librarianId=" + librarianId + ", isback=" + isback + ", borrowDate="
				+ borrowDate + ", backDate=" + backDate + "]";
	}
	
	

}
