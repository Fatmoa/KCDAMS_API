package com.kcdams.demo.Controller;



import com.kcdams.demo.Dto.loginDTO;
import com.kcdams.demo.Models.Users;
import com.kcdams.demo.Services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/login-auth")
@CrossOrigin
public class LoginController {
    @Autowired
    private LoginService loginServices;

    @GetMapping("/{username}/{password}")
    public Users login_authentication(@PathVariable("username") String username,
                                      @PathVariable("password") String password) {
        return loginServices.login_authentication(username, password);
    }

    @PostMapping("/registration")
    public ResponseEntity<Users> SaveUser(@RequestBody loginDTO dto) {
        Users lgn = loginServices.saveUsers(dto);
        return new ResponseEntity<Users>(lgn, new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping("/updateLoginData/{user_id}")
    public Optional<Users> updateLoginData(@PathVariable("user_id") int user_id, @RequestBody loginDTO dto) {
        return loginServices.updateLoginData(user_id, dto);
    }

    @PutMapping("/resetPassword/{user_id}")
    public Optional<Users> resetPassword(@PathVariable("user_id") int user_id, @RequestBody loginDTO dto) {
        return loginServices.resetPassword(user_id, dto);
    }

    @GetMapping("/getLoginInformationByUserId/{user_id}")
    public Users getLoginInformationByUserId(@PathVariable("user_id") int user_id) {
        return loginServices.getLoginDataByUserId(user_id);
    }

    @GetMapping("/getAllUsers")
    public List<Users> getAllUsers() {
        return loginServices.getAllUsers();
    }
}