package HospitalModel;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;
public class FeeModel implements Serializable {
	public String Card;//һ��ͨ��
	public String Name;//�ɷ�������
	public String Fee_Name;//�ɷ���Ŀ����
	public String Fee_Sort;//�ɷ���Ŀ�ѱ�
	public double Fee_Price;//���
	public Date Fee_Time;//�ɷ�ʱ��
	
	public FeeModel(){
		SimpleDateFormat sdf = new SimpleDateFormat();// ��ʽ��ʱ�� 
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss a");// aΪam/pm�ı��  
		this.Card=null;
		this.Name=null;
		this.Fee_Name=null;
		this.Fee_Sort="ҩƷ";
		this.Fee_Price=0;
		this.Fee_Time=new Date();
	}
	
	public FeeModel(String Card,String Name,String Fee_Name,String Fee_Sort,double Fee_Price,Date Fee_Time){
		this.Card=Card;
		this.Name=Name;
		this.Fee_Name=Fee_Name;
		this.Fee_Sort=Fee_Sort;
		this.Fee_Price=Fee_Price;
		this.Fee_Time=Fee_Time;
	}

	public String getCard() {
		return Card;
	}

	public void setCard(String card) {
		Card = card;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getFee_Name() {
		return Fee_Name;
	}

	public void setFee_Name(String fee_Name) {
		Fee_Name = fee_Name;
	}

	public String getFee_Sort() {
		return Fee_Sort;
	}

	public void setFee_Sort(String fee_Sort) {
		Fee_Sort = fee_Sort;
	}

	public double getFee_Price() {
		return Fee_Price;
	}

	public void setFee_Price(double fee_Price) {
		Fee_Price = fee_Price;
	}

	public Date getFee_Time() {
		return Fee_Time;
	}

	public void setFee_Time(Date fee_Time) {
		Fee_Time = fee_Time;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Card == null) ? 0 : Card.hashCode());
		result = prime * result + ((Fee_Name == null) ? 0 : Fee_Name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(Fee_Price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((Fee_Sort == null) ? 0 : Fee_Sort.hashCode());
		result = prime * result + ((Fee_Time == null) ? 0 : Fee_Time.hashCode());
		result = prime * result + ((Name == null) ? 0 : Name.hashCode());
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
		FeeModel other = (FeeModel) obj;
		if (Card == null) {
			if (other.Card != null)
				return false;
		} else if (!Card.equals(other.Card))
			return false;
		if (Fee_Name == null) {
			if (other.Fee_Name != null)
				return false;
		} else if (!Fee_Name.equals(other.Fee_Name))
			return false;
		if (Double.doubleToLongBits(Fee_Price) != Double.doubleToLongBits(other.Fee_Price))
			return false;
		if (Fee_Sort == null) {
			if (other.Fee_Sort != null)
				return false;
		} else if (!Fee_Sort.equals(other.Fee_Sort))
			return false;
		if (Fee_Time == null) {
			if (other.Fee_Time != null)
				return false;
		} else if (!Fee_Time.equals(other.Fee_Time))
			return false;
		if (Name == null) {
			if (other.Name != null)
				return false;
		} else if (!Name.equals(other.Name))
			return false;
		return true;
	}
	
	
	
}
