package com.ldb.truck.Controller;
import com.ldb.truck.Model.Login.VicicleHeader.VicicleHeaderReq;
import com.ldb.truck.Model.Login.VicicleHeader.VicicleHeaderRes;
import com.ldb.truck.Service.VicicleHeaderService.VicicleHeaderService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${base_url}")
public class VicicleHeaderController {
    private static final Logger log = LogManager.getLogger(VicicleHeaderController.class);
    @Autowired
    VicicleHeaderService vicicleHeaderService;
    @CrossOrigin(origins = "*")
    @PostMapping("/listVicicleHeader.service")
    public VicicleHeaderRes listVicicleHeader(){
        VicicleHeaderRes result = new VicicleHeaderRes();
        try {
            result = vicicleHeaderService.listVicicleHeader();
        }catch (Exception e){
            e.printStackTrace();
            result.setStatus("01");
            result.setMessage("exeption");
            return result;
        }
        return result;
    }
    //---
    @CrossOrigin(origins = "*")
    @PostMapping("/listVicicleHeaderCombo1.service")
    public VicicleHeaderRes listVicicleHeaderCombo1(){
        VicicleHeaderRes result = new VicicleHeaderRes();
        try {
            result = vicicleHeaderService.listVicicleHeaderCombo1();
        }catch (Exception e){
            e.printStackTrace();
            result.setStatus("01");
            result.setMessage("exeption");
            return result;
        }
        return result;
    }
    //
    @CrossOrigin(origins = "*")
    @PostMapping("/listVicicleHeaderByID.service")
    public VicicleHeaderRes listVicicleHeaderByID(@RequestBody  VicicleHeaderReq vicicleHeaderReq){
        VicicleHeaderRes result = new VicicleHeaderRes();
        try {
            result = vicicleHeaderService.listVicicleHeaderByID(vicicleHeaderReq);
        }catch (Exception e){
            e.printStackTrace();
            result.setStatus("01");
            result.setMessage("exeption");
            return result;
        }
        return result;
    }
    //--delete
    @CrossOrigin(origins = "*")
    @PostMapping("/DelVicicleHeaderByID.service")
    public VicicleHeaderRes DelVicicleHeaderByID (@RequestBody VicicleHeaderReq vicicleHeaderReq) {

        VicicleHeaderRes result = new VicicleHeaderRes();
        try {
            result = vicicleHeaderService.DelVicicleHeaderByID(vicicleHeaderReq);
        }catch (Exception e){
            e.printStackTrace();
            result.setStatus("01");
            result.setMessage("exeption");
            return result;
        }
        return result;
    }
    //save data
    @CrossOrigin(origins = "*")
    @PostMapping("/saveVicicleHeaderByID.service")
    public VicicleHeaderRes saveVicicleHeader(@RequestBody VicicleHeaderReq vicicleHeaderReq) {
        log.info("=================================================>SaveVicicleHeader service<===============================================");
        VicicleHeaderRes result = new VicicleHeaderRes();
        try {
            result = vicicleHeaderService.saveVicicleHeader(vicicleHeaderReq);
        }catch (Exception e){
            e.printStackTrace();
            result.setStatus("01");
            result.setMessage("exeption");
            return result;
        }
        return result;
    }
    //update data
    @CrossOrigin(origins = "*")
    @PostMapping("/updateVicicleHeaderByID.service")
    public VicicleHeaderRes updateVicicleHeader(@RequestBody VicicleHeaderReq vicicleHeaderReq) {
        log.info("reqReson:"+vicicleHeaderReq.getHis_REASON());
        log.info("reqResonkey:"+vicicleHeaderReq.getKey_id());

        VicicleHeaderRes result = new VicicleHeaderRes();
        try {
            result = vicicleHeaderService.updateVicicleHeader(vicicleHeaderReq);
        }catch (Exception e){
            e.printStackTrace();
            result.setStatus("01");
            result.setMessage("exeption");
            return result;
        }
        return result;
    }
}
