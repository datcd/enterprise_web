/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import model.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.CourseassignedDataAccess;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import java.util.Properties;
/**
 *
 * @author TTNNTT
 */
@ManagedBean
@SessionScoped
public class AddCourseAssigned {

    public int CAID;
    public int cId;
    public int CMID;
    public int CLID;
    public String cStart;
    public String cEnd;

    public String message;
    public int checkSuccess;

    public int getCAID() {
        return CAID;
    }

    public void setCAID(int CAID) {
        this.CAID = CAID;
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public int getCMID() {
        return CMID;
    }

    public void setCMID(int CMID) {
        this.CMID = CMID;
    }

    public int getCLID() {
        return CLID;
    }

    public void setCLID(int CLID) {
        this.CLID = CLID;
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

    public String addCourseAssigned() throws MessagingException {
        if (cId == 0) {
            message = "Please choose course's name";
        } else {
            if (CMID == 0) {
                message = "Please choose course manager name";
            } else {
                if (CLID == 0) {
                    message = "Please choose course leader name";
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
                                    CourseassignedDataAccess.addAssigned(cId, CMID, CLID, cStart, cEnd);
                                    message = null;
                                    checkSuccess = 1;
                                    Account cm = AccountDataAccess.getAccountByCMID(CMID);
                                    Account cl = AccountDataAccess.getAccountByCLID(CLID);
                                    Course c = CourseDataAccess.getCourseByID(cId);
                                    AccountDataAccess.generateAndSendEmail(cl , cm , c);
                                    return "CourseAssignedPVC?faces-redirect=true";
                                } else {
                                    message = "Start date must be smaller than the end date";
                                }
                            } catch (ParseException ex) {
                                Logger.getLogger(AddCourseAssigned.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
            }
        }
        return null;
    }
}
