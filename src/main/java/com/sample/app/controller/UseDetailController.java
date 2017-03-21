package com.sample.app.controller;

import com.sample.app.form.UseDetailForm;
import com.sample.domain.model.Customer;
import com.sample.domain.model.UseDetail;
import com.sample.domain.service.CustomerService;
import com.sample.domain.service.UseDetailService;
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
 * Created by abe.akira on 2017/03/21.
 */
@Controller
@RequestMapping("useDetail")
public class UseDetailController {

    @Autowired
    UseDetailService useDetailService;

    @Autowired
    CustomerService customerService;

    @ModelAttribute
    UseDetailForm setUpForm() {
        return new UseDetailForm()   ;
    }

    @RequestMapping(method = RequestMethod.GET)
    String list(Model model) {

        List<UseDetail> useDetails = useDetailService.findAll();
        if (useDetails != null) useDetails.forEach(System.out::println);
        model.addAttribute("useDetails", useDetails);
        return "useDetail/list";
    }

    @RequestMapping(value = "/input", method = RequestMethod.GET)
    public String input() {
        return "useDetail/input";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(@Validated UseDetailForm form, BindingResult result, Model mode, RedirectAttributes attributes) {

        if (result.hasErrors()) {
            return "useDetail/input";
        }

        // retrieve relation entities.
        Customer customer = customerService.getOne(form.getCustomerId());
        form.setCustomer(customer);

        UseDetail useDetail = new UseDetail(form);
        useDetailService.register(useDetail);

        return "redirect:";
    }

    @RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
    public String show(@PathVariable Long  id, Model model) {

        model.addAttribute("useDetail", useDetailService.getOne(id));
        return "useDetail/show";
    }
}
