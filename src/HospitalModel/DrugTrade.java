package HospitalModel;
import java.io.Serializable;
import java.util.Date;
public class DrugTrade implements Serializable{
	private String Card;//一卡通
	private String DrugTrade_ALL;//处方总况
	private double DrugTrade_Price;//金额
	private String DrugTrade_Doctor;//开方医生
	private String DrugTrade_Time;//单据时间
	
	public DrugTrade(String card, String drugTrade_ALL, double drugTrade_Price, String drugTrade_Doctor,
			String drugTrade_Time) {
		super();
		Card = card;
		DrugTrade_ALL = drugTrade_ALL;
		DrugTrade_Price = drugTrade_Price;
		DrugTrade_Doctor = drugTrade_Doctor;
		DrugTrade_Time = drugTrade_Time;
	}

	public DrugTrade(){
		
	}

	public String getCard() {
		return Card;
	}

	public void setCard(String card) {
		Card = card;
	}

	public String getDrugTrade_ALL() {
		return DrugTrade_ALL;
	}

	public void setDrugTrade_ALL(String drugTrade_ALL) {
		DrugTrade_ALL = drugTrade_ALL;
	}

	public double getDrugTrade_Price() {
		return DrugTrade_Price;
	}

	public void setDrugTrade_Price(double drugTrade_Price) {
		DrugTrade_Price = drugTrade_Price;
	}

	public String getDrugTrade_Doctor() {
		return DrugTrade_Doctor;
	}

	public void setDrugTrade_Doctor(String drugTrade_Doctor) {
		DrugTrade_Doctor = drugTrade_Doctor;
	}

	public String getDrugTrade_Time() {
		return DrugTrade_Time;
	}

	public void setDrugTrade_Time(String drugTrade_Time) {
		DrugTrade_Time = drugTrade_Time;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Card == null) ? 0 : Card.hashCode());
		result = prime * result + ((DrugTrade_ALL == null) ? 0 : DrugTrade_ALL.hashCode());
		result = prime * result + ((DrugTrade_Doctor == null) ? 0 : DrugTrade_Doctor.hashCode());
		long temp;
		temp = Double.doubleToLongBits(DrugTrade_Price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((DrugTrade_Time == null) ? 0 : DrugTrade_Time.hashCode());
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
		DrugTrade other = (DrugTrade) obj;
		if (Card == null) {
			if (other.Card != null)
				return false;
		} else if (!Card.equals(other.Card))
			return false;
		if (DrugTrade_ALL == null) {
			if (other.DrugTrade_ALL != null)
				return false;
		} else if (!DrugTrade_ALL.equals(other.DrugTrade_ALL))
			return false;
		if (DrugTrade_Doctor == null) {
			if (other.DrugTrade_Doctor != null)
				return false;
		} else if (!DrugTrade_Doctor.equals(other.DrugTrade_Doctor))
			return false;
		if (Double.doubleToLongBits(DrugTrade_Price) != Double.doubleToLongBits(other.DrugTrade_Price))
			return false;
		if (DrugTrade_Time == null) {
			if (other.DrugTrade_Time != null)
				return false;
		} else if (!DrugTrade_Time.equals(other.DrugTrade_Time))
			return false;
		return true;
	}

	
	
	
}
