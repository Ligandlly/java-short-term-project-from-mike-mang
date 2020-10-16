package HospitalModel;

import java.io.Serializable;

public class Transfer implements Serializable{
	private String Card;// 一卡通号
	private String Transfer_Name;// 姓名
	private String Transfer_Doctor;// 批准医生
	private String Transfer_Diagnose;// 医生意见
	private String Transfer_Status;// 转诊单状态
	
	public Transfer(String card, String name, String transfer_Doctor, String transfer_Diagnose, String transfer_Status) {
		super();
		Card = card;
		Transfer_Name = name;
		Transfer_Doctor = transfer_Doctor;
		Transfer_Diagnose = transfer_Diagnose;
		Transfer_Status = transfer_Status;
	}

	public Transfer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCard() {
		return Card;
	}

	public void setCard(String card) {
		Card = card;
	}

	public String getTransfer_Name() {
		return Transfer_Name;
	}

	public void setTransfer_Name(String name) {
		Transfer_Name = name;
	}

	public String getTransfer_Doctor() {
		return Transfer_Doctor;
	}

	public void setTransfer_Doctor(String transfer_Doctor) {
		Transfer_Doctor = transfer_Doctor;
	}

	public String getTransfer_Diagnose() {
		return Transfer_Diagnose;
	}

	public void setTransfer_Diagnose(String transfer_Diagnose) {
		Transfer_Diagnose = transfer_Diagnose;
	}

	public String getTransfer_Status() {
		return Transfer_Status;
	}

	public void setTransfer_Status(String transfer_Status) {
		Transfer_Status = transfer_Status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Card == null) ? 0 : Card.hashCode());
		result = prime * result + ((Transfer_Name == null) ? 0 : Transfer_Name.hashCode());
		result = prime * result + ((Transfer_Diagnose == null) ? 0 : Transfer_Diagnose.hashCode());
		result = prime * result + ((Transfer_Doctor == null) ? 0 : Transfer_Doctor.hashCode());
		result = prime * result + ((Transfer_Status == null) ? 0 : Transfer_Status.hashCode());
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
		Transfer other = (Transfer) obj;
		if (Card == null) {
			if (other.Card != null)
				return false;
		} else if (!Card.equals(other.Card))
			return false;
		if (Transfer_Name == null) {
			if (other.Transfer_Name != null)
				return false;
		} else if (!Transfer_Name.equals(other.Transfer_Name))
			return false;
		if (Transfer_Diagnose == null) {
			if (other.Transfer_Diagnose != null)
				return false;
		} else if (!Transfer_Diagnose.equals(other.Transfer_Diagnose))
			return false;
		if (Transfer_Doctor == null) {
			if (other.Transfer_Doctor != null)
				return false;
		} else if (!Transfer_Doctor.equals(other.Transfer_Doctor))
			return false;
		if (Transfer_Status == null) {
			if (other.Transfer_Status != null)
				return false;
		} else if (!Transfer_Status.equals(other.Transfer_Status))
			return false;
		return true;
	}


	
}
