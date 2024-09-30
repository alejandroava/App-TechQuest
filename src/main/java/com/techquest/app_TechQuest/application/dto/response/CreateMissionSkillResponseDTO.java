package com.techquest.app_TechQuest.application.dto.response;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateMissionSkillResponseDTO {

    private String mission;

    private String skill;


}
