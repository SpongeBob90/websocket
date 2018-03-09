package com.wyw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author wyw
 * @date 2018\3\9 0009 16:27
 */
@Controller
public class SourceTreeTestController {

    @GetMapping(value = "/st1")
    @ResponseBody
    public String hello1(){
        return "Hello SourceTree1 !";
    }

}
