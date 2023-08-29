package com.ldb.truck.Service.staft;

import com.ldb.truck.Dao.Customer.ImpCustomerDao;
import com.ldb.truck.Model.Login.staft.stafReq;
import com.ldb.truck.Model.Login.staft.staftOut;
import com.ldb.truck.Model.Login.staft.staftRes;
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
}
