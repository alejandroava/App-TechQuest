package com.techquest.app_TechQuest.application.service.generic;

public interface UserRegister <Entity,EntityRequest>{
    Entity registerUser(EntityRequest userRegisterDTO);
}
