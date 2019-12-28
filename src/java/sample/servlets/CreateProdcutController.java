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
import sample.beans.ErrorTeaBean;
import sample.daos.TeaDAO;
import sample.dtos.TeaDTO;

/**
 *
 * @author Bui Be Bong
 */
public class CreateProdcutController extends HttpServlet {

    private final String SUCCESS = "SearchAdminPageController";
    private final String ERROR = "createNewProduct.jsp";

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

        try {
            String teaID = request.getParameter("txtCreateTeaID");
            String teaName = request.getParameter("txtCreateTeaName");
            boolean flag = true;
            ErrorTeaBean error = new ErrorTeaBean();
            float price = 0;
            try {
                price = Float.parseFloat(request.getParameter("txtCreatePrice"));
                if (price < 0) {
                    error.setPriceError("Giá phải lớn hơn 0");
                    flag = false;
                }
            } catch (Exception e) {
                error.setPriceError("Giá phải là 1 số");
                flag = false;
            }

            TeaDAO dao = new TeaDAO();
            TeaDTO dto = new TeaDTO(teaID, teaName, price);
            boolean checkID = dao.checkID(teaID);
            if (!checkID) {
                error.setErrorMsg("ID đã tồn tại");
                flag = false;
            }
            if (checkID && flag == true) {
                dao.createNewProduct(dto);
                url = SUCCESS;
            } 
            request.setAttribute("ERRORTEA", error);
        } catch (Exception e) {
            log("Error at CreateUserController: " + e.toString());
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
