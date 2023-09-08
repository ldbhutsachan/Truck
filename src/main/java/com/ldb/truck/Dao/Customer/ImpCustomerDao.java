package com.ldb.truck.Dao.Customer;

import com.ldb.truck.Model.Login.customer.CustomerOut;
import com.ldb.truck.Model.Login.customer.CustomerReq;
import com.ldb.truck.Model.Login.location.LocationOut;
import com.ldb.truck.Model.Login.location.LocationReq;
import com.ldb.truck.Model.Login.product.ProductOut;
import com.ldb.truck.Model.Login.product.ProductReq;
import com.ldb.truck.Model.Login.staft.stafReq;
import com.ldb.truck.Model.Login.staft.staftOut;
import com.ldb.truck.RowMapper.Location.LocationOutMapper;
import com.ldb.truck.RowMapper.Product.ProductMapper;
import com.ldb.truck.RowMapper.customer.getAllcustomerMapper;
import com.ldb.truck.RowMapper.staftMapper.getAllStaftMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Component
@Repository
public class ImpCustomerDao  implements CustomerDao{

    @Autowired
    @Qualifier("EBankJdbcTemplate")
    private JdbcTemplate EBankJdbcTemplate;
    @Override
    public List<CustomerOut> getAllCustomer() {
        List<CustomerOut> result = new ArrayList<>();
        try {

            String SQL = "SELECT KEY_ID , CUSTOMER_ID , CUSTOMER_NAME , ADDRESS , VILLAGE , DISTRICT , PROVICNE , MOBILE1 , MOBILE2 , EMAIL  FROM CUSTOMER  WHERE STATUS='A' ";
            System.out.println(SQL);

            result = EBankJdbcTemplate.query(SQL , new getAllcustomerMapper());

        }catch (Exception e){
            e.printStackTrace();
            return result;
        }
        return result;
    }

    @Override
    public List<CustomerOut> getCustomerById(String id) {
        List<CustomerOut> result = new ArrayList<>();
        try {
            String SQL = "SELECT KEY_ID , CUSTOMER_ID , CUSTOMER_NAME , ADDRESS , VILLAGE , DISTRICT , PROVICNE , MOBILE1 , MOBILE2 , EMAIL  FROM CUSTOMER  WHERE STATUS='A'  AND KEY_ID = '"+id+"' ";
            System.out.println(SQL);
            result = EBankJdbcTemplate.query(SQL , new getAllcustomerMapper());
        }catch (Exception e){
            e.printStackTrace();
            return result;
        }
        return result;
    }
    @Override
    public int StoreCustomer(CustomerReq custoerReq) {

        int i = 0;
        String custId = custoerReq.getCustomerId();
        String custName = custoerReq.getCustomerName();
        String addrss =  custoerReq.getAddress();
        String village = custoerReq.getVilage();
        String district = custoerReq.getDistrict();
        String provicnce = custoerReq.getProvince();
        String mobile = custoerReq.getMobile();
        String mobile1 = custoerReq.getMobile1();
        String email = custoerReq.getEmail();

        try {

            String SQL = "INSERT INTO CUSTOMER (CUSTOMER_ID , CUSTOMER_NAME , ADDRESS , VILLAGE , DISTRICT , PROVICNE , MOBILE1 , MOBILE2 , EMAIL , STATUS)\n" +
                    "VALUES ( '"+custId+"' , '"+custName+"' , '"+addrss+"' , '"+village+"' , '"+district+"' , '"+provicnce+"' , '"+mobile+"' , '"+mobile1+"' , '"+email+"' , 'A') ";

            System.out.println(SQL);
            i = EBankJdbcTemplate.update(SQL);


        }catch (Exception e){
            e.printStackTrace();
            return i;
        }
        return i;
    }

