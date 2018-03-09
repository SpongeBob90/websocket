package com.wyw.controller;

<<<<<<< HEAD
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author wyw
 * @date 2018\3\9 0009 16:25
 */
@Controller
public class SourceTreeTestController {

    @GetMapping(value = "/st")
    @ResponseBody
    public String hello(){
        return "Hello SourceTree !";
    }

=======
/**
 * @author wyw
 * @date 2018\3\9 0009 16:27
 */
public class SourceTreeTestController {
>>>>>>> Bob-dev
}
