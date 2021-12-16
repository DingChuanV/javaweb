//package com.hz.util;
//
//import java.sql.*;
//
//public class NewsDao {
//
//    public void getNewsList(){
//
//        Connection connection=null;
//        PreparedStatement stmt=null;
//        ResultSet rs=null;
//
//        String driver = ConfigManager.getInstance().getString("driverClassName");
//        String url = ConfigManager.getInstance().getString("url");
//        String username = ConfigManager.getInstance().getString("username");
//        String password = ConfigManager.getInstance().getString("password");
//
//        try {
//            Class.forName(driver);
//            connection = DriverManager.getConnection(url,username,password);
//            String sql = "select*from news_detail";
//            stmt = connection.prepareStatement(sql);
//            rs = stmt.executeQuery();
//
//            while (rs.next()) {
//                int id = rs.getInt("id");
//                String title = rs.getString("title");
//                String summary = rs.getString("summary");
//                String content = rs.getString("content");
//                String author = rs.getString("author");
//                Timestamp time = rs.getTimestamp("createdate");
//                System.out.println(id + "\t" + title + "\t" + summary + "\t" + content + "\t" + author + "\t" + time);
//            }
//
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (rs != null) {
//                    rs.close();
//                }
//                if (stmt != null) {
//                    stmt.close();
//                }
//                if (connection != null) {
//                    connection.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//
//    }
//    public static void main(String[] args) throws SQLException {
//        NewsDao NewsDao = new NewsDao();
//        NewsDao.getNewsList();
//    }
//}
//
