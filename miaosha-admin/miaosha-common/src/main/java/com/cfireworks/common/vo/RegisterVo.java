package com.cfireworks.common.vo;

import com.cfireworks.common.validator.IsMobile;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * @description: login info
 * @author: cfireworks
 * @create: 2020-04-30 20:20
 **/
public class RegisterVo {

    @NotNull
    @IsMobile
    String mobile;

    @NotNull
    String nickname;

    @NotNull
    @Length(min=32)
    String password;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "LoginVo{" +
                "mobile='" + mobile + '\'' +
                "nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
