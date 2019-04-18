package com.aaa.demo;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * fileName:Game
 * description:
 * author:zz
 * createTime:2019/4/2 17:27
 */
public class Game implements Writable {

    private long killNum;
    private long killedNum;

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeLong(killNum);
        dataOutput.writeLong(killedNum);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        killNum = dataInput.readLong();
        killedNum = dataInput.readLong();
    }

    @Override
    public String toString() {
        return "," +
                  killNum +
                "," + killedNum;
    }

    public Game() {
    }

    public Game(long killNum, long killedNum) {

        this.killNum = killNum;
        this.killedNum = killedNum;
    }

    public long getKillNum() {
        return killNum;
    }

    public void setKillNum(long killNum) {
        this.killNum = killNum;
    }

    public long getKilledNum() {
        return killedNum;
    }

    public void setKilledNum(long killedNum) {
        this.killedNum = killedNum;
    }
}
