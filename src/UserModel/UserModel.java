package UserModel;

import java.io.Serializable;

public class UserModel implements Serializable {

	private String Card;// 一锟斤拷通
	private String Password;// 锟斤拷锟斤拷
	private String Identity;// 锟斤拷锟斤拷
	private String User_Name;// 锟斤拷锟斤拷
	private String Sex;// 锟皆憋拷
	private String College;// 学院
	private String Status;// 状态
	private String Email;// 锟斤拷锟斤拷

	public UserModel(String card, String password, String identity, String user_Name, String sex, String college,
			String status, String email) {
		super();
		Card = card;
		Password = password;
		Identity = identity;
		User_Name = user_Name;
		Sex = sex;
		College = college;
		Status = status;
		Email = email;
	}

	public UserModel() {
		// TODO Auto-generated constructor stub
	}

	public String getCard() {
		return Card;
	}

	public void setCard(String card) {
		Card = card;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getIdentity() {
		return Identity;
	}

	public void setIdentity(String identity) {
		Identity = identity;
	}

	public String getUser_Name() {
		return User_Name;
	}

	public void setUser_Name(String user_Name) {
		User_Name = user_Name;
	}

	public String getSex() {
		return Sex;
	}

	public void setSex(String sex) {
		Sex = sex;
	}

	public String getCollege() {
		return College;
	}

	public void setCollege(String college) {
		College = college;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Card == null) ? 0 : Card.hashCode());
		result = prime * result + ((College == null) ? 0 : College.hashCode());
		result = prime * result + ((Email == null) ? 0 : Email.hashCode());
		result = prime * result + ((Identity == null) ? 0 : Identity.hashCode());
		result = prime * result + ((Password == null) ? 0 : Password.hashCode());
		result = prime * result + ((Sex == null) ? 0 : Sex.hashCode());
		result = prime * result + ((Status == null) ? 0 : Status.hashCode());
		result = prime * result + ((User_Name == null) ? 0 : User_Name.hashCode());
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
		UserModel other = (UserModel) obj;
		if (Card == null) {
			if (other.Card != null)
				return false;
		} else if (!Card.equals(other.Card))
			return false;
		if (College == null) {
			if (other.College != null)
				return false;
		} else if (!College.equals(other.College))
			return false;
		if (Email == null) {
			if (other.Email != null)
				return false;
		} else if (!Email.equals(other.Email))
			return false;
		if (Identity == null) {
			if (other.Identity != null)
				return false;
		} else if (!Identity.equals(other.Identity))
			return false;
		if (Password == null) {
			if (other.Password != null)
				return false;
		} else if (!Password.equals(other.Password))
			return false;
		if (Sex == null) {
			if (other.Sex != null)
				return false;
		} else if (!Sex.equals(other.Sex))
			return false;
		if (Status == null) {
			if (other.Status != null)
				return false;
		} else if (!Status.equals(other.Status))
			return false;
		if (User_Name == null) {
			if (other.User_Name != null)
				return false;
		} else if (!User_Name.equals(other.User_Name))
			return false;
		return true;
	}

}
