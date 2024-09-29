package com.techquest.app_TechQuest.application.service.impl;

import com.techquest.app_TechQuest.application.dto.request.CreateMissionDTO;
import com.techquest.app_TechQuest.application.mappers.MissionMapper;
import com.techquest.app_TechQuest.application.service.IModel.IModelMission;
import com.techquest.app_TechQuest.domain.model.MissionEntity;
import com.techquest.app_TechQuest.infrastructure.persistence.MissionRepository;
import com.techquest.app_TechQuest.utils.MissionDifficulty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serial;

@Service
public class MissionService implements IModelMission {

    @Autowired
    MissionRepository missionRepository;

    @Autowired
    MissionMapper missionMapper;

    @Override
    public MissionEntity createMission(CreateMissionDTO createMissionDTO) {

        MissionEntity mission = missionRepository.findByTitle(createMissionDTO.getTitle());
        if(mission != null){
            throw new IllegalArgumentException("mission exist");
        }

        MissionDifficulty missionDifficulty = missionMapper.stringToMissionDifficulty(createMissionDTO.getDifficulty());

        MissionEntity missionEntity = MissionEntity.builder()
                .title(createMissionDTO.getTitle())
                .description(createMissionDTO.getDescription())
                .difficulty(missionDifficulty)
                .build();

        return missionRepository.save(missionEntity);

    }
}
