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
import sample.beans.ErrorUserBean;
import sample.daos.UserDAO;
import sample.dtos.UserDTO;

/**
 *
 * @author Bui Be Bong
 */
public class CreateUserController extends HttpServlet {
    private final String SUCCESS = "login.jsp";
    private final String ERROR = "createNewAccount.jsp";
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
            String userID = request.getParameter("txtCreateUserID");
            String userName = request.getParameter("txtCreateUserName");
            String password = request.getParameter("txtCreatePassword");
            String confirm = request.getParameter("txtCreateConfirm");
            System.out.println(userID + password + userName + confirm);
            UserDAO dao = new UserDAO();
            UserDTO dto = new UserDTO(userID, userName, password, userID);
            boolean checkID = dao.checkID(userID);
            if (checkID) {
                if (password.equals(confirm)) {
                    dao.createNewAccount(dto);
                    url = SUCCESS;
                } else {
                    ErrorUserBean error = new ErrorUserBean();
                    error.setConfirmError("Mật khẩu không trùng khớp");
                    request.setAttribute("ERRORCONFIRM", error);
                }
            } else {
                ErrorUserBean error = new ErrorUserBean();
                error.setErrorMsg("Tên đăng nhập đã tồn tại");
                request.setAttribute("ERRORUSERID", error);
            }
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
