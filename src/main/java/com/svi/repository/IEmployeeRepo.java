package com.svi.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.svi.model.Employee;

public interface IEmployeeRepo extends PagingAndSortingRepository<Employee, Integer> {

}
