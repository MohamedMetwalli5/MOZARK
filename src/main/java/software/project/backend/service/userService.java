package software.project.backend.service;

import org.json.JSONException;
import org.json.JSONObject;
import software.project.backend.Model.User;
import software.project.backend.Model.builder.Director;
import software.project.backend.sercuirty.Singelton;
import software.project.backend.sercuirty.passwordOperations;

public class userService {
    private Director director=new Director();
    private Singelton trackingSystem;
    private passwordOperations passwordOperations=new passwordOperations();

    public boolean signUp(String dataSent){
        User user = (User) director.composeModel("user",dataSent);
        //sent to database function
        return true;
    }
    public boolean checkUserName(String userName){
        return true;//
    }
    public String signIn(String dataSent){
        String userName;
        String password;
        try {
            JSONObject obj = new JSONObject(dataSent);
            userName=obj.getString("userName");
            password=passwordOperations.passswordToHash(obj.getString("password"));
        } catch (JSONException e) {
            return null;
        }
        String temp=null;// dbOperations.readuserFromdb(userName);
        if(temp==null) return null;
        trackingSystem= Singelton.getInstance();
        return trackingSystem.addOnlineUser(temp);
    }
}
