/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import model.CMR;
import model.CMRDataAccess;
import model.CommentDataAccess;

/**
 *
 * @author TTNNTT
 */
@ManagedBean
@SessionScoped
public class editCMR {

    public int CMRid;
    public int cID;
    public int studentCount;
    public float meancw1;
    public float meancw2;
    public float meanexam;
    public float mediancw1;
    public float mediancw2;
    public float medianexam;
    public int distributioncw1type1;
    public int distributioncw2type1;
    public int distributionexamtype1;
    public String status;
    public String content;
    public CMR cmr;

    public CMR getCmr() {
        cmr = new CMR();
        cmr = CMRDataAccess.getCMRbycId(cID);
        return cmr;
    }

    public int getcID() {
        return cID;
    }

    public void setcID(int cID) {
        this.cID = cID;
    }

    
    public void setCmr(CMR cmr) {
        this.cmr = cmr;
    }

    public int getCMRid() {
        return CMRid;
    }

    public void setCMRid(int CMRid) {
        this.CMRid = CMRid;
    }

   
    public int getStudentCount() {
        getCmr();
        return cmr.studentCount;
    }

    public void setStudentCount(int studentCount) {
        this.studentCount = studentCount;
    }

    public float getMeancw1() {
        getCmr();
        return cmr.meancw1;
    }

    public void setMeancw1(float meancw1) {
        this.meancw1 = meancw1;
    }

    public float getMeancw2() {
        getCmr();
        return cmr.meancw2;
    }

    public void setMeancw2(float meancw2) {
        this.meancw2 = meancw2;
    }

    public float getMeanexam() {
        getCmr();
        return cmr.meanexam;
    }

    public void setMeanexam(float meanexam) {
        this.meanexam = meanexam;
    }

    public float getMediancw1() {
        getCmr();
        return cmr.mediancw1;
    }

    public void setMediancw1(float mediancw1) {
        this.mediancw1 = mediancw1;
    }

    public float getMediancw2() {
        getCmr();
        return cmr.mediancw2;
    }

    public void setMediancw2(float mediancw2) {
        this.mediancw2 = mediancw2;
    }

    public float getMedianexam() {
        getCmr();
        return cmr.medianexam;
    }

    public void setMedianexam(float medianexam) {
        this.medianexam = medianexam;
    }

    public int getDistributioncw1type1() {
        getCmr();
        return cmr.distributioncw1type1;
    }

    public void setDistributioncw1type1(int distributioncw1type1) {
        this.distributioncw1type1 = distributioncw1type1;
    }

    public int getDistributioncw2type1() {
        getCmr();
        return cmr.distributioncw2type1;
    }

    public void setDistributioncw2type1(int distributioncw2type1) {
        this.distributioncw2type1 = distributioncw2type1;
    }

    public int getDistributionexamtype1() {
        getCmr();
        return cmr.distributionexamtype1;
    }

    public void setDistributionexamtype1(int distributionexamtype1) {
        this.distributionexamtype1 = distributionexamtype1;
    }

    public String getStatus() {
        getCmr();
        return cmr.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    
    
    

    public String editCMR() throws SQLException {
        CMRDataAccess.editCMRbycId(studentCount, meancw1, meancw2, meanexam, mediancw1, mediancw2, medianexam, distributioncw1type1, distributioncw2type1, distributionexamtype1, "2", cID);
//        boolean rs = new CommentDataAccess().create(cID, CMRid, content);
//        System.out.println("RES" +rs);
        return "homeCM?faces-redirect=true";
    }
    
    public String addComment() throws SQLException
    {
        boolean res = new CommentDataAccess().create(1, 1, content);
       
            return "homeCM?faces-redirect=true";
        
    }

    public void abc(String cId) {
        try {
            int x = Integer.parseInt(cId);
            CMR cmr = CMRDataAccess.getCMRbycId(x);
            if (cmr == null) {
                ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
                HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();
                PrintWriter pw = response.getWriter();
                pw.write("<Script>");
                pw.write("alert('No data found')");
                pw.write("</script>");
            }

        } catch (IOException e) {

            FacesContext.getCurrentInstance().addMessage(
                    "helloWorldButtonId",
                    new FacesMessage("Error:" + e.getMessage())
            );
        }
    }
}
