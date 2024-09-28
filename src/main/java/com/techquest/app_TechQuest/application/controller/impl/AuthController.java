package com.techquest.app_TechQuest.application.controller.impl;


import com.techquest.app_TechQuest.application.controller.interfaces.IModelAuth;
import com.techquest.app_TechQuest.application.dto.request.UserRegisterDTO;
import com.techquest.app_TechQuest.application.exeptions.ErrorSimple;
import com.techquest.app_TechQuest.application.service.impl.AuthService;
import com.techquest.app_TechQuest.utils.Role;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
public class AuthController implements IModelAuth {

    @Autowired
    AuthService authService;


    @PostMapping("/student")
    @Override
    public ResponseEntity<?> registerUser(@RequestBody @Valid UserRegisterDTO userRegister) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(authService.registerUser(userRegister, Role.STUDENT));
        }catch (IllegalArgumentException exception){
            ErrorSimple errorResponse = ErrorSimple.builder()
                    .code(HttpStatus.BAD_REQUEST.value())
                    .status(HttpStatus.BAD_REQUEST.getReasonPhrase())
                    .message(exception.getMessage())
                    .build();

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorResponse);
        }
    }

    @PostMapping("/teacher")
    @Override
    public ResponseEntity<?> registerUserTeacher(@RequestBody @Valid UserRegisterDTO userRegister) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(authService.registerUser(userRegister, Role.TEACHER));
        }catch (IllegalArgumentException exception){
            ErrorSimple errorResponse = ErrorSimple.builder()
                    .code(HttpStatus.BAD_REQUEST.value())
                    .status(HttpStatus.BAD_REQUEST.getReasonPhrase())
                    .message(exception.getMessage())
                    .build();

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorResponse);
        }
    }

    @PostMapping("/admin")
    @Override
    public ResponseEntity<?> registerUserAdmin(@RequestBody @Valid  UserRegisterDTO userRegister) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(authService.registerUser(userRegister, Role.ADMIN));
        }catch (IllegalArgumentException exception){
            ErrorSimple errorResponse = ErrorSimple.builder()
                    .code(HttpStatus.BAD_REQUEST.value())
                    .status(HttpStatus.BAD_REQUEST.getReasonPhrase())
                    .message(exception.getMessage())
                    .build();

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorResponse);
        }
    }
}
