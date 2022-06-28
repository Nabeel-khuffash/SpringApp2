package com.example.demo2.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/hello")
public class DefaultController {
    @RequestMapping(value = "/")
    public String f()
    {
        return "hi";
    }

}
