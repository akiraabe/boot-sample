package com.sample.app.plan;

import com.sample.app.form.BasicPlanCreationForm;
import com.sample.domain.model.BasicPlan;
import com.sample.domain.service.BasicPlanService;
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
@RequestMapping("plan")
public class BasicPlanController {

    @Autowired
    BasicPlanService basicPlanService;

    @ModelAttribute
    BasicPlanCreationForm setUpForm() {
        return new BasicPlanCreationForm();
    }

    @RequestMapping(method = RequestMethod.GET)
    String list(Model model) {

        List<BasicPlan> basicPlans = basicPlanService.findAll();
        if (basicPlans != null) basicPlans.forEach(System.out::println);
        model.addAttribute("basicPlans", basicPlans);
        return "plan/list";
    }

    @RequestMapping(value = "/input", method = RequestMethod.GET)
    public String input() {
        return "plan/input";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(@Validated BasicPlanCreationForm form, BindingResult result, Model mode, RedirectAttributes attributes) {

        if (result.hasErrors()) {
            return "plan/input";
        }

        BasicPlan basicPlan = new BasicPlan(form);
        basicPlanService.register(basicPlan);

        return "redirect:";
    }

    @RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
    public String show(@PathVariable Long  id, Model model) {

        model.addAttribute("basicPlan", basicPlanService.getOne(id));
        return "plan/show";
    }
}
