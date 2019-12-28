/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Bui Be Bong
 */
public class MainController extends HttpServlet {

    private final String LOGIN_PAGE = "login.jsp";
    private final String LOGIN_CONTROLLER = "LoginController";
    private final String CREATE_USER_CONTROLLER = "CreateUserController";
    private final String LOGOUT = "LogOutController";
    private final String SEARCH_ADMINP_PAGE = "SearchAdminPageController";
    private final String DELETE_PRODUCT_CONTROLLER = "DeleteProductController";
    private final String UPDATE_PRODUCT_CONTROLLER = "UpdateProductController";
    private final String CREATE_PRODUCT_CONTROLLER = "CreateProdcutController";
    private final String ADD_TO_CART_PRODUCT = "AddToCartController";
    private final String CONFIRM_CONTROLLER = "ConfirmController";

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
        String url = LOGIN_PAGE;
        try {
            String action = request.getParameter("btnAction");
            if (action.equals("Login")) {
                url = LOGIN_CONTROLLER;
            } else if (action.equals("Create")) {
                url = CREATE_USER_CONTROLLER;
            } else if (action.equals("Log out")) {
                url = LOGOUT;
            } else if (action.equals("Search Tea")) {
                url = SEARCH_ADMINP_PAGE;
            } else if (action.equals("Delete")) {
                url = DELETE_PRODUCT_CONTROLLER;
            } else if (action.equals("Update")) {
                url = UPDATE_PRODUCT_CONTROLLER;
            } else if (action.equals("Create Product")) {
                url = CREATE_PRODUCT_CONTROLLER;
            } else if (action.equals("Add to cart")) {
                url = ADD_TO_CART_PRODUCT;
            } else if (action.equals("Confirm")) {
                url = CONFIRM_CONTROLLER;
            }
        } catch (Exception e) {
            log("Error at MainController: " + e.toString());
        }
        request.getRequestDispatcher(url).forward(request, response);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
