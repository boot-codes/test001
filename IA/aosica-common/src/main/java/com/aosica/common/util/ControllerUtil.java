package com.aosica.common.util;

public class ControllerUtil {
    String controller;
    String head;
    String len;
    String type;
    String ackerr;
    String frameNumber;
    String projectId;
    String save;
    String Identification;
    String dataPakcetType;
    String dummyMask;
    String elementCount;
    String channelMask;
    String nIndex;
    String uTimeUs;
    String dataCollectionTime;
    String batteryLevel;
    String status;
    String channel1Data;
    String channel2Data;
    String channel3Data;
    String channel4Data;
    String channel5Data;
    String channel6Data;
    String channel7Data;
    String channel8Data;
    String sum;
    String end;

    public ControllerUtil(String controller) {
        this.controller = controller;
    }

    public String getController() {
        return controller;
    }

    public void setController(String controller) {
        this.controller = controller;
    }

    public String getHead() {
        return getController().substring(0, 2);
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getLen() {
        return getController().substring(2, 4);
    }

    public void setLen(String len) {
        this.len = len;
    }

    public String getType() {
        return getController().substring(4, 6);
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAckerr() {
        return getController().substring(6, 8);
    }

    public void setAckerr(String ackerr) {
        this.ackerr = ackerr;
    }

    public String getFrameNumber() {
        return getController().substring(8, 11);
    }

    public void setFrameNumber(String frameNumber) {
        this.frameNumber = frameNumber;
    }

    public String getProjectId() {
        return getController().substring(11, 19);
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getSave() {
        return getController().substring(19, 27);
    }

    public void setSave(String save) {
        this.save = save;
    }

    public String getIdentification() {
        return getController().substring(27, 39);
    }

    public void setIdentification(String identification) {
        Identification = identification;
    }

    public String getDataPakcetType() {
        return getController().substring(39, 41);
    }

    public void setDataPakcetType(String dataPakcetType) {
        this.dataPakcetType = dataPakcetType;
    }

    public String getDummyMask() {
        return getController().substring(41, 43);
    }

    public void setDummyMask(String dummyMask) {
        this.dummyMask = dummyMask;
    }

    public String getElementCount() {
        return getController().substring(43, 44);
    }

    public void setElementCount(String elementCount) {
        this.elementCount = elementCount;
    }

    public String getChannelMask() {
        return getController().substring(44, 46);
    }

    public void setChannelMask(String channelMask) {
        this.channelMask = channelMask;
    }

    public String getnIndex() {
        return getController().substring(46, 50);
    }

    public void setnIndex(String nIndex) {
        this.nIndex = nIndex;
    }

    public String getuTimeUs() {
        return getController().substring(50, 54);
    }

    public void setuTimeUs(String uTimeUs) {
        this.uTimeUs = uTimeUs;
    }

    public String getDataCollectionTime() {
        return getController().substring(71, 86);
    }

    public void setDataCollectionTime(String dataCollectionTime) {
        this.dataCollectionTime = dataCollectionTime;
    }

    public String getBatteryLevel() {
        return getController().substring(86, 88);
    }

    public void setBatteryLevel(String batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    public String getStatus() {
        return getController().substring(88, 89);
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getChannel1Data() {
        return getController().substring(89, 96);
    }

    public void setChannel1Data(String channel1Data) {
        this.channel1Data = channel1Data;
    }

    public String getChannel2Data() {
        return getController().substring(71, 78);
    }

    public void setChannel2Data(String channel2Data) {
        this.channel2Data = channel2Data;
    }

    public String getChannel3Data() {
        return getController().substring(78, 84);
    }

    public void setChannel3Data(String channel3Data) {
        this.channel3Data = channel3Data;
    }

    public String getChannel4Data() {
        return getController().substring(84, 91);
    }

    public void setChannel4Data(String channel4Data) {
        this.channel4Data = channel4Data;
    }

    public String getChannel5Data() {
        return getController().substring(91, 97);
    }

    public void setChannel5Data(String channel5Data) {
        this.channel5Data = channel5Data;
    }

    public String getChannel6Data() {
        return getController().substring(97, 104);
    }

    public void setChannel6Data(String channel6Data) {
        this.channel6Data = channel6Data;
    }

    public String getChannel7Data() {
        return getController().substring(104, 112);
    }

    public void setChannel7Data(String channel7Data) {
        this.channel7Data = channel7Data;
    }

    public String getChannel8Data() {
        return getController().substring(112, 119);
    }

    public void setChannel8Data(String channel8Data) {
        this.channel8Data = channel8Data;
    }

    public String getSum() {
        return getController().substring(getController().length() - 4, getController().length() - 2);
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public String getEnd() {
        return getController().substring(getController().length() - 2);
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public static void main(String[] args) {
        ControllerUtil machineUtil = new ControllerUtil("2a50118069000000000000000000ee0000000000000026061920030001012606192003000101011000000000000003000101888819200000000003031820080319200000000032ffd6054d543630227412439b23");
        System.out.println(machineUtil.getHead());
        System.out.println(machineUtil.getLen());
        System.out.println(machineUtil.getType());
        System.out.println(machineUtil.getAckerr());
        System.out.println(machineUtil.getFrameNumber());
        System.out.println(machineUtil.getProjectId());
        System.out.println(machineUtil.getSave());
        System.out.println(machineUtil.getIdentification());
        System.out.println(machineUtil.getDataPakcetType());
        System.out.println(machineUtil.getDummyMask());
        System.out.println(machineUtil.getElementCount());
        System.out.println(machineUtil.getChannelMask());
        System.out.println(machineUtil.getnIndex());
        System.out.println(machineUtil.getuTimeUs());
        System.out.println(machineUtil.getDataCollectionTime());
        System.out.println(machineUtil.getBatteryLevel());
        System.out.println(machineUtil.getStatus());
        System.out.println(machineUtil.getChannel1Data());
        System.out.println(machineUtil.getChannel2Data());
        System.out.println(machineUtil.getChannel3Data());
        System.out.println(machineUtil.getChannel4Data());
        System.out.println(machineUtil.getChannel5Data());
        System.out.println(machineUtil.getChannel6Data());
        System.out.println(machineUtil.getChannel7Data());
        System.out.println(machineUtil.getChannel8Data());
        System.out.println(machineUtil.getSum());
        System.out.println(machineUtil.getEnd());
    }

}
