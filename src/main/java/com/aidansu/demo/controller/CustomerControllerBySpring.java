package com.aidansu.demo.controller;

import com.aidansu.demo.model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by aidan on 17-5-15.
 */
@RequestMapping("/spring")
@Controller
public class CustomerControllerBySpring {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value ="/greeting", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public Customer greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Customer(counter.incrementAndGet(), String.format(template, name));
    }

}
