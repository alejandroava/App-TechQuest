package com.techquest.app_TechQuest.application.mappers;


import com.techquest.app_TechQuest.application.dto.request.UserRegisterDTO;
import com.techquest.app_TechQuest.domain.model.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthMapper {

    UserEntity userRegisterDTOToUserEntity(UserRegisterDTO userRegisterDTO);
}
