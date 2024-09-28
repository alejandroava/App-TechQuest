package com.techquest.app_TechQuest.application.controller.impl;

import com.techquest.app_TechQuest.application.controller.interfaces.IModelStudentSkill;
import com.techquest.app_TechQuest.application.dto.request.AssignSkillDTO;
import org.springframework.http.ResponseEntity;

public class StudentSkillController implements IModelStudentSkill {
    @Override
    public ResponseEntity<?> assignSkill(AssignSkillDTO assignSkillDTO) {
        return null;
    }
}
