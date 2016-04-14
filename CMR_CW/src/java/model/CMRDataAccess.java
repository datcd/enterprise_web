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
public class CMRDataAccess {

    public static ArrayList<CMR> getAllCMR() {
        try {
            ArrayList<CMR> listOfCMR = new ArrayList<>();
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from cmr2");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listOfCMR.add(new CMR(rs.getInt("CMRid"), rs.getInt("cId"), rs.getInt("studentCount"), rs.getFloat("meancw1"), rs.getFloat("meancw2"), rs.getFloat("meanexam"), rs.getFloat("mediancw1"), rs.getFloat("mediancw2"), rs.getFloat("medianexam"), rs.getInt("distributioncw1type1"), rs.getInt("distributioncw2type1"), rs.getInt("distributionexamtype1"), rs.getString("status")));
            }
            return listOfCMR;
        } catch (SQLException ex) {
            Logger.getLogger(CMRDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static ArrayList<CMR> getAllCMRbyStatus1() {
        try {
            ArrayList<CMR> listOfCMR = new ArrayList<>();
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from cmr2 where status =1 ");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listOfCMR.add(new CMR(rs.getInt("CMRid"), rs.getInt("cId"), rs.getInt("studentCount"), rs.getFloat("meancw1"), rs.getFloat("meancw2"), rs.getFloat("meanexam"), rs.getFloat("mediancw1"), rs.getFloat("mediancw2"), rs.getFloat("medianexam"), rs.getInt("distributioncw1type1"), rs.getInt("distributioncw2type1"), rs.getInt("distributionexamtype1"), rs.getString("status")));
            }
            return listOfCMR;
        } catch (SQLException ex) {
            Logger.getLogger(CMRDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public static ArrayList<CMR> getAllCMRbyStatus2() {
        try {
            ArrayList<CMR> listOfCMR = new ArrayList<>();
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from cmr2 where status =2 ");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listOfCMR.add(new CMR(rs.getInt("CMRid"), rs.getInt("cId"), rs.getInt("studentCount"), rs.getFloat("meancw1"), rs.getFloat("meancw2"), rs.getFloat("meanexam"), rs.getFloat("mediancw1"), rs.getFloat("mediancw2"), rs.getFloat("medianexam"), rs.getInt("distributioncw1type1"), rs.getInt("distributioncw2type1"), rs.getInt("distributionexamtype1"), rs.getString("status")));
            }
            return listOfCMR;
        } catch (SQLException ex) {
            Logger.getLogger(CMRDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public static ArrayList<CMR> getAllCMRbyStatus3() {
        try {
            ArrayList<CMR> listOfCMR = new ArrayList<>();
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from cmr2 where status =3 ");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listOfCMR.add(new CMR(rs.getInt("CMRid"), rs.getInt("cId"), rs.getInt("studentCount"), rs.getFloat("meancw1"), rs.getFloat("meancw2"), rs.getFloat("meanexam"), rs.getFloat("mediancw1"), rs.getFloat("mediancw2"), rs.getFloat("medianexam"), rs.getInt("distributioncw1type1"), rs.getInt("distributioncw2type1"), rs.getInt("distributionexamtype1"), rs.getString("status")));
            }
            return listOfCMR;
        } catch (SQLException ex) {
            Logger.getLogger(CMRDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static boolean addCMR(int cId, int studentCount, float meancw1, float meancw2, float meanexam, float mediancw1, float mediancw2, float medianexam, int distributioncw1type1, int distributioncw2type1, int distributionexamtype1, String status) {
        try {
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement ps = connection.prepareCall("INSERT INTO cmr2 (cId, studentCount, meancw1, meancw2, meanexam, mediancw1, mediancw2, medianexam, distributioncw1type1, distributioncw2type1,distributionexamtype1, status) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setInt(1, cId);
            ps.setInt(2, studentCount);
            ps.setDouble(3, meancw1);
            ps.setDouble(4, meancw2);
            ps.setDouble(5, meanexam);
            ps.setDouble(6, mediancw1);
            ps.setDouble(7, mediancw2);
            ps.setDouble(8, medianexam);
            ps.setInt(9, distributioncw1type1);
            ps.setInt(10, distributioncw2type1);
            ps.setInt(11, distributionexamtype1);
            ps.setString(12, status);
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CMRDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean editCMR(int cId, int studentCount, float meancw1, float meancw2, float meanexam, float mediancw1, float mediancw2, float medianexam, int distributioncw1type1, int distributioncw2type1, int distributionexamtype1, String status, int CMRid) {
        try {
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement ps = connection.prepareCall("UPDATE cmr2 SET cId=?, studentCount=?, meancw1=?, meancw2=?, meanexam=?, mediancw1=?, mediancw2=?, medianexam=?, distributioncw1type1=?, distributioncw2type1=?, distributionexamtype1=?, status=? WHERE CMRid=?");
            ps.setInt(1, cId);
            ps.setInt(2, studentCount);
            ps.setDouble(3, meancw1);
            ps.setDouble(4, meancw2);
            ps.setDouble(5, meanexam);
            ps.setDouble(6, mediancw1);
            ps.setDouble(7, mediancw2);
            ps.setDouble(8, medianexam);
            ps.setInt(9, distributioncw1type1);
            ps.setInt(10, distributioncw2type1);
            ps.setInt(11, distributionexamtype1);
            ps.setString(12, status);
            ps.setInt(13, CMRid);
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CMRDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static CMR getCMRbycId(int cId) {
        try {
            CMR cmr = null;
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from cmr2 where cId=?");
            ps.setInt(1, cId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cmr = new CMR(rs.getInt("CMRid"), rs.getInt("cId"), rs.getInt("studentCount"), rs.getFloat("meancw1"), rs.getFloat("meancw2"), rs.getFloat("meanexam"), rs.getFloat("mediancw1"), rs.getFloat("mediancw2"), rs.getFloat("medianexam"), rs.getInt("distributioncw1type1"), rs.getInt("distributioncw2type1"), rs.getInt("distributionexamtype1"), rs.getString("status"));
            }
            return cmr;
        } catch (SQLException ex) {
            Logger.getLogger(CMRDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
       
    public static boolean editCMRbycId(int studentCount, float meancw1, float meancw2, float meanexam, float mediancw1, float mediancw2, float medianexam, int distributioncw1type1, int distributioncw2type1, int distributionexamtype1, String status, int CMRid ) {
        try {
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement ps = connection.prepareCall("UPDATE cmr2 SET studentCount=?, meancw1=?, meancw2=?, meanexam=?, mediancw1=?, mediancw2=?, medianexam=?, distributioncw1type1=?, distributioncw2type1=?, distributionexamtype1=?, status=? WHERE cId=?");
            
            ps.setInt(1, studentCount);
            ps.setDouble(2, meancw1);
            ps.setDouble(3, meancw2);
            ps.setDouble(4, meanexam);
            ps.setDouble(5, mediancw1);
            ps.setDouble(6, mediancw2);
            ps.setDouble(7, medianexam);
            ps.setInt(8, distributioncw1type1);
            ps.setInt(9, distributioncw2type1);
            ps.setInt(10, distributionexamtype1);
            ps.setString(11, status);
            ps.setInt(12, CMRid);
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CMRDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
   
}
