package BankModel;

import java.io.Serializable;

public class TradeRecode implements Serializable {

	private String Card;
	private String Person_Name;
	private String Date;
	private String Trade_Type;
	private double Transaction_Amount;
	private double balance;
	public String getCard() {
		return Card;
	}
	public void setCard(String card) {
		Card = card;
	}
	public String getPerson_Name() {
		return Person_Name;
	}
	public void setPerson_Name(String person_Name) {
		Person_Name = person_Name;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getTrade_Type() {
		return Trade_Type;
	}
	public void setTrade_Type(String trade_Type) {
		Trade_Type = trade_Type;
	}
	public double getTransaction_Amount() {
		return Transaction_Amount;
	}
	public void setTransaction_Amount(double transaction_Amount) {
		Transaction_Amount = transaction_Amount;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Card == null) ? 0 : Card.hashCode());
		result = prime * result + ((Date == null) ? 0 : Date.hashCode());
		result = prime * result + ((Person_Name == null) ? 0 : Person_Name.hashCode());
		result = prime * result + ((Trade_Type == null) ? 0 : Trade_Type.hashCode());
		long temp;
		temp = Double.doubleToLongBits(Transaction_Amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		TradeRecode other = (TradeRecode) obj;
		if (Card == null) {
			if (other.Card != null)
				return false;
		} else if (!Card.equals(other.Card))
			return false;
		if (Date == null) {
			if (other.Date != null)
				return false;
		} else if (!Date.equals(other.Date))
			return false;
		if (Person_Name == null) {
			if (other.Person_Name != null)
				return false;
		} else if (!Person_Name.equals(other.Person_Name))
			return false;
		if (Trade_Type == null) {
			if (other.Trade_Type != null)
				return false;
		} else if (!Trade_Type.equals(other.Trade_Type))
			return false;
		if (Double.doubleToLongBits(Transaction_Amount) != Double.doubleToLongBits(other.Transaction_Amount))
			return false;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		return true;
	}
	public TradeRecode(String card, String person_Name, String date, String trade_Type, double transaction_Amount,
			double balance) {
		super();
		Card = card;
		Person_Name = person_Name;
		Date = date;
		Trade_Type = trade_Type;
		Transaction_Amount = transaction_Amount;
		this.balance = balance;
	}
	public TradeRecode() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
