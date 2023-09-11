package com.ldb.truck.Dao.NotiDao;

import com.ldb.truck.Model.Login.Noti.NotiDetails;
import com.ldb.truck.Model.Login.Noti.NotiInvoice;
import com.ldb.truck.Model.Login.Noti.NotiPerFormace;
import com.ldb.truck.Model.Login.Noti.OweNoti;

import java.util.List;

public interface NotiDaoIn{
    List<NotiDetails> notiDetails();
    List<NotiInvoice> notiInvoice();
    List<NotiPerFormace> noTiPer();

    List<NotiDetails> notiDetal();
    List<NotiInvoice> Invoice();
    List<NotiPerFormace> noPer();
    List<OweNoti> oweNoti();
}
