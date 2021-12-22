package software.project.backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import software.project.backend.service.adminService;

@RestController
@CrossOrigin
public class AdminController {
    adminService service=new adminService();
    @PostMapping("/admin/addProduct")
    public ResponseEntity<Boolean> signupController(@RequestBody String temp){
        if (service.addProduct(temp)) return new ResponseEntity<>(true, HttpStatus.OK);
        return new ResponseEntity<>(false, HttpStatus.FORBIDDEN);
    }

}
