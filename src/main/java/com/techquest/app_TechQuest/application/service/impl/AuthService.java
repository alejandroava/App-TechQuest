package com.techquest.app_TechQuest.application.service.impl;

import com.techquest.app_TechQuest.application.dto.request.LoginRequestDTO;
import com.techquest.app_TechQuest.application.dto.request.UserRegisterDTO;
import com.techquest.app_TechQuest.application.dto.response.LoginResponseDTO;
import com.techquest.app_TechQuest.application.mappers.AuthMapper;
import com.techquest.app_TechQuest.application.service.IModel.IModelAuth;
import com.techquest.app_TechQuest.domain.model.UserEntity;
import com.techquest.app_TechQuest.infrastructure.helpers.JWTService;
import com.techquest.app_TechQuest.infrastructure.persistence.AuthRepository;
import com.techquest.app_TechQuest.utils.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements IModelAuth {

    @Autowired
    AuthRepository authRepository;

    @Autowired
    AuthMapper authMapper;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JWTService jwtService;


    @Override
    public UserEntity registerUser(UserRegisterDTO userRegisterDTO, Role role) {

        UserEntity userExist = authRepository.findByEmail(userRegisterDTO.getEmail());
        if(userExist != null){
            throw new IllegalArgumentException("email exist");
        }

        UserEntity user = authMapper.userRegisterDTOToUserEntity(userRegisterDTO);
        user.setRole(role);

        return authRepository.save(user);
    }

    @Override
    public LoginResponseDTO login(LoginRequestDTO loginRequestDTO) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequestDTO.getEmail(), loginRequestDTO.getPassword()));
        if(authentication.isAuthenticated()){
            LoginResponseDTO loginResponseDTO = LoginResponseDTO.builder()
                    .id(authRepository.findByEmail(loginRequestDTO.getEmail()).getId())
                    .role(authRepository.findByEmail(loginRequestDTO.getEmail()).getRole())
                    .token(jwtService.getToken(loginRequestDTO))
                    .build()
        }

        return null;
    }
}
