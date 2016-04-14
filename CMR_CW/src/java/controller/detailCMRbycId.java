/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.CMR;
import model.CMRDataAccess;

/**
 *
 * @author TTNNTT
 */
@ManagedBean
@SessionScoped
public class detailCMRbycId {
    public int cId;
    public CMR cmr;

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public CMR getCmr() {
        return CMRDataAccess.getCMRbycId(cId);
    }

    public void setCmr(CMR cmr) {
        this.cmr = cmr;
    }
    
    
}
