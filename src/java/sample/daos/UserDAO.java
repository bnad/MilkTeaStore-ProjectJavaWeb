/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import sample.dtos.UserDTO;
import sample.utils.DBUtils;

/**
 *
 * @author Bui Be Bong
 */
public class UserDAO {
    public String checkLogin(String userID, String password) throws SQLException {
        String result = "";
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn!=null) {
                String sql = "SELECT roleID FROM dbo.tblUser WHERE userID=? AND password=?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, userID);
                stm.setString(2, password);
                rs = stm.executeQuery();
                if (rs.next()) {
                    result = rs.getString("RoleID");
                }
            }
        } catch (Exception e) {
        } finally {
            if (rs!=null) {
                conn.close();
            }
            if (stm!=null) {
                stm.close();
            }
            if (conn!=null) {
                rs.close();
            }
        }
        return result;
    }
    
    public void createNewAccount(UserDTO dto) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn!=null) {
                String sql = "INSERT INTO dbo.tblUser(userID,userName,password,roleID)VALUES(?,?,?,?)";
                stm = conn.prepareStatement(sql);
                stm.setString(1, dto.getUserID());
                stm.setString(2, dto.getUserName());
                stm.setString(3, dto.getPassword());
                stm.setString(4, "user");
                stm.executeUpdate();
            }
        } catch (Exception e) {
        } finally {
            if (rs!=null) {
                rs.close();
            } 
            if (stm!=null) {
                stm.close();
            }
            if (conn!=null) {
                conn.close();
            }
        }
    }
    
    public boolean checkID(String userID) throws SQLException, ClassNotFoundException {
        boolean result = true;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "Select userID from tblUser where userID=?";
                stm = con.prepareStatement(sql);
                stm.setString(1, userID);
                rs = stm.executeQuery();
                if (rs.next()) {
                    result = false;
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }
    
}
