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
public class CourseDataAccess {

    public static ArrayList<Course> getAllCourse() {
        try {
            ArrayList<Course> listOfCourses = new ArrayList<>();
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from Course");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listOfCourses.add(new Course(rs.getInt("cId"), rs.getInt("fId"), rs.getString("cCode"), rs.getString("cName"), rs.getString("cDescription"), rs.getString("cStart"), rs.getString("cEnd")));
            }
            return listOfCourses;
        } catch (SQLException ex) {
            Logger.getLogger(CourseDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static ArrayList<Course> getAllCourse1() {
        try {
            ArrayList<Course> listOfCourses = new ArrayList<>();
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT course.* FROM course LEFT join courseassigned on course.cId = courseassigned.cId WHERE courseassigned.cId is null");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listOfCourses.add(new Course(rs.getInt("cId"), rs.getInt("fId"), rs.getString("cCode"), rs.getString("cName"), rs.getString("cDescription"), rs.getString("cStart"), rs.getString("cEnd")));
            }
            return listOfCourses;
        } catch (SQLException ex) {
            Logger.getLogger(CourseDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static Course getCourseByID(int cId) {
        try {
            Course course = null;
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from Course WHERE cId=?");
            ps.setInt(1, cId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                course = new Course(rs.getInt("cId"), rs.getInt("fId"), rs.getString("cCode"), rs.getString("cName"), rs.getString("cDescription"), rs.getString("cStart"), rs.getString("cEnd"));
            }
            return course;
        } catch (SQLException ex) {
            Logger.getLogger(FacultyDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static Course getCourseByCode(String cCode) {
        try {
            Course course = null;
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from Course WHERE cCode=?");
            ps.setString(1, cCode);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                course = new Course(rs.getInt("cId"), rs.getInt("fId"), rs.getString("cCode"), rs.getString("cName"), rs.getString("cDescription"), rs.getString("cStart"), rs.getString("cEnd"));
            }
            return course;
        } catch (SQLException ex) {
            Logger.getLogger(FacultyDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static boolean addCourse(int fId, String cCode, String cName, String cDescription, String cStart, String cEnd) {
        try {
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement ps = connection.prepareCall("INSERT INTO Course(fId,cCode,cName,cDescription,cStart,cEnd) VALUES (?,?,?,?,?,?)");
            ps.setInt(1, fId);
            ps.setString(2, cCode);
            ps.setString(3, cName);
            ps.setString(4, cDescription);
            ps.setString(5, cStart);
            ps.setString(6, cEnd);
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean editCourse(int fId, String cCode, String cName, String cDescription, String cStart, String cEnd, int cId) {
        try {
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement ps = connection.prepareCall("UPDATE Course SET fId=?,cName = ?,cCode= ?,cDescription=?,cStart=?,cEnd=? WHERE cId = ?");
            ps.setInt(1, fId);
            ps.setString(2, cCode);
            ps.setString(3, cName);
            ps.setString(4, cDescription);
            ps.setString(5, cStart);
            ps.setString(6, cEnd);
            ps.setInt(7, cId);
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDataAccess.class.getName()).log(Level.SEVERE, null, ex);
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

    public static ArrayList<Course> getCourseByNameOrCode(String key) {
        try {
            ArrayList<Course> listOfCourses = new ArrayList<>();
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from Course WHERE cName like ? or cCode like ?");
            ps.setString(1, "%" + key + "%");
            ps.setString(2, "%" + key + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listOfCourses.add(new Course(rs.getInt("cId"), rs.getInt("fId"), rs.getString("cCode"), rs.getString("cName"), rs.getString("cDescription"), rs.getString("cStart"), rs.getString("cEnd")));
            }
            return listOfCourses;
        } catch (SQLException ex) {
            Logger.getLogger(FacultyDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static ArrayList<Course> getCourseByNameOrCodeAndFID(String key, int fId) {
        try {
            ArrayList<Course> listOfCourses = new ArrayList<>();
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from Course WHERE (cName like ? and fId=? )or (cCode like ? and fId=?)");
            ps.setString(1, "%" + key + "%");
            ps.setInt(2, fId);
            ps.setString(3, "%" + key + "%");
            ps.setInt(4, fId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listOfCourses.add(new Course(rs.getInt("cId"), rs.getInt("fId"), rs.getString("cCode"), rs.getString("cName"), rs.getString("cDescription"), rs.getString("cStart"), rs.getString("cEnd")));
            }
            return listOfCourses;
        } catch (SQLException ex) {
            Logger.getLogger(FacultyDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static ArrayList<Course> getCourseByFID(int fId) {
        try {
            ArrayList<Course> listOfCourses = new ArrayList<>();
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from Course WHERE fId=?");
            ps.setInt(1, fId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listOfCourses.add(new Course(rs.getInt("cId"), rs.getInt("fId"), rs.getString("cCode"), rs.getString("cName"), rs.getString("cDescription"), rs.getString("cStart"), rs.getString("cEnd")));
            }
            return listOfCourses;
        } catch (SQLException ex) {
            Logger.getLogger(FacultyDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
