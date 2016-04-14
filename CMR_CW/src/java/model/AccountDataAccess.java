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
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import java.util.Properties;
/**
 *
 * @author TTNNTT
 */
public class AccountDataAccess {
    static Properties mailServerProperties;
    static Session getMailSession;
    static MimeMessage generateMailMessage;
    public static ArrayList<Account> getAllAccount() {
        try {
            ArrayList<Account> listOfAccount = new ArrayList<>();
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from Account");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listOfAccount.add(new Account(rs.getInt("AID"), rs.getInt("ARID"), rs.getInt("fId"), rs.getString("AFirstName"), rs.getString("ALastName"), rs.getString("AUserName"), rs.getString("APassword"), rs.getString("AEmail"),rs.getString("AAddress"),rs.getInt("APhone")));
            }
            return listOfAccount;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
   
    
    public static Account getAccountByID(int AID) {
        try {
            Account account = null;
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from Account WHERE AID=?");
            ps.setInt(1, AID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                account = new Account(rs.getInt("AID"), rs.getInt("ARID"), rs.getInt("fId"), rs.getString("AFirstName"), rs.getString("ALastName"), rs.getString("AUserName"), rs.getString("APassword"), rs.getString("AEmail"),rs.getString("AAddress"),rs.getInt("APhone"));
            }
            return account;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static Account getAccountByAUserName(String AUserName) {
        try {
            Account account = null;
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from Account WHERE AUserName=?");
            ps.setString(1, AUserName);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                account = new Account(rs.getInt("AID"), rs.getInt("ARID"), rs.getInt("fId"), rs.getString("AFirstName"), rs.getString("ALastName"), rs.getString("AUserName"), rs.getString("APassword"), rs.getString("AEmail"),rs.getString("AAddress"),rs.getInt("APhone"));
            }
            return account;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static Account getAccountByCLID(int CLID) {
        try {
            Account account = null;
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from Account WHERE AID=?");
            ps.setInt(1, CLID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                account = new Account(rs.getInt("AID"), rs.getInt("ARID"), rs.getInt("fId"), rs.getString("AFirstName"), rs.getString("ALastName"), rs.getString("AUserName"), rs.getString("APassword"), rs.getString("AEmail"),rs.getString("AAddress"),rs.getInt("APhone"));
            }
            return account;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
   
    public static Account getAccountByCMID(int CMID) {
        try {
            Account account = null;
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from Account WHERE AID=?");
            ps.setInt(1, CMID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                account = new Account(rs.getInt("AID"), rs.getInt("ARID"), rs.getInt("fId"), rs.getString("AFirstName"), rs.getString("ALastName"), rs.getString("AUserName"), rs.getString("APassword"), rs.getString("AEmail"),rs.getString("AAddress"),rs.getInt("APhone"));
            }
            return account;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public static ArrayList<Account> getAccountByCMIDAdd() {
        try {
           ArrayList<Account> listOfAccountCM = new ArrayList<>();
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from Account WHERE ARID=4");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listOfAccountCM.add(new Account(rs.getInt("AID"), rs.getInt("ARID"), rs.getInt("fId"), rs.getString("AFirstName"), rs.getString("ALastName"), rs.getString("AUserName"), rs.getString("APassword"), rs.getString("AEmail"),rs.getString("AAddress"),rs.getInt("APhone"))) ;
            }
            return listOfAccountCM;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
     public static ArrayList<Account> getAccountByCLIDAdd() {
        try {
           ArrayList<Account> listOfAccountCL = new ArrayList<>();
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from Account WHERE ARID=3");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listOfAccountCL.add(new Account(rs.getInt("AID"), rs.getInt("ARID"), rs.getInt("fId"), rs.getString("AFirstName"), rs.getString("ALastName"), rs.getString("AUserName"), rs.getString("APassword"), rs.getString("AEmail"),rs.getString("AAddress"),rs.getInt("APhone"))) ;
            }
            return listOfAccountCL;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
     
     public static boolean checkLogin(String AUserName, String APassword){
        try {
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement ps = connection.prepareCall("SELECT * from Account WHERE AUserName = ? and APassword = ?");
            ps.setString(1, AUserName);
            ps.setString(2, APassword);
             ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
     }
     
     public static void generateAndSendEmail(Account cm,Account cl,Course c) throws AddressException, MessagingException {

        // Step1
        System.out.println("\n 1st ===> setup Mail Server Properties..");
        mailServerProperties = System.getProperties();
        mailServerProperties.put("mail.smtp.port", "587");
        mailServerProperties.put("mail.smtp.auth", "true");
        mailServerProperties.put("mail.smtp.starttls.enable", "true");
        mailServerProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        System.out.println("Mail Server Properties have been setup successfully..");

        // Step2
        System.out.println("\n\n 2nd ===> get Mail Session..");
        getMailSession = Session.getDefaultInstance(mailServerProperties, null);
        generateMailMessage = new MimeMessage(getMailSession);
        generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(cl.AEmail));
        generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress(cm.AEmail));
        generateMailMessage.setSubject("Greetings from Admin");
        String emailBody = "You have been assign to" + c.cName  +"<br> CL :" + cl.AFirstName + "<br> CM :" + cm.AFirstName + "<br><br> Regards, <br>Admin";
        generateMailMessage.setContent(emailBody, "text/html");
        

        // Step3
        
        Transport transport = getMailSession.getTransport("smtp");

		// Enter your correct gmail UserID and Password
        // if you have 2FA enabled then provide App Specific Password
        transport.connect("smtp.gmail.com", "hieunt018@gmail.com", "aA01081994");
        transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
        transport.close();

    }
   
     public static void generateAndSendEmail2(Course c,String cmemail) throws AddressException, MessagingException {

        // Step1
        System.out.println("\n 1st ===> setup Mail Server Properties..");
        mailServerProperties = System.getProperties();
        mailServerProperties.put("mail.smtp.port", "587");
        mailServerProperties.put("mail.smtp.auth", "true");
        mailServerProperties.put("mail.smtp.starttls.enable", "true");
        mailServerProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        System.out.println("Mail Server Properties have been setup successfully..");

        // Step2
        System.out.println("\n\n 2nd ===> get Mail Session..");
        getMailSession = Session.getDefaultInstance(mailServerProperties, null);
        generateMailMessage = new MimeMessage(getMailSession);
        generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(cmemail));
        generateMailMessage.setSubject("Greetings from Admin");
        String emailBody = "CL created CMR for course" + c.cName  +"<br> You can check it on : http://localhost:8080/Group3_CMR_CW/faces/editCMR.xhtml?cId=" + c.cId + "<br><br> Regards, <br>Admin";
        generateMailMessage.setContent(emailBody, "text/html");
        

        // Step3
        
        Transport transport = getMailSession.getTransport("smtp");

		// Enter your correct gmail UserID and Password
        // if you have 2FA enabled then provide App Specific Password
        transport.connect("smtp.gmail.com", "hieunt018@gmail.com", "aA01081994");
        transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
        transport.close();

    }
    
}
