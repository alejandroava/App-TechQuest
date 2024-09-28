package com.techquest.app_TechQuest.application.controller.generic;

import org.springframework.http.ResponseEntity;

public interface CreateRegister <Entity> {
    ResponseEntity<?> registerUser(Entity userRegister);
}
