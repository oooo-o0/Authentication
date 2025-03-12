package com.example.app.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private Map<String, String> userTable;

    public LoginService() {
        userTable = new HashMap<>();
        userTable.put("taro", "abc");
        userTable.put("jiro", "xyz");
        userTable.put("hanako", "123");
    }
    public boolean checkIdAndPass(String loginId, String pass) {
        String authPass = userTable.get(loginId);
        if (authPass == null) {
            System.out.println("不正なログインID");
            return false;
        }
        if(!pass.equals(authPass)) {
            System.out.println("不正なパスワード");
            return false;
        }
        return true;
    }
}

