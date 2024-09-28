package com.techquest.app_TechQuest.application.service.impl;

import com.techquest.app_TechQuest.application.dto.request.AssignSkillDTO;
import com.techquest.app_TechQuest.application.mappers.StudentSkillMapper;
import com.techquest.app_TechQuest.application.service.IModel.IModelStudentSkill;
import com.techquest.app_TechQuest.domain.model.StudentSkill;
import com.techquest.app_TechQuest.infrastructure.persistence.StudentSkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentSkillService implements IModelStudentSkill {

    @Autowired
    StudentSkillRepository studentSkillRepository;

    @Autowired
    StudentSkillMapper studentSkillMapper;

    @Override
    public StudentSkill createSkill(AssignSkillDTO assignSkillDTO) {

        StudentSkill studentExist = studentSkillRepository.findByEmail(assignSkillDTO.getEmailStudent());

        if(studentExist == null){
            throw new IllegalArgumentException("Student not found");
        }
        StudentSkill userSave = studentSkillMapper.assignSkillToStudentSkill(assignSkillDTO);

        return studentSkillRepository.save(userSave);
    }
}
