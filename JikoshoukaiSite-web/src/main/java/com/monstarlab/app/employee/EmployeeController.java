package com.monstarlab.app.employee;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.monstarlab.domain.form.EmployeeInfoInputForm;
import com.monstarlab.domain.form.SearchEmployeeForm;
import com.monstarlab.domain.model.Employee;
import com.monstarlab.domain.service.EmployeeService;

@Controller
public class EmployeeController {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Inject
	EmployeeService employeeService;

	/**
	 * Controller-method home (page:U0010)
	 * 
	 * @param pageable
	 *            page constraints
	 * @param model
	 *            model
	 * @return JSP link towards home page (U0010)
	 */
	@RequestMapping(value = "/", method = { RequestMethod.GET, RequestMethod.POST })
	public String home(
			@PageableDefault(page = 0, size = 2, direction = Direction.DESC, sort = "employeeId") Pageable pageable,
			Model model) {
		// Add form class for searching employee
		model.addAttribute("searchEmployeeForm", new SearchEmployeeForm());

		// find all records within page constraints
		Page<Employee> page = employeeService.findAll(pageable);

		// Employee records hold within the page returned
		model.addAttribute("page", page);

		return "welcome/home";
	}

	/**
	 * Controller-method search employees against search field
	 * 
	 * @param pageable
	 *            page constraints
	 * @param model
	 *            model
	 * @return JSP link towards home page (U0010)
	 */
	@RequestMapping(value = "/search", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchEmployee(
			@PageableDefault(page = 0, size = 2, direction = Direction.DESC, sort = "employeeId") Pageable pageable,
			Model model, SearchEmployeeForm searchEmployeeForm, BindingResult bindingResult,
			RedirectAttributes attributes) {
		Page<Employee> page = employeeService.search(searchEmployeeForm, pageable);
		model.addAttribute("page", page);
		return "welcome/home";
	}

	/**
	 * Controller-method create employee (page:U0020)
	 * 
	 * @param model
	 *            model
	 * @return JSP link towards create employee page (page:U0020)
	 */
	@RequestMapping(value = "/create")
	public String createEmployee(Model model) {
		model.addAttribute("headerTitle", "Add new employee");
		model.addAttribute("employeeInfoInputForm", new EmployeeInfoInputForm());
		return "employee/employee_info_input";
	}


	/**
	 * Controller home (page:U0010)
	 * 
	 * @param pageable
	 *            page constraints
	 * @param model
	 *            model
	 * @return JSP link towards edit employee page (page:U0030)
	 */
	@RequestMapping(value = "/edit")
	public String editEmployee(Model model) {
		model.addAttribute("headerTitle", "Edit employee");
		model.addAttribute("employeeInfoInputForm", new EmployeeInfoInputForm());
		return "employee/employee_info_input";
	}

	/**
	 * Controleer-method complete creation of the new employee
	 * 
	 * @param model
	 * @return Forward link towards home page (U0010)
	 */
	@RequestMapping(value = "/docreate", method = RequestMethod.POST)
	public String creationComplete(Model model) {
		
		return "redirect:/welcome/home";
	}
	
	@RequestMapping(value = "/doedit", method = RequestMethod.POST)
	public String editComplete(Model model) {
		
		return "redirect:/employee/employee_info_input";
	}
}
