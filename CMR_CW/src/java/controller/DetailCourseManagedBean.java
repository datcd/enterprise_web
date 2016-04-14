/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.faces.bean.ManagedBean;
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
public class DetailCourseManagedBean {

    public int cId;
    public Course course;

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public Course getCourse() {
        return CourseDataAccess.getCourseByID(cId);
    }

    public void setCourse(Course course) {
        this.course = course;
    }
    
    
}
