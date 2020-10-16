package HospitalModel;
import java.io.Serializable;
import java.util.Date;
public class MedHistoryModel implements Serializable{
	private String Card;//一卡通号
	private String Person_Name;//患者姓名
	private String MedHistory_History;//病历内容
	private String MedHistory_MainSuit;//主诉
	private String MedHistory_Diagnose;//诊断
	private String MedHistory_Time;//书写时间
	
	public MedHistoryModel(){
	}
	
	public MedHistoryModel(String Card,String Name,String MedHistory_History,String MedHistory_MainSuit,String MedHistory_Diagnose,String MedHistory_Time){
		this.Card=Card;
		this.Person_Name=Name;
		this.MedHistory_History=MedHistory_History;
		this.MedHistory_MainSuit=MedHistory_MainSuit;
		this.MedHistory_Diagnose=MedHistory_Diagnose;
		this.MedHistory_Time=MedHistory_Time;
	}


	public String getCard() {
		return Card;
	}
	public void setCard(String card) {
		Card = card;
	}
	public String getPerson_Name() {
		return Person_Name;
	}
	public void setPerson_Name(String name) {
		Person_Name = name;
	}
	public String getMedHistory_History() {
		return MedHistory_History;
	}
	public void setMedHistory_History(String medHistory_History) {
		MedHistory_History = medHistory_History;
	}
	public String getMedHistory_MainSuit() {
		return MedHistory_MainSuit;
	}
	public void setMedHistory_MainSuit(String medHistory_MainSuit) {
		MedHistory_MainSuit = medHistory_MainSuit;
	}
	public String getMedHistory_Diagnose() {
		return MedHistory_Diagnose;
	}
	public void setMedHistory_Diagnose(String medHistory_Diagnose) {
		MedHistory_Diagnose = medHistory_Diagnose;
	}
	public String getMedHistory_Time() {
		return MedHistory_Time;
	}
	public void setMedHistory_Time(String medHistory_Time) {
		MedHistory_Time = medHistory_Time;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Card == null) ? 0 : Card.hashCode());
		result = prime * result + ((MedHistory_Diagnose == null) ? 0 : MedHistory_Diagnose.hashCode());
		result = prime * result + ((MedHistory_History == null) ? 0 : MedHistory_History.hashCode());
		result = prime * result + ((MedHistory_MainSuit == null) ? 0 : MedHistory_MainSuit.hashCode());
		result = prime * result + ((MedHistory_Time == null) ? 0 : MedHistory_Time.hashCode());
		result = prime * result + ((Person_Name == null) ? 0 : Person_Name.hashCode());
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
		MedHistoryModel other = (MedHistoryModel) obj;
		if (Card == null) {
			if (other.Card != null)
				return false;
		} else if (!Card.equals(other.Card))
			return false;
		if (MedHistory_Diagnose == null) {
			if (other.MedHistory_Diagnose != null)
				return false;
		} else if (!MedHistory_Diagnose.equals(other.MedHistory_Diagnose))
			return false;
		if (MedHistory_History == null) {
			if (other.MedHistory_History != null)
				return false;
		} else if (!MedHistory_History.equals(other.MedHistory_History))
			return false;
		if (MedHistory_MainSuit == null) {
			if (other.MedHistory_MainSuit != null)
				return false;
		} else if (!MedHistory_MainSuit.equals(other.MedHistory_MainSuit))
			return false;
		if (MedHistory_Time == null) {
			if (other.MedHistory_Time != null)
				return false;
		} else if (!MedHistory_Time.equals(other.MedHistory_Time))
			return false;
		if (Person_Name == null) {
			if (other.Person_Name != null)
				return false;
		} else if (!Person_Name.equals(other.Person_Name))
			return false;
		return true;
	}
	
	
	
}
