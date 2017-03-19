package com.sample.app.controller;

import com.sample.app.form.CustomerForm;
import com.sample.domain.model.Customer;
import com.sample.domain.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * Created by sarah on 2017/03/18.
 */
@Controller
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @ModelAttribute
    CustomerForm setUpForm() {
        return new CustomerForm()   ;
    }

    @RequestMapping(method = RequestMethod.GET)
    String listCustomers(Model model) {

        List<Customer> customers = customerService.findAll();
        if (customers != null) customers.forEach(System.out::println);
        model.addAttribute("customers", customers);
        return "customer/list";
    }

    @RequestMapping(value = "/input", method = RequestMethod.GET)
    public String input() {
        return "customer/input";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(@Validated CustomerForm form, BindingResult result, Model mode, RedirectAttributes attributes) {

        if (result.hasErrors()) {
            return "customer/input";
        }

        Customer customer = new Customer(form);
        customerService.register(customer);

        return "redirect:";
    }

    @RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
    public String show(@PathVariable String  id, Model model) {

        model.addAttribute("customer", customerService.getOne(id));
        return "customer/show";
    }
}
