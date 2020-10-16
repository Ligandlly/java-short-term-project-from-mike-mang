package HospitalModel;

import java.io.Serializable;
public class DrugModel implements Serializable{
	private String Drug_ApporovalNumber;//批准文号
	private String Drug_Name;//药品名称
	private int Drug_Amount;//药品数量
	private double Drug_Price;//药品单价
	private String Drug_Sort;//药品种类
	
	public DrugModel(){
		this.Drug_ApporovalNumber=null;
		this.Drug_Name=null;
		this.Drug_Amount=0;
		this.Drug_Price=0;
		this.Drug_Sort="国药";
	}
	
	public DrugModel(String Name){
		this.Drug_ApporovalNumber=null;
		this.Drug_Name=Name;
		this.Drug_Amount=0;
		this.Drug_Price=0;
		this.Drug_Sort="国药";
	}
	
	public DrugModel(String Drug_ApporovalNumber,String Drug_Name,int Drug_Amount,double Drug_Price,String Drug_Sort){
		this.Drug_ApporovalNumber=Drug_ApporovalNumber;
		this.Drug_Name=Drug_Name;
		this.Drug_Amount=Drug_Amount;
		this.Drug_Price=Drug_Price;
		this.Drug_Sort=Drug_Sort;
	}
	
	public String getDrug_ApporovalNumber() {
		return Drug_ApporovalNumber;
	}
	public void setDrug_ApporovalNumber(String drug_ApporovalNumber) {
		Drug_ApporovalNumber = drug_ApporovalNumber;
	}
	public String getDrug_Name() {
		return Drug_Name;
	}
	public void setDrug_Name(String drug_Name) {
		Drug_Name = drug_Name;
	}
	public int getDrug_Amount() {
		return Drug_Amount;
	}
	public void setDrug_Amount(int drug_Amount) {
		Drug_Amount = drug_Amount;
	}
	public double getDrug_Price() {
		return Drug_Price;
	}
	public void setDrug_Price(double drug_Price) {
		Drug_Price = drug_Price;
	}
	public String getDrug_Sort() {
		return Drug_Sort;
	}
	public void setDrug_Sort(String drug_Sort) {
		Drug_Sort = drug_Sort;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Drug_Amount;
		result = prime * result + ((Drug_ApporovalNumber == null) ? 0 : Drug_ApporovalNumber.hashCode());
		result = prime * result + ((Drug_Name == null) ? 0 : Drug_Name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(Drug_Price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((Drug_Sort == null) ? 0 : Drug_Sort.hashCode());
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
		DrugModel other = (DrugModel) obj;
		if (Drug_Amount != other.Drug_Amount)
			return false;
		if (Drug_ApporovalNumber == null) {
			if (other.Drug_ApporovalNumber != null)
				return false;
		} else if (!Drug_ApporovalNumber.equals(other.Drug_ApporovalNumber))
			return false;
		if (Drug_Name == null) {
			if (other.Drug_Name != null)
				return false;
		} else if (!Drug_Name.equals(other.Drug_Name))
			return false;
		if (Double.doubleToLongBits(Drug_Price) != Double.doubleToLongBits(other.Drug_Price))
			return false;
		if (Drug_Sort == null) {
			if (other.Drug_Sort != null)
				return false;
		} else if (!Drug_Sort.equals(other.Drug_Sort))
			return false;
		return true;
	}

	
}
