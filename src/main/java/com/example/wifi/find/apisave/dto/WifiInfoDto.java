package com.example.wifi.find.apisave.dto;

//Wifi Info DTO
public class WifiInfoDto {

    private String distance; //거리
    private String managementNo; // 2.관리번호
    private String borough; // 3.자치구
    private String wifiName; // 4.와이파이 이름
    private String roadnameAddress; // 5.도로명주소
    private String detailName; // 6.상세주소
    private String installFloor; // 7.설치위치(층)
    private String installType; // 8.설치유형
    private String installAgency; // 9.설치기관
    private String serviceDivision; // 10.서비스구분
    private String netType; // 11.망종류
    private String yearOfInstall; // 12.설치년도
    private String divisionIo; // 13.실내외구분
    private String connectEnvironment; // 14.접속환경
    private String latX; // 15.X좌표 위동
    private String lntY; // 16.Y좌표 경도
    private String workDate; // 17.작업일자

    private int listCount;
    //(---------------------------------------------------------------------------------------------------------)//

    public WifiInfoDto(String distance, String managementNo, String borough, String wifiName, String roadnameAddress, String detailName, String installFloor, String installType, String installAgency, String serviceDivision, String netType, String yearOfInstall, String divisionIo, String connectEnvironment, String latX, String lntY, String workDate) {

    }

    public WifiInfoDto() {

    }
    //(---------------------------------------------------------------------------------------------------------)//


    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getManagementNo() {
        return managementNo;
    }

    public void setManagementNo(String managementNo) {
        this.managementNo = managementNo;
    }

    public String getBorough() {
        return borough;
    }

    public void setBorough(String borough) {
        this.borough = borough;
    }

    public String getWifiName() {
        return wifiName;
    }

    public void setWifiName(String wifiName) {
        this.wifiName = wifiName;
    }

    public String getRoadnameAddress() {
        return roadnameAddress;
    }

    public void setRoadnameAddress(String roadnameAddress) {
        this.roadnameAddress = roadnameAddress;
    }

    public String getDetailName() {
        return detailName;
    }

    public void setDetailName(String detailName) {
        this.detailName = detailName;
    }

    public String getInstallFloor() {
        return installFloor;
    }

    public void setInstallFloor(String installFloor) {
        this.installFloor = installFloor;
    }

    public String getInstallType() {
        return installType;
    }

    public void setInstallType(String installType) {
        this.installType = installType;
    }

    public String getInstallAgency() {
        return installAgency;
    }

    public void setInstallAgency(String installAgency) {
        this.installAgency = installAgency;
    }

    public String getServiceDivision() {
        return serviceDivision;
    }

    public void setServiceDivision(String serviceDivision) {
        this.serviceDivision = serviceDivision;
    }

    public String getNetType() {
        return netType;
    }

    public void setNetType(String netType) {
        this.netType = netType;
    }

    public String getYearOfInstall() {
        return yearOfInstall;
    }

    public void setYearOfInstall(String yearOfInstall) {
        this.yearOfInstall = yearOfInstall;
    }

    public String getDivisionIo() {
        return divisionIo;
    }

    public void setDivisionIo(String divisionIo) {
        this.divisionIo = divisionIo;
    }

    public String getConnectEnvironment() {
        return connectEnvironment;
    }

    public void setConnectEnvironment(String connectEnvironment) {
        this.connectEnvironment = connectEnvironment;
    }

    public String getLatX() {
        return latX;
    }

    public void setLatX(String latX) {
        this.latX = latX;
    }

    public String getLntY() {
        return lntY;
    }

    public void setLntY(String lntY) {
        this.lntY = lntY;
    }

    public String getWorkDate() {
        return workDate;
    }

    public void setWorkDate(String workDate) {
        this.workDate = workDate;
    }

    public int getListCount() {
        return listCount;
    }

    public void setListCount(int listCount) {
        this.listCount = listCount;
    }
}



