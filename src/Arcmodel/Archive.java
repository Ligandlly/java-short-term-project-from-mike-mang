package Arcmodel;

import java.io.Serializable;
import java.sql.Date;



public class  Archive implements Serializable{
	private String Card;//一卡通号
	private String Name;//学生姓名
	private String Age;//年龄
	private String Sex;//性别

	private String BirthDate;//出生日期
	private String IDnumber;//身份证号
	private String Nationality;//民族
	private String Nativeplace;//籍贯
	private String Marriaged;//婚姻状态
	private String Political_status;//政治面貌
	private String Education;//学历
	private String College;//学院
	private String Major;//专业
	private String Enrollment_date;//入学日期
	private String Telephone;//手机号

	public Archive(String card,String name,String age,String sex,String birthDate,
			String idnumber,String nationality,String nativeplace,String marriaged,
			String political_status,String education,String college,String major,String enrollment_date,String Telephone) {
		this.Card = card;
		this.Name = name;
		this.Age = age;
		this.Sex = sex;

		this.BirthDate = birthDate;
		this.IDnumber = idnumber;
		this.Nationality = nationality;
		this.Nativeplace = nativeplace;
		this.Marriaged = marriaged;
		this.Political_status = political_status;
		this.Education = education;
		this.College = college;
		this.Major = major;
		this.Enrollment_date = enrollment_date;
		this.Telephone = Telephone;
	}
	
	/*public Archive(Archive object) {
		this.Card=object.getCard();
		this.Staff_Name=object.getStaff_Name();
		this.Staff_Sex=object.getStaff_Sex();
		this.Staff_Identify=object.getStaff_Identify();
		this.Staff_WorkTime=object.getStaff_WorkTime();
		this.Staff_Department=object.getStaff_Department();
		this.Staff_Fee=object.getStaff_Fee();
	}*/
	


	public Archive() {
		// TODO Auto-generated constructor stub
	}




	public void setCard(String card) {
		this.Card = card;
	}
	public String getCard() {
		return Card;
	}
	
	public void setName(String name) {
		this.Name = name;
	}
	public String getName() {
		return Name;
	}
	
	public void setAge(String age) {
		this.Age = age;
	}
	public String getAge() {
		return Age;
	}
	
	public void setSex(String sex) {
		this.Sex = sex;
	}
	public String getSex() {
		return Sex;
	}
	
	/*public void setPwd(String pwd) {
		this.Pwd = pwd;
	}
	public String getPwd() {
		return Pwd;
	}*/
	
	public void setNationality(String nationality) {
		this.Nationality = nationality;
	}
	public String getNationality() {
		return Nationality;
	}
	
	public void setNativeplace(String nativeplace) {
		this.Nativeplace = nativeplace;
	}
	public String getNativeplace() {
		return Nativeplace;
	}
	
	public void setPolitical_status(String political_status) {
		this.Political_status = political_status;
	}
	public String getPolitical_status() {
		return Political_status;
	}
	
	public void setEducation(String education) {
		this.Education = education;
	}
	public String getEducation() {
		return Education;
	}
	
	public void setCollege(String college) {
		this.College = college;
	}
	public String getCollege() {
		return College;
	}
	
	public void setMajor(String major) {
		this.Major = major;
	}
	public String getMajor() {
		return Major;
	}
	
	public void setBirthDate(String birthDate) {
		this.BirthDate = birthDate;
	}
	public String getBirthDate() {
		return BirthDate;
	}
	
	public void setIDnumber(String idnumber) {
		this.IDnumber = idnumber;
	}
	public String getIDnumber() {
		return IDnumber;
	}
	
	public void setMarriaged(String marriaged) {
		this.Marriaged = marriaged;
	}
	public String getMarriaged() {
		return Marriaged;
	}
	
	public void setEnrollment_date(String enrollment_date) {
		this.Enrollment_date = enrollment_date;
	}
	public String getEnrollment_date() {
		return Enrollment_date;
	}

