package Arcmodel;

public class Student {
	private String Card;//“ªø®Õ®
	private String Password;//√‹¬Î
	private String Name;//–’√˚
	
	public Student(String card,String password, String name) {
		this.Card = card;
		this.Password = password;
		this.Name = name;
	}
	
	public void setCard(String card) {
		Card = card;
	}
	
	public String getCard() { 
		return this.Card;
	}
	
	public void setPassword(String password) {
		Password = password;
	}
	
	public String getPassword() { 
		return this.Password;
	}
	
	public void setName(String name) {
		Name = name;
	}
	
	public String getName() { 
		return this.Name;
	}
}
