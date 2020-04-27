package dev.deol.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dev.deol.entities.Employee;
import dev.deol.entities.Reimbursment;
import dev.deol.utils.ConnectionUtil;

public class EmployeeDAOmariadb implements EmployeeDAO{

	@Override
	public Employee login(String username, String password) {
		String sql = "SELECT * FROM EMPLOYEE WHERE USERNAME= ? AND PASSWORD=?";
        try(Connection conn = ConnectionUtil.createConnection()){
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
            	return new Employee(rs.getInt("E_ID"), rs.getString("NAME"));
            	
            	
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return null;
	}

}
