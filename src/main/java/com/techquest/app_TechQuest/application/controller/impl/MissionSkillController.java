package com.techquest.app_TechQuest.application.controller.impl;

import com.techquest.app_TechQuest.application.controller.interfaces.IModelMissionSkill;
import com.techquest.app_TechQuest.application.dto.request.MissionSkillDTO;
import com.techquest.app_TechQuest.application.dto.response.CreateMissionSkillResponseDTO;
import com.techquest.app_TechQuest.application.exeptions.ErrorSimple;
import com.techquest.app_TechQuest.application.service.impl.MissionSkillService;
import com.techquest.app_TechQuest.domain.model.MissionSkill;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MissionSkillController implements IModelMissionSkill {

    @Autowired
    MissionSkillService missionSkillService;

    @PostMapping("/create/mission-skill")
    @Override
    public ResponseEntity<?> create(@RequestBody @Valid MissionSkillDTO missionSkillDTO) {

        try {
            MissionSkill missionSkill = missionSkillService.create(missionSkillDTO);
            CreateMissionSkillResponseDTO createMissionSkillResponseDTO = CreateMissionSkillResponseDTO.builder()
                    .mission(missionSkill.getSkill().getTitle())
                    .skill(missionSkill.getSkill().getTitle())
                    .build();
            return ResponseEntity.status(HttpStatus.CREATED).body(createMissionSkillResponseDTO);

        }catch (IllegalArgumentException exception){
            ErrorSimple errorResponse = ErrorSimple.builder()
                    .code(HttpStatus.BAD_REQUEST.value())
                    .status(HttpStatus.BAD_REQUEST.getReasonPhrase())
                    .message(exception.getMessage())
                    .build();

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorResponse);
        }
    }
}
