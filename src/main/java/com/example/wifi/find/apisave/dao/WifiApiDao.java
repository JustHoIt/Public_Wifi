package com.example.wifi.find.apisave.dao;

import com.example.wifi.find.apisave.dto.WifiInfoDto;
import com.example.wifi.find.apisave.JdbcTemplate;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


import static com.example.wifi.find.apisave.JdbcTemplate.close;

public class WifiApiDao {

    //서울시 공공 Wifi API의 데이터를 받아와 DB_INSERT
    public static boolean insertWifi(List<WifiInfoDto> wa) {
        Connection conn = null;
        PreparedStatement pstm = null;
        int res = 0;
        boolean ok = false;


        try {
            conn = JdbcTemplate.loadConn();
            String sql = " INSERT INTO publicWifi(management_no, borough, wifi_name, roadname_address, detail_name, install_floor, install_type, install_agency, service_division, net_type, year_of_install, " +
                    " division_io, connect_environment, lat, lnt, work_date) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
            pstm = conn.prepareStatement(sql);

            for (int i = 0; i < wa.size(); i++) {
                WifiInfoDto str = wa.get(i);

                pstm.setString(1, str.getManagementNo());
                pstm.setString(2, str.getBorough());
                pstm.setString(3, str.getWifiName());
                pstm.setString(4, str.getRoadnameAddress());
                pstm.setString(5, str.getDetailName());
                pstm.setString(6, str.getInstallFloor());
                pstm.setString(7, str.getInstallType());
                pstm.setString(8, str.getInstallAgency());
                pstm.setString(9, str.getServiceDivision());
                pstm.setString(10, str.getNetType());
                pstm.setString(11, str.getYearOfInstall());
                pstm.setString(12, str.getDivisionIo());
                pstm.setString(13, str.getConnectEnvironment());
                pstm.setString(14, str.getLntY());
                pstm.setString(15, str.getLatX());
                pstm.setString(16, str.getWorkDate());
                res = pstm.executeUpdate();
            }
        } catch (Exception e) {
            System.out.println("wifiAPI_INSERT_3 or 4 Err@@@");
            e.printStackTrace();
        } finally {
            System.out.println("wifiAPI_INSERT_Success!!!");
            close(pstm, conn);
        }
        return ok;
    }

        //내 근처 와이파이 출력 DB_SELECT(distance)
    public List<WifiInfoDto> nearWifi(String lat, String lnt) {
        List<WifiInfoDto> wifilist = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = JdbcTemplate.loadConn();
                // 내 위치와 가까운 와이파이 거리 20 개 출력 및 distance 거리계산
            String sql = " SELECT ROUND((6371 * acos (cos(radians(" + lat + ")) * cos(radians(lat)) "
                    + " * cos (radians (lnt) - radians(" + lnt + "))  + sin(radians(" + lat + ")) "
                    + " * sin (radians (lat)))), 4) AS distance , * "
                    + " FROM publicWifi "
                    + " ORDER BY distance "
                    + " ASC limit 20 ; ";

            pstm = conn.prepareStatement(sql);

            rs = pstm.executeQuery();
            WifiInfoDto wd = null;
            while (rs.next()) {
                wd = new WifiInfoDto();
                wd.setDistance(rs.getString("distance"));
                wd.setManagementNo(rs.getString("management_no"));
                wd.setBorough(rs.getString("borough"));
                wd.setWifiName(rs.getString("wifi_name"));
                wd.setRoadnameAddress(rs.getString("roadname_address"));
                wd.setDetailName(rs.getString("detail_name"));
                wd.setInstallFloor(rs.getString("install_floor"));
                wd.setInstallType(rs.getString("install_type"));
                wd.setInstallAgency(rs.getString("install_agency"));
                wd.setServiceDivision(rs.getString("service_division"));
                wd.setNetType(rs.getString("net_type"));
                wd.setYearOfInstall(rs.getString("year_of_install"));
                wd.setDivisionIo(rs.getString("division_io"));
                wd.setConnectEnvironment(rs.getString("connect_environment"));
                wd.setLatX(rs.getString("lat"));
                wd.setLntY(rs.getString("lnt"));
                wd.setWorkDate(rs.getString("work_date"));
                wifilist.add(wd);
                System.out.println("SELECT_DATA : " + rs.getString("management_no"));

            }
        } catch (SQLException e) {
            System.out.println("nearWifiSelect_3 or 4 Err@@@");
            e.printStackTrace();
        } finally {
            System.out.println("nearWifiSelect_Success!!!");
            close(pstm, conn);
        }
        return wifilist;
    }

}


