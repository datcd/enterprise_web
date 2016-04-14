/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Courseassigned;
import model.CourseassignedDataAccess;

@ManagedBean
@SessionScoped
public class CourseassignedManagedBean {
    public ArrayList<Courseassigned> listOfCourse = new ArrayList<>();
    public ArrayList<Courseassigned> listOfCourseCL = new ArrayList<>();
    public ArrayList<Courseassigned> listOfCourseCM = new ArrayList<>();
    public int AIdSession;

    public ArrayList<Courseassigned> getListOfCourseCL() {
        return CourseassignedDataAccess.getAssignedCourseByCLID(LoginManagedBean.aIdSession);
    }

    public void setListOfCourseCL(ArrayList<Courseassigned> listOfCourseCL) {
        this.listOfCourseCL = listOfCourseCL;
    }

    public ArrayList<Courseassigned> getListOfCourseCM() {
        return CourseassignedDataAccess.getAssignedCourseByCMID(LoginManagedBean.aIdSession);
    }

    public void setListOfCourseCM(ArrayList<Courseassigned> listOfCourseCM) {
        this.listOfCourseCM = listOfCourseCM;
    }

     public int getAIdSession() {
        return AIdSession;
    }

    public void setAIdSession(int AIdSession) {
        this.AIdSession = AIdSession;
    }

    public ArrayList<Courseassigned> getListOfCourse() {
        return CourseassignedDataAccess.getAllAssignCourse();
    }

    public void setListOfCourse(ArrayList<Courseassigned> listOfCourse) {
        this.listOfCourse = listOfCourse;
    }
    
    
}
