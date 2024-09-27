package com.techquest.app_TechQuest.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class MIssionSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_mission")
    private MissionEntity mission;
    @ManyToOne
    @JoinColumn(name = "id_skill",referencedColumnName = "id" )
    private SkillEntity skill;

}
