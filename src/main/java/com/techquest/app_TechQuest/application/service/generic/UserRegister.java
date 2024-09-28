package com.techquest.app_TechQuest.application.service.generic;

public interface UserRegister <EntityRequest,Entity,EntityRole>{
    Entity registerUser(EntityRequest userRegisterDTO,EntityRole role);
}
