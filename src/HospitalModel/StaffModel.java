package HospitalModel;

import java.io.Serializable;

public class StaffModel implements Serializable {
	private String Card;// 一卡通号
	private String Staff_Name;// 职工姓名
	private String Staff_Sex;// 职工性别（男or女）
	private String Staff_Identity;//职工职位（医生or摆药员）
	private String Staff_WorkTime;//工作时段
	private String Staff_Department;//科室
	private Double Staff_Fee;//如果是医师有就诊费
	
	public StaffModel(){
	}
	
	public StaffModel(String Card,String Staff_Name,String Staff_Sex,String Staff_Identity,String Staff_WorkTime,String Staff_Department,Double Fee){
		this.Card=Card;
		this.Staff_Name=Staff_Name;
		this.Staff_Sex=Staff_Sex;
		this.Staff_Identity=Staff_Identity;
		this.Staff_WorkTime=Staff_WorkTime;
		this.Staff_Department=Staff_Department;
		this.Staff_Fee=Fee;
	}
	
	public StaffModel(StaffModel object) {
		this.Card=object.getCard();
		this.Staff_Name=object.getStaff_Name();
		this.Staff_Sex=object.getStaff_Sex();
		this.Staff_Identity=object.getStaff_Identity();
		this.Staff_WorkTime=object.getStaff_WorkTime();
		this.Staff_Department=object.getStaff_Department();
		this.Staff_Fee=object.getStaff_Fee();
	}

	public String getCard() {
		return Card;
	}

	public void setCard(String card) {
		Card = card;
	}

	public String getStaff_Name() {
		return Staff_Name;
	}

	public void setStaff_Name(String staff_Name) {
		Staff_Name = staff_Name;
	}

	public String getStaff_Sex() {
		return Staff_Sex;
	}

	public void setStaff_Sex(String staff_Sex) {
		Staff_Sex = staff_Sex;
	}

	public String getStaff_Identity() {
		return Staff_Identity;
	}

	public void setStaff_Identity(String staff_Identity) {
		Staff_Identity = staff_Identity;
	}

	public String getStaff_WorkTime() {
		return Staff_WorkTime;
	}

	public void setStaff_WorkTime(String staff_WorkTime) {
		Staff_WorkTime = staff_WorkTime;
	}

	public String getStaff_Department() {
		return Staff_Department;
	}

	public void setStaff_Department(String staff_Department) {
		Staff_Department = staff_Department;
	}

	public Double getStaff_Fee() {
		return Staff_Fee;
	}

	public void setStaff_Fee(Double staff_Fee) {
		Staff_Fee = staff_Fee;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Card == null) ? 0 : Card.hashCode());
		result = prime * result + ((Staff_Department == null) ? 0 : Staff_Department.hashCode());
		result = prime * result + ((Staff_Fee == null) ? 0 : Staff_Fee.hashCode());
		result = prime * result + ((Staff_Identity == null) ? 0 : Staff_Identity.hashCode());
		result = prime * result + ((Staff_Name == null) ? 0 : Staff_Name.hashCode());
		result = prime * result + ((Staff_Sex == null) ? 0 : Staff_Sex.hashCode());
		result = prime * result + ((Staff_WorkTime == null) ? 0 : Staff_WorkTime.hashCode());
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
		StaffModel other = (StaffModel) obj;
		if (Card == null) {
			if (other.Card != null)
				return false;
		} else if (!Card.equals(other.Card))
			return false;
		if (Staff_Department == null) {
			if (other.Staff_Department != null)
				return false;
		} else if (!Staff_Department.equals(other.Staff_Department))
			return false;
		if (Staff_Fee == null) {
			if (other.Staff_Fee != null)
				return false;
		} else if (!Staff_Fee.equals(other.Staff_Fee))
			return false;
		if (Staff_Identity == null) {
			if (other.Staff_Identity != null)
				return false;
		} else if (!Staff_Identity.equals(other.Staff_Identity))
			return false;
		if (Staff_Name == null) {
			if (other.Staff_Name != null)
				return false;
		} else if (!Staff_Name.equals(other.Staff_Name))
			return false;
		if (Staff_Sex == null) {
			if (other.Staff_Sex != null)
				return false;
		} else if (!Staff_Sex.equals(other.Staff_Sex))
			return false;
		if (Staff_WorkTime == null) {
			if (other.Staff_WorkTime != null)
				return false;
		} else if (!Staff_WorkTime.equals(other.Staff_WorkTime))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "StaffModel [Card=" + Card + ", Staff_Name=" + Staff_Name + ", Staff_Sex=" + Staff_Sex
				+ ", Staff_Identity=" + Staff_Identity + ", Staff_WorkTime=" + Staff_WorkTime + ", Staff_Department="
				+ Staff_Department + ", Staff_Fee=" + Staff_Fee + "]";
	}

	
	
	
}
