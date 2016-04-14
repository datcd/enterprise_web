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
public class Account {
    public int AID;
    public int ARID;
    public int fId;
    public String AFirstName;
    public String ALastName;
    public String AUserName;
    public String APassword;
    public String AEmail;
    public String AAddress;
    public int APhone;

    public int getAID() {
        return AID;
    }

    public void setAID(int AID) {
        this.AID = AID;
    }

    public int getARID() {
        return ARID;
    }

    public void setARID(int ARID) {
        this.ARID = ARID;
    }

    public int getfId() {
        return fId;
    }

    public void setfId(int fId) {
        this.fId = fId;
    }

    public String getAFirstName() {
        return AFirstName;
    }

    public void setAFirstName(String AFirstName) {
        this.AFirstName = AFirstName;
    }

    public String getALastName() {
        return ALastName;
    }

    public void setALastName(String ALastName) {
        this.ALastName = ALastName;
    }

    public String getAUserName() {
        return AUserName;
    }

    public void setAUserName(String AUserName) {
        this.AUserName = AUserName;
    }

    public String getAPassword() {
        return APassword;
    }

    public void setAPassword(String APassword) {
        this.APassword = APassword;
    }

    public String getAEmail() {
        return AEmail;
    }

    public void setAEmail(String AEmail) {
        this.AEmail = AEmail;
    }

    public String getAAddress() {
        return AAddress;
    }

    public void setAAddress(String AAddress) {
        this.AAddress = AAddress;
    }

    public int getAPhone() {
        return APhone;
    }

    public void setAPhone(int APhone) {
        this.APhone = APhone;
    }

    public Account(int AID, int ARID, int fId, String AFirstName, String ALastName, String AUserName, String APassword, String AEmail, String AAddress, int APhone) {
        this.AID = AID;
        this.ARID = ARID;
        this.fId = fId;
        this.AFirstName = AFirstName;
        this.ALastName = ALastName;
        this.AUserName = AUserName;
        this.APassword = APassword;
        this.AEmail = AEmail;
        this.AAddress = AAddress;
        this.APhone = APhone;
    }
    
    
}
