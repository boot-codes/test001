package com.aosica.common.util;

public class WeatherUtil {
    String machines;
    Double range;
    Double temperature;
    Double centigrade;
    Double rh;
    Double hPa;

    public WeatherUtil(String machines) {
        this.machines = machines;
    }

    public String getMachines() {
        return machines;
    }

    public void setMachines(String machines) {
        this.machines = machines;
    }

    public Double getRange() {
//        BigInteger bigInteger = new BigInteger(machines.substring(6, 10), 16);
//        return (bigInteger.divide(new BigInteger("10"))).doubleValue();
        Integer integer = Integer.valueOf(machines.substring(6, 10), 16);
        return integer / 10.0;
    }

    public void setRange(Double range) {
        this.range = range;
    }

    public Double getTemperature() {
        Integer integer = Integer.valueOf(machines.substring(10, 14), 16);
        return integer / 10.0;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getCentigrade() {
        Integer integer = Integer.valueOf(machines.substring(14, 18), 16);
        return integer / 10.0;
    }

    public void setCentigrade(Double centigrade) {
        this.centigrade = centigrade;
    }

    public Double getRh() {
        Integer integer = Integer.valueOf(machines.substring(18, 22), 16);
        return integer / 10.0;
    }

    public void setRh(Double rh) {
        this.rh = rh;
    }

    public Double gethPa() {
        Integer integer = Integer.valueOf(machines.substring(22, 26), 16);
        return integer / 10.0;
    }

    public void sethPa(Double hPa) {
        this.hPa = hPa;
    }

    public static void main(String[] args) {
        WeatherUtil machineUtil = new WeatherUtil("01031400030ADF010B02F523DA0000000000000000000065F2");
        System.out.println(machineUtil.getRange());
        System.out.println(machineUtil.getTemperature());
        System.out.println(machineUtil.getCentigrade());
        System.out.println(machineUtil.getRh());
        System.out.println(machineUtil.gethPa());
    }

}
