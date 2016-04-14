/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Faculty;
import model.FacultyDataAccess;

/**
 *
 * @author Dat
 */
@ManagedBean
@SessionScoped
public class AddFacultyManagedBean {

    public String fName;
    public String fCode;
    public String fDescription;
    public String message;
    
    public int checkSuccess;

    public int getCheckSuccess() {
        return checkSuccess;
    }

    public void setCheckSuccess(int checkSuccess) {
        this.checkSuccess = checkSuccess;
    }
    

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getfCode() {
        return fCode;
    }

    public void setfCode(String fCode) {
        this.fCode = fCode;
    }

    public String getfDescription() {
        return fDescription;
    }

    public void setfDescription(String fDescription) {
        this.fDescription = fDescription;
    }

    public String addFaculty() {
        if (fName.equals("")) {
            message = "Please enter faculty's name";
        } else {
            if (fCode.equals("")) {
                message = "Please enter faculty's code";
            } else {
                Faculty faculty= FacultyDataAccess.getFacultyByCode(fCode);
                if (faculty!=null) {
                    message = "This code is existed";
                } else {
                    if (fDescription.equals("")) {
                        message = "Please enter faculty's description";
                    } else {
                        FacultyDataAccess.addFaculty(fName, fCode, fDescription);
                        checkSuccess=1;
                        message=null;
                        
                                    return "home?faces-redirect=true";
                    }
                }
            }
        }
        return null;
    }
}
