/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
public class EditFacultyManagedBean {

    public int fId;
    public String fName;
    public String fCode;
    public String fDescription;

    public String message;
    public int checkSuccess;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCheckSuccess() {
        return checkSuccess;
    }

    public void setCheckSuccess(int checkSuccess) {
        this.checkSuccess = checkSuccess;
    }
    
    public int getfId() {
        return fId;
    }

    public void setfId(int fId) {
        this.fId = fId;
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

    public String editFaculty() {
        Faculty faculty=FacultyDataAccess.getFacultyByID(fId);
        String oldCode= faculty.fCode;
        if (fName.equals("")) {
            message = "Please enter faculty's name";
        } else {
            if (fCode.equals("")) {
                message = "Please enter faculty's code";
            } else {
                Faculty searchFaculty= FacultyDataAccess.getFacultyByCode(fCode);
                if (searchFaculty!=null && !fCode.equals(oldCode)) {
                    message = "This code is existed";
                } else {
                    if (fDescription.equals("")) {
                        message = "Please enter faculty's description";
                    } else {
                        FacultyDataAccess.editFaculty(fName, fCode, fDescription, fId);
                        
                        checkSuccess = 1;
                        message = null;
                        
                                    return "home?faces-redirect=true";
                    }
                }
            }
        }
        return null;
    }
}
