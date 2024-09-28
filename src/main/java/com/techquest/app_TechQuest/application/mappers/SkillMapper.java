package com.techquest.app_TechQuest.application.mappers;

import com.techquest.app_TechQuest.application.dto.request.AdminCreateSkillDTO;
import com.techquest.app_TechQuest.domain.model.SkillEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SkillMapper {

    SkillEntity adminCreateSkillToSkillEntity(AdminCreateSkillDTO adminCreateSkillDTO);
}
