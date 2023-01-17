package com.okta.developer.ADP_Capstone.Blacklist.entity;

public class Blacklist {

    String lName;
    String fName;

    public Blacklist(String lName, String fName) {
        this.lName = lName;
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }
}
