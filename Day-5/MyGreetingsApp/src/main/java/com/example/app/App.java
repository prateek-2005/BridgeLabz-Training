package com.example.app;

import com.example.app.client.User;
import com.example.app.config.AppConfig;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args) {    
        ApplicationContext context =new AnnotationConfigApplicationContext(AppConfig.class);

        User user = context.getBean(User.class);

        user.welcome();
        
    }
}