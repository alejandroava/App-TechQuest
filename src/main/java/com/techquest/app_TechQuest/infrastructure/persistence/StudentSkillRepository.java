package com.techquest.app_TechQuest.infrastructure.persistence;

import com.techquest.app_TechQuest.domain.model.StudentSkill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentSkillRepository extends JpaRepository<StudentSkill,Long> {

    StudentSkill findByEmail(String email);
}
