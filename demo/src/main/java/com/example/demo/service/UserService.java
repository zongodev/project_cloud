package com.example.demo.service;

import java.util.List;

import com.example.demo.vo.UserVO;

public interface UserService {
    List<UserVO> fingAll();


    void createuser(UserVO uservo);
    void updateuser(Long id , UserVO uservo );
    void deleteuser(Long id );
}
