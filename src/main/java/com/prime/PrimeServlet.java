package com.prime;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/prime")
public class PrimeServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            int number = Integer.parseInt(request.getParameter("number"));

            boolean isPrime = true;
            String steps = "Step by step checking:<br>";

            if (number <= 1) {
                isPrime = false;
                steps += number + " is not a prime number (must be > 1)";
            } else {
                for (int i = 2; i <= number / 2; i++) {
                    steps += number + " ÷ " + i;

                    if (number % i == 0) {
                        steps += " = " + (number / i) + " (Divisible)<br>";
                        isPrime = false;
                        break;
                    } else {
                        steps += " (Not divisible)<br>";
                    }
                }

                if (isPrime) {
                    steps += "No divisors found → Prime number";
                }
            }

            // Output
            out.println("<html><body>");
            out.println("<h2>Prime Number Result</h2>");
            out.println("<p>Number: " + number + "</p>");
            out.println("<p><b>Result: " + (isPrime ? "Prime Number" : "Not a Prime Number") + "</b></p>");
            out.println("<p>" + steps + "</p>");
            out.println("<a href='index.html'>Check Another</a>");
            out.println("</body></html>");

        } catch (Exception e) {
            out.println("<html><body>");
            out.println("<h2>Error</h2>");
            out.println("<p>Please enter a valid number</p>");
            out.println("<a href='index.html'>Try Again</a>");
            out.println("</body></html>");
        }

        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("index.html");
    }
}