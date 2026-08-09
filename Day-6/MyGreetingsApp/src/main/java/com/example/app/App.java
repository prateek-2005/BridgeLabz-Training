package com.example.app;

import java.io.File;

import org.apache.catalina.startup.Tomcat;

public class App {

    public static void main(String[] args) throws Exception {

        Tomcat tomcat = new Tomcat();

        tomcat.setPort(8080);
        tomcat.getConnector();

        String webappPath =
                new File("src/main/webapp").getAbsolutePath();

        System.out.println("Webapp path: " + webappPath);

        // ROOT web application
        tomcat.addWebapp(
                "",
                webappPath
        );

        System.out.println("Starting Greetings App...");

        tomcat.start();

        System.out.println(
                "Greetings App running at:"
        );

        System.out.println(
                "http://localhost:8080/greetings"
        );

        tomcat.getServer().await();
    }
}