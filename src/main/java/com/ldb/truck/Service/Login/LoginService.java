package com.ldb.truck.Service.Login;

import com.ldb.truck.Dao.Login.ImploginDao;
import com.ldb.truck.Model.Login.Login.GetUserLoginOut;
import com.ldb.truck.Model.Login.Login.GetUserLoginReq;
import com.ldb.truck.Model.Login.Login.GetUserLoginRes;
import com.ldb.truck.Model.Login.Login.LoginReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoginService {
    @Autowired
    ImploginDao imploginDao;
    public GetUserLoginRes Userlogin(LoginReq loginReq){
        GetUserLoginRes result = new GetUserLoginRes();
        List<GetUserLoginOut> listData = new ArrayList<>();
        GetUserLoginOut data = new GetUserLoginOut();
        try {
            listData = imploginDao.Login(loginReq);
            if(listData.size() < 1){
                result.setMessage("user or password incorrect");
                result.setStatus("01");
                return result;
            }
            data.setStaftName(listData.get(0).getStaftName());
            data.setStaftId(listData.get(0).getStaftId());
            data.setRole(listData.get(0).getRole());
            result.setMessage("success");
            result.setStatus("00");
            result.setData(data);
            return result;
        }catch (Exception e){
            e.printStackTrace();
            result.setMessage("user or password incorrect");
            result.setStatus("01");
            return result;
        }

    }
}
