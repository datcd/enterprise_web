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
import model.Faculty;
import model.FacultyDataAccess;

/**
 *
 * @author Dat
 */
@ManagedBean
@SessionScoped
public class SearchFacultyManagedBean {

    public String key;
    public ArrayList<Faculty> listOfFacultys = new ArrayList<>();
    public String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public ArrayList<Faculty> getListOfFacultys() {
        return listOfFacultys;
    }

    public void setListOfFacultys(ArrayList<Faculty> listOfFacultys) {
        this.listOfFacultys = listOfFacultys;
    }

    public String searchFaculty() {
        if (key.equals("")) {
            message = "Please enter the key word";
        } else {
            listOfFacultys = FacultyDataAccess.getFacultyByNameOrCode(key);
            if (listOfFacultys.isEmpty()) {
                message="No item is found";
            }else{
                message=null;
            }
        }
        return "searchFaculities?faces-redirect=true";
    }

}