	public void setTelephone(String telephone) {
		this.Telephone = telephone;
		
	}
	public String getTelephone() {
		return Telephone;
	}

	@Override
	public String toString() {
		return "Archive [Card=" + Card + ", Name=" + Name + ", Age=" + Age + ", Sex=" + Sex + ", BirthDate=" + BirthDate
				+ ", IDnumber=" + IDnumber + ", Nationality=" + Nationality + ", Nativeplace=" + Nativeplace
				+ ", Marriaged=" + Marriaged + ", Political_status=" + Political_status + ", Education=" + Education
				+ ", College=" + College + ", Major=" + Major + ", Enrollment_date=" + Enrollment_date + ", Telephone="
				+ Telephone + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Age == null) ? 0 : Age.hashCode());
		result = prime * result + ((BirthDate == null) ? 0 : BirthDate.hashCode());
		result = prime * result + ((Card == null) ? 0 : Card.hashCode());
		result = prime * result + ((College == null) ? 0 : College.hashCode());
		result = prime * result + ((Education == null) ? 0 : Education.hashCode());
		result = prime * result + ((Enrollment_date == null) ? 0 : Enrollment_date.hashCode());
		result = prime * result + ((IDnumber == null) ? 0 : IDnumber.hashCode());
		result = prime * result + ((Major == null) ? 0 : Major.hashCode());
		result = prime * result + ((Marriaged == null) ? 0 : Marriaged.hashCode());
		result = prime * result + ((Name == null) ? 0 : Name.hashCode());
		result = prime * result + ((Nationality == null) ? 0 : Nationality.hashCode());
		result = prime * result + ((Nativeplace == null) ? 0 : Nativeplace.hashCode());
		result = prime * result + ((Political_status == null) ? 0 : Political_status.hashCode());
		result = prime * result + ((Sex == null) ? 0 : Sex.hashCode());
		result = prime * result + ((Telephone == null) ? 0 : Telephone.hashCode());
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
		Archive other = (Archive) obj;
		if (Age == null) {
			if (other.Age != null)
				return false;
		} else if (!Age.equals(other.Age))
			return false;
		if (BirthDate == null) {
			if (other.BirthDate != null)
				return false;
		} else if (!BirthDate.equals(other.BirthDate))
			return false;
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
		if (Education == null) {
			if (other.Education != null)
				return false;
		} else if (!Education.equals(other.Education))
			return false;
		if (Enrollment_date == null) {
			if (other.Enrollment_date != null)
				return false;
		} else if (!Enrollment_date.equals(other.Enrollment_date))
			return false;
		if (IDnumber == null) {
			if (other.IDnumber != null)
				return false;
		} else if (!IDnumber.equals(other.IDnumber))
			return false;
		if (Major == null) {
			if (other.Major != null)
				return false;
		} else if (!Major.equals(other.Major))
			return false;
		if (Marriaged == null) {
			if (other.Marriaged != null)
				return false;
		} else if (!Marriaged.equals(other.Marriaged))
			return false;
		if (Name == null) {
			if (other.Name != null)
				return false;
		} else if (!Name.equals(other.Name))
			return false;
		if (Nationality == null) {
			if (other.Nationality != null)
				return false;
		} else if (!Nationality.equals(other.Nationality))
			return false;
		if (Nativeplace == null) {
			if (other.Nativeplace != null)
				return false;
		} else if (!Nativeplace.equals(other.Nativeplace))
			return false;
		if (Political_status == null) {
			if (other.Political_status != null)
				return false;
		} else if (!Political_status.equals(other.Political_status))
			return false;
		if (Sex == null) {
			if (other.Sex != null)
				return false;
		} else if (!Sex.equals(other.Sex))
			return false;
		if (Telephone == null) {
			if (other.Telephone != null)
				return false;
		} else if (!Telephone.equals(other.Telephone))
			return false;
		return true;
	}
	
	

	
	
}