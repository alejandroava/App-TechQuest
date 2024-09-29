package com.techquest.app_TechQuest.application.dto.response;


import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AssignSkillResponseDTO {

    private String user;

    private String skill;
}
