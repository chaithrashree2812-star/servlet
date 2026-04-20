package com.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/visit")
public class VisitServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");

        int visitCount = 0;
        String existingUser = null;

        // Read cookies
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("user")) {
                    existingUser = c.getValue();
                }
                if (c.getName().equals("count")) {
                    visitCount = Integer.parseInt(c.getValue());
                }
            }
        }

        // First time input
        if (username != null && !username.isEmpty()) {
            existingUser = username;
        }

        // Update count
        if (existingUser != null) {
            visitCount++;

            Cookie userCookie = new Cookie("user", existingUser);
            Cookie countCookie = new Cookie("count", String.valueOf(visitCount));

            // Expiry (60 seconds)
            userCookie.setMaxAge(60);
            countCookie.setMaxAge(60);

            response.addCookie(userCookie);
            response.addCookie(countCookie);
        }

        // Output
        out.println("<html><body>");

        if (existingUser != null) {
            out.println("<h2 style='color:blue;'>Welcome back " + existingUser + "!</h2>");
            out.println("<h3>You have visited this page " + visitCount + " times.</h3>");
            out.println("<p><b>Note:</b> Cookie expires in 60 seconds.</p>");
        } else {
            out.println("<h2>Please enter your name first</h2>");
            out.println("<a href='index.html'>Go Back</a>");
        }

        // Display all cookies
        out.println("<h3>List of Cookies:</h3>");

        if (cookies != null && cookies.length > 0) {
            out.println("<table border='1'>");
            out.println("<tr><th>Name</th><th>Value</th></tr>");

            for (Cookie c : cookies) {
                out.println("<tr>");
                out.println("<td>" + c.getName() + "</td>");
                out.println("<td>" + c.getValue() + "</td>");
                out.println("</tr>");
            }

            out.println("</table>");
        } else {
            out.println("<p>No cookies found.</p>");
        }

        out.println("<br><a href='visit'>Visit Again</a>");
        out.println("</body></html>");

        out.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}