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
import java.util.ArrayList;
import java.util.List;
import sample.dtos.TeaDTO;
import sample.utils.DBUtils;

/**
 *
 * @author Bui Be Bong
 */
public class TeaDAO {

    public boolean insertOrderDetail(TeaDTO dto, String orderID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "INSERT INTO dbo.tblOrderDetail(orderID, teaID,quantity,size,ice, sugar,topping)VALUES( ?, ? , ? , ? , ?, ?, ?)";
                stm = conn.prepareStatement(sql);
                stm.setString(1, orderID);
                stm.setString(2, dto.getTeaID());
                stm.setInt(3, dto.getQuantity());
                stm.setFloat(4, dto.getSize());
                stm.setInt(5, dto.getIce());
                stm.setInt(6, dto.getSugar());
                stm.setString(7, dto.getTopping());
                check = stm.executeUpdate() > 0;
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

    public boolean insertOrder(String userID, String orderID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "INSERT INTO dbo.tblOrder(orderID,userID)VALUES(?,?)";
                stm = conn.prepareStatement(sql);
                stm.setString(1, orderID);
                stm.setString(2, userID);
                check = stm.executeUpdate() > 0;
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

    public float getUnitPrice(String teaID) throws SQLException {
        float price = 0;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT price FROM tblMilkTea WHERE teaID = ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, teaID);
                rs = stm.executeQuery();
                if (rs.next()) {
                    price = rs.getFloat("price");
                }
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return price;
    }

    public List<TeaDTO> getListProductByUser() throws SQLException {
        List<TeaDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT teaID, teaName, price FROM tblMilkTea";
                stm = conn.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String teaID = rs.getString("teaID");
                    String teaName = rs.getString("teaName");
                    Float price = rs.getFloat("price");
                    list.add(new TeaDTO(teaID, teaName, price));
                }
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public List<TeaDTO> getListProduct(String searchValue) throws SQLException {
        List<TeaDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT teaID, teaName, price FROM dbo.tblMilkTea WHERE teaName LIKE ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, "%" + searchValue + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    String teaID = rs.getString("teaID");
                    String teaName = rs.getString("teaName");
                    float price = rs.getFloat("price");
                    list.add(new TeaDTO(teaID, teaName, price));
                }
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public void deleteProduct(String teaID) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "DELETE FROM dbo.tblMilkTea WHERE teaID = ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, teaID);
                stm.executeUpdate();
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

    }

    public void updateProduct(TeaDTO dto) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "UPDATE dbo.tblMilkTea SET teaName = ?,price = ? WHERE teaID = ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, dto.getTeaName());
                stm.setFloat(2, dto.getPrice());
                stm.setString(3, dto.getTeaID());
                stm.execute();
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    public boolean checkID(String teaID) throws SQLException, ClassNotFoundException {
        boolean result = true;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "Select teaID from tblMilkTea where teaID=?";
                stm = con.prepareStatement(sql);
                stm.setString(1, teaID);
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

    public void createNewProduct(TeaDTO dto) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "INSERT INTO dbo.tblMilkTea (teaID,teaName,price)VALUES(?,?,?)";
                stm = conn.prepareStatement(sql);
                stm.setString(1, dto.getTeaID());
                stm.setString(2, dto.getTeaName());
                stm.setFloat(3, dto.getPrice());
                stm.executeUpdate();
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }
}
