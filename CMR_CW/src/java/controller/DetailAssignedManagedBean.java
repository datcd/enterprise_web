/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Courseassigned;
import model.CourseassignedDataAccess;

@ManagedBean
@SessionScoped
public class DetailAssignedManagedBean {
    public int CAID;
    public Courseassigned courseassigned;

    public int getCAID() {
        return CAID;
    }

    public void setCAID(int CAID) {
        this.CAID = CAID;
    }

    public Courseassigned getCourseassigned() {
        return CourseassignedDataAccess.getAssignedCourseByID(CAID);
    }

    public void setCourseassigned(Courseassigned courseassigned) {
        this.courseassigned = courseassigned;
    }
    
    
}
