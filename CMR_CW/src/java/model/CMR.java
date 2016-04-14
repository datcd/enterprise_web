/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author TTNNTT
 */
public class CMR {
    public int CMRid;
    public int cId;
    public int studentCount;
    public float meancw1;
    public float meancw2;
    public float meanexam;
    public float mediancw1;
    public float mediancw2;
    public float medianexam;
    public int distributioncw1type1;
    public int distributioncw2type1;
    public int distributionexamtype1;
    public String status;

    public int getCMRid() {
        return CMRid;
    }

    public void setCMRid(int CMRid) {
        this.CMRid = CMRid;
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public int getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(int studentCount) {
        this.studentCount = studentCount;
    }

    public float getMeancw1() {
        return meancw1;
    }

    public void setMeancw1(float meancw1) {
        this.meancw1 = meancw1;
    }

    public float getMeancw2() {
        return meancw2;
    }

    public void setMeancw2(float meancw2) {
        this.meancw2 = meancw2;
    }

    public float getMeanexam() {
        return meanexam;
    }

    public void setMeanexam(float meanexam) {
        this.meanexam = meanexam;
    }

    public float getMediancw1() {
        return mediancw1;
    }

    public void setMediancw1(float mediancw1) {
        this.mediancw1 = mediancw1;
    }

    public float getMediancw2() {
        return mediancw2;
    }

    public void setMediancw2(float mediancw2) {
        this.mediancw2 = mediancw2;
    }

    public float getMedianexam() {
        return medianexam;
    }

    public void setMedianexam(float medianexam) {
        this.medianexam = medianexam;
    }

    public int getDistributioncw1type1() {
        return distributioncw1type1;
    }

    public void setDistributioncw1type1(int distributioncw1type1) {
        this.distributioncw1type1 = distributioncw1type1;
    }

    public int getDistributioncw2type1() {
        return distributioncw2type1;
    }

    public void setDistributioncw2type1(int distributioncw2type1) {
        this.distributioncw2type1 = distributioncw2type1;
    }

    public int getDistributionexamtype1() {
        return distributionexamtype1;
    }

    public void setDistributionexamtype1(int distributionexamtype1) {
        this.distributionexamtype1 = distributionexamtype1;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public CMR(int CMRid, int cId, int studentCount, float meancw1, float meancw2, float meanexam, float mediancw1, float mediancw2, float medianexam, int distributioncw1type1, int distributioncw2type1, int distributionexamtype1, String status) {
        this.CMRid = CMRid;
        this.cId = cId;
        this.studentCount = studentCount;
        this.meancw1 = meancw1;
        this.meancw2 = meancw2;
        this.meanexam = meanexam;
        this.mediancw1 = mediancw1;
        this.mediancw2 = mediancw2;
        this.medianexam = medianexam;
        this.distributioncw1type1 = distributioncw1type1;
        this.distributioncw2type1 = distributioncw2type1;
        this.distributionexamtype1 = distributionexamtype1;
        this.status = status;
    }

    public CMR() {
    }
    
    
}
