package com.example.module_demo.mvp.model.entity;

import com.google.gson.annotations.SerializedName;

public class RegisterResp {

    /**
     * device-name : Gunjans device
     * device-type : 0
     * imsieap :  0310260109789629@nai.epc.mnc260.mcc310.3gppnetwork.org
     * os-type : 0
     * deviceid :  dXJuOmdzbWE6aW1laTozNTI1NjcwNy0wMDQzMjMtMA==
     * messageid : 1
     * method : 3gppAuthentication
     */

    @SerializedName("device-name")
    private String devicename;
    @SerializedName("device-type")
    private int devicetype;
    private String imsieap;
    @SerializedName("os-type")
    private int ostype;
    private String deviceid;
    private int messageid;
    private String method;

    public String getDevicename() {
        return devicename;
    }

    public void setDevicename(String devicename) {
        this.devicename = devicename;
    }

    public int getDevicetype() {
        return devicetype;
    }

    public void setDevicetype(int devicetype) {
        this.devicetype = devicetype;
    }

    public String getImsieap() {
        return imsieap;
    }

    public void setImsieap(String imsieap) {
        this.imsieap = imsieap;
    }

    public int getOstype() {
        return ostype;
    }

    public void setOstype(int ostype) {
        this.ostype = ostype;
    }

    public String getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(String deviceid) {
        this.deviceid = deviceid;
    }

    public int getMessageid() {
        return messageid;
    }

    public void setMessageid(int messageid) {
        this.messageid = messageid;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    @Override
    public String toString() {
        return "RegisterResp{" +
                "devicename='" + devicename + '\'' +
                ", devicetype=" + devicetype +
                ", imsieap='" + imsieap + '\'' +
                ", ostype=" + ostype +
                ", deviceid='" + deviceid + '\'' +
                ", messageid=" + messageid +
                ", method='" + method + '\'' +
                '}';
    }
}
