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
public class DetailFacultyManagedBean {
    
    public int fId;
    public Faculty faculty;

    public int getfId() {
        return fId;
    }

    public void setfId(int fId) {
        this.fId = fId;
    }

    
    public Faculty getFaculty() {
        return FacultyDataAccess.getFacultyByID(fId);
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }
   
}
