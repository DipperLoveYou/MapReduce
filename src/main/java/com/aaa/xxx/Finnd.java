package com.aaa.xxx;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class Finnd implements WritableComparable<Finnd> {

    private  int  findId;
    private    Double  findIden;


    @Override
    public int compareTo(Finnd o) {
        if (this.findId>o.findId){
            return 1;
        }else  if(this.findId<o.findId){
            return -1;
        }
        return 0;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(findId);
        dataOutput.writeDouble(findIden);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        findId = dataInput.readInt();
        findIden = dataInput.readDouble();
    }

    public Finnd() {
        super();
    }

    public Finnd(int findId, Double findIden) {
        this.findId = findId;
        this.findIden = findIden;
    }

    @Override
    public String toString() {
        return "Finnd{" +
                "findId=" + findId +
                ", findIden=" + findIden +
                '}';
    }

    public int getFindId() {
        return findId;
    }

    public void setFindId(int findId) {
        this.findId = findId;
    }

    public Double getFindIden() {
        return findIden;
    }

    public void setFindIden(Double findIden) {
        this.findIden = findIden;
    }
}
