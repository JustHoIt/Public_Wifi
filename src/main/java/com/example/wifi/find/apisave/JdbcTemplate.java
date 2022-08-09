package com.example.wifi.find.apisave;

import org.sqlite.SQLiteConfig;

import java.sql.*;

// SQLite DB에 연결하기
public class JdbcTemplate {

    public static Connection loadConn() {
        String DBFileName = "D:\\dev\\Workspace\\sqlite\\TbPublicWifiInfo.db"; //데이터베이스 경로
        Connection conn = null;

        try {

            Class.forName("org.sqlite.JDBC");
            SQLiteConfig config = new SQLiteConfig();
            config.setEncoding(SQLiteConfig.Encoding.UTF8);
            conn = DriverManager.getConnection("jdbc:sqlite:" + DBFileName, config.toProperties());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

//    public static void commit(Connection conn) {
//        try {
//            conn.commit();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void rollback(Connection conn) {
//        try {
//            conn.rollback();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    public static void close(ResultSet rs, PreparedStatement pstm, Connection conn) {
        try {
            rs.close();
            pstm.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(PreparedStatement insert_pstm, Connection conn) {
        try {
            insert_pstm.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
