package org.test.spring.service;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.test.spring.entity.Cabinet;
import org.test.spring.repository.CabinetRepository;
import org.test.spring.repository.UserCabinetRoleRepository;
import org.test.spring.repository.UserRepository;
import org.test.spring.entity.User;

@Service
public class TestService {
    private final UserRepository userRepository;
    private final CabinetRepository cabinetRepository;
    private final UserCabinetRoleRepository userCabinetRoleRepository;

    public TestService(UserRepository userRepository, CabinetRepository cabinetRepository, UserCabinetRoleRepository userCabinetRoleRepository) {
        this.userRepository = userRepository;
        this.cabinetRepository = cabinetRepository;
        this.userCabinetRoleRepository = userCabinetRoleRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationReady() {
        User user = userRepository.findById(1L).get();
        userRepository.delete(user);

        Cabinet cabinet = cabinetRepository.findById(1L).get();
        cabinetRepository.delete(cabinet);
    }
}
