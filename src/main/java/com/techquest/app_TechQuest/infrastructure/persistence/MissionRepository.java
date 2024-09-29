package com.techquest.app_TechQuest.infrastructure.persistence;

import com.techquest.app_TechQuest.domain.model.MissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository extends JpaRepository<MissionEntity,Long> {

    MissionEntity findByTitle(String title);
}
