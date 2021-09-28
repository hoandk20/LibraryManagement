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
import model.book;
import model.borrow;
import model.category;

/**
 *
 * @author hoand
 */
public class borrowDAO extends DBContext {

    public boolean remove(int id) {
        try {
            String sql = "DELETE FROM [dbo].[borrowDetail]\n"
                    + "      WHERE  [borrowId] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            stm.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    public int GetTotalBorrowbook(int Bookid) {
        try {
            String sql = "Select SUM(quantity) as total from borrowDetail Where bookId=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, Bookid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return rs.getInt("total");
            }
        } catch (SQLException ex) {
            Logger.getLogger(borrowDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    public ArrayList<borrow> getAllbook() {
        try {
            ArrayList<borrow> list = new ArrayList<>();
            String sql = "SELECT [borrowId]\n"
                    + "      ,[bookId]\n"
                    + "      ,[quantity]\n"
                    + "      ,[studentName]\n"
                    + "      ,[studentClass]\n"
                    + "      ,[studentId]\n"
                    + "      ,[timeGet]\n"
                    + "      ,[status]\n"
                    + "  FROM [dbo].[borrowDetail]";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                borrow b = new borrow();
                b.setId(rs.getInt("borrowId"));
                b.setBookId(rs.getInt("bookId"));
                b.setQuantity(rs.getInt("quantity"));
                b.setStudentName(rs.getString("studentName"));
                b.setStudentClass(rs.getString("studentClass"));
                b.setStudentID(rs.getString("studentId"));
                b.setTimeGet(rs.getDate("timeGet"));
                b.setStatus(rs.getBoolean("status"));
                list.add(b);
            }
            return list;

        } catch (SQLException ex) {
            Logger.getLogger(bookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<borrow> getAllbook(String studentName) {
        try {
            ArrayList<borrow> list = new ArrayList<>();
            String sql = "SELECT [borrowId]\n"
                    + "      ,[bookId]\n"
                    + "      ,[quantity]\n"
                    + "      ,[studentName]\n"
                    + "      ,[studentClass]\n"
                    + "      ,[studentId]\n"
                    + "      ,[timeGet]\n"
                    + "      ,[status]\n"
                    + "  FROM [dbo].[borrowDetail] WHERE [studentName] LIKE '%" + studentName + "%'";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                borrow b = new borrow();
                b.setId(rs.getInt("borrowId"));
                b.setBookId(rs.getInt("bookId"));
                b.setQuantity(rs.getInt("quantity"));
                b.setStudentName(rs.getString("studentName"));
                b.setStudentClass(rs.getString("studentClass"));
                b.setStudentID(rs.getString("studentId"));
                b.setTimeGet(rs.getDate("timeGet"));
                b.setStatus(rs.getBoolean("status"));
                list.add(b);
            }
            return list;

        } catch (SQLException ex) {
            Logger.getLogger(bookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<borrow> getAllbookById(String id) {
        try {
            ArrayList<borrow> list = new ArrayList<>();
            String sql = "SELECT [borrowId]\n"
                    + "      ,[bookId]\n"
                    + "      ,[quantity]\n"
                    + "      ,[studentName]\n"
                    + "      ,[studentClass]\n"
                    + "      ,[studentId]\n"
                    + "      ,[timeGet]\n"
                    + "      ,[status]\n"
                    + "  FROM [dbo].[borrowDetail] WHERE [studentId] LIKE '%" + id + "%'";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                borrow b = new borrow();
                b.setId(rs.getInt("borrowId"));
                b.setBookId(rs.getInt("bookId"));
                b.setQuantity(rs.getInt("quantity"));
                b.setStudentName(rs.getString("studentName"));
                b.setStudentClass(rs.getString("studentClass"));
                b.setStudentID(rs.getString("studentId"));
                b.setTimeGet(rs.getDate("timeGet"));
                b.setStatus(rs.getBoolean("status"));
                list.add(b);
            }
            return list;

        } catch (SQLException ex) {
            Logger.getLogger(bookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<borrow> getAllbook(boolean status) {
        try {
            ArrayList<borrow> list = new ArrayList<>();
            String sql = "SELECT [borrowId]\n"
                    + "      ,[bookId]\n"
                    + "      ,[quantity]\n"
                    + "      ,[studentName]\n"
                    + "      ,[studentClass]\n"
                    + "      ,[studentId]\n"
                    + "      ,[timeGet]\n"
                    + "      ,[status]\n"
                    + "  FROM [dbo].[borrowDetail] WHERE [status] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setBoolean(1, status);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                borrow b = new borrow();
                b.setId(rs.getInt("borrowId"));
                b.setBookId(rs.getInt("bookId"));
                b.setQuantity(rs.getInt("quantity"));
                b.setStudentName(rs.getString("studentName"));
                b.setStudentClass(rs.getString("studentClass"));
                b.setStudentID(rs.getString("studentId"));
                b.setTimeGet(rs.getDate("timeGet"));
                b.setStatus(rs.getBoolean("status"));
                list.add(b);
            }
            return list;

        } catch (SQLException ex) {
            Logger.getLogger(bookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void setStatus(int id, boolean status) {
        try {
            String sql = "UPDATE [dbo].[borrowDetail]\n"
                    + "   SET \n"
                    + "      [status] = ?\n"
                    + " WHERE [borrowId] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setBoolean(1, status);
            stm.setInt(2, id);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(borrowDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insert(borrow b) {
        try {
            String sql = "INSERT INTO [dbo].[borrowDetail]\n"
                    + "           ([bookId]\n"
                    + "           ,[quantity]\n"
                    + "           ,[studentName]\n"
                    + "           ,[studentClass]\n"
                    + "           ,[studentId]\n"
                    + "           ,[timeGet]\n"
                    + "           ,[status])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, b.getBookId());
            stm.setInt(2, b.getQuantity());
            stm.setString(3, b.getStudentName());
            stm.setString(4, b.getStudentClass());
            stm.setString(5, b.getStudentID());
            stm.setDate(6, b.getTimeGet());
            stm.setBoolean(7, b.isStatus());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(borrowDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void main(String[] args) {
        borrowDAO bDAO = new borrowDAO();
        bDAO.setStatus(2, true);
    }
}
