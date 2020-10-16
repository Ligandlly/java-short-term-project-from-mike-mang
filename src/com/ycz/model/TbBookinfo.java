/*
 * copyright:pomelo
 * 图书信息表模型类TbBookinfo
 */
package com.ycz.model;

import java.io.Serializable;

public class TbBookinfo implements Serializable{
	private String ISBN;//索书号
	private String typeld;//类别编号
	private String bookName;//书名
	private String writer;//作者名
	private String publisher;//出版社
	private String publicdate;//出版时间
	private double price;//价格
	private int amount;//库存
	
	public TbBookinfo() {
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getTypeld() {
		return typeld;
	}

	public void setTypeld(String typeld) {
		this.typeld = typeld;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPublicdate() {
		return publicdate;
	}

	public void setPublicdate(String publicdate) {
		this.publicdate = publicdate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ISBN == null) ? 0 : ISBN.hashCode());
		result = prime * result + amount;
		result = prime * result + ((bookName == null) ? 0 : bookName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((publicdate == null) ? 0 : publicdate.hashCode());
		result = prime * result + ((publisher == null) ? 0 : publisher.hashCode());
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
		TbBookinfo other = (TbBookinfo) obj;
		if (ISBN == null) {
			if (other.ISBN != null)
				return false;
		} else if (!ISBN.equals(other.ISBN))
			return false;
		if (amount != other.amount)
			return false;
		if (bookName == null) {
			if (other.bookName != null)
				return false;
		} else if (!bookName.equals(other.bookName))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (publicdate == null) {
			if (other.publicdate != null)
				return false;
		} else if (!publicdate.equals(other.publicdate))
			return false;
		if (publisher == null) {
			if (other.publisher != null)
				return false;
		} else if (!publisher.equals(other.publisher))
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
		return "TbBookinfo [ISBN=" + ISBN + ", typeld=" + typeld + ", bookName=" + bookName + ", writer=" + writer
				+ ", publisher=" + publisher + ", publicdate=" + publicdate + ", price=" + price + ", amount=" + amount
				+ "]";
	}

	
}
