package com.nesterenya;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class SampleController {
	
	@RequestMapping("/index")
    String home() {
        return "index";
    }
	
}
