package Servlet;

import Beans.UserBLocal;
import Client.UserC;
import entity.Usertable;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;

@WebServlet(name = "test", urlPatterns = {"/test"})
public class test extends HttpServlet {

    @Inject
    UserC uc;
    @EJB
    UserBLocal ur;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet test</title>");
            out.println("</head>");
            out.println("<body>");

            out.println("<h1>Servlet test at</h1>");

            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//        PrintWriter out = response.getWriter();
//        Integer userID = ur.getIdByusername("Bhagyashree");
//        if (userID != null) {
//            out.println("User ID for : " + userID);
//        } else {
//            out.println("User not found");
//        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
