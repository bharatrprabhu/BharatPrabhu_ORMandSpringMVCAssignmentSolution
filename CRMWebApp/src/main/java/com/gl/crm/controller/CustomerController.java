package com.gl.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gl.crm.entity.Customer;
import com.gl.crm.service.CustomerService;

@Controller
@RequestMapping("/customers")
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	// add mapping for "/list"
	@GetMapping("/list")
	public String listStudents(Model theModel) {

		// get Students from db
		List<Customer> theCustomers = customerService.findAll();

		// add to the spring model
		theModel.addAttribute("Customers", theCustomers);

		return "list-customers";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		// create model attribute to bind form data
		Customer theCustomer = new Customer();

		theModel.addAttribute("Customer", theCustomer);

		return "customer-form";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("CustomerId") int theId, Model theModel) {

		// get the Customer from the service
		Customer theCustomer = customerService.findById(theId);

		// set Customer as a model attribute to pre-populate the form
		theModel.addAttribute("Customer", theCustomer);

		// send over to our form
		return "customer-form";
	}

	@PostMapping("/save")
	public String saveCustomer(@RequestParam("id") int id, @RequestParam("first_name") String first_name,
			@RequestParam("last_name") String last_name, @RequestParam("email") String email) {

		System.out.println(id);
		Customer theCustomer;
		if (id != 0) {
			theCustomer = customerService.findById(id);
			theCustomer.setFirst_name(first_name);
			theCustomer.setLast_name(last_name);
			theCustomer.setEmail(email);
		} else
			theCustomer = new Customer(first_name, last_name, email);
		// save the Book
		customerService.save(theCustomer);

		// use a redirect to prevent duplicate submissions
		return "redirect:/customers/list";

	}

	@GetMapping("/delete")
	public String delete(@RequestParam("CustomerId") int theId) {

		// delete the Student
		customerService.deleteById(theId);

		// redirect to /Student/list
		return "redirect:/customers/list";

	}

}
