package com.wyw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author wyw
 * @date 2018\2\24 0024 14:25
 */
@Controller
public class IndexController {

    @GetMapping(value = "/index")
    public String index(){
        return "index";
    }

}
