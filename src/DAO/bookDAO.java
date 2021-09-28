/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.book;
import model.author;
import model.category;

/**
 *
 * @author hoand
 */
public class bookDAO extends DBContext {

    public boolean remove(int id) {
        try {
            String sql = "DELETE FROM [dbo].[books]\n"
                    + "      WHERE  [BookID] Like ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            stm.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(bookDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public ArrayList<book> getAllbookByAuthorandCate(int author, int cate) {
        try {
            ArrayList<book> list = new ArrayList<>();
            String sql = "SELECT [BookID]\n"
                    + "      ,[bookName]\n"
                    + "      ,[quantity]\n"
                    + "      ,a.authorId\n"
                    + "	  ,a.[name] as authorName\n"
                    + "      ,c.[cateId]\n"
                    + "	  ,c.[CateName]\n"
                    + "  FROM [dbo].[books] b JOIN authors a on b.authorId = a.authorID \n"
                    + "  JOIN category c on b.cateId=c.CateId Where a.[authorId] = ? and c.[cateId] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, author);
            stm.setInt(2, cate);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                book b = new book();
                b.setId(rs.getInt("BookID"));
                b.setName(rs.getString("bookName"));
                b.setQuantity(rs.getInt("quantity"));

                author a = new author();
                a.setAuthorID(rs.getInt("authorId"));
                a.setAuthorName(rs.getString("authorName"));
                b.setAuthor(a);

                category c = new category();
                c.setCateId(rs.getInt("cateId"));
                c.setCateName(rs.getString("cateName"));
                b.setCate(c);
                list.add(b);

            }
            return list;

        } catch (SQLException ex) {
            Logger.getLogger(bookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public book getAllbookByID(int id) {
        try {

            String sql = "SELECT [BookID]\n"
                    + "      ,[bookName]\n"
                    + "      ,[quantity]\n"
                    + "      ,a.authorId\n"
                    + "	  ,a.[name] as authorName\n"
                    + "      ,c.[cateId]\n"
                    + "	  ,c.[CateName]\n"
                    + "  FROM [dbo].[books] b JOIN authors a on b.authorId = a.authorID \n"
                    + "  JOIN category c on b.cateId=c.CateId Where [BookID] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                book b = new book();
                b.setId(rs.getInt("BookID"));
                b.setName(rs.getString("bookName"));
                b.setQuantity(rs.getInt("quantity"));

                author a = new author();
                a.setAuthorID(rs.getInt("authorId"));
                a.setAuthorName(rs.getString("authorName"));
                b.setAuthor(a);

                category c = new category();
                c.setCateId(rs.getInt("cateId"));
                c.setCateName(rs.getString("cateName"));
                b.setCate(c);
                return b;

            }
        } catch (SQLException ex) {
            Logger.getLogger(bookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<book> getAllbookByName(String txt) {
        try {
            ArrayList<book> list = new ArrayList<>();
            String sql = "SELECT [BookID]\n"
                    + "      ,[bookName]\n"
                    + "      ,[quantity]\n"
                    + "      ,a.authorId\n"
                    + "	  ,a.[name] as authorName\n"
                    + "      ,c.[cateId]\n"
                    + "	  ,c.[CateName]\n"
                    + "  FROM [dbo].[books] b JOIN authors a on b.authorId = a.authorID \n"
                    + "  JOIN category c on b.cateId=c.CateId Where [bookName] Like '%" + txt + "%'";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                book b = new book();
                b.setId(rs.getInt("BookID"));
                b.setName(rs.getString("bookName"));
                b.setQuantity(rs.getInt("quantity"));

                author a = new author();
                a.setAuthorID(rs.getInt("authorId"));
                a.setAuthorName(rs.getString("authorName"));
                b.setAuthor(a);

                category c = new category();
                c.setCateId(rs.getInt("cateId"));
                c.setCateName(rs.getString("cateName"));
                b.setCate(c);
                list.add(b);

            }
            return list;

        } catch (SQLException ex) {
            Logger.getLogger(bookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<book> getAllbookByAuthor(int author) {
        try {
            ArrayList<book> list = new ArrayList<>();
            String sql = "SELECT [BookID]\n"
                    + "      ,[bookName]\n"
                    + "      ,[quantity]\n"
                    + "      ,a.authorId\n"
                    + "	  ,a.[name] as authorName\n"
                    + "      ,c.[cateId]\n"
                    + "	  ,c.[CateName]\n"
                    + "  FROM [dbo].[books] b JOIN authors a on b.authorId = a.authorID \n"
                    + "  JOIN category c on b.cateId=c.CateId Where a.[authorId] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, author);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                book b = new book();
                b.setId(rs.getInt("BookID"));
                b.setName(rs.getString("bookName"));
                b.setQuantity(rs.getInt("quantity"));

                author a = new author();
                a.setAuthorID(rs.getInt("authorId"));
                a.setAuthorName(rs.getString("authorName"));
                b.setAuthor(a);

                category c = new category();
                c.setCateId(rs.getInt("cateId"));
                c.setCateName(rs.getString("cateName"));
                b.setCate(c);
                list.add(b);

            }
            return list;

        } catch (SQLException ex) {
            Logger.getLogger(bookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<book> getAllbookByCate(int cate) {
        try {
            ArrayList<book> list = new ArrayList<>();
            String sql = "SELECT [BookID]\n"
                    + "      ,[bookName]\n"
                    + "      ,[quantity]\n"
                    + "      ,a.authorId\n"
                    + "	  ,a.[name] as authorName\n"
                    + "      ,c.[cateId]\n"
                    + "	  ,c.[CateName]\n"
                    + "  FROM [dbo].[books] b JOIN authors a on b.authorId = a.authorID \n"
                    + "  JOIN category c on b.cateId=c.CateId Where c.[cateId] =  ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, cate);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                book b = new book();
                b.setId(rs.getInt("BookID"));
                b.setName(rs.getString("bookName"));
                b.setQuantity(rs.getInt("quantity"));

                author a = new author();
                a.setAuthorID(rs.getInt("authorId"));
                a.setAuthorName(rs.getString("authorName"));
                b.setAuthor(a);

                category c = new category();
                c.setCateId(rs.getInt("cateId"));
                c.setCateName(rs.getString("cateName"));
                b.setCate(c);
                list.add(b);

            }
            return list;

        } catch (SQLException ex) {
            Logger.getLogger(bookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<book> getAllbook() {
        try {
            ArrayList<book> list = new ArrayList<>();
            String sql = "SELECT [BookID]\n"
                    + "      ,[bookName]\n"
                    + "      ,[quantity]\n"
                    + "      ,a.authorId\n"
                    + "	  ,a.[name] as authorName\n"
                    + "      ,c.[cateId]\n"
                    + "	  ,c.[CateName]\n"
                    + "  FROM [dbo].[books] b JOIN authors a on b.authorId = a.authorID \n"
                    + "  JOIN category c on b.cateId=c.CateId";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                book b = new book();
                b.setId(rs.getInt("BookID"));
                b.setName(rs.getString("bookName"));
                b.setQuantity(rs.getInt("quantity"));

                author a = new author();
                a.setAuthorID(rs.getInt("authorId"));
                a.setAuthorName(rs.getString("authorName"));
                b.setAuthor(a);

                category c = new category();
                c.setCateId(rs.getInt("cateId"));
                c.setCateName(rs.getString("cateName"));
                b.setCate(c);
                list.add(b);

            }
            return list;

        } catch (SQLException ex) {
            Logger.getLogger(bookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void insert(book b) {
        try {
            String sql = "INSERT INTO [dbo].[books]\n"
                    + "           ([bookName]\n"
                    + "           ,[quantity]\n"
                    + "           ,[authorId]\n"
                    + "           ,[cateId])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, b.getName());
            stm.setInt(2, b.getQuantity());
            stm.setInt(3, b.getAuthor().getAuthorID());
            stm.setInt(4, b.getCate().getCateId());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(bookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
//    public static void main(String[] args) {
//        ArrayList<book> list = new ArrayList<>();
//        bookDAO bDAO = new bookDAO();
//        list = bDAO.getAllbookByAuthorandCate("gió", "Hài kịch");
//        System.out.println(list.size());
//    }
}
