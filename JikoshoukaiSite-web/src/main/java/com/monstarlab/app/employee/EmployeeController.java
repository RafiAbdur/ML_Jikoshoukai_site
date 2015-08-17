package com.monstarlab.app.employee;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.terasoluna.gfw.common.message.ResultMessage;
import org.terasoluna.gfw.common.message.ResultMessages;

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
			Model model, SearchEmployeeForm searchEmployeeForm, BindingResult bindingResult) {
		Page<Employee> page = employeeService.search(searchEmployeeForm, pageable);
		model.addAttribute("page", page);
		String searchResultMessage = page.getTotalElements() + " results found from your search.";
		model.addAttribute("searchResultMessage", searchResultMessage);
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
		model.addAttribute("action", "docreate");
		model.addAttribute("employeeInfoInputForm", new EmployeeInfoInputForm());
		return "employee/employee_info_input";
	}

	/**
	 * Controller-method complete creation of the new employee
	 * 
	 * @param model
	 * @return Forward link towards home page (U0010)
	 */
	@RequestMapping(value = "/docreate", method = RequestMethod.POST)
	public String creationComplete(Model model, @Valid EmployeeInfoInputForm employeeInfoForm,
			BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		Date date = convertToDate(employeeInfoForm.getBirthdate());

		if (date == null) {
			model.addAttribute("dateErrorMessage", "Please input valid date.");
		}
		
		if (bindingResult.hasErrors() || date == null) {
			model.addAttribute("headerTitle", "Add new employee");
			model.addAttribute("action", "docreate");
			return "employee/employee_info_input";
		}

		Employee employee = employeeInfoForm.getEmployee();
		employee.setBirthdate(convertToDate(employeeInfoForm.getBirthdate()));
		employeeService.create(employeeInfoForm.getEmployee());
		redirectAttributes.addFlashAttribute(
				ResultMessages.success().add(ResultMessage.fromText("Employee created successfully!")));
		return "redirect:/";
	}

	/**
	 * Controller edit employee (page:U0030)
	 * 
	 * @param pageable
	 *            page constraints
	 * @param model
	 *            model
	 * @return JSP link towards edit employee page (page:U0030)
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
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
	public String editComplete(Model model, @Valid EmployeeInfoInputForm employeeInfoForm, BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {
		Employee employee = employeeInfoForm.getEmployee();
		Date date = convertToDate(employeeInfoForm.getBirthdate());
		
		if (date == null) {
			model.addAttribute("dateErrorMessage", "Please input valid date.");
		}

		if (bindingResult.hasErrors() || date == null) {
			model.addAttribute("headerTitle", "Edit employee");
			model.addAttribute("action", "doedit");
			return "employee/employee_info_input";
		}

		employee.setBirthdate(date);
		employeeService.update(employeeInfoForm.getEmployee());
		redirectAttributes
				.addFlashAttribute(ResultMessages.success().add(ResultMessage.fromText("Update successful!")));
		return "redirect:/";
	}

	/**
	 * Controller delete employee
	 * 
	 * @param pageable
	 *            page constraints
	 * @param model
	 *            model
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String deleteEmployee(Model model, @RequestParam("id") String employeeId) {
		employeeService.delete(employeeId);
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
		formatter.setLenient(false);
		
		try {
			date = formatter.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
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
