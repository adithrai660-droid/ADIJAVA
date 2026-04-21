package com.cookieservlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Handle GET requests
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Step 1: Get user input from form
        String userName = request.getParameter("userName");
        if (userName != null && !userName.isEmpty()) {
            // Create a cookie for user name
            Cookie userCookie = new Cookie("user", userName);
            userCookie.setMaxAge(60); // expires in 1 minute
            response.addCookie(userCookie);

            // Initialize visit count cookie
            Cookie visitCookie = new Cookie("visits", "1");
            visitCookie.setMaxAge(60);
            response.addCookie(visitCookie);
        }

        // Step 2: Read cookies
        Cookie[] cookies = request.getCookies();
        String existingUser = null;
        int visits = 0;

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("user")) {
                    existingUser = cookie.getValue();
                }
                if (cookie.getName().equals("visits")) {
                    visits = Integer.parseInt(cookie.getValue());
                    visits++;
                    cookie.setValue(String.valueOf(visits));
                    cookie.setMaxAge(60); // refresh expiry
                    response.addCookie(cookie);
                }
            }
        }

        // Step 3: Generate HTML response
        out.println("<html><head><title>Cookie Example</title></head><body>");
        if (existingUser != null) {
            out.println("<h2 style='color:blue;'>Welcome back, " + existingUser + "!</h2>");
            out.println("<h2 style='color:magenta;'>You have visited this page " + visits + " times!</h2>");
        } else {
            out.println("<h2 style='color:red;'>Welcome Guest! Please login</h2>");
            out.println("<form action='CookieServlet' method='get'>");
            out.println("Enter your name: <input type='text' name='userName'>");
            out.println("<input type='submit' value='Submit'>");
            out.println("</form>");
        }

        // Step 4: Display all cookies
        out.println("<h3>List of Cookies:</h3>");
        if (cookies != null) {
            out.println("<ul>");
            for (Cookie cookie : cookies) {
                out.println("<li>" + cookie.getName() + " = " + cookie.getValue() +
                        " (MaxAge: " + cookie.getMaxAge() + " seconds)</li>");
            }
            out.println("</ul>");
        } else {
            out.println("<p>No cookies found.</p>");
        }

        out.println("</body></html>");
    }
}
