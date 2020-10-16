package coursedao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import coursesystemmodel.*;
import com.Hospital.Ubtil.*;

public class StudentDao {
	public static ResultSet StudentList(Connection con, Sinfo sinfo) throws SQLException {
		StringBuffer sb = new StringBuffer("select * from t_sinfo ");
		if (sinfo.getSno() != -1) {
			sb.append(" and Sno=" + sinfo.getSno());
		}
		if (StringUtil.isNotEmpty(sinfo.getSname())) {
			sb.append(" and Sname like '%" + sinfo.getSname() + "%'");
		}
		PreparedStatement pstmt = con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}

}
