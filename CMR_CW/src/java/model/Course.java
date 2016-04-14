/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Dat
 */
public class Course {
    public int cId;
    public int fId;
    public String cCode;
    public String cName;
    public String cDescription;
    public String cStart;
    public String cEnd;

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public int getfId() {
        return fId;
    }

    public void setfId(int fId) {
        this.fId = fId;
    }

    public String getcCode() {
        return cCode;
    }

    public void setcCode(String cCode) {
        this.cCode = cCode;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcDescription() {
        return cDescription;
    }

    public void setcDescription(String cDescription) {
        this.cDescription = cDescription;
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

    public Course(int cId, int fId, String cCode, String cName, String cDescription, String cStart, String cEnd) {
        this.cId = cId;
        this.fId = fId;
        this.cCode = cCode;
        this.cName = cName;
        this.cDescription = cDescription;
        this.cStart = cStart;
        this.cEnd = cEnd;
    }
    
    
}
