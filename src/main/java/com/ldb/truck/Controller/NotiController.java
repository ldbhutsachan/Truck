package com.ldb.truck.Controller;

import com.ldb.truck.Service.NotiService.NotiService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ldb.truck.Model.Login.Noti.NotiRes;
@RestController
@RequestMapping("${base_url}")
public class NotiController {
    private static final Logger log = LogManager.getLogger(NotiController.class);
    @Autowired
    NotiService notiService;
    @CrossOrigin(origins = "*")
    @PostMapping("/getNoti.service")
    public NotiRes getNoti(){
        NotiRes result = new NotiRes();
        try{
            result = notiService.listNoti();
        }catch (Exception e){
            e.printStackTrace();
            result.setStatus("01");
            result.setMessage("exception");
        }
        return  result;
    }
}
