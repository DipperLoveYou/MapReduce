package com.aaa.score;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * fileName:
 * description:
 * author:zyq
 * createTime: 0:42
 */

    public class Score implements WritableComparable<Score> {

        private int subjectId;
        private double score;


        /**
         * 比较器，按照两个字段进行比较  二次排序
         * @param o
         * @return
         */
        @Override
        public int compareTo(Score o) {
            if(this.subjectId>o.subjectId){
                return 1;
            }else if(this.subjectId<o.subjectId){
                return -1;
            }else{
              return 0;
            }

        }

        /**
         * 序列化
         * @param dataOutput
         * @throws IOException
         */
        @Override
        public void write(DataOutput dataOutput) throws IOException {
            dataOutput.writeInt(subjectId);
            dataOutput.writeDouble(score);
        }

        /**
         * 反序列化
         * @param dataInput
         * @throws IOException
         */
        @Override
        public void readFields(DataInput dataInput) throws IOException {
            subjectId =  dataInput.readInt();
            score = dataInput.readDouble();
        }

        public Score(int subjectId, double score) {
            this.subjectId = subjectId;
            this.score = score;
        }

        public Score() {
        }

        public int getSubjectId() {
            return subjectId;
        }

        public void setSubjectId(int subjectId) {
            this.subjectId = subjectId;
        }

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }

        @Override
        public String toString() {
            return "Score{" +
                    "subjectId=" + subjectId +
                    ", score=" + score +
                    '}';
        }
    }

