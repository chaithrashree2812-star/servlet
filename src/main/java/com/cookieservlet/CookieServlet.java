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

        // If user enters name first time
        if (userName != null && !userName.isEmpty()) {
            existingUser = userName;
        }

        // If user exists → increment count
        if (existingUser != null) {
            visitCount++;

            Cookie userCookie = new Cookie("user", existingUser);
            Cookie countCookie = new Cookie("count", String.valueOf(visitCount));

            // Expiry (60 sec)
            userCookie.setMaxAge(60);
            countCookie.setMaxAge(60);

            response.addCookie(userCookie);
            response.addCookie(countCookie);
        }

        // Output
        out.println("<html><body>");

        if (existingUser != null) {
            out.println("<h2 style='color:blue;'>Welcome back, " + existingUser + "!</h2>");
            out.println("<h2 style='color:magenta;'>You have visited this page " + visitCount + " times!</h2>");
            out.println("<p>Cookie expires in 60 seconds.</p>");
            out.println("<a href='CookieServlet'>Visit Again</a>");
        } else {
            out.println("<h2 style='color:red;'>Welcome! Please enter your name</h2>");
            out.println("<form action='CookieServlet' method='get'>");
            out.println("Enter your name: <input type='text' name='userName'>");
            out.println("<input type='submit' value='Submit'>");
            out.println("</form>");
        }

        out.println("</body></html>");
        out.close();
    }
}