/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Course;
import model.CourseDataAccess;

/**
 *
 * @author Dat
 */
@ManagedBean
@SessionScoped
public class SearchCourseManagedBean {

    public int fId;
    public String key;
    ArrayList<Course> listOfCourses = new ArrayList<>();
    public String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getfId() {
        return fId;
    }

    public void setfId(int fId) {
        this.fId = fId;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public ArrayList<Course> getListOfCourses() {
        return listOfCourses;
    }

    public void setListOfCourses(ArrayList<Course> listOfCourses) {
        this.listOfCourses = listOfCourses;
    }

    public String searchCourse() {
        if (fId == 0) {
            if (key.equals("")) {
                message = "Please enter the key word";
            } else {
                listOfCourses = CourseDataAccess.getCourseByNameOrCode(key);
                if (listOfCourses.isEmpty()) {
                    message = "No item is found";
                } else {
                    message = null;
                }
            }
        } else {
            listOfCourses = CourseDataAccess.getCourseByNameOrCodeAndFID(key, fId);
            if (listOfCourses.isEmpty()) {
                message = "No item is found";
            } else {
                message = null;
            }
        }
        return "searchCourse?faces-redirect=true";

    }
}
