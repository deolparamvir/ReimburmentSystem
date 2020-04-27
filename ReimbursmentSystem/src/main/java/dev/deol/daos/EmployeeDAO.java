package dev.deol.daos;

import java.util.List;

import dev.deol.entities.Employee;
import dev.deol.entities.Reimbursment;

public interface EmployeeDAO {
	Employee login(String username, String password);
	
	
}
