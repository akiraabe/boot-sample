package com.sample.app.controller;

import com.sample.app.form.BillForm;
import com.sample.app.form.CustomerForm;
import com.sample.domain.model.Bill;
import com.sample.domain.model.Customer;
import com.sample.domain.model.Inspection;
import com.sample.domain.service.BillService;
import com.sample.domain.service.CustomerService;
import com.sample.domain.service.InspectionService;
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
 * Created by abe.akira on 2017/03/23.
 */
@Controller
@RequestMapping("bill")
public class BillController {

    @Autowired
    BillService billService;

    @Autowired
    CustomerService customerService;

    @Autowired
    InspectionService inspectionService;

    @ModelAttribute
    BillForm setUpForm() {
        return new BillForm()   ;
    }

    @RequestMapping(method = RequestMethod.GET)
    String list(Model model) {

        List<Bill> bills = billService.findAll();
        if (bills != null) bills.forEach(System.out::println);
        model.addAttribute("bills", bills);
        return "bill/list";
    }

    @RequestMapping(value = "/input", method = RequestMethod.GET)
    public String input() {
        return "bill/input";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(@Validated BillForm form, BindingResult result, Model mode, RedirectAttributes attributes) {

        if (result.hasErrors()) {
            return "bill/input";
        }

        // retrieve relation entities.
        Inspection inspection = inspectionService.getOne(Long.valueOf(form.getInspectionId()));
        Bill bill = new Bill(form);
        bill.setInspection(inspection);
        billService.register(bill);

        return "redirect:";
    }

    @RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
    public String show(@PathVariable Long id, Model model) {

        model.addAttribute("bill", billService.getOne(id));
        return "bill/show";
    }
}
