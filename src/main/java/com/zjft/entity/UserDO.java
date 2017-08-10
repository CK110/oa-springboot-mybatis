package com.zjft.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by CK on 2017/8/8.
 */
@Data
@NoArgsConstructor
public class UserDO implements Serializable {
    private Integer id;
    private String username;
    private String password;
    private Date createdAt;
    private Date updatedAt;

    private String uuid;
    private String token;
    private String ua;

    public String toString1(){
        return ua+uuid;
    }

    public UserDO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserDO(String username, String password, String uuid, String ua) {
        this.username = username;
        this.password = password;
        this.uuid = uuid;
        this.ua = ua;
    }




}
