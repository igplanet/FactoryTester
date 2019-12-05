/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caspercoding;

/**
 *
 * @author oghomwen.aigbedion
 */
public class ProductLineTestReport {
      long correctCnt;      // number of correct products
        long checkedExcCnt;   // number of products which threw a checked exception during verification
        long uncheckedExcCnt; // number of products which threw an unchecked exception during verification
        long otherExcCnt;     // number of products which threw an error during verification

        ProductLineTestReport(long correctCnt, long checkedExcCnt, long uncheckedExcCnt, long otherExcCnt) {
            this.correctCnt = correctCnt;
            this.checkedExcCnt = checkedExcCnt;
            this.uncheckedExcCnt = uncheckedExcCnt;
            this.otherExcCnt = otherExcCnt;
        }

//        @Override
//        public String toString() {
//            return "ProductLineTestReport{" + "correctCnt=" + correctCnt + ", checkedExcCnt=" + checkedExcCnt + ", uncheckedExcCnt=" + uncheckedExcCnt + ", otherExcCnt=" + otherExcCnt + '}';
//        }
        public long getCorrectCnt() {
            return correctCnt;
        }

        public long getCheckedExcCnt() {
            return checkedExcCnt;
        }

        public long getUncheckedExcCnt() {
            return uncheckedExcCnt;
        }

        public long getOtherExcCnt() {
            return otherExcCnt;
        }

    public void setCorrectCnt(long correctCnt) {
        this.correctCnt = correctCnt;
    }

    public void setCheckedExcCnt(long checkedExcCnt) {
        this.checkedExcCnt = checkedExcCnt;
    }

    public void setUncheckedExcCnt(long uncheckedExcCnt) {
        this.uncheckedExcCnt = uncheckedExcCnt;
    }

    public void setOtherExcCnt(long otherExcCnt) {
        this.otherExcCnt = otherExcCnt;
    }

    @Override
    public String toString() {
        return "ProductLineTestReport{" + "correctCnt=" + correctCnt + ", checkedExcCnt=" + checkedExcCnt + ", uncheckedExcCnt=" + uncheckedExcCnt + ", otherExcCnt=" + otherExcCnt + '}';
    }

}
