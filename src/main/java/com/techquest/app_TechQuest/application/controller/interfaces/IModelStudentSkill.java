package com.techquest.app_TechQuest.application.controller.interfaces;

import com.techquest.app_TechQuest.application.controller.generic.Create;
import com.techquest.app_TechQuest.application.dto.request.AssignSkillDTO;
import com.techquest.app_TechQuest.domain.model.StudentSkill;
import org.springframework.http.ResponseEntity;

public interface IModelStudentSkill {
    public ResponseEntity<?> assignSkill (AssignSkillDTO assignSkillDTO);
}
