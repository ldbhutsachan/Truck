package com.ldb.truck.Model.Login.staft;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StaffPayReq {
    private String staffID;
    private String lahudPoyLod;
//    private String staffName;
//    private String staffSurname;
//    private String staff02_PayAll;
//    private String staff02_Beforepay;
//    private String staff02_Notpay;
//    private String totalRow;
    private String startDate;
    private String endDate;
}