/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Pham Tung
 */
public class CommentDataAccess {
    public boolean create(int _courseId, int _cmrId, String _content) throws SQLException 
    {
         Connection connection = ConnectionUtil.getConnection();
            PreparedStatement ps = connection.prepareCall("INSERT INTO comment(	coID,cmrID,content) VALUES (?,?,?)");
            ps.setInt(1, _courseId);
            ps.setInt(2, _cmrId);
            ps.setString(3, _content);
           
            if (ps.executeUpdate() > 0) {
                return true;
            }
            return false;
    }
}
