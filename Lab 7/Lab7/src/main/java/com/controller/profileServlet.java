package com.controller;

import com.dao.profileDao;
import com.model.Profile;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.util.DBConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

public class profileServlet extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException {
        
        PrintWriter out = response.getWriter();
        
        profileDao profileDao = new profileDao();
        
        Profile profile = new Profile();
        
        String username = request.getParameter("username");
        String icno = request.getParameter("icno");
        String firstname = request.getParameter("firstname");
        
        profile.setUsername(username);
        profile.setIcno(icno);
        profile.setFirstname(firstname);
        
        if ( !profile.equals(profileDao.getProfileByUsername(username)) ) {

            profileDao.addProfile(profile);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/processProfile.jsp");
            request.setAttribute("profile", profile);
            requestDispatcher.forward(request, response);
        }
        else {
            out.println("<script>");
            out.println("alert('Profile with username \\'" + username + "\\' already exists.');");
            out.println("window.location.href = 'registerProfile.html';");
            out.println("</script>");
        }
        
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(profileServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(profileServlet.class.getName()).log(Level.SEVERE, null, ex);
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