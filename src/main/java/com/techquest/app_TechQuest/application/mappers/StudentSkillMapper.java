package com.techquest.app_TechQuest.application.mappers;

import com.techquest.app_TechQuest.application.dto.request.AssignSkillDTO;
import com.techquest.app_TechQuest.domain.model.StudentSkill;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentSkillMapper {

    StudentSkill assignSkillToStudentSkill(AssignSkillDTO assignSkillDTO);
}
