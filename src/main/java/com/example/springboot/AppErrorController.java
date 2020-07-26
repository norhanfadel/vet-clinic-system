/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.springboot;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import org.springframework.boot.web.reactive.error.ErrorAttributes;

/**
 *
 * @author Dan
 */
@Controller
public class AppErrorController implements ErrorController {

    private final static String PATH = "/error";

    @Override
    @RequestMapping(PATH)
    @ResponseBody
    public String getErrorPath() {

        return "Invalid Data you Enter";
    }

}
