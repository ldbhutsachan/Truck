package com.ldb.truck.Service.staft;

import com.ldb.truck.Dao.Customer.ImpCustomerDao;
import com.ldb.truck.Model.Login.ReportStaff.ReportStaff;
import com.ldb.truck.Model.Login.ReportStaff.ReportStaffReq;
import com.ldb.truck.Model.Login.ReportStaff.ReportStaffRes;
import com.ldb.truck.Model.Login.ReportStaff.Staff;
import com.ldb.truck.Model.Login.ResFromDateReq;
import com.ldb.truck.Model.Login.staft.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StaftService {

    @Autowired
    ImpCustomerDao impCustomerDao;

    public staftRes getAllStaft (){
        staftRes result = new staftRes();
        List<staftOut> data = new ArrayList<>();
        try {
            data = impCustomerDao.getAllStaft();
            if(data.size() < 1 ){

                result.setMessage("data not found ");
                result.setStatus("01");
                return  result;
            }
            result.setMessage("success");
            result.setStatus("00");
            result.setData(data);
            return  result;
        }catch (Exception e) {
            e.printStackTrace();
            result.setMessage("data not found ");
            result.setStatus("01");
            return result;
        }
    }
    //--List<staftOut> getChooseStaft01()
    public staftRes getChooseStaft01 (){
        staftRes result = new staftRes();
        List<staftOut> data = new ArrayList<>();
        try {
            data = impCustomerDao.getChooseStaft01();
            if(data.size() < 1 ){

                result.setMessage("data not found ");
                result.setStatus("01");
                return  result;
            }
            result.setMessage("success");
            result.setStatus("00");
            result.setData(data);
            return  result;
        }catch (Exception e) {
            e.printStackTrace();
            result.setMessage("data not found ");
            result.setStatus("01");
            return result;
        }
    }
    public staftRes getStaftById (stafReq stafReq){

        staftRes result = new staftRes();
        List<staftOut> data = new ArrayList<>();

        try {

            data = impCustomerDao.getStaftById(stafReq.getId());

            if(data.size() < 1 ){

                result.setMessage("data not found ");
                result.setStatus("01");
                return  result;
            }
            result.setMessage("success");
            result.setStatus("00");
            result.setData(data);
            return  result;
        }catch (Exception e) {
            e.printStackTrace();
            result.setMessage("data not found ");
            result.setStatus("01");
            return result;
        }
    }

    public staftRes UpdateStaft (stafReq stafReq){

        staftRes result = new staftRes();
     int i = 0;

        try {

            i = impCustomerDao.UpdateStaft(stafReq);

            if(i == 0 ){

                result.setMessage(" can not update stft");
                result.setStatus("01");
                return  result;
            }
            result.setMessage("success");
            result.setStatus("00");
            return  result;
        }catch (Exception e) {
            e.printStackTrace();
            result.setMessage(" can not update stft");
            result.setStatus("01");
            return result;
        }
    }

    public staftRes StoreStaft (stafReq stafReq){


        staftRes result = new staftRes();
        int i = 0;

        try {

            i = impCustomerDao.StoreStaft(stafReq);

            if(i == 0 ){

                result.setMessage(" can not store stft");
                result.setStatus("01");
                return  result;
            }
            result.setMessage("success");
            result.setStatus("00");
            return  result;
        }catch (Exception e) {
            e.printStackTrace();
            result.setMessage(" can not store stft");
            result.setStatus("01");
            return result;
        }
    }

    public staftRes DeleteStaft ( String id){


        staftRes result = new staftRes();
        int i = 0;

        try {

            i = impCustomerDao.deleteStaft(id);

            if(i == 0 ){

                result.setMessage(" can not delete stft");
                result.setStatus("01");
                return  result;
            }
            result.setMessage("success");
            result.setStatus("00");
            return  result;
        }catch (Exception e) {
            e.printStackTrace();
            result.setMessage(" can not delete stft");
            result.setStatus("01");
            return result;
        }
    }
    //-------wait pay staff
    public ReportStaffRes ListWaiyPaymentStaff(){
        List<ReportStaff> listdata = new ArrayList<>();
        ReportStaffRes result = new ReportStaffRes();
        try{
            listdata = impCustomerDao.ListWaiyPaymentStaff();
            result.setData(listdata);
            result.setStatus("00");
            result.setMessage("success");
        }catch (Exception e){
            e.printStackTrace();
            result.setStatus("01");
            result.setMessage("data not found");
        }
        return result;
    }
    //=======payment staff========================
    public ReportStaffRes paymentStaff(StaffPaymentReq staffPaymentReq){
        List<ReportStaff> listdata = new ArrayList<>();
        ReportStaffRes result = new ReportStaffRes();
        int checkData= 0;
        int checkData01= 0;
        try{
            checkData01=impCustomerDao.paymentStaffUpdate(staffPaymentReq);
            checkData = impCustomerDao.paymentStaff(staffPaymentReq);
            if(checkData == 0 && checkData01==0){
                result.setStatus("01");
                result.setMessage("can't save data");
                return result;
            }else
            {
                result.setStatus("00");
                result.setMessage("save data done ");
                return result;

            }
        }catch (Exception e){
            e.printStackTrace();
            result.setStatus("01");
            result.setMessage("data not found");
        }
        return result;
    }
    //-----report sum staff
    public ReportStaffRes ReportStaffPeymnet(ResFromDateReq resFromDateReq){
        List<ReportStaff> listdata = new ArrayList<>();
        ReportStaffRes result = new ReportStaffRes();
        List<Staff> liststaff = new ArrayList<>();

        try{
            listdata = impCustomerDao.ReportStaffPeymnet(resFromDateReq);
            result.setData(listdata);
            result.setStatus("00");
            result.setMessage("success");
        }catch (Exception e){
            e.printStackTrace();
            result.setStatus("01");
            result.setMessage("data not found");
        }
        return result;
    }
    //================================>ListStaffPay<============================================
    public StaffPayRes ReportListStaffPay(StaffPayReq staffPayReq){
        List<StaffPay> listdata = new ArrayList<>();
        StaffPayRes result = new StaffPayRes();
        List<Staff> liststaff = new ArrayList<>();
        try{
            listdata = impCustomerDao.ListStaffPay(staffPayReq);
            result.setData(listdata);
            result.setStatus("00");
            result.setMessage("success");
        }catch (Exception e){
            e.printStackTrace();
            result.setStatus("01");
            result.setMessage("data not found");
        }
        return result;
    }
    //========================================>ListStaffPaydetailsByStaffId<=============================
    public ReportStaffRes ListWaiyPaymentStaffByID(StaffPayReq staffPayReq){
        List<ReportStaff> listdata = new ArrayList<>();
        ReportStaffRes result = new ReportStaffRes();
        try{
            listdata = impCustomerDao.ListStaffPaydetailsByStaffId(staffPayReq);
            result.setData(listdata);
            result.setStatus("00");
            result.setMessage("success");
        }catch (Exception e){
            e.printStackTrace();
            result.setStatus("01");
            result.setMessage("data not found");
        }
        return result;
    }

}
