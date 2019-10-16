package edu.cvtc.agile.controllers;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.cvtc.agile.util.EmailUtility;

/**
 * A servlet that takes user input and message and sends it as a new e-mail
 * 	through an SMTP server
 */
@WebServlet("/EmailSending")
public class EmailSendingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String host;
    private String port;
    private String user;
    private String pass;
 
    public void init() {
        // reads SMTP server setting from web.xml file
        ServletContext context = getServletContext();
        host = context.getInitParameter("host");
        port = context.getInitParameter("port");
        user = context.getInitParameter("user");
        pass = context.getInitParameter("pass");
    }
 
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // reads form fields
        //String recipient = request.getParameter("name");
    	String recipient = "StreamLineGroup.contact@gmail.com";
        String subject = request.getParameter("name");
        String content = "Name: " + request.getParameter("name") +
        				"<br><br>E-Mail: " + request.getParameter("email") +
        				"<br><br>Comment: " + request.getParameter("text");
 
        String resultMessage = "";
 
        try {
            EmailUtility.sendEmail(host, port, user, pass, recipient, subject,
                    content);
            resultMessage = "The message was sent successfully. Thank you!";
        } catch (Exception ex) {
            ex.printStackTrace();
            resultMessage = "There were an error: " + ex.getMessage();
        } finally {
            request.setAttribute("Message", resultMessage);
            getServletContext().getRequestDispatcher("/result.jsp").forward(
                    request, response);
        }
    }
}
