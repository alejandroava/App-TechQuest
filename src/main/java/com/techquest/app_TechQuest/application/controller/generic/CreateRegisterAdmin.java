package com.techquest.app_TechQuest.application.controller.generic;

import org.springframework.http.ResponseEntity;

public interface CreateRegisterAdmin <Entity> {
    ResponseEntity<?> registerUserAdmin(Entity userRegister);
}
