package com.example.demo2.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/hello")
public class Hello {
    @RequestMapping(value = "/")
    public String f()
    {
        return "helo world";
    }
    @GetMapping(value = "/ss")
    @ResponseBody
    public String fs(@RequestParam(defaultValue = "test") String ssd,@RequestParam(defaultValue = "test2") String sssd)
    {
        return "hi : "+ssd+ " "+sssd;
    }
}
