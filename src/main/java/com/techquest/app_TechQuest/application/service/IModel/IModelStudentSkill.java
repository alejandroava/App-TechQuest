package com.techquest.app_TechQuest.application.service.IModel;

import com.techquest.app_TechQuest.application.dto.request.AssignSkillDTO;
import com.techquest.app_TechQuest.application.service.generic.Create;
import com.techquest.app_TechQuest.domain.model.StudentSkill;
import org.springframework.stereotype.Repository;

@Repository
public interface IModelStudentSkill extends Create<AssignSkillDTO, StudentSkill> {
}
