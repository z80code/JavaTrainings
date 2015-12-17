package com.nesterenya;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GreetingController {

    @RequestMapping("/greeting/{name}")
    @ResponseBody
    public String greeting(@PathVariable(value="name") String name) { //, Model model
        //model.addAttribute("name", name);
        return "greeting"+name;
    }

}
