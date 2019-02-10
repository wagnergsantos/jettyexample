package com.ifen.web.controller;

import com.ifen.web.MyJetttyServerMain;
import com.ifen.web.dao.TestDao;
import com.ifen.web.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {
    private static final Logger log = LoggerFactory.getLogger(HelloWorldController.class);
    @Resource
    protected TestDao testDao;

    /**
     * produces = "application/json;charset=utf-8" 解决中文乱码问题,也可以在拦截器中统一设置
     * @return
     */
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    @ResponseBody
    public String Hello() {
        User user = testDao.getUser(1);
        log.info(user.getName());
        return "Hello World : " + user.getName()+","+user.getAge();
    }
}
