package com.shenniu.service;

import java.util.List;

/**
 * 公共接口，需要打包，分别被provider和consumer引用
 * （注：如果是同一项目工程下并且是idea开发工具，直接implement后会自动被maven引用）
 */
public interface UserService {

    public List<MoUser> getUsers();

    public MoUser getUserById(String id);

    public  boolean delUserById(String id);
}


