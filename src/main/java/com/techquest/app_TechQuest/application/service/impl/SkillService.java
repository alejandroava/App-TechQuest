package com.techquest.app_TechQuest.application.service.impl;

import com.techquest.app_TechQuest.application.dto.request.AdminCreateSkillDTO;
import com.techquest.app_TechQuest.application.mappers.SkillMapper;
import com.techquest.app_TechQuest.application.service.IModel.IModelSkill;
import com.techquest.app_TechQuest.domain.model.SkillEntity;
import com.techquest.app_TechQuest.infrastructure.persistence.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillService implements IModelSkill {
    @Autowired
    SkillRepository skillRepository;

    @Autowired
    SkillMapper SkillMapper;

    @Override
    public SkillEntity create(AdminCreateSkillDTO adminCreateSkillDTO) {
            SkillEntity skillExist = skillRepository.findByTitle(adminCreateSkillDTO.getTitle());
            if (skillExist != null){
                throw new IllegalArgumentException("Skill exist");
            }

            return skillRepository.save(SkillMapper.adminCreateSkillToSkillEntity(adminCreateSkillDTO));
    }
}
