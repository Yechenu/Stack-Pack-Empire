package com.okta.developer.ADP_Capstone.Blacklist.payload;


import lombok.Data;
import java.io.Serializable;


@Data
public class Blacklist_Request implements Serializable {

    public final Integer blacklistID;
    public final Integer employeeID;
    private final String lastname;
    private final String firstname;
    private final String status;
}
