package com.ifen.web.controller;

import com.ifen.web.dao.TestDao;
import com.ifen.web.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.xml.ws.RequestWrapper;

@Controller
@RequestMapping("/user")
public class UserController {
    public static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Resource
    protected TestDao testDao;

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public ModelAndView userDetail(int id) {
        ModelAndView mav = new ModelAndView();
        User user = testDao.getUser(1);
        log.info(user.getName());
        mav.setViewName("user/Detail");
        mav.addObject("user",user);
        return mav;
    }

}
