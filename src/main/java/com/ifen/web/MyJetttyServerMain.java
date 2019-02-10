package com.ifen.web;

import com.ifen.web.example.HelloWorld;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import java.sql.*;
import java.util.Properties;

/**
 * -Dlog.dir=./
 */
public class MyJetttyServerMain {
    public static final Logger log = LoggerFactory.getLogger(MyJetttyServerMain.class);

    public static void main(String [] args) {
        log.info("Hello Jetty!");

        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:jetty.xml");
        final Server server = (Server) ctx.getBean("jettyServer");
        /**
         * start jetty
         */
        int port = server.getConnectors()[0].getPort();
        try {
            server.start();
        } catch (Exception e) {
            log.error("Jetty start failed", e);
            System.exit(1);
        }
        WebAppContext webContext = (WebAppContext) server.getHandlers()[0];
        String path = webContext.getContextPath();
        if ("/".equals(path)) {
            path = "";
        }
        log.info("Jetty started at http://localhost:{}{}", port, path);
        WebApplicationContext webAppContext = WebApplicationContextUtils.getRequiredWebApplicationContext(webContext.getServletContext());

//        HelloWorld helloWorld = (HelloWorld) webAppContext.getBean("helloWorld");
//        log.info(helloWorld.sayHello());

        /**
         * register shutdown hook
         */
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                server.stop();
            } catch (Exception e) {
                log.error("Stop jetty failed", e);
            }
            log.info("Jetty stopped");
        }));
        log.info("server start success!");
        try {
            server.join();
        } catch (InterruptedException e) {
            log.error("server.join()",e);
        }
    }
}
