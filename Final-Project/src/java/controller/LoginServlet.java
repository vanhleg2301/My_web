/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.DAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import model.Product;

/**
 *
 * @author Admin
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = request.getParameter("Email");
        String password = request.getParameter("Password");
        String remember = request.getParameter("re");
        DAO dao = new DAO();
        Account a = dao.check(email, password);
        if (a == null) {
            String ms = "Email or Pass Was Incorrect";
            request.setAttribute("ms", ms);
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            //tim thay
            //tao session
            session.setAttribute("account", a);
            Cookie cemail = new Cookie("Email", email);
            Cookie cpass = new Cookie("Password", password);
            Cookie cre = new Cookie("re", remember);
            if (remember != null) {
                cemail.setMaxAge(60 * 60 * 24 * 30);
                cpass.setMaxAge(60 * 60 * 24 * 3);
                cre.setMaxAge(60 * 60 * 24 * 30);
            } else {
                cemail.setMaxAge(0);
                cpass.setMaxAge(0);
                cre.setMaxAge(0);
            }
            response.addCookie(cemail);
            response.addCookie(cpass);
            response.addCookie(cre);
            
            if (a.getRole() == 1) {
                session.setAttribute("role", 1);
            }
            //dua ngoi dung sang trang home

            List<Product> listF = dao.getFeatureProduct();
            List<Product> listL = dao.getLastestProduct();
            request.setAttribute("listF", listF);
            request.setAttribute("listL", listL);
            request.getRequestDispatcher("home").forward(request, response);
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
