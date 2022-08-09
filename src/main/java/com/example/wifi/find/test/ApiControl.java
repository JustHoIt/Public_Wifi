package com.example.wifi.find.test;

import com.example.wifi.find.apisave.dao.WifiApiDao;
import com.example.wifi.find.apisave.WifiApiJson;
import com.example.wifi.find.apisave.dto.WifiInfoDto;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.List;

public class ApiControl  {
    //@@@@@ API DB INSERT TEST    @@@@@@@
    public void load() {
        WifiApiJson vlist = new WifiApiJson();
        List<WifiInfoDto> wa;
        try {
            wa = vlist.getWifiApi();
            WifiApiDao waDao = new WifiApiDao();
            waDao.insertWifi(wa);

        } catch (IOException e) {
                e.printStackTrace();
        } catch (ParseException e) {
                e.printStackTrace();
        } catch (Exception e) {
                e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ApiControl ac = new ApiControl();
        ac.load();

    }

}
