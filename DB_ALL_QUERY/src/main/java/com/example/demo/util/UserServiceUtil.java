package com.example.demo.util;

import com.example.demo.model.*;
import lombok.experimental.UtilityClass;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@UtilityClass
public class UserServiceUtil {
    private static final Random RANDOM = new Random();

    public static List<User> createUsers() {
        List<User> list = new LinkedList<>();
        list.add(User.builder().setUsername("Alice").setAge(25).setSex(UserSex.WOMAN).build());
        list.add(User.builder().setUsername("Hank").setAge(35).setSex(UserSex.MAN).build());
        list.add(User.builder().setUsername("Jack").setAge(26).setSex(UserSex.MAN).build());
//        return userRepository.saveAllAndFlush(list);
        return list;
    }

    public static List<Role> createAndAttachRole(List<User> userList) {
        List<Role> list = new LinkedList<>();
        list.add(new Role(null, "ADMIN"));
        list.add(new Role(null, "MANAGER"));
        list.add(new Role(null, "USER"));

        userList.get(0).getRoleList().addAll(list);
        userList.get(1).getRoleList().addAll(List.of(list.get(1), list.get(2)));
        userList.get(2).getRoleList().addAll(List.of(list.get(2)));

        return list;
    }

    public static List<LineFirst> createAndAttachLineFirst(List<User> userList) {
        List<LineFirst> list = new LinkedList<>();
        list.add(new LineFirst(null, "LineFirst_1111"));
        list.add(new LineFirst(null, "LineFirst_22222"));
        list.add(new LineFirst(null, "LineFirst_33333"));

        userList.get(0).getLineFirstList().addAll(list);
        userList.get(1).getLineFirstList().addAll(List.of(list.get(1), list.get(2)));
        userList.get(2).getLineFirstList().addAll(List.of(list.get(0), list.get(2)));

        return list;
    }

    public static List<LineSecond> createAndAttachLineSecond(List<LineFirst> lineFirstList) {
        List<LineSecond> list = new LinkedList<>();
        for (LineFirst lineFirst : lineFirstList) {
            for (int i = 0; i < 2; i++) {
                String name = String.format("LineSecond_%d - %s", i, lineFirst.getName());
                LineSecond lineSecond = new LineSecond(null, name, lineFirst);
                list.add(lineSecond);
                lineFirst.getLineSecondList().add(lineSecond);
            }
        }
        return list;
    }
}
