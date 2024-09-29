package com.techquest.app_TechQuest.application.mappers;

import com.techquest.app_TechQuest.utils.MissionDifficulty;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MissionMapper {

    MissionDifficulty stringToMissionDifficulty(String difficulty);
}
