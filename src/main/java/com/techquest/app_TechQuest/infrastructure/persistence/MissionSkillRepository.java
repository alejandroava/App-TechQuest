package com.techquest.app_TechQuest.infrastructure.persistence;

import com.techquest.app_TechQuest.domain.model.MissionSkill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionSkillRepository extends JpaRepository<MissionSkill,Long> {
}
