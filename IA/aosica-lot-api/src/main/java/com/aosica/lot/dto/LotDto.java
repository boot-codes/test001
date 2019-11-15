package com.aosica.lot.dto;



public class LotDto {

    private Long id ;
    private String deviceName ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    @Override
    public String toString() {
        return "LotDto{" +
                "id=" + id +
                ", deviceName='" + deviceName + '\'' +
                '}';
    }
}
