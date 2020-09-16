package com.cn.beisanproject.modelbean;

import com.zebra.rfid.api3.ACCESS_OPERATION_CODE;
import com.zebra.rfid.api3.ACCESS_OPERATION_STATUS;
import com.zebra.rfid.api3.AccessOperationResult;
import com.zebra.rfid.api3.GEN2V2_OPERATION_CODE;
import com.zebra.rfid.api3.GEN2V2_OPERATION_STATUS;
import com.zebra.rfid.api3.MEMORY_BANK;
import com.zebra.rfid.api3.SYSTEMTIME;
import com.zebra.rfid.api3.SeenTime;
import com.zebra.rfid.api3.TagData;

public class MyTagData extends TagData {
    public com.zebra.rfid.api3.LocationInfo LocationInfo;
//    public com.zebra.rfid.api3.SeenTime SeenTime = new SeenTime();
    public com.zebra.rfid.api3.AccessOperationResult AccessOperationResult;
    String a;
    int b;
    int c;
    int d;
    int e;
    short f;
    short g;
    short h;
    short i;
    short j;
    int k;

    public String getRFIDNUM() {
        return RFIDNUM;
    }

    public void setRFIDNUM(String RFIDNUM) {
        this.RFIDNUM = RFIDNUM;
    }

    String RFIDNUM;
    ACCESS_OPERATION_CODE l;
    GEN2V2_OPERATION_CODE m;
    ACCESS_OPERATION_STATUS n;
    GEN2V2_OPERATION_STATUS o;
    MEMORY_BANK p;
    String q;
    String r;
    int s;
    int t;
//    r2 u;
    SYSTEMTIME v;
    boolean w;
    String x;
    boolean y;

    public MyTagData() {
    }

    public boolean isContainsLocationInfo() {
        return this.w;
    }

    public String getTagID() {
        return this.a;
    }

    public int getTagIDAllocatedSize() {
        return this.b;
    }

    public int getPC() {
        return this.c;
    }

    public int getXPC_W1() {
        return (short)(this.d & '\uffff');
    }

    public int getXPC_W2() {
        return (short)(this.d << 16 & '\uffff');
    }

    public int getCRC() {
        return this.e;
    }

    public short getAntennaID() {
        return this.f;
    }

    public short getPeakRSSI() {
        return this.g;
    }

    public short getPhase() {
        return this.h;
    }

    public short getChannelIndex() {
        return this.i;
    }

    public short getTagSeenCount() {
        return this.j;
    }

    public ACCESS_OPERATION_CODE getOpCode() {
        return this.l;
    }

    public GEN2V2_OPERATION_CODE getG2v2OpCode() {
        return this.m;
    }

    public ACCESS_OPERATION_STATUS getOpStatus() {
        return this.n;
    }

    public GEN2V2_OPERATION_STATUS getG2v2OpStatus() {
        return this.o;
    }

    public MEMORY_BANK getMemoryBank() {
        return this.p;
    }

    public String getG2v2Response() {
        return this.r;
    }

    public String getMemoryBankData() {
        return this.q;
    }

    public int getMemoryBankDataOffset() {
        return this.s;
    }

    public int getMemoryBankDataAllocatedSize() {
        return this.t;
    }

//    public r2 getTagEvent() {
//        return this.u;
//    }

    public SYSTEMTIME getTagEventTimeStamp() {
        return this.v;
    }

    public int getNumberOfWords() {
        return this.k;
    }

    public String getPermaLockData() {
        return this.x;
    }

    public Boolean getBrandIDStatus() {
        return this.y;
    }
}