    @Override
    public int UpdateCustomer(CustomerReq custoerReq) {

        int i = 0;
        int id = custoerReq.getId();
        String custId = custoerReq.getCustomerId();
        String custName = custoerReq.getCustomerName();
        String addrss =  custoerReq.getAddress();
        String village = custoerReq.getVilage();
        String district = custoerReq.getDistrict();
        String provicnce = custoerReq.getProvince();
        String mobile = custoerReq.getMobile();
        String mobile1 = custoerReq.getMobile1();
        String email = custoerReq.getEmail();


        try {

            String SQL = " UPDATE  CUSTOMER SET    CUSTOMER_ID ='"+custId+"'  , CUSTOMER_NAME  = '"+custName+"' , ADDRESS = '"+addrss+"' , VILLAGE ='"+village+"' , DISTRICT ='"+district+"' , PROVICNE ='"+provicnce+"', \n" +
                    " MOBILE1 = '"+mobile+"', MOBILE2  ='"+mobile1+"', EMAIL ='"+email+"'  WHERE KEY_ID = '"+id+"' " ;
            i = EBankJdbcTemplate.update(SQL);

        }catch (Exception e){
            e.printStackTrace();
            return  i;
        }

        return i;
    }

    @Override
    public int deleteCustomer(String id) {

        int i = 0;

        try {

            String SQL = "UPDATE CUSTOMER SET STATUS = 'D'  WHERE KEY_ID = '"+id+"' ";

            i = EBankJdbcTemplate.update(SQL);

        }catch (Exception e){
            e.printStackTrace();
            return i;
        }
        return i;
    }


    @Override
    public List<staftOut> getAllStaft() {
        List<staftOut>  result = new ArrayList<>();
        try {
              String SQL = "SELECT  KEY_ID , STAFT_ID , STAFT_NAME , STAFT_SURNAME , ID_CARD , LICENCE_ID , VERIFY_BY , " +
              "LICENCE_ID_EXP , VILLAGE , DISTRICT , PROVINCE , MOBILE1 , MOBILE2, GENDER , GENDER_STATUS , GENDER_STATUS ,DATE_INSERT, USERID   FROM STAFF WHERE STATUS = 'A' ";
            System.out.println("show SQL:"+SQL);
       result = EBankJdbcTemplate.query(SQL , new getAllStaftMapper());

        }catch (Exception e){
            e.printStackTrace();
            return result;
        }
        return result;
    }
    //-----choose staff 01
    @Override
    public List<staftOut> getChooseStaft01() {
        List<staftOut>  result = new ArrayList<>();
        try {
            String SQL = "SELECT  KEY_ID , STAFT_ID , STAFT_NAME , STAFT_SURNAME , ID_CARD , LICENCE_ID , VERIFY_BY , " +
                    "LICENCE_ID_EXP , VILLAGE , DISTRICT , PROVINCE , MOBILE1 , MOBILE2, GENDER , GENDER_STATUS , GENDER_STATUS ,DATE_INSERT, USERID   FROM STAFF WHERE OUT_STATUS = 'N'  and STATUS='A'";
            System.out.println("show SQL:"+SQL);
            result = EBankJdbcTemplate.query(SQL , new getAllStaftMapper());
        }catch (Exception e){
            e.printStackTrace();
            return result;
        }
        return result;
    }
    @Override
    public List<staftOut> getStaftById(String id) {

        List<staftOut>  result = new ArrayList<>();
        try {

            String SQL = "SELECT  KEY_ID , STAFT_ID , STAFT_NAME , STAFT_SURNAME , ID_CARD , LICENCE_ID , VERIFY_BY , " +
                    "LICENCE_ID_EXP , VILLAGE , DISTRICT , PROVINCE , MOBILE1 , MOBILE2, GENDER , GENDER_STATUS , GENDER_STATUS ,DATE_INSERT, USERID   FROM STAFF WHERE STATUS = 'A' AND KEY_ID = '"+id+"' ";

            System.out.println(SQL);
            result = EBankJdbcTemplate.query(SQL , new getAllStaftMapper());

        }catch (Exception e){
            e.printStackTrace();
            return result;
        }
        return result;
    }

