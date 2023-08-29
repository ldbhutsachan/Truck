package com.ldb.truck.Controller;

import com.ldb.truck.Model.Login.Owe.OwePayBackRes;
import com.ldb.truck.Model.Login.Pay.PayTxnDetailsRes;
import com.ldb.truck.Model.Login.ResFromDateReq;
import com.ldb.truck.Service.OweService.OweService;
import com.ldb.truck.Model.Login.Owe.OweRes;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${base_url}")
public class OweController {
    private static final Logger log = LogManager.getLogger(OweController.class);
    @Autowired
    OweService oweService;
    @CrossOrigin(origins = "*")
    @PostMapping("/listTxnPayOwe.service")
    public OweRes listTxn(){
        OweRes result =new OweRes();
        try
        {
            result = oweService.listTxnOwe();
        }catch (Exception e){
            e.printStackTrace();
            result.setStatus("01");
            result.setMessage("exeption");
        }
        return result;
    }
    //--
    @CrossOrigin(origins = "*")
    @PostMapping("/OweReport.service")
    public OwePayBackRes getListReportOweContrller(@RequestBody ResFromDateReq resFromDateReq){
        OwePayBackRes result = new OwePayBackRes();
        try
        {
            result = oweService.listReportOwe(resFromDateReq);
            result.setStatus("00");
            result.setMessage("sucess");

        }catch (Exception e){
            e.printStackTrace();
            result.setStatus("01");
            result.setMessage("exeption");
        }
        return result;
    }
    //--get by date to date
    @CrossOrigin(origins = "*")
    @PostMapping("/OweReportByDate.service")
    public OwePayBackRes getListReportByDateOweController(ResFromDateReq resFromDateReq){
        OwePayBackRes result = new OwePayBackRes();
        try
        {
            result = oweService.listReportOweByDate(resFromDateReq);
            result.setStatus("00");
            result.setMessage("sucess");

        }catch (Exception e){
            e.printStackTrace();
            result.setStatus("01");
            result.setMessage("exeption");
        }
        return result;
    }

}
