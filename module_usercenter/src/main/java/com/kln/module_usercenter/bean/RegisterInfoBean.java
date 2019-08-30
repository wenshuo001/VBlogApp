package com.kln.module_usercenter.bean;

public class RegisterInfoBean {
    /**
     * email : string
     * enabled : true
     * id : 0
     * nickname : string
     * password : string
     * userface : string
     * username : string
     */

    private String email;
    private boolean enabled=true;
    private int id;
    private String nickname;
    private String password;
    private String userface;
    private String username;


    public RegisterInfoBean(String nickname, String password, String userface, String username) {
        this.nickname = nickname;
        this.password = password;
        this.userface = userface;
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getUserface() {
        return userface;
    }

    public void setUserface(String userface) {
        this.userface = userface;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
