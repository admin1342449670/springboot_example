package com.shenniu.service;

import java.util.ArrayList;
import java.util.List;

/**
 * 公共接口实现类（有provider来实现）
 */
public class UserServiceImpl implements UserService {

    private List<MoUser> list = new ArrayList<MoUser>();

    public List<MoUser> getUsers() {

        if (list.size() >= 1) {
            return list;
        }

        for (int i = 0; i < 55; i++) {

            MoUser moUser = new MoUser();

            moUser.setId("100000" + i);
            moUser.setName("神牛00" + i);
            moUser.setSex(i % 2 == 1);

            list.add(moUser);
        }

        return list;
    }

    public MoUser getUserById(String id) {
        MoUser moUser = null;

        for (MoUser user :
                list) {
            if (user.getId().equals(id)) {
                moUser = user;
                break;
            }
        }
        return moUser;
    }

    public boolean delUserById(final String id) {

        // return list.removeIf(b -> b.getId().equals(id));

        MoUser moUser = this.getUserById(id);
        if (moUser == null) {
            return false;
        }
        return list.remove(moUser);
    }
}
