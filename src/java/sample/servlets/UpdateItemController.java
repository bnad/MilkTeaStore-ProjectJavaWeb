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
import javax.servlet.http.HttpSession;
import sample.beans.ErrorTeaBean;
import sample.cart.CartObject;
import sample.dtos.TeaDTO;

/**
 *
 * @author Bui Be Bong
 */
public class UpdateItemController extends HttpServlet {
    private final String CART_PAGE = "ViewOrderController";
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
        String url = CART_PAGE;
        String teaID = request.getParameter("TeaID");
        float size = Float.parseFloat(request.getParameter("TeaSize"));
        int ice = Integer.parseInt(request.getParameter("TeaIce"));
        int sugar = Integer.parseInt(request.getParameter("TeaSugar"));
        String topping = request.getParameter("TeaTopping");
        String quantity = request.getParameter("quantity");
        ErrorTeaBean error = new ErrorTeaBean();
        
        boolean founderr = false;
        try {
            HttpSession session = request.getSession();
            CartObject cart = (CartObject) session.getAttribute("CART");
            if (cart!=null) {
                int quantityInt = Integer.parseInt(quantity);
                if (quantityInt < 0) {
                    error.setErrorMsg("Quantity must be more then zero");
                    founderr = true;
                }
                if (!founderr) {
                    TeaDTO dto = new TeaDTO(teaID, quantityInt, size, sugar, ice, topping);
                    cart.updateItem(dto);
                    session.setAttribute("CART", cart);
                } else {
                    request.setAttribute("ERRORCART", error);
                }
            }
        } catch (Exception e) {
            log("UpdateItemServlet NumberFormatException: " + e.getMessage());
            error.setErrorMsg("Quantity is an integer");
            request.setAttribute("ERRORCART", error);
        } finally {
            response.sendRedirect(url);
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
