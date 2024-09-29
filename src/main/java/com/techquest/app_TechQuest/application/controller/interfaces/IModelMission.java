package com.techquest.app_TechQuest.application.controller.interfaces;

import com.techquest.app_TechQuest.application.dto.request.CreateMissionDTO;
import org.springframework.http.ResponseEntity;

public interface IModelMission {
    ResponseEntity<?> createMission(CreateMissionDTO createMissionDTO);
}
