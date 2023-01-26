package com.okta.developer.ADP_Capstone.Blacklist.payload;

import com.okta.developer.ADP_Capstone.Blacklist.entity.Blacklist;
import lombok.Data;
import java.io.Serializable;


@Data
public class Blacklist_Request implements Serializable {

    public final Integer blacklistID;
    public final Integer employeeID;
    private final String lName;
    private final String fName;
    private final String status;
}
