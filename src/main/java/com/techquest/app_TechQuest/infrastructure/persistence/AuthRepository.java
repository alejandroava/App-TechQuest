package com.techquest.app_TechQuest.infrastructure.persistence;

import com.techquest.app_TechQuest.domain.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepository extends JpaRepository<UserEntity,Long> {
    UserEntity findByEmail(String email);

}
