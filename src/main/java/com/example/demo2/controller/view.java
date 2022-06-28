package com.example.demo2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller // MVC
public class view {
    @GetMapping(value = "/p")
    public ModelAndView f (){

        return new ModelAndView("hello");
    }
}
