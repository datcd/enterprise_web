/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class EditCourseManagedBean {

    public int cId;
    public int fId;
    public String cCode;
    public String cName;
    public String cDescription;
    public String cStart;
    public String cEnd;
    
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
    
    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public int getfId() {
        return fId;
    }

    public void setfId(int fId) {
        this.fId = fId;
    }

    public String getcCode() {
        return cCode;
    }

    public void setcCode(String cCode) {
        this.cCode = cCode;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcDescription() {
        return cDescription;
    }

    public void setcDescription(String cDescription) {
        this.cDescription = cDescription;
    }

    public String getcStart() {
        return cStart;
    }

    public void setcStart(String cStart) {
        this.cStart = cStart;
    }

    public String getcEnd() {
        return cEnd;
    }

    public void setcEnd(String cEnd) {
        this.cEnd = cEnd;
    }

    public String editCourse() {
        Course course=CourseDataAccess.getCourseByID(cId);
        String oldCode=course.cCode;
        if (fId == 0) {
            message = "Please choose faculty's name";
        } else {
            if (cName.equals("")) {
                message = "Please enter course's name";
            } else {
                if (cCode.equals("")) {
                    message = "Please enter course's code";
                } else {
                    Course searchCourse = CourseDataAccess.getCourseByCode(cCode);
                    if (searchCourse!=null && !cCode.equals(oldCode)) {
                        message = "This code is existed";
                    } else {
                        if (cDescription.equals("")) {
                            message = "Please enter course's code";
                        } else {
                            if (cStart.equals("")) {
                                message = "Please enter start date";
                            } else {
                                if (cEnd.equals("")) {
                                    message = "Please enter end date";
                                } else {
                                    try {
                                        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
                                        Date StartDate = sdf.parse(cStart);
                                        Date EndDate = sdf.parse(cEnd);
                                        if (StartDate.before(EndDate)) {
                                            CourseDataAccess.editCourse(fId, cCode, cName, cDescription, cStart, cEnd, cId);
                                            message = null;
                                            checkSuccess = 1;
                                            
                                    return "course?faces-redirect=true";
                                        } else {
                                            message = "Start date must be smaller than the end date";
                                        }
                                    } catch (ParseException ex) {
                                        Logger.getLogger(AddCourseManagedBean.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

}
