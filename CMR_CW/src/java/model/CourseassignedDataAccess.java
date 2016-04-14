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
 * @author TTNNTT
 */
public class CourseassignedDataAccess {

    public static ArrayList<Courseassigned> getAllAssignCourse() {
        try {
            ArrayList<Courseassigned> listOfCoursesAssign = new ArrayList<>();
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from courseassigned");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listOfCoursesAssign.add(new Courseassigned(rs.getInt("CAID"), rs.getInt("cId"), rs.getInt("CMID"), rs.getInt("CLID"), rs.getString("cStart"), rs.getString("cEnd")));
            }
            return listOfCoursesAssign;
        } catch (SQLException ex) {
            Logger.getLogger(CourseassignedDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static Courseassigned getAssignedCourseByID(int CAID) {
        try {
            Courseassigned courseassigned = null;
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from courseassigned WHERE CAID=?");
            ps.setInt(1, CAID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                courseassigned = new Courseassigned(rs.getInt("CAID"), rs.getInt("cId"), rs.getInt("CMID"), rs.getInt("CLID"), rs.getString("cStart"), rs.getString("cEnd"));
            }
            return courseassigned;
        } catch (SQLException ex) {
            Logger.getLogger(CourseassignedDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    

    public static boolean addAssigned(int cId, int CMID, int CLID, String cStart, String cEnd) {
        try {
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement ps = connection.prepareCall("INSERT INTO courseassigned(cId,CMID,CLID,cStart,cEnd) VALUES (?,?,?,?,?)");
            ps.setInt(1, cId);
            ps.setInt(2, CMID);
            ps.setInt(3, CLID);
            ps.setString(4, cStart);
            ps.setString(5, cEnd);
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseassignedDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean editAssigned(int cId, int CMID, int CLID, String cStart, String cEnd, int CAID) {
        try {
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement ps = connection.prepareCall("UPDATE courseassigned SET cId=?, CMID=?, CLID=?, cStart=?, cEnd=? WHERE CAID=?");
            ps.setInt(1, cId);
            ps.setInt(2, CMID);
            ps.setInt(3, CLID);
            ps.setString(4, cStart);
            ps.setString(5, cEnd);
            ps.setInt(6, CAID);
            if(ps.executeUpdate()>0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseassignedDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public static ArrayList<Courseassigned> getAssignedCourseByCMID(int CMID) {
        try {
            ArrayList<Courseassigned> listOfCoursesAssignCM = new ArrayList<>();
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from courseassigned WHERE CMID=?");
            ps.setInt(1, CMID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listOfCoursesAssignCM.add(new Courseassigned(rs.getInt("CAID"), rs.getInt("cId"), rs.getInt("CMID"), rs.getInt("CLID"), rs.getString("cStart"), rs.getString("cEnd"))) ;
            }
            return listOfCoursesAssignCM;
        } catch (SQLException ex) {
            Logger.getLogger(CourseassignedDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static ArrayList<Courseassigned> getAssignedCourseByCLID(int CLID) {
        try {
            ArrayList<Courseassigned> listOfCoursesAssignCL = new ArrayList<>();
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from courseassigned WHERE CLID=?");
            ps.setInt(1, CLID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listOfCoursesAssignCL.add(new Courseassigned(rs.getInt("CAID"), rs.getInt("cId"), rs.getInt("CMID"), rs.getInt("CLID"), rs.getString("cStart"), rs.getString("cEnd"))) ;
            }
            return listOfCoursesAssignCL;
        } catch (SQLException ex) {
            Logger.getLogger(CourseassignedDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
