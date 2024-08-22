package org.test.spring.service;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import org.test.spring.entity.Cabinet;
import org.test.spring.entity.Role;
import org.test.spring.entity.User;
import org.test.spring.entity.UserCabinetRole;
import org.test.spring.repository.CabinetRepository;
import org.test.spring.repository.UserCabinetRoleRepository;
import org.test.spring.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class MockUserService {
    private final UserRepository userRepository;
    private final CabinetRepository cabinetRepository;
    private final UserCabinetRoleRepository userCabinetRoleRepository;

    public MockUserService(UserRepository userRepository, CabinetRepository cabinetRepository, UserCabinetRoleRepository userCabinetRoleRepository) {
        this.userRepository = userRepository;
        this.cabinetRepository = cabinetRepository;
        this.userCabinetRoleRepository = userCabinetRoleRepository;
    }

    @PostConstruct
    public void init() {
        long userCount = userRepository.count();
        if (userCount == 0) {
            List<Cabinet> cabinetList = new ArrayList<>();
            cabinetList.add(new Cabinet(null, "main cabinet", new ArrayList<>()));
            cabinetList.add(new Cabinet(null, "2 cabinet", new ArrayList<>()));
            cabinetList = cabinetRepository.saveAll(cabinetList);

            List<User> userList = new ArrayList<>();
            userList.add(new User(null, "owner", new ArrayList<>()));
            userList.add(new User(null, "manager", new ArrayList<>()));
            userList.add(new User(null, "observer", new ArrayList<>()));

            userList.add(new User(null, "owner1", new ArrayList<>()));
            userList.add(new User(null, "manager1", new ArrayList<>()));
            userList = userRepository.saveAll(userList);


            List<UserCabinetRole> list = new ArrayList<>();
            list.add(new UserCabinetRole(null, Role.OWNER, userList.get(0), cabinetList.get(0)));
            list.add(new UserCabinetRole(null, Role.MANAGER, userList.get(0), cabinetList.get(0)));
            list.add(new UserCabinetRole(null, Role.OBSERVER, userList.get(0), cabinetList.get(0)));
            list.add(new UserCabinetRole(null, Role.MANAGER, userList.get(1), cabinetList.get(0)));
            list.add(new UserCabinetRole(null, Role.OBSERVER, userList.get(2), cabinetList.get(0)));

            list.add(new UserCabinetRole(null, Role.OWNER, userList.get(3), cabinetList.get(1)));
            list.add(new UserCabinetRole(null, Role.MANAGER, userList.get(4), cabinetList.get(1)));
            list.add(new UserCabinetRole(null, Role.OBSERVER, userList.get(2), cabinetList.get(1)));
            userCabinetRoleRepository.saveAll(list);
        }
    }
}
