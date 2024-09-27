package com.techquest.app_TechQuest.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "skills")
public class SkillEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;
    @OneToMany(mappedBy = "skill")
    private List<MIssionSkill> mIssionSkillList;

    @OneToMany(mappedBy = "skill")
    private List<StudentSkill> studentSkillList;


}
