package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.persistence.repository.BasicRepositoryUser;
import com.example.demo.persistence.entity.User;
import com.example.demo.service.UserService;

import com.example.demo.vo.UserVO;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private BasicRepositoryUser basicRepositoryUser;
    @Override
    public List<UserVO> fingAll() {
        List<UserVO> res = new ArrayList<>();
        List<User> userList = (List<User>) basicRepositoryUser.findAll();
        for (User u: userList) {
            UserVO newUser = new UserVO();
            newUser.setId(u.getId());
            newUser.setFirstname(u.getFirstname());
            newUser.setLastname(u.getLastname());
            res.add(newUser);
        }
        return res;
    }
    @Override
    public void createuser(UserVO uservo) {
        User newuser = new User();
        newuser.setFirstname(uservo.getFirstname());
        newuser.setLastname(uservo.getLastname());
        basicRepositoryUser.save(newuser);
        
    }
    @Override
    public void updateuser(Long id, UserVO uservo) {
        if (basicRepositoryUser.findById(id).isPresent()){
            User u = basicRepositoryUser.findById(id).get();
            u.setFirstname(uservo.getFirstname());
            u.setLastname(uservo.getLastname());
            basicRepositoryUser.save(u);
    }
    
}
    @Override
    public void deleteuser(Long id) {
        if (basicRepositoryUser.existsById(id)){
            basicRepositoryUser.deleteById(id);
        }
        
    }
}
