package HospitalModel;
import java.io.Serializable;
import java.util.Date;

public class Regist implements Serializable {
	private String Card;//一卡通号
	private String Regist_Name;//患者名字
	private String Regist_Department;//挂号科室
	private String Regist_Doctor;//挂号医生
	private double Regist_Fee;//挂号费
	private String Regist_Time;//挂号时间
	private String Regist_Status;//单据状态
	
	public Regist() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Regist(String card, String name, String regist_Department, String regist_Doctor, double regist_Fee,
			String regist_Time) {
		super();
		Card = card;
		Regist_Name = name;
		Regist_Department = regist_Department;
		Regist_Doctor = regist_Doctor;
		Regist_Fee = regist_Fee;
		Regist_Time = regist_Time;
		Regist_Status = "新开";
	}



	public Regist(String card, String regist_Status) {
		super();
		Card = card;
		Regist_Status = regist_Status;
	}//给医生修改单据状态用



	public String getCard() {
		return Card;
	}

	public void setCard(String card) {
		Card = card;
	}

	public String getRegist_Name() {
		return Regist_Name;
	}

	public void setRegist_Name(String name) {
		Regist_Name = name;
	}

	public String getRegist_Department() {
		return Regist_Department;
	}

	public void setRegist_Department(String regist_Department) {
		Regist_Department = regist_Department;
	}

	public String getRegist_Doctor() {
		return Regist_Doctor;
	}

	public void setRegist_Doctor(String regist_Doctor) {
		Regist_Doctor = regist_Doctor;
	}

	public double getRegist_Fee() {
		return Regist_Fee;
	}

	public void setRegist_Fee(double regist_Fee) {
		Regist_Fee = regist_Fee;
	}

	public String getRegist_Time() {
		return Regist_Time;
	}

	public void setRegist_Time(String regist_Time) {
		Regist_Time = regist_Time;
	}



	public String getRegist_Status() {
		return Regist_Status;
	}



	public void setRegist_Status(String regist_Status) {
		Regist_Status = regist_Status;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Card == null) ? 0 : Card.hashCode());
		result = prime * result + ((Regist_Department == null) ? 0 : Regist_Department.hashCode());
		result = prime * result + ((Regist_Doctor == null) ? 0 : Regist_Doctor.hashCode());
		long temp;
		temp = Double.doubleToLongBits(Regist_Fee);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((Regist_Name == null) ? 0 : Regist_Name.hashCode());
		result = prime * result + ((Regist_Status == null) ? 0 : Regist_Status.hashCode());
		result = prime * result + ((Regist_Time == null) ? 0 : Regist_Time.hashCode());
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
		Regist other = (Regist) obj;
		if (Card == null) {
			if (other.Card != null)
				return false;
		} else if (!Card.equals(other.Card))
			return false;
		if (Regist_Department == null) {
			if (other.Regist_Department != null)
				return false;
		} else if (!Regist_Department.equals(other.Regist_Department))
			return false;
		if (Regist_Doctor == null) {
			if (other.Regist_Doctor != null)
				return false;
		} else if (!Regist_Doctor.equals(other.Regist_Doctor))
			return false;
		if (Double.doubleToLongBits(Regist_Fee) != Double.doubleToLongBits(other.Regist_Fee))
			return false;
		if (Regist_Name == null) {
			if (other.Regist_Name != null)
				return false;
		} else if (!Regist_Name.equals(other.Regist_Name))
			return false;
		if (Regist_Status == null) {
			if (other.Regist_Status != null)
				return false;
		} else if (!Regist_Status.equals(other.Regist_Status))
			return false;
		if (Regist_Time == null) {
			if (other.Regist_Time != null)
				return false;
		} else if (!Regist_Time.equals(other.Regist_Time))
			return false;
		return true;
	}



	
}
