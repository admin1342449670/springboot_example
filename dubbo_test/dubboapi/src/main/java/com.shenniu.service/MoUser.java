package com.shenniu.service;

import java.io.Serializable;

/**
 * 公布实体类，必须要支持序列化，所以这里实现  Serializable
 */
public class MoUser implements Serializable {

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String id;
    public String name;
    public boolean sex;

}
