/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dat
 */
public class FacultyDataAccess {

    public static ArrayList<Faculty> getAllFaculty() {
        try {
            ArrayList<Faculty> listOfFacultys = new ArrayList<>();
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from Faculty");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listOfFacultys.add(new Faculty(rs.getInt("fId"), rs.getString("fName"), rs.getString("fCode"), rs.getString("fDescription")));
            }
            return listOfFacultys;
        } catch (SQLException ex) {
            Logger.getLogger(FacultyDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static Faculty getFacultyByID(int fId) {
        try {
            Faculty faculty = null;
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from Faculty WHERE fId=?");
            ps.setInt(1, fId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                faculty = new Faculty(rs.getInt("fId"), rs.getString("fName"), rs.getString("fCode"), rs.getString("fDescription"));
            }
            return faculty;
        } catch (SQLException ex) {
            Logger.getLogger(FacultyDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static ArrayList<Faculty> getFacultyByNameOrCode(String key) {
        try {
            ArrayList<Faculty> listOfFacultys = new ArrayList<>();
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from Faculty WHERE fName like ? or fCode like ?");
            ps.setString(1, "%" + key + "%");
            ps.setString(2, "%" + key + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listOfFacultys.add(new Faculty(rs.getInt("fId"), rs.getString("fName"), rs.getString("fCode"), rs.getString("fDescription")));
            }
            return listOfFacultys;
        } catch (SQLException ex) {
            Logger.getLogger(FacultyDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static Faculty getFacultyByCode(String key) {
        try {
            Faculty faculty = null;
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from Faculty WHERE  fCode like ?");
            ps.setString(1, "%" + key + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                faculty=new Faculty(rs.getInt("fId"), rs.getString("fName"), rs.getString("fCode"), rs.getString("fDescription"));
            }
            return faculty;
        } catch (SQLException ex) {
            Logger.getLogger(FacultyDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    

    public static boolean editFaculty(String fName, String fCode, String fDescription, int fId) {
        try {
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement ps = connection.prepareCall("UPDATE Faculty SET fName = ?,fCode= ?,fDescription=? WHERE fId = ?");
            ps.setString(1, fName);
            ps.setString(2, fCode);
            ps.setString(3, fDescription);
            ps.setInt(4, fId);
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(FacultyDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean addFaculty(String fName, String fCode, String fDescription) {
        try {
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement ps = connection.prepareCall("INSERT INTO Faculty(fName,fCode,fDescription) VALUES (?,?,?)");
            ps.setString(1, fName);
            ps.setString(2, fCode);
            ps.setString(3, fDescription);
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(FacultyDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
