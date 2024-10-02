package com.techquest.app_TechQuest.application.controller.interfaces;

import com.techquest.app_TechQuest.application.controller.generic.CreateRegister;
import com.techquest.app_TechQuest.application.controller.generic.CreateRegisterAdmin;
import com.techquest.app_TechQuest.application.controller.generic.CreateRegisterTeacher;
import com.techquest.app_TechQuest.application.dto.request.LoginRequestDTO;
import com.techquest.app_TechQuest.application.dto.request.UserRegisterDTO;
import com.techquest.app_TechQuest.application.dto.response.LoginResponseDTO;
import org.springframework.http.ResponseEntity;

public interface IModelAuth extends CreateRegister<UserRegisterDTO>, CreateRegisterTeacher<UserRegisterDTO>, CreateRegisterAdmin<UserRegisterDTO> {

    public ResponseEntity<?> login(LoginRequestDTO loginRequestDTO);
}
