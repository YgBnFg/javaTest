package com.binfeng.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.Clock;
import java.util.Date;

/**
 * Created by bfyang on 2017/10/17.
 */
@Controller
public class MainController {
    @Autowired
    private Clock clock;

    @Value("${environment}")
    private String environment;

    @RequestMapping("/")
    @ResponseBody
    String home() {
        final Date now = new Date(clock.millis());
        return "Hello World! " + now + "in " + environment;
    }
}
