package com.techquest.app_TechQuest.application.service.generic;

public interface Create <EntityDTO,Entity>{
    Entity create(EntityDTO entityDTO);
}
