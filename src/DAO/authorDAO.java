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

/**
 *
 * @author hoand
 */
public class authorDAO extends DBContext {

    public ArrayList<author> getAllAuthors() {
        try {
            ArrayList<author> list = new ArrayList<>();
            String sql = "SELECT [authorID]\n"
                    + "      ,[name]\n"
                    + "  FROM [dbo].[authors]";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                author a = new author();
                a.setAuthorID(rs.getInt("authorID"));
                a.setAuthorName(rs.getString("name"));
                list.add(a);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(authorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean remove(String author) {
        try {
            String sql = "DELETE FROM [dbo].[authors]\n"
                    + "      WHERE  [name] Like ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, author);
            stm.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    public author getAuthor(String name) {
        try {
            String sql = "SELECT [authorID]\n"
                    + "      ,[name]\n"
                    + "  FROM [dbo].[authors]"
                    + "Where [name] Like ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, name);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                author a = new author();
                a.setAuthorID(rs.getInt("authorID"));
                a.setAuthorName(rs.getString("name"));
                return a;
            }
        } catch (SQLException ex) {
            Logger.getLogger(authorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<author> getAuthorList(String name) {
        try {
            ArrayList<author> list = new ArrayList<>();
            String sql = "SELECT [authorID]\n"
                    + "      ,[name]\n"
                    + "  FROM [dbo].[authors]"
                    + "Where [name] Like '%" + name + "%'";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                author a = new author();
                a.setAuthorID(rs.getInt("authorID"));
                a.setAuthorName(rs.getString("name"));
                list.add(a);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(authorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void insert(String author) {
        try {
            String sql = "INSERT INTO [dbo].[authors]\n"
                    + "           ([name])\n"
                    + "     VALUES\n"
                    + "           (?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, author);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(categoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        authorDAO aDAO = new authorDAO();
        ArrayList<author> list = aDAO.getAuthorList("ánh");
        System.out.println(list.size());
    }
}
