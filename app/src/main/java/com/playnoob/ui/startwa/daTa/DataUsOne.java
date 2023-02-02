package com.playnoob.ui.startwa.daTa;

public class DataUsOne {
    private String gaid;
    private String apsId;
    private String adb;
    private String bat;

    public String getGaid() {
        return gaid;
    }

    public void setGaid(String gaid) {
        this.gaid = gaid;
    }

    public String getApsId() {
        return apsId;
    }

    public void setApsId(String apsId) {
        this.apsId = apsId;
    }

    public String getAdb() {
        return adb;
    }

    public void setAdb(String adb) {
        this.adb = adb;
    }

    public String getBat() {
        return bat;
    }

    public void setBat(String bat) {
        this.bat = bat;
    }

    public String getDateUse(){
        return "?ffdsssdcccv=" + getGaid() + "&ffdsewed=" +getApsId() + "&ffdaasaasa=" +getAdb() + "&ffffvbnmmmhf=" + getBat();
    }
}
