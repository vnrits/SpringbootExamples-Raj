package com.springboot.controller;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.model.Employee;
import com.springboot.service.EmployeeService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	// display list of employees
	@GetMapping("/")
	public String viewHomePage(Model model) {
		return findPaginated(1, "firstName", "asc", model);
	}

	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model) {
		// create model attribute to bind form data
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "new_employee";
	}

	@PostMapping("/saveEmployee")
	public String saveEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName,
			@RequestParam("email") String email, @RequestParam("file") MultipartFile file) {
		// save employee to database
		employeeService.saveEmployee(firstName, lastName, email, file);
		return "redirect:/";
	}

	@PostMapping("/updateEmployee")
	public String updateEmployee(@RequestParam("id") long id, @RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("email") String email,
			@RequestParam("file") MultipartFile file) {
		// save employee to database
		employeeService.updateEmployee(id, firstName, lastName, email, file);
		return "redirect:/";
	}

	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

		// get employee from the service
		Employee employee = employeeService.getEmployeeById(id);

		// set employee as a model attribute to pre-populate the form
		model.addAttribute("employee", employee);
		return "update_employee";
	}

	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable(value = "id") long id) {

		// call delete employee method
		this.employeeService.deleteEmployeeById(id);
		return "redirect:/";
	}

	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable(value = "pageNo") int pageNo, @RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir, Model model) {
		int pageSize = 5;

		Page<Employee> page = employeeService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Employee> listEmployees = page.getContent();

		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());

		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "asc" : "desc");

		model.addAttribute("listEmployees", listEmployees);
		return "index";
	}

	@GetMapping("/downloadFile/{id}")
	public ResponseEntity<Resource> downloadFile(@PathVariable long id, HttpServletRequest request) throws IOException {
		Employee employee = employeeService.getEmployeeById(id);

		// Check if the employee exists
		if (employee == null) {
			return ResponseEntity.notFound().build();
		}

		// Decode the Base64 string back to bytes
		byte[] fileBytes = Base64.getDecoder().decode(employee.getFile());

		// Create Resource from the byte array
		ByteArrayResource resource = new ByteArrayResource(fileBytes);

		// Generate a random filename using UUID
		String fileName = UUID.randomUUID().toString() + ".jpg"; // Change the extension based on the actual file type

		// Try to determine file's content type based on the file extension
		String contentType = null;
		contentType = request.getServletContext().getMimeType(fileName);

		if (contentType == null) {
			contentType = "application/octet-stream";
		}

		return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"").body(resource);
	}

	@GetMapping(value = "/employees/{id}/file", produces = MediaType.IMAGE_JPEG_VALUE)
	public ResponseEntity<byte[]> getEmployeeFile(@PathVariable long id) {
		Employee employee = employeeService.getEmployeeById(id);
		if (employee != null && employee.getFile() != null) {
			// Decode the Base64 string back to bytes
			byte[] fileData = Base64.getDecoder().decode(employee.getFile().getBytes(StandardCharsets.UTF_8));
			return ResponseEntity.ok().body(fileData);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/search")
	public String searchById(@RequestParam("id") Long id, Model model) {
	    Employee employee = employeeService.getEmployeeById(id);
	    if (employee != null) {
	        model.addAttribute("employees", Collections.singletonList(employee));
	    } else {
	        model.addAttribute("employees", Collections.emptyList());
	    }
	    return "search";
	}


}
