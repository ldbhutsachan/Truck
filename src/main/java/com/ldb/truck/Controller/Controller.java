package com.ldb.truck.Controller;

import com.ldb.truck.Model.Login.Login.GetUserLoginRes;
import com.ldb.truck.Model.Login.Login.LoginReq;
import com.ldb.truck.Model.Login.Truck.TruckReq;
import com.ldb.truck.Model.Login.Truck.TruckRes;
import com.ldb.truck.Model.Login.customer.CustomerReq;
import com.ldb.truck.Model.Login.customer.CustomerRes;
import com.ldb.truck.Model.Login.location.LocationReq;
import com.ldb.truck.Model.Login.location.LocationRes;
import com.ldb.truck.Model.Login.product.ProductReq;
import com.ldb.truck.Model.Login.product.ProductRes;
import com.ldb.truck.Model.Login.staft.stafReq;
import com.ldb.truck.Model.Login.staft.staftRes;
import com.ldb.truck.Service.Login.LoginService;
import com.ldb.truck.Service.Product.ProductService;
import com.ldb.truck.Service.Truck.TruckService;
import com.ldb.truck.Service.customer.CustomerService;
import com.ldb.truck.Service.location.LocationService;
import com.ldb.truck.Service.staft.StaftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${base_url}")
public class Controller {
    @Autowired
    CustomerService customerService;
    @Autowired
    StaftService staftService;
    @Autowired
    ProductService productService;
    @Autowired
    LoginService loginService;
    @Autowired
    LocationService locationService;
    @Autowired
    TruckService truckService;

