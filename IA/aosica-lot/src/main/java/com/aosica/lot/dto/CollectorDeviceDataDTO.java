package com.aosica.lot.dto;


import com.aosica.lot.util.HexBinUtil;

/**
 * 采集器设备采集的娄据   实体类。
 */
public class CollectorDeviceDataDTO {


    //head
    private String head;
    //len
    private String len;
    //Type
    private String type;
    //AckErr
    private String ackerr;
    //帧号
    private String frameNumber;
    //工程ID
    private String projectId;

    //保留
    private String save;

    //控制器序列号（产品标识+批次+编号）
    private String controllerSeriesNo;

    //DataPakcetType
    private String dataPakcetType;

    //DummyMask
    private String dummyMask;

    //ElementCount
    private String elementCount;

    //ChannelMask
    private String channelMask;

    //nIndex  界面显示的序号
    private String nIndex;

    // uTime_us
    private String uTimeUs;

    //数据采集时间2018-03-28 11：03：29  高位在后，低位在前
    private String dataCollectionTime;

    //电池电量
    private String batteryLevel;

    //Status
    private String status;

    //通道1数据
    private String channel1Data;

    //通道2数据
    private String channel2Data;

    //通道3数据
    private String channel3Data;

    //通道4数据
    private String channel4Data;

    //通道5数据
    private String channel5Data;

    //通道6数据
    private String channel6Data;

    //通道7数据
    private String channel7Data;

    //通道8数据
    private String channel8Data;

    //为Type到Check的累加和的低字节，不包括Check
    private String sum;

    //结束码
    private String end;



    public static CollectorDeviceDataDTO buildObject(String hexString)  {


        CollectorDeviceDataDTO controllerUtil = new CollectorDeviceDataDTO() ;
        controllerUtil.head = hexString.substring(0, 2);
        controllerUtil.len = hexString.substring(2, 4);
        controllerUtil.type = hexString.substring(4, 6) ;
        controllerUtil.ackerr = hexString.substring(6, 8);
        // 帧号
        controllerUtil.frameNumber = hexString.substring(8, 12);
        // 工程id  16
        controllerUtil.projectId = hexString.substring(12, 28);

        // 预留位 16
        controllerUtil.save = hexString.substring(28, 44) ;

        //产品序列号 （产品标识+批次+编号）  16
        controllerUtil.controllerSeriesNo = hexString.substring(44, 60) ;

        //DataPakcetType  1
        controllerUtil.dataPakcetType = hexString.substring(60, 62) ;

        //  1
        controllerUtil.dummyMask = hexString.substring(62, 64) ;

        // 1
        controllerUtil.elementCount = hexString.substring(64, 66) ;

        // 1
        controllerUtil.channelMask = hexString.substring(66, 68) ;

        // 8
        controllerUtil.nIndex = hexString.substring(68, 76) ;

        // 8
        controllerUtil.uTimeUs = hexString.substring(76, 84) ;


        // 数据采集时间  16

        String dataCollectionTime = HexBinUtil.dataAcquisition(HexBinUtil.dataAcquisitionStringInversion(hexString.substring(84, 100)));
        controllerUtil.dataCollectionTime =dataCollectionTime ;

        // 1
        controllerUtil.batteryLevel = HexBinUtil.hexStrToIntegerStr(hexString.substring(100, 102)) ;

        // 1
        controllerUtil.status = HexBinUtil.hexStrToIntegerStr(hexString.substring(102, 104));

        // 8
        controllerUtil.channel1Data = HexBinUtil.hexStrToIntegerStr(hexString.substring(104, 112)) ;

        //8
        controllerUtil.channel2Data = HexBinUtil.hexStrToIntegerStr(hexString.substring(112, 120)) ;

        //8
        controllerUtil.channel3Data = hexString.substring(120, 128) ;

        //8
        controllerUtil.channel4Data = hexString.substring(128, 136) ;

        //8
        controllerUtil.channel5Data = hexString.substring(136, 144);


        controllerUtil.channel6Data = hexString.substring(144, 152);

        //8
        controllerUtil.channel7Data = hexString.substring(152, 160) ;

        //8
        controllerUtil.channel8Data = hexString.substring(160, 168) ;

        //1
        controllerUtil.sum = HexBinUtil.hexStrToIntegerStr(hexString.substring(hexString.length() - 4, hexString.length() - 2));

        //1
        controllerUtil.end = hexString.substring(hexString.length() - 2) ;

        return  controllerUtil ;
    }


    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getLen() {
        return len;
    }

