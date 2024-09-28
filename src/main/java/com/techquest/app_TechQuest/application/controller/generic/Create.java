package com.techquest.app_TechQuest.application.controller.generic;

import org.springframework.http.ResponseEntity;

public interface Create <Entity> {
    ResponseEntity<?> create(Entity entity);
}
