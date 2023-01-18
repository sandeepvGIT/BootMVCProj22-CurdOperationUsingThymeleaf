package com.svi.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.svi.model.Employee;
import com.svi.repository.IEmployeeRepo;

@Service("service")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	@Autowired
	private IEmployeeRepo empRepo;

	@Override
	public Iterable<Employee> getAllEmployee() {
		return empRepo.findAll(Sort.by("job").ascending());
	}

	@Override
	public String insertEmployee(Employee emp) {
		return "Record is saved with EmpNo : "+empRepo.save(emp).getEmpno();
	}

	@Override
	public Employee getEmployeeByEmpNo(int empno) {
		return empRepo.findById(empno).get();
	}

	@Override
	public String updateEmployee(Employee emp) {
		return "Employee with EmpNo : "+empRepo.save(emp).getEmpno()+" Updated";
	}

	@Override
	public String deleteEmployeeById(int empno) {
		//delete the employee by Id
		empRepo.deleteById(empno);
		return "Employee record  deleted";
	}

}
