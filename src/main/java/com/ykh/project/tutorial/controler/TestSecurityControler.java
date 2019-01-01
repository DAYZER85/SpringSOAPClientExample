package com.ykh.project.tutorial.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

@RestController
@RequestMapping("helper")
public class TestSecurityControler {

    @GetMapping(value = "/test")
    public String testSecurity() {
         return "Hello world";
    }

    @GetMapping(value="hello/{name}/{lastName}")
    public String heloMan(@PathVariable String name, @PathVariable String lastName, WebRequest webRequest){

        return "Hello " + name + " "+ lastName + webRequest.toString();
    }
}
