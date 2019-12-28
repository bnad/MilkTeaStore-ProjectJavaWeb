/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sample.cart.CartObject;
import sample.daos.TeaDAO;
import sample.dtos.TeaDTO;

/**
 *
 * @author Bui Be Bong
 */
public class AddToCartController extends HttpServlet {

    private final String SUCCESS = "userpage.jsp";
    private final String ERROR = "error.jsp";

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
        String url = ERROR;
        String teaID = request.getParameter("txtTeaID");
        String sizeStr = request.getParameter("cboSize");
        String topping = request.getParameter("cboTopping");
        String sugarStr = request.getParameter("cboSugar");
        String iceStr = request.getParameter("cboIce");
        float size = 0;
        int sugar = 0, ice = 0;
        try {
            String msg = "";
            if (teaID == null || teaID.isEmpty()) {
                msg += "ID not found";
            }
            if (sizeStr == null || sizeStr.isEmpty()) {
                msg += "Please select size";
            } else {
                try {
                    size = Float.parseFloat(sizeStr);
                } catch (NumberFormatException e) {
                    msg += "Please select valid size";
                }
            }
            if (sugarStr != null && !sugarStr.isEmpty()) {
                try {
                    sugar = Integer.parseInt(sugarStr);
                } catch (NumberFormatException e) {
                    msg += "Invalid amount of sugar";
                }
            }
            if (iceStr != null && !iceStr.isEmpty()) {
                try {
                    ice = Integer.parseInt(iceStr);
                } catch (NumberFormatException e) {
                    msg += "Invalid amount of ice";
                }
            }
            if (msg.isEmpty()) {
                HttpSession session = request.getSession();
                CartObject cart = (CartObject) session.getAttribute("CART");
                if (cart == null) {
                    cart = new CartObject();
                } 
                TeaDTO dto = new TeaDTO(teaID, 1, size, sugar, ice, topping);
                cart.addItem(dto);
                session.setAttribute("CART", cart);
                session.setAttribute("ORDERDETAIL", dto);
                url = "userpage.jsp";
            }
        } catch (Exception e) {
            log("ERROR at AddToCartController: " + e.getMessage());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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
