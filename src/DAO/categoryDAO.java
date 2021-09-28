/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.author;
import model.category;

/**
 *
 * @author hoand
 */
public class categoryDAO extends DBContext {

    public ArrayList<category> getAllCate() {
        ArrayList<category> list = new ArrayList<>();
        try {
            String sql = "SELECT [CateId]\n"
                    + "      ,[CateName]\n"
                    + "  FROM [dbo].[category]";

            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                category c = new category();
                c.setCateId(rs.getInt("CateId"));
                c.setCateName(rs.getString("cateName"));
                list.add(c);

            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(categoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean remove(String name) {
        try {
            String sql = "DELETE FROM [dbo].[category]\n"
                    + "      WHERE  [CateName] Like ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, name);
            stm.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    public category getCate(String name) {
        try {
            String sql = "SELECT [CateId]\n"
                    + "      ,[CateName]\n"
                    + "  FROM [dbo].[category]\n"
                    + "  Where [CateName] LIKE ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, name);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                category a = new category();
                a.setCateId(rs.getInt("CateId"));
                a.setCateName(rs.getString("CateName"));
                return a;
            }
        } catch (SQLException ex) {
            Logger.getLogger(authorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void insert(String cate) {
        try {
            String sql = "INSERT INTO [dbo].[category]\n"
                    + "           ([CateName])\n"
                    + "     VALUES\n"
                    + "           (?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, cate);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(categoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//    public static void main(String[] args) {
//        categoryDAO cDAO = new categoryDAO();
//        ArrayList<category> list = cDAO.getAllCate();
//        System.out.println(list.size());
//    }
}
