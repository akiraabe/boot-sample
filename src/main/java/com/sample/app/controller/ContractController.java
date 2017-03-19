package com.sample.app.controller;

import com.sample.app.form.ContractForm;
import com.sample.domain.model.BasicPlan;
import com.sample.domain.model.Contract;
import com.sample.domain.model.Customer;
import com.sample.domain.service.BasicPlanService;
import com.sample.domain.service.ContractService;
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
 * Created by abe.akira on 2017/03/18.
 */
@Controller
@RequestMapping("contract")
public class ContractController {

    @Autowired
    ContractService contractService;

    @Autowired
    CustomerService customerService;

    @Autowired
    BasicPlanService basicPlanService;

    @ModelAttribute
    ContractForm setUpForm() {
        return new ContractForm()   ;
    }

    @RequestMapping(method = RequestMethod.GET)
    String listCustomers(Model model) {

        List<Contract> contracts = contractService.findAll();
        if (contracts != null) contracts.forEach(System.out::println);
        model.addAttribute("contracts", contracts);
        return "contract/list";
    }

    @RequestMapping(value = "/input", method = RequestMethod.GET)
    public String input() {
        return "contract/input";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(@Validated ContractForm form, BindingResult result, Model mode, RedirectAttributes attributes) {

        if (result.hasErrors()) {
            return "contract/input";
        }

        // retrieve relation entities.
        Customer customer = customerService.getOne(form.getCustomerId());
        BasicPlan basicPlan = basicPlanService.getOne(Long.valueOf(form.getBasicPlanId()));

        Contract contract = new Contract(form, customer, basicPlan);
        contractService.register(contract);

        return "redirect:";
    }

    @RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
    public String show(@PathVariable Long  id, Model model) {

        model.addAttribute("contract", contractService.getOne(id));
        return "contract/show";
    }
}
