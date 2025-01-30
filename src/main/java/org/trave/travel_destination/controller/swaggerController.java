package org.trave.travel_destination.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class swaggerController {

    @GetMapping("/")
    public String swaggerUi() {
        return "redirect:/swagger-ui.html";
    }
    
}
