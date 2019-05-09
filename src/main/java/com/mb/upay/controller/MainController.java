package com.mb.upay.controller;

import com.mb.upay.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author:lwenm
 * Description:
 * Date:2019/3/5
 * Time:16:15
 **/

@RestController
@RequestMapping(value = "/blackface", produces = "application/json")
public class MainController {


    @Autowired
    UserServiceImpl userService;

    @GetMapping("/user")
    public Object getUserByPage( @RequestParam(name = "pageNum", required = false, defaultValue = "1")int pageNum,
                                 @RequestParam(name = "pageSize", required = false, defaultValue = "3")int pageSize ){

        return userService.findAllUser(pageNum,pageSize);
    }

}
