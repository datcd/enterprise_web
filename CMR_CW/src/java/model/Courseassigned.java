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
public class Courseassigned {
    public int CAID;
    public int cId;
    public int CMID;
    public int CLID;
    public String cStart;
    public String cEnd;

    public int getCAID() {
        return CAID;
    }

    public void setCAID(int CAID) {
        this.CAID = CAID;
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public int getCMID() {
        return CMID;
    }

    public void setCMID(int CMID) {
        this.CMID = CMID;
    }

    public int getCLID() {
        return CLID;
    }

    public void setCLID(int CLID) {
        this.CLID = CLID;
    }

    public String getcStart() {
        return cStart;
    }

    public void setcStart(String cStart) {
        this.cStart = cStart;
    }

    public String getcEnd() {
        return cEnd;
    }

    public void setcEnd(String cEnd) {
        this.cEnd = cEnd;
    }

    public Courseassigned(int CAID, int cId, int CMID, int CLID, String cStart, String cEnd) {
        this.CAID = CAID;
        this.cId = cId;
        this.CMID = CMID;
        this.CLID = CLID;
        this.cStart = cStart;
        this.cEnd = cEnd;
    }
    
    
}
