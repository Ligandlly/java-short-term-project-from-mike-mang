package HospitalDAO;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import HospitalModel.*;
import com.Hospital.Ubtil.Hospital_dbUtil;

public class DepartmentDAO {

	private DepartmentDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public static Vector<Department> DepartmentList(Connection con)throws Exception{
		Vector<Department> vd=new Vector<Department>();
		String sql="select * from tblDepartment";
		PreparedStatement stmt=con.prepareStatement(sql);
		ResultSet rs=stmt.executeQuery();
		while(rs.next()) {
			Department dp=new Department();
			dp.setDepartment_Name(rs.getString("Department_Name"));
			vd.add(dp);
		}
		return vd;
	}
}
