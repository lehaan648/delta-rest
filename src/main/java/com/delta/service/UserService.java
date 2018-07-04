package com.delta.service;

import com.delta.repository.DeltaUserRepository;
import com.delta.domain.DeltaUser;
import com.delta.dto.DeltaUserDTO;
import com.delta.form.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    DeltaUserRepository deltaUserRepository;

    public DeltaUserDTO validateLogin(LoginForm loginForm) {
        DeltaUser deltaUser = deltaUserRepository.getUserByUsernameAndPassword(loginForm);
        if (deltaUser == null) {
            return null;
        }
        DeltaUserDTO deltaUserDTO = new DeltaUserDTO();
        deltaUserDTO.setFirstName(deltaUser.getFirstName());
        deltaUserDTO.setLastName(deltaUser.getLastName());
        deltaUserDTO.setUsername(deltaUser.getUsername());
        deltaUserDTO.setDefaultScriptId(deltaUser.getDefaultScriptId());
        deltaUserDTO.setToken("fake token");
        return deltaUserDTO;
    }
}
