package com.techquest.app_TechQuest.application.controller.impl;

import com.techquest.app_TechQuest.application.controller.interfaces.IModelMissionSkill;
import com.techquest.app_TechQuest.application.dto.request.MissionSkillDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MIssionSkillController implements IModelMissionSkill {
    @Override
    public ResponseEntity<?> create(@RequestBody @Valid MissionSkillDTO missionSkillDTO) {
        return null;
    }
}
