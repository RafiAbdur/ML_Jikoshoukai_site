package com.monstarlab.app.employee;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmployeeController {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = { RequestMethod.GET, RequestMethod.POST })
	public String home(Model model) {

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "welcome/home";
	}

	@RequestMapping(value = "/create")
	public String createEmployee(Model model) {
		model.addAttribute("headerTitle", "Add new employee");
		return "employee/employee_info_input";
	}
	
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
