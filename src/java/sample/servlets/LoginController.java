/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sample.beans.ErrorUserBean;
import sample.daos.TeaDAO;
import sample.daos.UserDAO;
import sample.dtos.TeaDTO;

/**
 *
 * @author Bui Be Bong
 */
public class LoginController extends HttpServlet {

    private final String ERROR = "login.jsp";
    private final String ADMIN_PAGE = "adminpage.jsp";
    private final String USER_PAGE = "userpage.jsp";

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
            String userID = request.getParameter("txtUserID");
            String password = request.getParameter("txtPassword");
            System.out.println(userID + password);
            UserDAO dao = new UserDAO();
            String roleID = dao.checkLogin(userID, password).trim();
            if (roleID.equals("ad")) {
                url = ADMIN_PAGE;
            } else if (roleID.equals("user")) {
                
                TeaDAO tea = new TeaDAO();
                List<TeaDTO> list = tea.getListProductByUser();
                HttpSession session = request.getSession();
                session.setAttribute("LISTTEAUSER", list);
                url = USER_PAGE;
            } else {
                ErrorUserBean error = new ErrorUserBean();
                error.setErrorMsg("Sai tên đăng nhập hoặc mật khẩu");
                request.setAttribute("ERRORLOGIN", error);
            }
            HttpSession session = request.getSession();
            session.setAttribute("USERIDLOGIN", userID);
        } catch (Exception e) {
            log("Error at LoginController: " + e.toString());
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
