/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import model.Account;
import model.Cart;
import model.Item;
import model.Product;
import model.User;

/**
 *
 * @author DELL
 */
public class OrderDAO extends DBContext {

    public void addOrder(Account u, Cart cart) throws SQLException {
        LocalDate curDate = java.time.LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = curDate.format(formatter);
        String date = formattedDate.toString();
        try {
            //add vao order
            String sql = "INSERT INTO FinalProject.dbo.[Order] VALUES (?, ?, ?)";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, date);
            st.setInt(2, u.getUserID());
            st.setDouble(3, cart.getTotalMoney());
            st.executeUpdate();

            // lay rea id cua order vua add
            String sql1 = "select top 1 id from FinalProject.dbo.[Order] order by id desc";
            PreparedStatement st1 = connection.prepareStatement(sql1);
            ResultSet rs = st1.executeQuery();
            if (rs.next()) {
                for (Item i : cart.getItems()) {
                    String sql2 = "insert into FinalProject.dbo.[OrderLine] values(?,?,?)";
                    PreparedStatement st2 = connection.prepareStatement(sql2);
                    st2.setInt(1, i.getProduct().getId());
                    st2.setInt(2, i.getQuantity());
                    st2.setDouble(3, i.getPrice());
                    st2.executeUpdate();
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
