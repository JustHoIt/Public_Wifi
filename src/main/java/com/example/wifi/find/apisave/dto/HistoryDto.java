package com.example.wifi.find.apisave.dto;

//Wifi History DTO
public class HistoryDto {
    private String searchLatx;
    private String searchLnty;
    private String searchTime;
    //(---------------------------------------------------------------------------------------------------------)//

    public HistoryDto(String searchLatx, String searchLnty,
                      String searchTime) {
        this.searchLatx = searchLatx;
        this.searchLnty = searchLnty;
        this.searchTime = searchTime;
    }

    public HistoryDto() {

    }

    //(---------------------------------------------------------------------------------------------------------)//


    public String getSearchLatx() {
        return searchLatx;
    }

    public void setSearchLatx(String searchLatx) {
        this.searchLatx = searchLatx;
    }

    public String getSearchLnty() {
        return searchLnty;
    }

    public void setSearchLnty(String searchLnty) {
        this.searchLnty = searchLnty;
    }

    public String getSearchTime() {
        return searchTime;
    }

    public void setSearchTime(String searchTime) {
        this.searchTime = searchTime;
    }
}