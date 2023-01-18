package com.svi.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.svi.model.Employee;
import com.svi.service.IEmployeeMgmtService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private IEmployeeMgmtService service;
	
	@GetMapping("/")
	public String showHomePage() {
		return"home";
	}
	
	@GetMapping("/emp_report")
	public String showEmpReportPage(Map<String,Object> map) {
		Iterable<Employee> empList=service.getAllEmployee();
		map.put("empList", empList);
		return"employee_report";
	}
	
	@GetMapping("/insert_employee")
	public String showAddEmpFormPage(@ModelAttribute("emp") Employee emp) {
		return"add_employee";//LVN
	}
	
	@PostMapping("/insert_employee")
	public String insertEmployeeDetail(RedirectAttributes redirect,@ModelAttribute("emp") Employee emp) {
		String resultMsg=service.insertEmployee(emp);
		//Add the given flash attribute.
		redirect.addFlashAttribute("resultMsg", resultMsg);
		//LVN
		return"redirect:emp_report";
	}
	
	@GetMapping("/edit_employee")
	public String showEditEmployeeForm(@ModelAttribute("emp") Employee emp,@RequestParam("empno") int empno) {
		Employee emp1=service.getEmployeeByEmpNo(empno);
		//Copy the property values of the given source bean into the target bean.
		BeanUtils.copyProperties(emp1, emp);
		return"modify_employee";
	}
	/*
	@PostMapping("/edit_employee")
	public String editEmployeeForm(@ModelAttribute("emp") Employee emp,Map<String,Object> map) {
		String resultMsg=service.updateEmployee(emp);
		Iterable<Employee> empList=service.getAllEmployee();
		map.put("resultMsg", resultMsg);
		map.put("empList", empList);
		return"employee_report";
	}
	*/
	@PostMapping("/edit_employee")
	public String editEmployeeForm(@ModelAttribute("emp") Employee emp,RedirectAttributes redirect) {
		String resultMsg=service.updateEmployee(emp);
		//Add the given flash attribute
		redirect.addFlashAttribute("resultMsg", resultMsg);
		//return LVN
		return"redirect:emp_report";
	}
	
	@GetMapping("/delete_employee")
	public String deleteEmployee(RedirectAttributes redirect,@RequestParam("empno") int empno) {
		//use service
		String resultMsg=service.deleteEmployeeById(empno);
		//Add the given flash attribute.
		redirect.addFlashAttribute("resultMsg", resultMsg);
		//LVN
		return"redirect:emp_report";
	}

}//class
