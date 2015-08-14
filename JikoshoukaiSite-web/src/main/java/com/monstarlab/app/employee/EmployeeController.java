package com.monstarlab.app.employee;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
import org.springframework.web.bind.annotation.RequestParam;
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
			@PageableDefault(page = 0, size = 20, direction = Direction.DESC, sort = "employeeId") Pageable pageable,
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
			@PageableDefault(page = 0, size = 20, direction = Direction.DESC, sort = "employeeId") Pageable pageable,
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
		model.addAttribute("action", "docreate");
		return "employee/employee_info_input";
	}

	/**
	 * Controller-method complete creation of the new employee
	 * 
	 * @param model
	 * @return Forward link towards home page (U0010)
	 */
	@RequestMapping(value = "/docreate", method = RequestMethod.POST)
	public String creationComplete(Model model, EmployeeInfoInputForm employeeInfoForm, BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {
		Employee employee = employeeInfoForm.getEmployee();
		employee.setBirthdate(convertToDate(employeeInfoForm.getBirthdate()));
		employeeService.create(employeeInfoForm.getEmployee());
		return "redirect:/";
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
	public String editEmployee(Model model, @RequestParam("id") String employeeId) {
		model.addAttribute("headerTitle", "Edit employee");
		EmployeeInfoInputForm employeeForm = new EmployeeInfoInputForm();
		Employee employee = employeeService.findOne(employeeId);
		employeeForm.setEmployee(employee);
		employeeForm.setBirthdate(convertToDateString(employee.getBirthdate()));
		model.addAttribute("employeeInfoInputForm", employeeForm);
		model.addAttribute("action", "doedit");
		return "employee/employee_info_input";
	}

	/**
	 * Controller-method complete update of the new employee
	 * 
	 * @param model
	 * @return Forward link towards home page (U0010)
	 */
	@RequestMapping(value = "/doedit", method = RequestMethod.POST)
	public String editComplete(Model model, EmployeeInfoInputForm employeeInfoForm, BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {
		Employee employee = employeeInfoForm.getEmployee();
		employee.setBirthdate(convertToDate(employeeInfoForm.getBirthdate()));
		employeeService.update(employeeInfoForm.getEmployee());
		return "redirect:/";
	}

	/**
	 * Converts date String to Date object
	 * 
	 * @param dateString
	 * @return
	 */
	private Date convertToDate(String dateString) {
		Date date = null;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			date = formatter.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return date;
	}

	private String convertToDateString(Date date) {
		String dateString = null;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		dateString = formatter.format(date);
		return dateString;
	}

}
