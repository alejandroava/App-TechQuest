package com.techquest.app_TechQuest.application.controller.generic;

import org.springframework.http.ResponseEntity;

public interface CreateRegisterTeacher<Entity> {
    ResponseEntity<?> registerUserTeacher(Entity userRegister);
}
