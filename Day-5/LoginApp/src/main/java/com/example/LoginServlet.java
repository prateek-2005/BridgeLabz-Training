package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(
    urlPatterns = "/LoginServlet",
    initParams = {
        @WebInitParam(name = "user", value = "Admin"),
        @WebInitParam(name = "password", value = "Admin@123")
    }
)
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String user = request.getParameter("user");
        String pwd = request.getParameter("pwd");

        if (!user.matches("^[A-Z][a-zA-Z]{2,}$")) {

            out.println("<font color='red'>");
            out.println("Invalid Name!<br>");
            out.println("Name must start with a Capital letter and contain at least 3 characters.");
            out.println("</font>");

            RequestDispatcher rd = request.getRequestDispatcher("Login.html");
            rd.include(request, response);
            return;
        }

        if (!isValidPassword(pwd)) {

            out.println("<font color='red'>");
            out.println("Invalid Password!<br>");
            out.println("Password must:");
            out.println("<ul>");
            out.println("<li>Have at least 8 characters</li>");
            out.println("<li>Contain at least one Uppercase letter</li>");
            out.println("<li>Contain at least one Numeric digit</li>");
            out.println("<li>Contain exactly one Special Character</li>");
            out.println("</ul>");
            out.println("</font>");

            RequestDispatcher rd = request.getRequestDispatcher("Login.html");
            rd.include(request, response);
            return;
        }

        String userID = getServletConfig().getInitParameter("user");
        String password = getServletConfig().getInitParameter("password");

        if (userID.equals(user) && password.equals(pwd)) {

            request.setAttribute("user", user);
            request.getRequestDispatcher("LoginSuccess.jsp")
                   .forward(request, response);

        } else {

            RequestDispatcher rd =
                    request.getRequestDispatcher("Login.html");

            out.println("<font color='red'>Either username or password is wrong.</font>");

            rd.include(request, response);
        }
    }

    private boolean isValidPassword(String password) {

        if (password.length() < 8)
            return false;

        int upper = 0;
        int digit = 0;
        int special = 0;

        for (char ch : password.toCharArray()) {

            if (Character.isUpperCase(ch))
                upper++;
            else if (Character.isDigit(ch))
                digit++;
            else if (!Character.isLetterOrDigit(ch))
                special++;
        }

        return upper >= 1 && digit >= 1 && special == 1;
    }
}