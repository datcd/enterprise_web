/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.AccountDataAccess;
import model.CourseDataAccess;
import model.FacultyDataAccess;

/**
 *
 * @author Dat
 */
@ManagedBean
@SessionScoped
public class JSFManagedBean {

    public String viewFacultyName(int fId) {
        return FacultyDataAccess.getFacultyByID(fId).fName;
    }
    
    public String viewCourseName(int cId){
        return CourseDataAccess.getCourseByID(cId).cName;
    }
    
    public String viewAccCL (int CLID){
        return AccountDataAccess.getAccountByCLID(CLID).AUserName;
    }
    
    public String viewAccCM (int CMID){
        return AccountDataAccess.getAccountByCMID(CMID).AUserName;
    }  
    
    public String viewAccCLAdd (int AID){
        return AccountDataAccess.getAccountByCLID(AID).AUserName;
    }
    
    public String viewAccCMAdd (int AID){
        return AccountDataAccess.getAccountByCMID(AID).AUserName;
    }
}
