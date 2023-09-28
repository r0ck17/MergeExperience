package by.javaguru.git.mergeexperience;

import java.io.*;

import by.javaguru.git.mergeexperience.topics.Module1Topics;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import static java.lang.String.*;

@WebServlet("/module1")
public class Module1Servlet extends HttpServlet {
    private String message;
    public void init() {
        message = "Модуль 1";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");

        out.println("<table>");
        for (Module1Topics value : Module1Topics.values()) {
            String link = value.getTopic().contains("Jakarta")
                    ? "/jakarta.html"
                    : "/topic-description.html";

            out.println("<tr><td>"
                    + value.getOrder() + "</td><td>"
                    + value.getTopic() + "</td><td>"
                    + value.getDesc()
                    + "</td><td><a href='"
                    + link
                    + "'>Подробнее</a>"
                    + "</td></tr>");
        }

        out.println("</table>");

        String linkToImg = request.getContextPath() + "/images/arrow-right.png";
        out.println("""
                <a href="%s">Следующий модуль <img src="%s" alt="" width="16" height="16"></a>
                """.formatted(request.getContextPath() + "/module2", linkToImg));
        out.println("</body></html>");
    }

    public void destroy() {
    }
}