    @Override
    public int StoreStaft(stafReq stafReq) {

        int i = 0 ;

        String staftId = stafReq.getStaftId();
        String name = stafReq.getName();
        String surname = stafReq.getSurname();
        String idCard = stafReq.getIdCard();
        String licenceId = stafReq.getLicenceId();
        String verBy = stafReq.getVerBy();
        String licenceExp = stafReq.getLicenceExp();
        String vaillage = stafReq.getVaillage();
        String district = stafReq.getDistrict();
        String province = stafReq.getProvince();
        String mobile = stafReq.getMobile();
        String mobile1 = stafReq.getMobile1();
        String gender = stafReq.getGender();
        String genderStatus = stafReq.getGenderStatus();
        String userId = stafReq.getUserId();

        try {

            String SQL  = " INSERT INTO STAFF ( STATUS , STAFT_ID , STAFT_NAME , STAFT_SURNAME , ID_CARD , LICENCE_ID , VERIFY_BY , LICENCE_ID_EXP , VILLAGE , DISTRICT ,\n" +
                    "PROVINCE , MOBILE1 , MOBILE2 ,GENDER , GENDER_STATUS ,  USERID ) VALUES ( 'A' ,'"+staftId+"' , '"+name+"' , '"+surname+"' , '"+idCard+"' ,\n " +
                    " '"+licenceId+"' , '"+verBy+"' , '"+licenceExp+"' , '"+vaillage+"' , '"+district+"'  ,'"+province+"' , '"+mobile+"' , '"+mobile1+"' , '"+gender+"' , '"+genderStatus+"' ,'"+userId+"') ";

            i= EBankJdbcTemplate.update(SQL);
        }catch (Exception e){
            e.printStackTrace();
            return i;
        }
        return i;
    }

    @Override
    public int UpdateStaft(stafReq stafReq) {

        int i = 0 ;
        String id = stafReq.getId();
        String staftId = stafReq.getStaftId();
        String name = stafReq.getName();
        String surname = stafReq.getSurname();
        String idCard = stafReq.getIdCard();
        String licenceId = stafReq.getLicenceId();
        String verBy = stafReq.getVerBy();
        String licenceExp = stafReq.getLicenceExp();
        String vaillage = stafReq.getVaillage();
        String district = stafReq.getDistrict();
        String province = stafReq.getProvince();
        String mobile = stafReq.getMobile();
        String mobile1 = stafReq.getMobile1();
        String gender = stafReq.getGender();
        String genderStatus = stafReq.getGenderStatus();
        String userId = stafReq.getUserId();

        try {

            String SQL = " UPDATE STAFF  SET STAFT_NAME = '"+name+"' , STAFT_SURNAME ='"+surname+"' , ID_CARD = '"+idCard+"' , LICENCE_ID = '"+licenceId+"'  , VERIFY_BY = '"+verBy+"' , \n" +
                "LICENCE_ID_EXP = '"+licenceExp+"'  , VILLAGE = '"+vaillage+"'  , DISTRICT = '"+district+"'  ,\n" +
                    "PROVINCE ='"+province+"'  , MOBILE1 ='"+mobile+"'  , MOBILE2 = '"+mobile1+"'  ,GENDER = '"+gender+"'  , GENDER_STATUS = '"+genderStatus+"' , USERID = '"+userId+"'   WHERE KEY_ID =  '"+id+"' " ;

            i = EBankJdbcTemplate.update(SQL);
        }catch (Exception e){
            e.printStackTrace();
            return i;
        }
        return i;
    }

    @Override
    public int deleteStaft(String id) {

        int i = 0;

        try {

            String SQL = " UPDATE  STAFF SET STATUS = 'D' WHERE KEY_ID = '"+id+"' ";

            i = EBankJdbcTemplate.update(SQL);

        }catch (Exception e){
            e.printStackTrace();
            return i;
        }
        return i;
    }

    @Override
    public List<ProductOut> getAllProduct() {

        List<ProductOut> restult = new ArrayList<>();

        try {

            String SQL = "SELECT KEY_ID , PRO_ID , PRO_NAME , PRO_TYPE , URL , USERID , DATE_INSERT  FROM PRODUCT  WHERE STATUS = 'A' ORDER BY KEY_ID DESC ";
            System.out.println(SQL);

            restult = EBankJdbcTemplate.query(SQL , new ProductMapper());

        }catch (Exception e){
            e.printStackTrace();
            return restult;
        }

        return restult;
    }

    @Override
    public List<ProductOut> getProductById(String id) {
        List<ProductOut> restult = new ArrayList<>();

        try {

            String SQL = "SELECT KEY_ID , PRO_ID , PRO_NAME , PRO_TYPE , URL , USERID , DATE_INSERT  FROM PRODUCT  WHERE STATUS = 'A'  AND KEY_ID = '"+id+"' ORDER BY KEY_ID DESC ";
            System.out.println(SQL);

            restult = EBankJdbcTemplate.query(SQL , new ProductMapper());

        }catch (Exception e){
            e.printStackTrace();
            return restult;
        }

        return restult;
    }

