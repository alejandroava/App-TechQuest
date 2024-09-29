package com.techquest.app_TechQuest.application.service.IModel;

import com.techquest.app_TechQuest.application.dto.request.CreateMissionDTO;
import com.techquest.app_TechQuest.domain.model.MissionEntity;

public interface IModelMission {
    MissionEntity createMission(CreateMissionDTO createMissionDTO);
}
