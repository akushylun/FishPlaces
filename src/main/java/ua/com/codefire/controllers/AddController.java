package ua.com.codefire.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AddController {

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showAddpage() {

        return "add";
    }
}
