package com.example.wifi.find.apisave.dao;

import com.example.wifi.find.apisave.dto.HistoryDto;
import com.example.wifi.find.apisave.JdbcTemplate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.example.wifi.find.apisave.JdbcTemplate.close;

public class HistoryDao {

    //홈페이지에서 검색한 데이터를 기록으로 남기는 DB_INSERT
    public void insertHistory(String lat, String lnt, String time) throws SQLException {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        int res = 0;

        try {
            conn = JdbcTemplate.loadConn();

            String sql = " INSERT INTO history (" +
                    "  search_lat, search_lnt, search_time) " +
                    " VALUES( ?, ?, ?) ";
            pstm = conn.prepareStatement(sql);


            pstm.setString(1, lat);
            pstm.setString(2, lnt);
            pstm.setString(3, time);
            System.out.println("INSERT DATA : " + lat + ", " + lnt + ", " + time);

            res = pstm.executeUpdate();

            if (res > 0) {
                System.out.println("historyInsert_Success!!!");
            } else {
                System.out.println("historyInsert_Fail@@@");
            }


        } catch (SQLException e) {
            System.out.println("historyInsert_3 or 4 Err@@@");
            e.printStackTrace();
        } finally {
            close(pstm, conn);
        }
    }

    //홈페이지에서 검색했던 기록을 삭제하는  DB_DELETE
    public void deleteHistory(String search_time) throws SQLException {

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        int res = 0;


        try {
            conn = JdbcTemplate.loadConn();

            String sql = " DELETE " +
                    " FROM history" +
                    " WHERE search_time = ? ; ";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, search_time);
            System.out.println("DELETE_DATA : " + search_time);

            res = pstm.executeUpdate();

            if (res > 0) {
                System.out.println("historyDelete_Success");
            } else {
                System.out.println("historyDelete_Fail");
            }


        } catch (SQLException e) {
            System.out.println("historyDelete_3 or 4 Err");
            e.printStackTrace();
        } finally {
            close(pstm, conn);
        }
    }


    //홈페이지에서 검색했던 기록을 보여주는  DB_SELECT
    public List<HistoryDto> selecthistory() {
        List<HistoryDto> historylist = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstm = null;
        int res = 0;
        ResultSet rs = null;

        try {
            conn = JdbcTemplate.loadConn();
            String sql = " SELECT *  FROM history; ";
            pstm = conn.prepareStatement(sql);

            rs = pstm.executeQuery();
            HistoryDto hd = null;

            while (rs.next()) {
                hd = new HistoryDto();
                hd.setSearchLatx(rs.getString("search_lat"));
                hd.setSearchLnty(rs.getString("search_lnt"));
                hd.setSearchTime(rs.getString("search_time"));
                historylist.add(hd);
                System.out.println("SELECT_DATA : " + rs.getString("search_time"));
            }
        } catch (SQLException e) {
            System.out.println("historySelect_3 or 4 Err@@@");
            throw new RuntimeException(e);
        } finally {
            System.out.println("historySelect_Success!!!");
            close(pstm, conn);
        }
        return historylist;
    }
}