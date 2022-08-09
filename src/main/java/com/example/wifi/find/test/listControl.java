package com.example.wifi.find.test;

import com.example.wifi.find.apisave.dao.WifiApiDao;
import com.example.wifi.find.apisave.dto.WifiInfoDto;

import java.util.ArrayList;
import java.util.List;

public class listControl {

    public static void main(String[] args) {

        //@@@@@ DB distance(lat,lnt) SELECT TEST @@@@@@@
        WifiApiDao wd = new WifiApiDao();
        wd.nearWifi("37.6137082","127.0600126");
        List<WifiInfoDto> wlist = new ArrayList<>();
        String arr[] = new String[wlist.size()];
        for (int i = 0; i < wlist.size(); i++) {
            arr[i] = String.valueOf(wlist.get(i));

        }

    }


}
