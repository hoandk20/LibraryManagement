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
import model.login;

/**
 *
 * @author hoand
 */
public class loginDAO extends DBContext {

    public void insert(String user, String pass) {
        try {
            String sql = "INSERT INTO [dbo].[login]\n"
                    + "           ([username]\n"
                    + "           ,[password])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(2, pass);
            stm.setString(1, user);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(loginDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void changePass(String user, String pass) {
        try {
            String sql = "UPDATE [dbo].[login]\n"
                    + "   SET \n"
                    + "      [password] = ?\n"
                    + " WHERE [username] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, pass);
            stm.setString(2, user);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(loginDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<login> getList() {
        try {
            ArrayList<login> list = new ArrayList<>();
            String sql = "SELECT [username]\n"
                    + "      ,[password]\n"
                    + "  FROM [dbo].[login]";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                login l = new login();
                l.setUsername(rs.getString("username"));
                l.setPassword(rs.getString("password"));
                list.add(l);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(loginDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public login getLogin(String username, String pass) {
        try {
            String sql = "SELECT [username]\n"
                    + "      ,[password]\n"
                    + "  FROM [dbo].[login]"
                    + "Where username=? and password=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, pass);
            ResultSet rs = stm.executeQuery();
            login l = new login();
            while (rs.next()) {

                l.setUsername(rs.getString("username"));
                l.setPassword(rs.getString("password"));
            }
            return l;
        } catch (SQLException ex) {
            Logger.getLogger(loginDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean remove(String user) {
        try {
            String sql = "DELETE FROM [dbo].[login]\n"
                    + "      WHERE username = '"+user+"'";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    public login getLogin(String username) {
        try {
            String sql = "SELECT [username]\n"
                    + "      ,[password]\n"
                    + "  FROM [dbo].[login]"
                    + "Where username=? ";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, username);
            ResultSet rs = stm.executeQuery();
            login l = new login();
            while (rs.next()) {
                l.setUsername(rs.getString("username"));
                l.setPassword(rs.getString("password"));
            }
            return l;
        } catch (SQLException ex) {
            Logger.getLogger(loginDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

//    public static void main(String[] args) {
//        loginDAO lDAO = new loginDAO();
//        lDAO.changePass("a", "b");
//        login l = new login();
//        l = lDAO.getLogin("a", "b");
//        System.out.println(l.getUsername());
//    }
}
