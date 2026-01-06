package com.example.ems.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.ems.entity.Employee;
import com.example.ems.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // ===============================
    // List Employees
    // ===============================
    @GetMapping
    public String listEmployees(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "employees";
    }

    // ===============================
    // Show Add Employee Form
    // ===============================
    @GetMapping("/add")
    public String showAddEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "add-employee";
    }

    // ===============================
    // Save Employee
    // ===============================
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/employees";
    }

    // ===============================
    // Show Edit Form
    // ===============================
    @GetMapping("/edit/{id}")
    public String showEditEmployeeForm(@PathVariable Long id, Model model) {
        model.addAttribute("employee", employeeService.getEmployeeById(id));
        return "edit-employee";
    }

    // ===============================
    // Update Employee
    // ===============================
    @PostMapping("/update/{id}")
    public String updateEmployee(@PathVariable Long id,
                                 @ModelAttribute("employee") Employee employee) {
        employee.setId(id);
        employeeService.updateEmployee(employee);
        return "redirect:/employees";
    }

    // ===============================
    // Delete Employee
    // ===============================
    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployeeById(id);
        return "redirect:/employees";
    }
}
