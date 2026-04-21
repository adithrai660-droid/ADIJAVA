package com.sessiontracking;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SessionTracker")
public class SessionTrackingServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get or create session
        HttpSession session = request.getSession(true);

        // Set session expiry to 1 minute (60 seconds)
        session.setMaxInactiveInterval(60);

        // Get user name from request
        String userName = request.getParameter("userName");
        if (userName != null && !userName.isEmpty()) {
            session.setAttribute("userName", userName);
        }

        // Retrieve stored name
        String existingUser = (String) session.getAttribute("userName");

        // Track visit count
        Integer visitCount = (Integer) session.getAttribute("visitCount");
        if (visitCount == null) {
            visitCount = 1;
        } else {
            visitCount++;
        }
        session.setAttribute("visitCount", visitCount);

        // Get session details
        Date createTime = new Date(session.getCreationTime());
        Date lastAccessTime = new Date(session.getLastAccessedTime());
        String sessionId = session.getId();

        // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Generate HTML response
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><title>Session Tracking Demo</title></head>");
        out.println("<body>");
        out.println("<h2>Session Tracking Information</h2>");

        if (existingUser != null) {
            out.println("<h3 style='color:blue;'>Hello " + existingUser + "!</h3>");
            out.println("<h3 style='color:magenta;'>You have visited this page " + visitCount + " times.</h3>");
        } else {
            out.println("<h3 style='color:red;'>Welcome Guest! Please login</h3>");
            out.println("<form action='SessionTracker' method='get'>");
            out.println("Enter your name: <input type='text' name='userName'>");
            out.println("<input type='submit' value='Submit'>");
            out.println("</form>");
        }

        out.println("<p>Session ID: " + sessionId + "</p>");
        out.println("<p>Session Creation Time: " + createTime + "</p>");
        out.println("<p>Last Access Time: " + lastAccessTime + "</p>");
        out.println("<p>Session Expiry (Max Inactive Interval): " + session.getMaxInactiveInterval() + " seconds</p>");

        out.println("<p><b>Note:</b> Wait more than 1 minute without activity, and the session will expire. On next refresh you’ll be treated as a new guest.</p>");

        out.println("</body>");
        out.println("</html>");
    }
}
