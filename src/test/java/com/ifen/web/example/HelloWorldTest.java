package com.ifen.web.example;

import com.ifen.web.dao.TestDao;
import com.ifen.web.domain.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
* HelloWorld Tester. 
* 
* @author <Authors name> 
* @since <pre>二月 10, 2019</pre> 
* @version 1.0 
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/datasource.xml"})
public class HelloWorldTest {
    public static final Logger log = LoggerFactory.getLogger(HelloWorldTest.class);
    @Resource
    TestDao testDao;

    @Before
    public void before() throws Exception { 
    } 
    
    @After
    public void after() throws Exception { 
    } 

    /** 
    * 
    * Method: sayHello() 
    * 
    */ 
    @Test
    public void testSayHello() throws Exception {
        User user = testDao.getUser(1);
        log.info(user.getName());
    } 


} 
