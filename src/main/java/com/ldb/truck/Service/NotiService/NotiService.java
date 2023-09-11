package com.ldb.truck.Service.NotiService;
import com.ldb.truck.Dao.NotiDao.NotiDao;
import com.ldb.truck.Model.Login.Noti.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
@Service
public class NotiService {
    @Autowired
    NotiDao notiDao;
//    public NotiRes listNoti(){
//        NotiRes result = new NotiRes();
//        List<NotiDetails> resDetails = new ArrayList<>();
//        List<NotiInvoice> resInvoice = new ArrayList<>();
//        List<NotiPerFormace> resPer = new ArrayList<>();
//        try{
//            resDetails = notiDao.notiDetails();
//            resInvoice = notiDao.notiInvoice();
//            resPer = notiDao.noTiPer();
//            result.setMessage("success");
//            result.setStatus("00");
//            result.setNotiDetails(resDetails);
//            result.setNotiInvoice(resInvoice);
//            result.setNotiPerForMance(resPer);
//        }catch (Exception e){
//        e.printStackTrace();
//            result.setMessage("Data Not found");
//            result.setStatus("01");
//            result.setNotiDetails(resDetails);
//            result.setNotiInvoice(resInvoice);
//            result.setNotiPerForMance(resPer);
//        }
//        return result;
//    }
    //get noti for tap 3 ========================>****<=================================
    public NotiRes listNotiTap3(){
        NotiRes result = new NotiRes();
        List<NotiDetails> resDetails = new ArrayList<>();
        List<NotiInvoice> resInvoice = new ArrayList<>();
        List<NotiPerFormace> resPer = new ArrayList<>();
        List<OweNoti> resOweNoti = new ArrayList<>();
        double total = 0.0;
        double total1 = 0.0;
        double total2 = 0.0;
        double total3 = 0.0;
        double total4 = 0.0;
        DecimalFormat numfm = new DecimalFormat("###,###");
        try{
            resDetails = notiDao.notiDetal();
            resInvoice = notiDao.Invoice();
            resPer = notiDao.noPer();
            resOweNoti = notiDao.oweNoti();
            total1 =resDetails.get(0).getDetailsStatus();
            total2 =resInvoice.get(0).getInvoiceStatus();
            total3 =resPer.get(0).getPerStatus();
            total4 =resOweNoti.get(0).getTotal_owe();

            total = resDetails.get(0).getDetailsStatus()+resInvoice.get(0).getInvoiceStatus()+resPer.get(0).getPerStatus()+resOweNoti.get(0).getTotal_owe();
            result.setMessage("success");
            result.setStatus("00");
            result.setNotiDetails(numfm.format(total1));
            result.setNotiInvoice(numfm.format(total2));
            result.setNotiPerForMance(numfm.format(total3));
            result.setTotalOwe(numfm.format(total4));
            result.setTotalRow(numfm.format(total));
        }catch (Exception e){
            e.printStackTrace();
            result.setMessage("Data Not found");
            result.setStatus("01");
            result.setNotiDetails(numfm.format(total1));
            result.setNotiInvoice(numfm.format(total2));
            result.setNotiPerForMance(numfm.format(total3));
            result.setTotalOwe(numfm.format(total4));
            result.setTotalRow(numfm.format(total));
        }
        return result;
    }
}
