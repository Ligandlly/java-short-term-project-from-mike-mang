package BankModel;

import java.io.Serializable;

public class WalletModel implements Serializable {

	private String Card;
	private String Person_Name;
	private double balance;
	public String getCard() {
		return Card;
	}
	public void setCard(String card) {
		Card = card;
	}
	public String getName() {
		return Person_Name;
	}
	public void setName(String name) {
		Person_Name = name;
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
		result = prime * result + ((Person_Name == null) ? 0 : Person_Name.hashCode());
		long temp;
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
		WalletModel other = (WalletModel) obj;
		if (Card == null) {
			if (other.Card != null)
				return false;
		} else if (!Card.equals(other.Card))
			return false;
		if (Person_Name == null) {
			if (other.Person_Name != null)
				return false;
		} else if (!Person_Name.equals(other.Person_Name))
			return false;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		return true;
	}
	public WalletModel(String card, String name, double balance) {
		super();
		Card = card;
		Person_Name = name;
		this.balance = balance;
	}
	public WalletModel() {
		// TODO Auto-generated constructor stub
	}
	
	
}
