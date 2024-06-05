//package com.springboot.controller;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.springboot.model.Employee;
//import com.springboot.model.UploadForm;
//import com.springboot.service.EmployeeService;
//
//@Controller
//public class FileUploadController {
//	private static final String UPLOAD_DIRECTORY = "C:/Users/Relanto/Pictures/Saved Pictures/";
//
//	@Autowired
//	private EmployeeService employeeService;
//
//	@GetMapping("/file")
//	public String viewHomePage() {
//		return "index";
//	}
//
//	@PostMapping("/upload")
//	public String handleFileUpload(@RequestParam("file") MultipartFile file, Model model) {
//		if (!file.isEmpty()) {
//			try {
//				byte[] bytes = file.getBytes();
//				Path path = Paths.get(UPLOAD_DIRECTORY + file.getOriginalFilename());
//				Files.write(path, bytes);
//				model.addAttribute("uploadStatus", "success");
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//		return "index";
//	}
//
//	@GetMapping("/files")
//	public String showUploadedFiles(Model model) {
//		List<String> uploadedFiles = new ArrayList<>();
//		File directory = new File(UPLOAD_DIRECTORY);
//		if (directory.exists() && directory.isDirectory()) {
//			File[] files = directory.listFiles();
//			if (files != null) {
//				for (File file : files) {
//					uploadedFiles.add(file.getName());
//				}
//			}
//		}
//		model.addAttribute("uploadedFiles", uploadedFiles);
//		return "uploaded_files";
//	}
//
//	@GetMapping("/employee-list")
//	public String showEmployeeList(Model model) {
//		List<Employee> employees = employeeService.getAllEmployees();
//		model.addAttribute("employees", employees);
//
//		// Create and add the uploadForm object to the model
//		model.addAttribute("uploadForm", new UploadForm());
//
//		return "employee_list";
//	}
//
//	@PostMapping("/uploadFile/{id}")
//	public String uploadFile(@PathVariable("id") long id, @ModelAttribute UploadForm uploadForm, Model model)
//			throws IOException {
//		Employee employee = employeeService.getEmployeeById(id);
//		if (employee != null) {
//			MultipartFile file = uploadForm.getFile();
//			if (file != null && !file.isEmpty()) {
//				// Get the file content as a byte array
//				byte[] fileBytes = file.getBytes();
//				// Save the file content to the employee entity
////				employee.setFile(fileBytes);
//				// Save the employee to update the file data
////				employeeService.saveEmployee(employee);
//				model.addAttribute("uploadStatus", "File uploaded successfully for employee ID: " + employee.getId());
//			} else {
//				model.addAttribute("uploadStatus", "No file selected.");
//			}
//		} else {
//			model.addAttribute("uploadStatus", "Employee not found with ID: " + id);
//		}
//		// Reload the list of employees after file upload
//		List<Employee> employees = employeeService.getAllEmployees();
//		model.addAttribute("employees", employees);
//
//		return "employee_list";
//	}
//
//	@GetMapping("/updateFile/{id}")
//	public String showUpdateFileForm(@PathVariable("id") long id, Model model) {
//		Employee employee = employeeService.getEmployeeById(id);
//		if (employee != null) {
//			UploadForm uploadForm = new UploadForm();
//			model.addAttribute("employee", employee);
//			model.addAttribute("uploadForm", uploadForm);
//			return "update_file";
//		} else {
//			return "index";
//		}
//	}
//
//	@PostMapping("/updateFile/{id}")
//	public String updateFile(@PathVariable("id") long id, @ModelAttribute UploadForm uploadForm) throws IOException {
//		Employee employee = employeeService.getEmployeeById(id);
//		if (employee != null) {
//			MultipartFile file = uploadForm.getFile();
//			if (file != null && !file.isEmpty()) {
//				// Get the file content as a byte array
//				byte[] fileBytes = file.getBytes();
//				// Save the file content to the employee entity
////				employee.setFile(fileBytes);
//				// Save the employee to update the file data
////				employeeService.saveEmployee(employee);
//			}
//		}
//		return "index";
//	}
//}
