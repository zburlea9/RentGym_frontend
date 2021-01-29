package com.example.rentGymsFrontEnd.dto;

public class UserDTOG {

    private String user_id;
    private String user_username;
    private String user_password;
    private String user_last_name;
    private String user_first_name;
    private String user_email;
    private String user_phone_number;
    private String user_is_admin;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_username() {
        return user_username;
    }

    public void setUser_username(String user_username) {
        this.user_username = user_username;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_last_name() {
        return user_last_name;
    }

    public void setUser_last_name(String user_last_name) {
        this.user_last_name = user_last_name;
    }

    public String getUser_first_name() {
        return user_first_name;
    }

    public void setUser_first_name(String user_first_name) {
        this.user_first_name = user_first_name;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_phone_number() {
        return user_phone_number;
    }

    public void setUser_phone_number(String user_phone_number) {
        this.user_phone_number = user_phone_number;
    }

    public String getUser_is_admin() {
        return user_is_admin;
    }

    public void setUser_is_admin(String user_is_admin) {
        this.user_is_admin = user_is_admin;
    }

    @Override
    public String toString() {
        return "UserDTOG{" +
                "user_id='" + user_id + '\'' +
                ", user_username='" + user_username + '\'' +
                ", user_password='" + user_password + '\'' +
                ", user_last_name='" + user_last_name + '\'' +
                ", user_first_name='" + user_first_name + '\'' +
                ", user_email='" + user_email + '\'' +
                ", user_phone_number='" + user_phone_number + '\'' +
                ", user_is_admin='" + user_is_admin + '\'' +
                '}';
    }
}
