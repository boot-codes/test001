package com.aosica.lot.entity;


/**
 * 网络控制器  实体类
 */
public class NetworkControllerDevice {


    private String machine;
    private String head;
    private String len;
    private String type;
    private String ackerr;
    private String frameNumber;
    private String projectId;
    private String save;
    private String Identification;
    private String serialNumber;
    private String networkRegistry;
    private String save2;
    private String productIdentification;
    private String networkId;
    private String step;
    private String channelNum;
    private String hardwareVersion;
    private String firmwareVersion;
    private String chipIdA;
    private String chipIdB;
    private String chipIdC;
    private String chipIdD;
    private String sum;
    private String end;

    public NetworkControllerDevice(String machine) {
        this.machine = machine;
    }

    public NetworkControllerDevice() {
    }

    public String getMachine() {
        return machine;
    }

    public void setMachine(String machine) {
        this.machine = machine;
    }

    public String getHead() {
        return getMachine().substring(0, 2);
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getLen() {
        return getMachine().substring(2, 4);
    }

    public void setLen(String len) {
        this.len = len;
    }

    public String getType() {
        return getMachine().substring(4, 6);
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAckerr() {
        return getMachine().substring(6, 8);
    }

    public void setAckerr(String ackerr) {
        this.ackerr = ackerr;
    }


    public String getFrameNumber() {
        return getMachine().substring(8, 11);
    }

    public void setFrameNumber(String frameNumber) {
        this.frameNumber = frameNumber;
    }

    public String getProjectId() {
        return getMachine().substring(11, 19);
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getSave() {
        return getMachine().substring(19, 27);
    }

    public void setSave(String save) {
        this.save = save;
    }

    public String getIdentification() {
        return getMachine().substring(27, 39);
    }

    public void setIdentification(String identification) {
        Identification = identification;
    }

    public String getSerialNumber() {
        return getMachine().substring(39, 51);
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getNetworkRegistry() {
        return machine.substring(machine.length() - 62, machine.length() - 57);
    }

    public void setNetworkRegistry(String networkRegistry) {
        this.networkRegistry = networkRegistry;
    }

    public String getSave2() {
        return machine.substring(machine.length() - 57, machine.length() - 53);
    }

    public void setSave2(String save2) {
        this.save2 = save2;
    }

    public String getProductIdentification() {
        return machine.substring(machine.length() - 53, machine.length() - 49);
    }

    public void setProductIdentification(String productIdentification) {
        this.productIdentification = productIdentification;
    }

    public String getNetworkId() {
        return machine.substring(machine.length() - 49, machine.length() - 42);
    }

    public void setNetworkId(String networkId) {
        this.networkId = networkId;
    }

    public String getStep() {
        return machine.substring(machine.length() - 42, machine.length() - 40);
    }

    public void setStep(String step) {
        this.step = step;
    }

    public String getChannelNum() {
        return machine.substring(machine.length() - 40, machine.length() - 38);
    }

    public void setChannelNum(String channelNum) {
        this.channelNum = channelNum;
    }

    public String getHardwareVersion() {
        return machine.substring(machine.length() - 38, machine.length() - 34);
    }

    public void setHardwareVersion(String hardwareVersion) {
        this.hardwareVersion = hardwareVersion;
    }

    public String getFirmwareVersion() {
        return machine.substring(machine.length() - 34, machine.length() - 30);
    }

    public void setFirmwareVersion(String firmwareVersion) {
        this.firmwareVersion = firmwareVersion;
    }

    public String getChipIdA() {
        return machine.substring(machine.length() - 30, machine.length() - 26);
    }

    public void setChipIdA(String chipIdA) {
        this.chipIdA = chipIdA;
    }

    public String getChipIdB() {
        return machine.substring(machine.length() - 26, machine.length() - 19);
    }

    public void setChipIdB(String chipIdB) {
        this.chipIdB = chipIdB;
    }

    public String getChipIdC() {
        return machine.substring(machine.length() - 19, machine.length() - 11);
    }

    public void setChipIdC(String chipIdC) {
        this.chipIdC = chipIdC;
    }

    public String getChipIdD() {
        return machine.substring(machine.length() - 11, machine.length() - 4);
    }

    public void setChipIdD(String chipIdD) {
        this.chipIdD = chipIdD;
    }

    public String getSum() {
        return machine.substring(machine.length() - 4, machine.length() - 2);
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public String getEnd() {
        return machine.substring(machine.length() - 2);
    }

    public void setEnd(String end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "MachineUtil{" +
                "machine='" + machine + '\'' +
                ", head='" + head + '\'' +
                ", len='" + len + '\'' +
                ", type='" + type + '\'' +
                ", ackerr='" + ackerr + '\'' +
                '}';
    }

    public static void main(String[] args) {
        NetworkControllerDevice machineUtil = new NetworkControllerDevice("2a50118069000000000000000000ee0000000000000026061920030001012606192003000101011000000000000003000101888819200000000003031820080319200000000032ffd6054d543630227412439b23");
        System.out.println(machineUtil.getHead());
        System.out.println(machineUtil.getLen());
        System.out.println(machineUtil.getType());
        System.out.println(machineUtil.getAckerr());
        System.out.println(machineUtil.getFrameNumber());
        System.out.println(machineUtil.getProjectId());
        System.out.println(machineUtil.getSave());
        System.out.println(machineUtil.getIdentification());
        System.out.println(machineUtil.getSerialNumber());
        System.out.println(machineUtil.getNetworkRegistry());
        System.out.println(machineUtil.getSave2());
        System.out.println(machineUtil.getProductIdentification());
        System.out.println(machineUtil.getNetworkId());
        System.out.println(machineUtil.getStep());
        System.out.println(machineUtil.getChannelNum());
        System.out.println(machineUtil.getHardwareVersion());
        System.out.println(machineUtil.getFirmwareVersion());
        System.out.println(machineUtil.getChipIdA());
        System.out.println(machineUtil.getChipIdB());
        System.out.println(machineUtil.getChipIdC());
        System.out.println(machineUtil.getChipIdD());
        System.out.println(machineUtil.getSum());
        System.out.println(machineUtil.getEnd());
    }

}
