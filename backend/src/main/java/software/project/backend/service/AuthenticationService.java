package software.project.backend.service;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import software.project.backend.Database.UserDAO;
import software.project.backend.Model.User;
import software.project.backend.Model.builder.Director;
import software.project.backend.sercuirty.Singelton;
import software.project.backend.sercuirty.passwordOperations;

public class AuthenticationService {
    private Director director=new Director();
    private Singelton trackingSystem;
    private software.project.backend.sercuirty.passwordOperations passwordOperations=new passwordOperations();
    @Autowired
    private JdbcTemplate jdbcTemplate=new JdbcTemplate();
    private UserDAO userDAO=new UserDAO(jdbcTemplate);
    public boolean signUp(String dataSent){
        User user = (User) director.composeModel("user",dataSent);
        System.out.println(user.getUserName()+
                " "+user.getFirstName()+
                " " +user.getPassword()+
                " "+user.getLastName()+
                " "+user.getAddress()+
                " "+user.getPhone()
        );
        return userDAO.insertUser(user);
    }
    public boolean checkUserName(String userName){
        System.out.println(userName);
        return !userDAO.findByUserName(userName);
    }
    public String signIn(String dataSent){
        String userName;
        String password;
        try {
            JSONObject obj = new JSONObject(dataSent);
            userName=obj.getString("userName");
            password=passwordOperations.passswordToHash(obj.getString("password"));
            System.out.println(userName+"-->"+password);
        } catch (JSONException e) {
            return null;
        }
        String temp= String.valueOf(userDAO.checkSignIn(userName,password));
        if(temp==null) return null;
        trackingSystem= Singelton.getInstance();
        return trackingSystem.addOnlineUser(temp);
    }
}
