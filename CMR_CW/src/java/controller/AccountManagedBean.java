/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Account;
import model.AccountDataAccess;

@ManagedBean
@SessionScoped
public class AccountManagedBean {

    public ArrayList<Account> listOfAccounts = new ArrayList<>();

    public ArrayList<Account> listOfAccounts1 = new ArrayList<>();

    public ArrayList<Account> listOfAccounts2 = new ArrayList<>();

    public ArrayList<Account> getListOfAccounts2() {
        return AccountDataAccess.getAccountByCLIDAdd();
    }

    public void setListOfAccounts2(ArrayList<Account> listOfAccounts2) {
        this.listOfAccounts2 = listOfAccounts2;
    }

    public ArrayList<Account> getListOfAccounts1() {
        return AccountDataAccess.getAccountByCMIDAdd();
    }

    public void setListOfAccounts1(ArrayList<Account> listOfAccounts1) {
        this.listOfAccounts1 = listOfAccounts1;
    }

    public ArrayList<Account> getListOfAccounts() {
        return AccountDataAccess.getAllAccount();
    }

    public void setListOfAccounts(ArrayList<Account> listOfAccounts) {
        this.listOfAccounts = listOfAccounts;
    }

}
