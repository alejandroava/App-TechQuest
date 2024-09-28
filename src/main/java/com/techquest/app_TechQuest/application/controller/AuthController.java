package com.techquest.app_TechQuest.application.controller;


import com.techquest.app_TechQuest.application.controller.interfaces.IModelAuth;
import com.techquest.app_TechQuest.application.dto.request.UserRegisterDTO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController implements IModelAuth {


    @PostMapping("/register")
    @Override
    public UserRegisterDTO registerUser(@RequestBody @Valid UserRegisterDTO userRegister) {
        return null;
    }
}
