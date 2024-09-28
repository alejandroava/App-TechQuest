package com.techquest.app_TechQuest.application.service.IModel;

import com.techquest.app_TechQuest.application.dto.request.UserRegisterDTO;
import com.techquest.app_TechQuest.application.service.generic.UserRegister;
import com.techquest.app_TechQuest.domain.model.UserEntity;

public interface IModelAuth extends UserRegister<UserRegisterDTO, UserEntity> {
}
