package com.aidansu.demo.controller;

import com.aidansu.demo.model.Customer;
import org.springframework.stereotype.Controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by aidan on 17-5-15.
 */
@Path("/cxf")
@Controller
public class CustomerControllerByCXF {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GET
    @Path("/greeting")
    @Produces(MediaType.APPLICATION_JSON)
    public Customer greeting(@DefaultValue("World") @FormParam("name") String name) {
        return new Customer(counter.incrementAndGet(), String.format(template, name));
    }

}
