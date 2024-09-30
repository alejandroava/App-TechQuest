package com.techquest.app_TechQuest.application.mappers;

import com.techquest.app_TechQuest.domain.model.MissionEntity;
import com.techquest.app_TechQuest.domain.model.SkillEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MissionSkillMapper {

    MissionEntity stringToMissionEntity(String mission);
    SkillEntity stringToSkillEntity(String skill);

}
