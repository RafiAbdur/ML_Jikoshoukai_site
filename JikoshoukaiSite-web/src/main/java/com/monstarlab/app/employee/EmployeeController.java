package com.monstarlab.app.employee;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.monstarlab.app.form.SearchEmployeeForm;

@Controller
public class EmployeeController {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	/**
	 * Returns page U0010
	 */
	@RequestMapping(value = "/", method = { RequestMethod.GET, RequestMethod.POST })
	public String home(Model model) {
		model.addAttribute("searchEmployeeForm", new SearchEmployeeForm());
		return "welcome/home";
	}

	/**
	 * Returns page U0020
	 */
	@RequestMapping(value = "/create")
	public String createEmployee(Model model) {
		model.addAttribute("headerTitle", "Add new employee");
		return "employee/employee_info_input";
	}
	
	/**
	 * Returns page U0030
	 */
	@RequestMapping(value = "/edit")
	public String editEmployee(Model model) {
		model.addAttribute("headerTitle", "Edit employee");
		return "employee/employee_info_input";
	}

	@RequestMapping(value = "/docreate", method = RequestMethod.POST)
	public String creationComplete(Model model) {
		
		return "redirect:/welcome/home";
	}
}
