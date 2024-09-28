package com.techquest.app_TechQuest.application.controller.impl;

import com.techquest.app_TechQuest.application.controller.interfaces.IModelSkill;
import com.techquest.app_TechQuest.application.dto.request.AdminCreateSkillDTO;
import com.techquest.app_TechQuest.application.exeptions.ErrorSimple;
import com.techquest.app_TechQuest.application.service.impl.SkillService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SkillController implements IModelSkill {

    @Autowired
    SkillService skillService;

    @Override
    @PostMapping("/admin/create")
    public ResponseEntity<?> create(@RequestBody @Valid AdminCreateSkillDTO adminCreateSkillDTO) {
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(skillService.createSkill(adminCreateSkillDTO));
        }catch (IllegalArgumentException exception){
            ErrorSimple errorResponse = ErrorSimple.builder()
                    .code(HttpStatus.BAD_REQUEST.value())
                    .status(HttpStatus.BAD_REQUEST.getReasonPhrase())
                    .message(exception.getMessage())
                    .build();

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorResponse);
        }
    }

}

