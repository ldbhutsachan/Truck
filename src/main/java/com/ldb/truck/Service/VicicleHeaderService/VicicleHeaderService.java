package com.ldb.truck.Service.VicicleHeaderService;
import com.ldb.truck.Dao.VicicleHeaderDao.VicicleHeaderDao;
import com.ldb.truck.Dao.VicicleHeaderDao.VicicleHeaderServiceDao;
import com.ldb.truck.Model.Login.Report.ReportAllReq;
import com.ldb.truck.Model.Login.Report.ReportHeader;
import com.ldb.truck.Model.Login.Report.ReportHeaderReq;
import com.ldb.truck.Model.Login.Report.ReportHeaderRes;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ldb.truck.Model.Login.VicicleHeader.VicicleHeaderReq;
import com.ldb.truck.Model.Login.VicicleHeader.VicicleHeader;
import com.ldb.truck.Model.Login.VicicleHeader.VicicleHeaderRes;

import java.util.ArrayList;
import java.util.List;

@Service
public class VicicleHeaderService  {
    private static final Logger log = LogManager.getLogger(VicicleHeaderService.class);
    @Autowired private VicicleHeaderDao vicicleHeaderDao;
    public VicicleHeaderRes listVicicleHeader (){
        List<VicicleHeader> vicicleHeaders = new ArrayList<>();
        VicicleHeaderRes result = new VicicleHeaderRes();
        try {
            vicicleHeaders = vicicleHeaderDao.listVicicleHeader();
            if(vicicleHeaders.size() < 1 ){
                result.setMessage("data not found");
                result.setStatus("01");
                return result;
            }
            result.setMessage("Success");
            result.setStatus("00");
            result.setData(vicicleHeaders);
            return result;
        }catch (Exception e){
            e.printStackTrace();
            result.setMessage("data not found");
            result.setStatus("01");
            return result;
        }
    }
    //---combo1
    public VicicleHeaderRes listVicicleHeaderCombo1(){
        List<VicicleHeader> vicicleHeaders = new ArrayList<>();
        VicicleHeaderRes result = new VicicleHeaderRes();
        try {
            vicicleHeaders = vicicleHeaderDao.listVicicleHeaderCombox1();
            if(vicicleHeaders.size() < 1 ){
                result.setMessage("data not found");
                result.setStatus("01");
                return result;
            }
            result.setMessage("Success");
            result.setStatus("00");
            result.setData(vicicleHeaders);
            return result;
        }catch (Exception e){
            e.printStackTrace();
            result.setMessage("data not found");
            result.setStatus("01");
            return result;
        }
    }
    //---get data by id
    public VicicleHeaderRes listVicicleHeaderByID (VicicleHeaderReq vicicleHeaderReq){
        List<VicicleHeader> vicicleHeaders = new ArrayList<>();
        VicicleHeaderRes result = new VicicleHeaderRes();
        try {
            vicicleHeaders = vicicleHeaderDao.listVicicleHeaderByID(vicicleHeaderReq);
            if(vicicleHeaders.size() < 1 ){
                result.setMessage("data not found");
                result.setStatus("01");
                return result;
            }
            result.setMessage("Success");
            result.setStatus("00");
            result.setData(vicicleHeaders);
            return result;
        }catch (Exception e){
            e.printStackTrace();
            result.setMessage("data not found");
            result.setStatus("01");
            return result;
        }
    }
    //--del
    public VicicleHeaderRes DelVicicleHeaderByID (VicicleHeaderReq vicicleHeaderReq){
        VicicleHeaderRes result = new VicicleHeaderRes();
        try {
            vicicleHeaderDao.delVicicleHeader(vicicleHeaderReq);
            result.setMessage("Success");
            result.setStatus("00");
            return result;
        }catch (Exception e){
            e.printStackTrace();
            result.setMessage("data not found");
            result.setStatus("01");
            return result;
        }
    }
//--insert data
public VicicleHeaderRes saveVicicleHeader(VicicleHeaderReq vicicleHeaderReq){
log.info("data req:"+vicicleHeaderReq);
    VicicleHeaderRes result = new VicicleHeaderRes();
    try {
        vicicleHeaderDao.saveVicicleHeader(vicicleHeaderReq);
        result.setMessage("Success");
        result.setStatus("00");
        return result;
    }catch (Exception e){
        e.printStackTrace();
        result.setMessage("data not found");
        result.setStatus("01");
        return result;
    }
}
//---update
public VicicleHeaderRes updateVicicleHeader(VicicleHeaderReq vicicleHeaderReq){
    VicicleHeaderRes result = new VicicleHeaderRes();
    try {
        vicicleHeaderDao.updateVicicleHeader(vicicleHeaderReq);
        vicicleHeaderDao.saveHeaderHistroty(vicicleHeaderReq);
        result.setMessage("Success");
        result.setStatus("00");
        return result;
    }catch (Exception e){
        e.printStackTrace();
        result.setMessage("data not found");
        result.setStatus("01");
        return result;
    }
    //---report header
}
    public VicicleHeaderRes ReportHeaderHis(ReportAllReq vicicleHeaderReq){
        VicicleHeaderRes result = new VicicleHeaderRes();
        List<VicicleHeader> ListData = new ArrayList<>();
        try {
            ListData  = vicicleHeaderDao.ReportHistoryHeader(vicicleHeaderReq);
            result.setData(ListData);
            result.setMessage("Success");
            result.setStatus("00");
        }catch (Exception e ){
            e.printStackTrace();
            result.setMessage("data not found");
            result.setStatus("01");
            return result;
        }
        return result;
    }
    //List<ReportHeader> listReportHeader(ReportHeaderReq reportHeaderReq)
    public ReportHeaderRes listReportHeader(ReportHeaderReq vicicleHeaderReq){
        ReportHeaderRes result = new ReportHeaderRes();
        List<ReportHeader> ListData = new ArrayList<>();
        try {
            ListData  = vicicleHeaderDao.listReportHeader(vicicleHeaderReq);
            result.setData(ListData);
            result.setMessage("Success");
            result.setStatus("00");
        }catch (Exception e ){
            e.printStackTrace();
            result.setMessage("data not found");
            result.setStatus("01");
            return result;
        }
        return result;
    }
}
