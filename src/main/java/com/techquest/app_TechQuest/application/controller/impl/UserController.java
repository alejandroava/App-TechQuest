package com.techquest.app_TechQuest.application.controller.impl;

import com.techquest.app_TechQuest.application.controller.interfaces.IModelUser;
import com.techquest.app_TechQuest.application.dto.request.AdminCreateSkillDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements IModelUser {

    @Autowired

    @Override
    public ResponseEntity<?> create(AdminCreateSkillDTO adminCreateSkillDTO) {
        return null;
    }
}
