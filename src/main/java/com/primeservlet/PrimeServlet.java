//6c. Build a servlet program to check the given number is prime number or not using HTML with step by
//step procedure.
package com.primeservlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/PrimeServlet")
public class PrimeServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String input = request.getParameter("number");

        out.println("<html><body>");

        try {
            int num = Integer.parseInt(input);

            if (num <= 1) {
                out.println("<h3 style='color:red;'>Enter a number greater than 1</h3>");
            } else {
                boolean isPrime = true;

                for (int i = 2; i <= num / 2; i++) {
                    if (num % i == 0) {
                        isPrime = false;
                        break;
                    }
                }

                if (isPrime) {
                    out.println("<h2 style='color:green;'>" + num + " is a Prime Number</h2>");
                } else {
                    out.println("<h2 style='color:blue;'>" + num + " is NOT a Prime Number</h2>");
                }
            }

        } catch (NumberFormatException e) {
            // ERROR HANDLING
            response.setStatus(400); // HTTP Error Code
            out.println("<h2 style='color:red;'>Invalid Input! Please enter a valid number.</h2>");
        }

        out.println("<br><a href='index.html'>Go Back</a>");
        out.println("</body></html>");
    }
}