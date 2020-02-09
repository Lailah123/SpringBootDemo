package com.example.demo.hello.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//@RestController
@Controller
public class HelloController {

    private final Logger log = LoggerFactory.getLogger(HelloController.class);
    @RequestMapping("/hello")
    public ModelAndView hello(){
        log.debug("start jump hello,jsp");
        ModelAndView model = new ModelAndView("hello");
        model.addObject("msg","hello");
        return model;
    }
    @RequestMapping("test")
    public String test(){
        return "hello test";
    }
}
