package com.example.wifi.find.apisave;

import com.example.wifi.find.apisave.dto.WifiInfoDto;
import org.json.simple.JSONArray;

import org.json.simple.JSONObject;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class WifiApiJson {
    //API에서 데이터를 호출해와서 DB에 담기전 데이터 담기
    String apiUrl = "http://openapi.seoul.go.kr:8088/4c5357495a7a616c3130307055704a71/json/TbPublicWifiInfo"; //API를 받아올 Url 주소 + 키
    List<WifiInfoDto> datalist = new ArrayList<WifiInfoDto>();

    public List<WifiInfoDto> getWifiApi() throws Exception {
        int maxcnt = TotalCNT();
        int max = maxcnt / 1000;

        for (int i = 0; i <= max; i++) {
            int sp = 1 + (i * 1000);
            int ep = (i + 1) * 1000;

            String plusurl = apiUrl + "/" + sp + "/" + ep;

            StringBuilder urlBuilder = new StringBuilder(plusurl);

            URL url = new URL(urlBuilder.toString());
            System.out.println(url);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-type", "application/xml");
            System.out.println("Response code: " + conn.getResponseCode()); /* 연결자체에 대한 확인이 필요하므로 추가합니다.*/

            BufferedReader rd;
            if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
                rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            } else {
                rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
            }
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = rd.readLine()) != null) {
                sb.append(line);
            }


            rd.close();
            conn.disconnect();

            String result = sb.toString();

            JSONParser jsonparser = new JSONParser();
            JSONObject jsonobj = (JSONObject) jsonparser.parse(result);
            JSONObject channel = (JSONObject) jsonobj.get("TbPublicWifiInfo");
            JSONArray row = (JSONArray) channel.get("row");

            for (int j = 0; j < row.size(); j++) {
                WifiInfoDto wa = new WifiInfoDto();
                JSONObject obj = (JSONObject) row.get(j);

                Object management_no = obj.get("X_SWIFI_MGR_NO"); //관리번호
                Object borough = obj.get("X_SWIFI_WRDOFC"); // 자치구
                Object wifi_name = obj.get("X_SWIFI_MAIN_NM"); // 와이파이명
                Object roadname_address = obj.get("X_SWIFI_ADRES1"); // 도로명주소
                Object detail_name = obj.get("X_SWIFI_ADRES2"); // 상세주소
                Object install_floor = obj.get("X_SWIFI_INSTL_FLOOR"); // 설치위치(층)
                Object install_type = obj.get("X_SWIFI_INSTL_TY"); // 설치유형
                Object install_agency = obj.get("X_SWIFI_INSTL_MBY"); // 설치기관
                Object service_division = obj.get("X_SWIFI_SVC_SE"); // 서비스 구분
                Object net_type = obj.get("X_SWIFI_CMCWR"); // 망종류
                Object year_of_install = obj.get("X_SWIFI_CNSTC_YEAR"); //설치년도
                Object division_io = obj.get("X_SWIFI_INOUT_DOOR"); //실내외구분
                Object connect_environment = obj.get("X_SWIFI_REMARS3"); //wifi접속환경
                Object lat_x = obj.get("LNT"); //X좌표
                Object lnt_y = obj.get("LAT"); //Y좌표
                Object work_date = obj.get("WORK_DTTM"); //작업일자

                wa.setManagementNo((obj.get("X_SWIFI_MGR_NO")).toString());
                wa.setBorough((obj.get("X_SWIFI_WRDOFC")).toString());
                wa.setWifiName((obj.get("X_SWIFI_MAIN_NM")).toString());
                wa.setRoadnameAddress((obj.get("X_SWIFI_ADRES1")).toString());
                wa.setDetailName((obj.get("X_SWIFI_ADRES2")).toString());
                wa.setInstallFloor((obj.get("X_SWIFI_INSTL_FLOOR")).toString());
                wa.setInstallType((obj.get("X_SWIFI_INSTL_TY")).toString());
                wa.setInstallAgency((obj.get("X_SWIFI_INSTL_MBY")).toString());
                wa.setServiceDivision((obj.get("X_SWIFI_SVC_SE")).toString());
                wa.setNetType((obj.get("X_SWIFI_CMCWR")).toString());
                wa.setYearOfInstall((obj.get("X_SWIFI_CNSTC_YEAR")).toString());
                wa.setDivisionIo((obj.get("X_SWIFI_INOUT_DOOR")).toString());
                wa.setConnectEnvironment((obj.get("X_SWIFI_REMARS3")).toString());
                wa.setLatX((obj.get("LAT")).toString());
                wa.setLntY((obj.get("LNT")).toString());
                wa.setWorkDate((obj.get("WORK_DTTM")).toString());
                System.out.println(obj.get("X_SWIFI_MGR_NO"));


                datalist.add(wa);
            }
        }
        return datalist;
    }


    public int TotalCNT() throws IOException, ParseException {  //전체 데이터 수를 알아보기위해 실행
        String apiurl = "http://openapi.seoul.go.kr:8088/4c5357495a7a616c3130307055704a71/json/TbPublicWifiInfo/1/1/";

        StringBuilder urlBuilder = new StringBuilder(apiurl);

        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/xml"); /* 연결자체에 대한 확인이 필요하므로 추가합니다.*/

        BufferedReader rd;
        if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        String result = sb.toString();

        JSONParser jsonparser = new JSONParser();
        JSONObject jsonobj = (JSONObject) jsonparser.parse(result);
        JSONObject channel = (JSONObject) jsonobj.get("TbPublicWifiInfo");
        //총 데이타수 가져오기
        int listcount = Integer.parseInt(String.valueOf(channel.get("list_total_count")));

        return listcount;
    }
}
