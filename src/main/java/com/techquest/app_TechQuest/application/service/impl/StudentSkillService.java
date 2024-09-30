package com.techquest.app_TechQuest.application.service.impl;

import com.techquest.app_TechQuest.application.dto.request.AssignSkillDTO;
import com.techquest.app_TechQuest.application.mappers.StudentSkillMapper;
import com.techquest.app_TechQuest.application.service.IModel.IModelStudentSkill;
import com.techquest.app_TechQuest.domain.model.SkillEntity;
import com.techquest.app_TechQuest.domain.model.StudentSkill;
import com.techquest.app_TechQuest.domain.model.UserEntity;
import com.techquest.app_TechQuest.infrastructure.persistence.SkillRepository;
import com.techquest.app_TechQuest.infrastructure.persistence.StudentSkillRepository;
import com.techquest.app_TechQuest.infrastructure.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentSkillService implements IModelStudentSkill {

    @Autowired
    StudentSkillRepository studentSkillRepository;

    @Autowired
    StudentSkillMapper studentSkillMapper;

    @Autowired
    SkillRepository skillRepository;

    @Autowired
    UserRepository userRepository;



    @Override
    public StudentSkill create(AssignSkillDTO assignSkillDTO) {

        UserEntity studentExist = userRepository.findByEmail(assignSkillDTO.getEmailStudent());

        if(studentExist == null){
            throw new IllegalArgumentException("Student not found");
        }
        SkillEntity skill = skillRepository.findByTitle(assignSkillDTO.getSkillStudent());

        if(skill == null){
            throw new IllegalArgumentException("Skill not found");
        }

        StudentSkill studentSkill = new StudentSkill();
        studentSkill.setUser(studentExist);
        studentSkill.setSkill(skill);

        return studentSkillRepository.save(studentSkill);
    }
}

