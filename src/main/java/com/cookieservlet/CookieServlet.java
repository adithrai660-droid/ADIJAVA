package com.cookieservlet;
//Step 1: Required imports
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

//Step 2: Create servlet class and use WebServlet annotation
@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Handle GET requests
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String userName = request.getParameter("userName");
        if (userName != null && !userName.isEmpty()) {
            Cookie userCookie = new Cookie("user", userName);
            userCookie.setMaxAge(60); // 1 minute
            response.addCookie(userCookie);

            // Initialize visit count cookie
            Cookie visitCookie = new Cookie("visits", "1");
            visitCookie.setMaxAge(60);
            response.addCookie(visitCookie);
        }

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
                    cookie.setMaxAge(60);
                    response.addCookie(cookie);
                }
            }
        }

        out.println("<html><head><title>Cookie Example</title></head><body>");
        if (existingUser != null) {
            out.println("<font color=blue><h2>Welcome back, " + existingUser + "!</h2></font>");
            out.println("<font color=magenta><h2>You have visited this page " + visits + " times!</h2></font>");
            out.println("<form action='CookieServlet' method='post'>");
            out.println("<input type='submit' value='Logout'>");
            out.println("</form>");
        } else {
            out.println("<h2 style='color:red;'>Welcome Guest! Kindly login</h2>");
            out.println("<form action='CookieServlet' method='get'>");
            out.println("Enter your name: <input type='text' name='userName'>");
            out.println("<input type='submit' value='Submit'>");
            out.println("</form>");
        }
        out.println("</body></html>");
    }

    // Handle POST requests (Logout)
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Cookie cookie = new Cookie("user", "");
        cookie.setMaxAge(0); // delete cookie
        response.addCookie(cookie);

        Cookie visitCookie = new Cookie("visits", "");
        visitCookie.setMaxAge(0); // delete visit count
        response.addCookie(visitCookie);

        response.sendRedirect("CookieServlet");
    }
}
