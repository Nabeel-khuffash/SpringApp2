package com.example.demo2.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/")
public class DefaultController {
    @RequestMapping(value = "/")
    public String f()
    {
        return "hi";
    }

}
