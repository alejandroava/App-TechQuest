package com.techquest.app_TechQuest.application.service.impl;

import com.techquest.app_TechQuest.application.dto.request.UserRegisterDTO;
import com.techquest.app_TechQuest.application.mappers.AuthMapper;
import com.techquest.app_TechQuest.application.service.IModel.IModelAuth;
import com.techquest.app_TechQuest.domain.model.UserEntity;
import com.techquest.app_TechQuest.infrastructure.persistence.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements IModelAuth {

    @Autowired
    AuthRepository authRepository;

    @Autowired
    AuthMapper authMapper;

    @Override
    public UserEntity registerUser(UserRegisterDTO userRegisterDTO) {

        UserEntity userExist = authRepository.findByEmail(userRegisterDTO.getEmail());
        if(userExist != null){
            throw new IllegalArgumentException("email exist");
        }

        UserEntity user = authMapper.userRegisterDTOToUserEntity(userRegisterDTO);

        return authRepository.save(user);
    }
}
