package com.thunneycomb.thunneycombarchtype.sample;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * thunneycomb-autotest
 * 2019-11-08 11:37
 * Test demo controller
 *
 * @author Daine.H
 * @since 2015
 **/

@Controller
public class HomeController {

    @RequestMapping("/")
    public @ResponseBody
    String greeting() {
        return "Hello World";
    }
}
