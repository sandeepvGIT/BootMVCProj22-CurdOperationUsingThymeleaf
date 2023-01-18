package com.svi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "employee")
public class Employee {
	@Id
	//@SequenceGenerator(name = "gen1",sequenceName = "emp_no_seq1",initialValue = 1000,allocationSize = 1)
	//@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer empno;
	private String ename;
	private String job;
	private String sal;
	private Integer deptno;

}