    @Override
    public int StoreProduct(ProductReq productReq) {
        int i = 0;

        String proId = productReq.getProId();
        String proName = productReq.getProName();
        String proType = productReq.getProType();
        String proUrl = productReq.getProUrl();
        String userId = productReq.getUserId();


        try {

            String SQL = "INSERT INTO PRODUCT ( PRO_ID , PRO_NAME , PRO_TYPE , URL , USERID , DATE_INSERT , STATUS) VALUES ( '"+proId+"' , '"+proName+"' , '"+proType+"' , '"+proUrl+"' , '"+userId+"' , now() , 'A' )";
            System.out.println(SQL);
            i = EBankJdbcTemplate.update(SQL);

        }catch (Exception e){
            e.printStackTrace();
            return i;
        }

        return i;
    }

    @Override
    public int UpdateProduct(ProductReq productReq) {

        int i = 0;

        String proId = productReq.getProId();
        String proName = productReq.getProName();
        String proType = productReq.getProType();
        String proUrl = productReq.getProUrl();
        String userId = productReq.getUserId();

        try {

            String SQL = " UPDATE PRODUCT  SET  PRO_ID = '"+proId+"'  , PRO_NAME = '"+proName+"'  , PRO_TYPE = '"+proType+"'  , URL  = '"+proUrl+"' , USERID  = '"+userId+"' WHERE KEY_ID = '"+productReq.getId()+"' ";
            System.out.println(SQL);
            i = EBankJdbcTemplate.update(SQL);

        }catch (Exception e){
            e.printStackTrace();
            return i;
        }
        return i;
    }

    @Override
    public int deleteProduct(String id) {

        int i = 0;

        try {

            String SQL = " DELETE FROM PRODUCT  WHERE KEY_ID ='"+id+"' ";
            System.out.println(SQL);
            i = EBankJdbcTemplate.update(SQL);

        }catch (Exception e){
            e.printStackTrace();
            return i;
        }
        return i;
    }


    @Override
    public List<LocationOut> getAllLocatino() {

        List<LocationOut> result = new ArrayList<>();

        try {

            String SQL = "SELECT KEY_ID, PROVINCE , DETAIL , STATUS FROM LOCATION WHERE STATUS = 'A' ";

            result = EBankJdbcTemplate.query(SQL , new LocationOutMapper());

        }catch (Exception e){
            e.printStackTrace();
            return result;
        }
        return result;
    }

    @Override
    public List<LocationOut> getLocationById(String id) {
        List<LocationOut> result = new ArrayList<>();

        try {

            String SQL = "SELECT KEY_ID, PROVINCE , DETAIL , STATUS FROM LOCATION WHERE STATUS = 'A' WHERE KEY_ID = '"+id+"' ";

            result = EBankJdbcTemplate.query(SQL , new LocationOutMapper());

        }catch (Exception e){
            e.printStackTrace();
            return result;
        }
        return result;
    }

    @Override
    public int StoreLocation(LocationReq locationReq) {

        String province = locationReq.getProvince();
        String detail = locationReq.getDetail();

        int i = 0;

        try {

            String SQL = "INSERT INTO LOCATION ( PROVINCE , DETAIL , STATUS) VALUES ( '"+province+"' , '"+detail+"' , 'A' ) " ;

            i = EBankJdbcTemplate.update(SQL);

        }catch (Exception e){
            e.printStackTrace();
            return  i;
        }
        return  i;
    }

    @Override
    public int UpdateLocation(LocationReq locationReq) {

        int i = 0;

        try {

            String SQL = " UPDATE LOCATION SET PROVINCE =  '"+locationReq.getProvince()+"', DETAIL = '"+locationReq.getDetail()+"' WHERE KEY_ID = '"+locationReq.getId()+"' " ;

            i = EBankJdbcTemplate.update(SQL);

        }catch (Exception e){
            e.printStackTrace();
            return i;
        }
        return i;
    }

    @Override
    public int DeleteLocation(LocationReq locationReq) {
        int i = 0;

        try {
            String SQL = " UPDATE LOCATION SET STATUS = 'D' WHERE KEY_ID = '"+locationReq.getId()+"' ";

            i = EBankJdbcTemplate.update(SQL);


        }catch (Exception e){
            e.printStackTrace();
            return i;
        }
        return i;
    }
}
