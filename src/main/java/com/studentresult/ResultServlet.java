package com.studentresult;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ResultServlet")
public class ResultServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String rollno = request.getParameter("rollno");
        String studentname = request.getParameter("studentname");

        int[] marks = new int[5];
        boolean valid = true;

        try {
            for (int i = 0; i < 5; i++) {
                marks[i] = Integer.parseInt(request.getParameter("sub" + (i+1)));
                if (marks[i] < 0 || marks[i] > 100) {
                    valid = false;
                }
            }
        } catch (NumberFormatException e) {
            valid = false;
        }

        if (!valid || rollno == null || studentname == null || studentname.trim().isEmpty()) {
            request.setAttribute("error", "Invalid input! Please enter correct details.");
            request.getRequestDispatcher("index.jsp").forward(request, response);
            return;
        }

        // Calculate average
        int total = 0;
        for (int m : marks) total += m;
        double average = total / 5.0;

        // Check pass/fail (all subjects > 40)
        String result = "Pass";
        for (int m : marks) {
            if (m < 40) {
                result = "Fail";
                break;
            }
        }

        // Set attributes for JSP
        request.setAttribute("rollno", rollno);
        request.setAttribute("studentname", studentname);
        request.setAttribute("marks", marks);
        request.setAttribute("average", average);
        request.setAttribute("result", result);

        request.getRequestDispatcher("result.jsp").forward(request, response);
    }
}
