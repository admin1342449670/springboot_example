package com.shenniu.controller;

import com.shenniu.service.MoUser;
import com.shenniu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    //测试springmvc路由
    @GetMapping("/users_t")
    public List<MoUser> getUsers_t() {

        System.out.println("进入了getUsers_t...");
        List<MoUser> list = new ArrayList<MoUser>();
        for (int i = 0; i < 55; i++) {

            MoUser moUser = new MoUser();

            moUser.setId("100000" + i);
            moUser.setName("神牛00" + i);
            moUser.setSex(i % 2 == 1);

            list.add(moUser);
        }
        return list;
    }

    //dubbo上服务依赖注入
    @Autowired
    UserService userService;

    //消费服务端的getUsers服务
    @GetMapping("/users")
    public List<MoUser> getUsers() {

        System.out.println("进入了getUsers...");
        return userService.getUsers();
    }

    //消费服务端的getUser服务
    @GetMapping("/users/{id}")
    public MoUser getUser(@PathVariable String id) {

        System.out.println("进入了getUser...");
        return userService.getUserById(id);
    }

    @GetMapping("/users/{id}/del")
    public boolean delUser(@PathVariable String id) {

        System.out.println("进入了delUser...");
        return userService.delUserById(id);
    }
}
