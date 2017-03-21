package com.sample.app.controller;

import com.sample.app.form.ContractForm;
import com.sample.app.form.InspectionForm;
import com.sample.domain.model.*;
import com.sample.domain.service.*;
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
@RequestMapping("inspection")
public class InspectionController {

    @Autowired
    InspectionService inspectionService;
    @Autowired
    ContractService contractService;
    @Autowired
    UseDetailService useDetailService;

    @ModelAttribute
    InspectionForm setUpForm() {
        return new InspectionForm();
    }

    @RequestMapping(method = RequestMethod.GET)
    String list(Model model) {

        List<Inspection> inspections = inspectionService.findAll();
        if (inspections != null) inspections.forEach(System.out::println);
        model.addAttribute("inspections", inspections);
        return "inspection/list";
    }

    @RequestMapping(value = "/input", method = RequestMethod.GET)
    public String input() {
        return "inspection/input";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(@Validated InspectionForm form, BindingResult result, Model mode, RedirectAttributes attributes) {

        if (result.hasErrors()) {
            return "inspection/input";
        }

        // Delegate to domain logic.
        inspectionService.register(form);

        return "redirect:";
    }

    @RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
    public String show(@PathVariable Long  id, Model model) {

        model.addAttribute("inspection", inspectionService.getOne(id));
        return "inspection/show";
    }
}
