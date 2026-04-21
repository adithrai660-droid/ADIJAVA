//6b. Build a servlet program to create a cookie to get your name through text box and press submit button(
//through HTML) to display the message by greeting Welcome back your name ! , you have visited this page
//n times ( n = number of your visit ) and demonstrate the expiry of cookie also.

package com.cookieservlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String userName = request.getParameter("userName");

        // Create user cookie
        if (userName != null && !userName.isEmpty()) {
            Cookie userCookie = new Cookie("user", userName);
            userCookie.setMaxAge(60); // 1 minute
            response.addCookie(userCookie);

            // Initialize count cookie
            Cookie countCookie = new Cookie("count", "1");
            countCookie.setMaxAge(60);
            response.addCookie(countCookie);
        }

        // Read cookies
        Cookie[] cookies = request.getCookies();
        String existingUser = null;
        int count = 0;

        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("user")) {
                    existingUser = c.getValue();
                }
                if (c.getName().equals("count")) {
                    count = Integer.parseInt(c.getValue());
                }
            }
        }

        // Increase visit count
        if (existingUser != null) {
            count++;
            Cookie countCookie = new Cookie("count", String.valueOf(count));
            countCookie.setMaxAge(60);
            response.addCookie(countCookie);
        }

        // HTML Output
        out.println("<html><body>");

        if (existingUser != null) {
            out.println("<h2 style='color:blue;'>Welcome back, " + existingUser + "</h2>");
            out.println("<h3 style='color:green;'>Visited " + count + " times</h3>");

            out.println("<form action='CookieServlet' method='post'>");
            out.println("<input type='submit' value='Logout'>");
            out.println("</form>");
        } else {
            out.println("<h2 style='color:red;'>Welcome Guest</h2>");
            out.println("<form action='CookieServlet' method='get'>");
            out.println("Enter Name: <input type='text' name='userName'>");
            out.println("<input type='submit' value='Login'>");
            out.println("</form>");
        }

        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Delete cookies (logout)
        Cookie userCookie = new Cookie("user", "");
        userCookie.setMaxAge(0);
        userCookie.setPath("/");

        Cookie countCookie = new Cookie("count", "");
        countCookie.setMaxAge(0);
        countCookie.setPath("/");

        response.addCookie(userCookie);
        response.addCookie(countCookie);

        response.sendRedirect("CookieServlet");
    }
}