package com.springboot.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.model.Employee;

public interface EmployeeService {
	List<Employee> getAllEmployees();

	Employee getEmployeeById(long id);

	void deleteEmployeeById(long id);

	Page<Employee> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);

	void saveEmployee(String firstName, String lastName, String email, MultipartFile file);

	void updateEmployee(long id, String firstName, String lastName, String email, MultipartFile file);

//	List<Employee> searchEmployees(String searchTerm);
}
