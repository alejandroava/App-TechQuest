package com.techquest.app_TechQuest.application.service.impl;

import com.techquest.app_TechQuest.application.dto.request.MissionSkillDTO;
import com.techquest.app_TechQuest.application.mappers.MissionSkillMapper;
import com.techquest.app_TechQuest.application.service.IModel.IModelMissionSkill;
import com.techquest.app_TechQuest.domain.model.MissionEntity;
import com.techquest.app_TechQuest.domain.model.MissionSkill;
import com.techquest.app_TechQuest.domain.model.SkillEntity;
import com.techquest.app_TechQuest.infrastructure.persistence.MissionRepository;
import com.techquest.app_TechQuest.infrastructure.persistence.MissionSkillRepository;
import com.techquest.app_TechQuest.infrastructure.persistence.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MissionSkillService implements IModelMissionSkill {

    @Autowired
    MissionSkillMapper missionSkillMapper;

    @Autowired
    MissionSkillRepository missionSkillRepository;

    @Autowired
    MissionRepository missionRepository;

    @Autowired
    SkillRepository skillRepository;

    public MissionSkill create(MissionSkillDTO missionSkillDTO) {

        MissionEntity mission = missionRepository.findByTitle(missionSkillDTO.getMission());

        if(mission == null){
            throw new IllegalArgumentException("mission does not exist");
        }

        SkillEntity skill = skillRepository.findByTitle(missionSkillDTO.getSkill());

        if(skill == null){
            throw new IllegalArgumentException("skill does not exist");
        }

        MissionSkill missionSkill = MissionSkill.builder()
                .mission(missionSkillMapper.stringToMissionEntity(missionSkillDTO.getMission()))
                .skill(missionSkillMapper.stringToSkillEntity(missionSkillDTO.getSkill()))
                .build();


        return missionSkillRepository.save(missionSkill);
    }
}
