package com.ldb.truck.Model.Login.Noti;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class NotiRes {
    private String status;
    private String message;
    private List<NotiDetails> notiDetails;
    private List<NotiInvoice> notiInvoice;
    private List<NotiPerFormace> notiPerForMance;
}
