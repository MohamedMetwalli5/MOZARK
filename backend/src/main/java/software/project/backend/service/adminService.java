package software.project.backend.service;

import software.project.backend.Model.Product;
import software.project.backend.Model.builder.Director;

public class adminService {
    private Director director=new Director();
    public boolean addProduct(String dataSent){
        Product product=(Product) director.composeModel("product",dataSent);
        //sent to dataBase
        return true;
    }
}
