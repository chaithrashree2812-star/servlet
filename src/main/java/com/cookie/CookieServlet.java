package com.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/cookie")
public class CookieServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");

        int visitCount = 0;
        boolean userFound = false;

        // Get cookies
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("user")) {
                    username = c.getValue();
                    userFound = true;
                }
                if (c.getName().equals("count")) {
                    visitCount = Integer.parseInt(c.getValue());
                }
            }
        }

        visitCount++; // increment visit

        // Create/Update cookies
        Cookie userCookie = new Cookie("user", username);
        Cookie countCookie = new Cookie("count", String.valueOf(visitCount));

        // Set expiry (60 seconds for demo)
        userCookie.setMaxAge(60);
        countCookie.setMaxAge(60);

        response.addCookie(userCookie);
        response.addCookie(countCookie);

        // Output
        out.println("<html>");
        out.println("<head><title>Cookie Result</title></head>");
        out.println("<body>");
        out.println("<h2>Welcome back " + username + "!</h2>");
        out.println("<p>You have visited this page " + visitCount + " times.</p>");
        out.println("<p><b>Note:</b> Cookie will expire in 60 seconds.</p>");
        out.println("<a href='index.html'>Go Back</a>");
        out.println("</body>");
        out.println("</html>");

        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("index.html");
    }
}