    public void setLen(String len) {
        this.len = len;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAckerr() {
        return ackerr;
    }

    public void setAckerr(String ackerr) {
        this.ackerr = ackerr;
    }

    public String getFrameNumber() {
        return frameNumber;
    }

    public void setFrameNumber(String frameNumber) {
        this.frameNumber = frameNumber;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getSave() {
        return save;
    }

    public void setSave(String save) {
        this.save = save;
    }

    public String getcontrollerSeriesNo() {
        return controllerSeriesNo;
    }

    public void setcontrollerSeriesNo(String controllerSeriesNo) {
        this.controllerSeriesNo = controllerSeriesNo;
    }

    public String getDataPakcetType() {
        return dataPakcetType;
    }

    public void setDataPakcetType(String dataPakcetType) {
        this.dataPakcetType = dataPakcetType;
    }

    public String getDummyMask() {
        return dummyMask;
    }

    public void setDummyMask(String dummyMask) {
        this.dummyMask = dummyMask;
    }

    public String getElementCount() {
        return elementCount;
    }

    public void setElementCount(String elementCount) {
        this.elementCount = elementCount;
    }

    public String getChannelMask() {
        return channelMask;
    }

    public void setChannelMask(String channelMask) {
        this.channelMask = channelMask;
    }

    public String getnIndex() {
        return nIndex;
    }

    public void setnIndex(String nIndex) {
        this.nIndex = nIndex;
    }

    public String getuTimeUs() {
        return uTimeUs;
    }

    public void setuTimeUs(String uTimeUs) {
        this.uTimeUs = uTimeUs;
    }

    public String getDataCollectionTime() {
        return dataCollectionTime;
    }

    public void setDataCollectionTime(String dataCollectionTime) {
        this.dataCollectionTime = dataCollectionTime;
    }

    public String getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(String batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getChannel1Data() {
        return channel1Data;
    }

    public void setChannel1Data(String channel1Data) {
        this.channel1Data = channel1Data;
    }

    public String getChannel2Data() {
        return channel2Data;
    }

    public void setChannel2Data(String channel2Data) {
        this.channel2Data = channel2Data;
    }

    public String getChannel3Data() {
        return channel3Data;
    }

    public void setChannel3Data(String channel3Data) {
        this.channel3Data = channel3Data;
    }

    public String getChannel4Data() {
        return channel4Data;
    }

    public void setChannel4Data(String channel4Data) {
        this.channel4Data = channel4Data;
    }

    public String getChannel5Data() {
        return channel5Data;
    }

    public void setChannel5Data(String channel5Data) {
        this.channel5Data = channel5Data;
    }

    public String getChannel6Data() {
        return channel6Data;
    }

    public void setChannel6Data(String channel6Data) {
        this.channel6Data = channel6Data;
    }

    public String getChannel7Data() {
        return channel7Data;
    }

    public void setChannel7Data(String channel7Data) {
        this.channel7Data = channel7Data;
    }

    public String getChannel8Data() {
        return channel8Data;
    }

    public void setChannel8Data(String channel8Data) {
        this.channel8Data = channel8Data;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }



    @Override
    public String toString() {
        return "CollectorDevice{" +
                " head='" + head + '\'' +
                ", len='" + len + '\'' +
                ", type='" + type + '\'' +
                ", ackerr='" + ackerr + '\'' +
                ", frameNumber='" + frameNumber + '\'' +
                ", projectId='" + projectId + '\'' +
                ", save='" + save + '\'' +
                ", controllerSeriesNo='" + controllerSeriesNo + '\'' +
                ", dataPakcetType='" + dataPakcetType + '\'' +
                ", dummyMask='" + dummyMask + '\'' +
                ", elementCount='" + elementCount + '\'' +
                ", channelMask='" + channelMask + '\'' +
                ", nIndex='" + nIndex + '\'' +
                ", uTimeUs='" + uTimeUs + '\'' +
                ", dataCollectionTime='" + dataCollectionTime + '\'' +
                ", batteryLevel='" + batteryLevel + '\'' +
                ", status='" + status + '\'' +
                ", channel1Data='" + channel1Data + '\'' +
                ", channel2Data='" + channel2Data + '\'' +
                ", channel3Data='" + channel3Data + '\'' +
                ", channel4Data='" + channel4Data + '\'' +
                ", channel5Data='" + channel5Data + '\'' +
                ", channel6Data='" + channel6Data + '\'' +
                ", channel7Data='" + channel7Data + '\'' +
                ", channel8Data='" + channel8Data + '\'' +
                ", sum='" + sum + '\'' +
                ", end='" + end + '\'' +
                '}';
    }
}
