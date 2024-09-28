package com.techquest.app_TechQuest.application.controller;


import com.techquest.app_TechQuest.application.controller.interfaces.IModelAuth;
import com.techquest.app_TechQuest.application.dto.request.UserRegisterDTO;
import com.techquest.app_TechQuest.application.service.impl.AuthService;
import com.techquest.app_TechQuest.infrastructure.persistence.AuthRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController implements IModelAuth {

    @Autowired
    AuthService authService;

    @PostMapping("/register")
    @Override
    public ResponseEntity<?> registerUser(@RequestBody @Valid UserRegisterDTO userRegister) {
        try {
            authService.registerUser(userRegister);
            return ResponseEntity.status(HttpStatus.CREATED).body(authService.registerUser(userRegister));
        }catch (IllegalArgumentException exception){
        }
    }
}
