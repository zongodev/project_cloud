package com.example.demo.api;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.UserService;
import com.example.demo.vo.UserVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/user")
public class EcommerceController {
    @Autowired
    private UserService userService;
    @GetMapping(value = "/findall")
    public List<UserVO> findAll(){
        return userService.fingAll();
    }


    @PostMapping(value = "/createuser")
    public void  createUser(@RequestBody UserVO userVO) {
        //TODO: process POST request
        
        userService.createuser(userVO);
    }

    @PutMapping(value = "/updateuser/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody UserVO userVO){
        userService.updateuser(id, userVO);
    }

    @DeleteMapping(value = "/deleteuser/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteuser(id);
    }

    
}
