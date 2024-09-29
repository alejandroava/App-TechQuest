package com.techquest.app_TechQuest.application.controller.impl;

import com.techquest.app_TechQuest.application.controller.interfaces.IModelStudentSkill;
import com.techquest.app_TechQuest.application.dto.request.AssignSkillDTO;
import com.techquest.app_TechQuest.application.dto.response.AssignSkillResponseDTO;
import com.techquest.app_TechQuest.application.exeptions.ErrorSimple;
import com.techquest.app_TechQuest.application.service.impl.StudentSkillService;
import com.techquest.app_TechQuest.domain.model.StudentSkill;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentSkillController implements IModelStudentSkill {

    @Autowired
    StudentSkillService studentSkillService;

    @Override
    @PostMapping("/student-skill/assign")
    public ResponseEntity<?> assignSkill(@RequestBody @Valid AssignSkillDTO assignSkillDTO) {
        try {
            StudentSkill studentSkill= studentSkillService.createSkill(assignSkillDTO);
            AssignSkillResponseDTO assignSkillResponseDTO = AssignSkillResponseDTO.builder()
                    .skill(studentSkill.getSkill().getTitle())
                    .user(studentSkill.getUser().getName())
                    .build();
            return ResponseEntity.status(HttpStatus.CREATED).body(assignSkillResponseDTO);
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

