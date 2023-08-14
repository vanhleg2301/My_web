/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import model.Account;
import model.Product;

/**
 *
 * @author DELL
 */
public class AdminDAO extends DBContext {

    public List<Account> getAllAccount() throws SQLException {
        List<Account> list = new ArrayList<>();
        String sql = "select * from Account";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getBoolean(5), rs.getInt(6)));
            }
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return list;
    }

    public void UpdateAccount(int userID, int cusID, int role) throws SQLException {
        String sql = "UPDATE Account SET role = ?, CustomerID = ? WHERE (AccountID = ?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, role);
            st.setInt(2, cusID);
            st.setInt(3, userID);
            st.executeUpdate();
        } catch (Exception e) {
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    public Account getAccountDetail(int userUD) {
        String sql = "select * from FinalProject.dbo.[Account] where [AccountID] = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, userUD);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Account a = new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getBoolean(5), rs.getInt(6));
                return a;
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return null;
    }
}

