/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import model.Account;
import model.AccountDataAccess;

/**
 *
 * @author TTNNTT
 */
@ManagedBean
@SessionScoped
public class LoginManagedBean {

    public String AUserName;
    public String APassword;
    private String message;
    private String pathInfo;
    public static int aIdSession = 0;
    public int UserId;
    private int role;

    public String getAUserName() {
        return AUserName;
    }

    public void setAUserName(String AUserName) {
        this.AUserName = AUserName;
    }

    public String getAPassword() {
        return APassword;
    }

    public void setAPassword(String APassword) {
        this.APassword = APassword;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPathInfo() {
        return pathInfo;
    }

    public void setPathInfo(String pathInfo) {
        this.pathInfo = pathInfo;
    }

    public static int getaIdSession() {
        return aIdSession;
    }

    public static void setaIdSession(int aIdSession) {
        LoginManagedBean.aIdSession = aIdSession;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int UserId) {
        this.UserId = UserId;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getAIdSession() {
        return aIdSession;
    }

    public void setAIdSession(int aIdSession) {
        this.aIdSession = aIdSession;
    }

    public String login() {
        if (AUserName != null && !AUserName.trim().isEmpty() && APassword != null && !APassword.trim().isEmpty()) {
            boolean rs = AccountDataAccess.checkLogin(AUserName, APassword);
            if (rs) {
                Account acc = AccountDataAccess.getAccountByAUserName(AUserName);
                aIdSession = acc.getAID();
                UserId = acc.getAID();
                role = acc.getARID();
                if (role == 3) {
                    return "homeCL?faces-redirect=true";
                } else {
                    if (role == 4) {
                        return "homeCM?faces-redirect=true";
                    } else {
                        if (role == 1) {
                            return "homePVC?faces-redirect=true";
                        } else {
                            if (role == 2) {
                                return "homeDLT?faces-redirect=true";
                            } else {
                                if (AUserName.equals("admin") && APassword.equals("admin")) {
                                    return "home?faces-redirect=true";
                                } else {
                                    message = "This account wwrong username or password!";
                                    return "";
                                }
                            }
                        }
                    }
                }
            } else {
                message = "This account doesn't exixt !";
                return "";
            }
        }
        message = "Please fill all the blank!";
        return "";
    }

    public String getAutoLogin() throws IOException {
        if (role == 0) {
            FacesContext context = FacesContext.getCurrentInstance();
            pathInfo = context.getExternalContext().getRequestPathInfo();
            String contextPath = context.getExternalContext().getRequestContextPath();
            ((HttpServletResponse) context.getExternalContext().getResponse()).sendRedirect(contextPath + "/faces/login.xhtml?faces-redirect=true");

        }
        return "";
    }

    public String logout() {
        role = 0;
        message = null;
        AUserName = null;
        aIdSession = 0;
        return "login?faces-redirect=true";
    }

}
