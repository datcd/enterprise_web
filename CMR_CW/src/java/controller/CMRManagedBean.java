/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
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
public class CMRManagedBean {
    public ArrayList<CMR> listCMR1 = new ArrayList<>();
    public ArrayList<CMR> listCMR2 = new ArrayList<>();
    public ArrayList<CMR> listCMR3 = new ArrayList<>();

    public ArrayList<CMR> getListCMR1() {
        return CMRDataAccess.getAllCMRbyStatus1();
    }

    public void setListCMR1(ArrayList<CMR> listCMR1) {
        this.listCMR1 = listCMR1;
    }

    public ArrayList<CMR> getListCMR2() {
        return CMRDataAccess.getAllCMRbyStatus2();
    }

    public void setListCMR2(ArrayList<CMR> listCMR2) {
        this.listCMR2 = listCMR2;
    }

    public ArrayList<CMR> getListCMR3() {
        return CMRDataAccess.getAllCMRbyStatus3();
    }

    public void setListCMR3(ArrayList<CMR> listCMR3) {
        this.listCMR3 = listCMR3;
    }
    
    
    
}
