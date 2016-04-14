/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import model.Course;
import model.CourseDataAccess;
import model.Faculty;

/**
 *
 * @author Dat
 */
@ManagedBean
@SessionScoped
public class CourseManagedBean {
    public ArrayList<Course> listOfCourse = new ArrayList<>();
    public ArrayList<Course> listOfCourse1 = new ArrayList<>();

    public ArrayList<Course> getListOfCourse1() {
        return CourseDataAccess.getAllCourse1();
    }

    public void setListOfCourse1(ArrayList<Course> listOfCourse1) {
        this.listOfCourse1 = listOfCourse1;
    }
    
    

    public ArrayList<Course> getListOfCourse() {
        return CourseDataAccess.getAllCourse();
    }
    
    public void setListOfCourse(ArrayList<Course> listOfCourse) {
        this.listOfCourse = listOfCourse;
    }

   
}
