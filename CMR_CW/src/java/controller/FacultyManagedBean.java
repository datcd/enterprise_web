/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Faculty;
import model.FacultyDataAccess;

/**
 *
 * @author Dat
 */
@ManagedBean
@SessionScoped
public class FacultyManagedBean {
    public ArrayList<Faculty> listOfFacultys = new ArrayList<>();

    public ArrayList<Faculty> getListOfFacultys() {
        return FacultyDataAccess.getAllFaculty();
    }

    public void setListOfFacultys(ArrayList<Faculty> listOfFacultys) {
        this.listOfFacultys = listOfFacultys;
    }
    
}
