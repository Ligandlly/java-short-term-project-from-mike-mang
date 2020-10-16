package HospitalModel;

import java.io.Serializable;

public class Department implements Serializable{

	private String Department_Name;

	public String getDepartment_Name() {
		return Department_Name;
	}

	public void setDepartment_Name(String department_Name) {
		Department_Name = department_Name;
	}

	public Department(String department_Name) {
		Department_Name = department_Name;
	}

	public Department() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Department_Name == null) ? 0 : Department_Name.hashCode());
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
		Department other = (Department) obj;
		if (Department_Name == null) {
			if (other.Department_Name != null)
				return false;
		} else if (!Department_Name.equals(other.Department_Name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return Department_Name;
	}
	
	
}
