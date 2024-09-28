package com.techquest.app_TechQuest.application.service.generic;

public interface UserRegister <EntityRequest,Entity>{
    Entity registerUser(EntityRequest userRegisterDTO);
}
