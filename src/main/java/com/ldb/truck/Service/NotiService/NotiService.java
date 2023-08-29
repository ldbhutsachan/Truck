package com.ldb.truck.Service.NotiService;
import com.ldb.truck.Dao.NotiDao.NotiDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ldb.truck.Model.Login.Noti.NotiRes;
import com.ldb.truck.Model.Login.Noti.NotiDetails;
import com.ldb.truck.Model.Login.Noti.NotiInvoice;
import com.ldb.truck.Model.Login.Noti.NotiPerFormace;
import java.util.ArrayList;
import java.util.List;
@Service
public class NotiService {
    @Autowired
    NotiDao notiDao;
    public NotiRes listNoti(){
        NotiRes result = new NotiRes();
        List<NotiDetails> resDetails = new ArrayList<>();
        List<NotiInvoice> resInvoice = new ArrayList<>();
        List<NotiPerFormace> resPer = new ArrayList<>();
        try{
            resDetails = notiDao.notiDetails();
            resInvoice = notiDao.notiInvoice();
            resPer = notiDao.noTiPer();
            result.setMessage("success");
            result.setStatus("00");
            result.setNotiDetails(resDetails);
            result.setNotiInvoice(resInvoice);
            result.setNotiPerForMance(resPer);
        }catch (Exception e){
        e.printStackTrace();
            result.setMessage("Data Not found");
            result.setStatus("01");
            result.setNotiDetails(resDetails);
            result.setNotiInvoice(resInvoice);
            result.setNotiPerForMance(resPer);
        }
        return result;
    }
}