    @CrossOrigin(origins = "*")
    @GetMapping("/test")
    public String Test() throws Exception {

        return "hello";
    }
    @CrossOrigin(origins = "*")
    @PostMapping("/getAllCustomer")
    public CustomerRes  getAllCustomer (){
        CustomerRes result = new CustomerRes();
        try {

            result = customerService.getAllCustomer();

        }catch (Exception e){
            e.printStackTrace();
            result.setStatus("01");
            result.setMessage("exeption");
            return result;
        }
        return result;
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/getCustomerById")
    public CustomerRes  getCustomerById (@RequestBody  CustomerReq customerReq){

        CustomerRes result = new CustomerRes();

        try {

            result = customerService.getCustomerById(customerReq);
        }catch (Exception e){
            e.printStackTrace();
            result.setStatus("01");
            result.setMessage("exeption");
            return result;
        }
        return result;
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/StoreCustomer")
    public CustomerRes  StoreCustomer (@RequestBody  CustomerReq customerReq){

        CustomerRes result = new CustomerRes();

        try {

            result = customerService.StoreCustomer(customerReq);

        }catch (Exception e){
            e.printStackTrace();
            result.setStatus("01");
            result.setMessage("exeption");
            return result;
        }
        return result;
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/UpdateCustomer")
    public CustomerRes  UpdateCustomer (@RequestBody  CustomerReq customerReq){

        CustomerRes result = new CustomerRes();

        try {

            result = customerService.UpdateCustomer(customerReq);

        }catch (Exception e){
            e.printStackTrace();
            result.setStatus("01");
            result.setMessage("exeption");
            return result;
        }
        return result;
    }


    @CrossOrigin(origins = "*")
    @PostMapping("/DeleteCustomer")
    public CustomerRes  DeleteCustomer (@RequestBody  CustomerReq customerReq){

        CustomerRes result = new CustomerRes();

        String id = String.valueOf(customerReq.getId());

        try {

            result = customerService.deleteCustomer(id);

        }catch (Exception e){
            e.printStackTrace();
            result.setStatus("01");
            result.setMessage("exeption");
            return result;
        }
        return result;
    }


    @CrossOrigin(origins = "*")
    @PostMapping("/getAllStaft")
    public staftRes getAllStaft (){

        staftRes result = new staftRes();

        try {

            result = staftService.getAllStaft();

        }catch (Exception e){
            e.printStackTrace();
            result.setStatus("01");
            result.setMessage("exeption");
            return result;
        }
        return result;
    }
    //--List<staftOut> getChooseStaft01(
    @CrossOrigin(origins = "*")
    @PostMapping("/getChooseStaft01.service")
    public staftRes getChooseStaft01(){
        staftRes result = new staftRes();
        try {
            result = staftService.getChooseStaft01();
        }catch (Exception e){
            e.printStackTrace();
            result.setStatus("01");
            result.setMessage("exeption");
            return result;
        }
        return result;
    }
    @CrossOrigin(origins = "*")
    @PostMapping("/getStaftById")
    public staftRes getStaftById (@RequestBody stafReq stafReq){
        staftRes result = new staftRes();

        try {

            result = staftService.getStaftById(stafReq);

        }catch (Exception e){
            e.printStackTrace();
            result.setStatus("01");
            result.setMessage("exeption");
            return result;
        }
        return result;
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/StoreStaft")
    public staftRes  StoreStaft ( @RequestBody stafReq stafReq){

        staftRes result = new staftRes();

        try {

            result = staftService.StoreStaft(stafReq);

        }catch (Exception e){
            e.printStackTrace();
            result.setStatus("01");
            result.setMessage("exeption");
            return result;
        }
        return result;
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/updateStaft")
    public staftRes  updateStaft ( @RequestBody stafReq stafReq){

        staftRes result = new staftRes();

        try {

            result = staftService.UpdateStaft(stafReq);

        }catch (Exception e){
            e.printStackTrace();
            result.setStatus("01");
            result.setMessage("exeption");
            return result;
        }
        return result;
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/DeleteStaft")
    public staftRes  DeleteStaft ( @RequestBody stafReq stafReq){

        staftRes result = new staftRes();

        try {

            result = staftService.DeleteStaft(stafReq.getId());

        }catch (Exception e){
            e.printStackTrace();
            result.setStatus("01");
            result.setMessage("exeption");
            return result;
        }
        return result;
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/getAllProduct")
    public ProductRes getAllProduct (){

        ProductRes result = new ProductRes();

        try {

            result = productService.getAllProcut();

        }catch (Exception e){
            e.printStackTrace();
            result.setStatus("01");
            result.setMessage("exeption");
            return result;
        }
        return result;
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/getProductById")
    public ProductRes getProductById (@RequestBody  ProductReq productReq){

        ProductRes result = new ProductRes();

        try {

            result = productService.getProcutById(productReq);

        }catch (Exception e){
            e.printStackTrace();
            result.setStatus("01");
            result.setMessage("exeption");
            return result;
        }
        return result;
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/StoreProduct")
    public ProductRes StoreProduct (@RequestBody  ProductReq productReq){

        ProductRes result = new ProductRes();

        try {

            result = productService.StoreProcut(productReq);

        }catch (Exception e){
            e.printStackTrace();
            result.setStatus("01");
            result.setMessage("exeption");
            return result;
        }
        return result;
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/UpdateProduct")
    public ProductRes UpdateProduct (@RequestBody  ProductReq productReq){

        ProductRes result = new ProductRes();

        try {

            result = productService.UpdaeProcut(productReq);

        }catch (Exception e){
            e.printStackTrace();
            result.setStatus("01");
            result.setMessage("exeption");
            return result;
        }
        return result;
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/DeleteProduct")
    public ProductRes DeleteProduct (@RequestBody  ProductReq productReq){

        ProductRes result = new ProductRes();

        try {

            result = productService.DeleteProcut(productReq);

        }catch (Exception e){
            e.printStackTrace();
            result.setStatus("01");
            result.setMessage("exeption");
            return result;
        }
        return result;
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/Login")
    public GetUserLoginRes Login (@RequestBody  LoginReq loginReq){
        GetUserLoginRes result = new GetUserLoginRes();
        try {
            result = loginService.Userlogin(loginReq);
        }catch (Exception e){
            e.printStackTrace();
            result.setStatus("01");
            result.setMessage("exeption");
            return result;
        }
        return result;
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/getAllLocation")
    public LocationRes getAllLocation (){
        LocationRes result = new LocationRes();
        try {
            result = locationService.getAllLocation();
        }catch (Exception e){
            e.printStackTrace();
            result.setStatus("01");
            result.setMessage("exeption");
            return result;
        }
        return result;
    }
    @CrossOrigin(origins = "*")
    @PostMapping("/getLocationById")
    public LocationRes getLocationById (@RequestBody LocationReq locationReq){
        LocationRes result = new LocationRes();
        try {
            result = locationService.getLocationById(locationReq);
        }catch (Exception e){
            e.printStackTrace();
            result.setStatus("01");
            result.setMessage("exeption");
            return result;
        }
        return result;
    }
    @CrossOrigin(origins = "*")
    @PostMapping("/StoreLocation")
    public LocationRes StoreProduct (@RequestBody LocationReq locationReq){
        LocationRes result = new LocationRes();
        try {

            result = locationService.StoreLocation(locationReq);

        }catch (Exception e){
            e.printStackTrace();
            result.setStatus("01");
            result.setMessage("exeption");
            return result;
        }
        return result;
    }
    @CrossOrigin(origins = "*")
    @PostMapping("/UpdateLocation")
    public LocationRes UpdateLocation (@RequestBody LocationReq locationReq){
        LocationRes result = new LocationRes();
        try {
            result = locationService.UpdateLocation(locationReq);
        }catch (Exception e){
            e.printStackTrace();
            result.setStatus("01");
            result.setMessage("exeption");
            return result;
        }
        return result;
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/DeleteLocation")
    public LocationRes DeleteLocation (@RequestBody LocationReq locationReq){

        LocationRes result = new LocationRes();

        try {

            result = locationService.DeleteLocation(locationReq);

        }catch (Exception e){
            e.printStackTrace();
            result.setStatus("01");
            result.setMessage("exeption");
            return result;
        }
        return result;
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/getAllTruck")
    public TruckRes getAllTruck (){

        TruckRes result = new TruckRes();

        try {

            result = truckService.getAllTruck();

        }catch (Exception e){
            e.printStackTrace();
            result.setStatus("01");
            result.setMessage("exeption");
            return result;
        }
        return result;
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/getTruckById")
    public TruckRes getTruckById (@RequestBody TruckReq truckReq){

        TruckRes result = new TruckRes();

        try {

            result = truckService.getTruckById(truckReq);

        }catch (Exception e){
            e.printStackTrace();
            result.setStatus("01");
            result.setMessage("exeption");
            return result;
        }
        return result;
    }
    @CrossOrigin(origins = "*")
    @PostMapping("/StoreTruck")
    public TruckRes StoreTruck (@RequestBody TruckReq truckReq){
        TruckRes result = new TruckRes();
        try {
            result = truckService.StoreTruck(truckReq);
        }catch (Exception e){
            e.printStackTrace();
            result.setStatus("01");
            result.setMessage("exeption");
            return result;
        }
        return result;
    }
    @CrossOrigin(origins = "*")
    @PostMapping("/UpdateTruck")
    public TruckRes UpdateTruck (@RequestBody TruckReq truckReq){
        TruckRes result = new TruckRes();
        try {
            result = truckService.UpdateTruck(truckReq);
        }catch (Exception e){
            e.printStackTrace();
            result.setStatus("01");
            result.setMessage("exeption");
            return result;
        }
        return result;
    }
    @CrossOrigin(origins = "*")
    @PostMapping("/DeleteTruck")
    public TruckRes DeleteTruck (@RequestBody TruckReq truckReq){
        TruckRes result = new TruckRes();

        try {

            result = truckService.DeleteTruck(truckReq);

        }catch (Exception e){
            e.printStackTrace();
            result.setStatus("01");
            result.setMessage("exeption");
            return result;
        }
        return result;
    }

}
