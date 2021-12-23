package software.project.backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import software.project.backend.service.AuthenticationService;
import software.project.backend.service.userService;

public class AuthenticationController {
    AuthenticationService service=new AuthenticationService();
    @PostMapping("/signup")
    public ResponseEntity<Boolean> signupController(@RequestBody String temp){
        System.out.println(temp);
        if (service.signUp(temp)) return new ResponseEntity<>(true, HttpStatus.OK);
        return new ResponseEntity<>(false, HttpStatus.FORBIDDEN);
    }


    @GetMapping("/checkUsername/{userName}")
    public ResponseEntity<Boolean> checkUsernameController(@PathVariable("userName") String temp){
        System.out.println(temp);
        if(service.checkUserName(temp)) return new ResponseEntity<>(true, HttpStatus.ACCEPTED);
        return new ResponseEntity<>(false, HttpStatus.FORBIDDEN);
    }
    @PostMapping("/signin")
    public ResponseEntity<String> signinController( @RequestBody String dataSent){
        String status=service.signIn(dataSent);
        if (status!=null)  return new ResponseEntity<>(status, HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
    }
}
