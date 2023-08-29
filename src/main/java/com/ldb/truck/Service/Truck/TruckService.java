package com.ldb.truck.Service.Truck;

import com.ldb.truck.Dao.Truck.ImpTruckDao;
import com.ldb.truck.Model.Login.Truck.TruckOut;
import com.ldb.truck.Model.Login.Truck.TruckReq;
import com.ldb.truck.Model.Login.Truck.TruckRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TruckService {

    @Autowired
    ImpTruckDao impTruckDao;

    public TruckRes getAllTruck (){
        List<TruckOut> listTruck = new ArrayList<>();
        TruckRes result = new TruckRes();
        try {
            listTruck = impTruckDao.getAllTruck();
            if(listTruck.size() < 1 ){
                result.setMessage("data not found");
                result.setStatus("01");
                return result;
            }
            result.setMessage("Success");
            result.setStatus("00");
            result.setData(listTruck);
            return result;
        }catch (Exception e){
            e.printStackTrace();
            result.setMessage("data not found");
            result.setStatus("01");
            return result;
        }
    }
    public TruckRes getTruckById (TruckReq truckReq){
        List<TruckOut> listTruck = new ArrayList<>();
        TruckRes result = new TruckRes();
        try {
            listTruck = impTruckDao.getTruckById(truckReq);

            if(listTruck.size() < 1 ){
                result.setMessage("data not found");
                result.setStatus("01");
                return result;
            }
            result.setMessage("Success");
            result.setStatus("00");
            result.setData(listTruck);
            return result;

        }catch (Exception e){
            e.printStackTrace();
            result.setMessage("data not found");
            result.setStatus("01");
            return result;
        }
    }

    public TruckRes StoreTruck (TruckReq truckReq){
        TruckRes result = new TruckRes();
        int i = 0;
        try {
            i = impTruckDao.StoreTruck(truckReq);
            if(i == 0){
                result.setMessage(" can not store truck");
                result.setStatus("01");
                return result;
            }
            result.setMessage("Success");
            result.setStatus("00");
            return result;
        }catch (Exception e){
            e.printStackTrace();

            result.setMessage(" can not store truck");
            result.setStatus("01");
            return result;
        }
    }

    public TruckRes UpdateTruck (TruckReq truckReq){

        TruckRes result = new TruckRes();

        int i = 0 ;

        try {

            i = impTruckDao.updateTruck(truckReq);

            if(i == 0){

                result.setMessage(" can not update truck");
                result.setStatus("01");
                return result;
            }

            result.setMessage("Success");
            result.setStatus("00");
            return result;


        }catch (Exception e){
            e.printStackTrace();
            result.setMessage(" can not update truck");
            result.setStatus("01");
            return result;
        }

    }

    public TruckRes DeleteTruck (TruckReq truckReq){

        int id = Integer.parseInt(truckReq.getId());

        TruckRes result = new TruckRes();
        int i = 0;

        try {

            i = impTruckDao.deleteTruck(id);

            if(i == 0){

                result.setMessage(" can not delete truck");
                result.setStatus("01");
                return result;
            }

            result.setMessage("success");
            result.setStatus("00");
            return result;

        }catch (Exception e){
            e.printStackTrace();

            result.setMessage(" can not delete truck");
            result.setStatus("01");
            return result;
        }
    }


}
