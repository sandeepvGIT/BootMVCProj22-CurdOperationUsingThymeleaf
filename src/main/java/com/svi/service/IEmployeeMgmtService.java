package com.svi.service;


import com.svi.model.Employee;

public interface IEmployeeMgmtService {
	public Iterable<Employee> getAllEmployee();
	public String insertEmployee(Employee emp);
	public Employee getEmployeeByEmpNo(int empno);
	public String updateEmployee(Employee emp);
	public String deleteEmployeeById(int empno);

}
