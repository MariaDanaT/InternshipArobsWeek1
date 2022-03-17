package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MyFirstServlet", urlPatterns = "/myPage")
public class MyFirstServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();

        resp.setContentType("text/html");
        printWriter.println("""
                <html>
                    <head><title>Add two numbers</title></head>
                    <body><h1>Add two numbers</h1>
                        <form action="./myPage" method = "POST">
                        First number <input type = "text" name = "first" ><br>
                        Second number <input type = "text" name = "second" ><br>
                        <input type="submit" value="Add" ><br><br>
                        </form>
                    </body>
                </html>""");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int first;
        int second;

        first = Integer.parseInt(req.getParameter("first"));
        second = Integer.parseInt(req.getParameter("second"));

        resp.setContentType("text/html");
        resp.getWriter().println("Sum: <input type=\"text\" disabled =\"true\" value=\"" + (first + second) + "\" >");

    }
}