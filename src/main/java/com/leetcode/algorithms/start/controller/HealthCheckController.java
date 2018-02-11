package com.leetcode.algorithms.start.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



/**
 * 健康检查类
 */
@Controller
@RequestMapping("/")
public class HealthCheckController {

    @RequestMapping("check")
    @ResponseBody
    public String check() {
        return "check success";
    }

}
