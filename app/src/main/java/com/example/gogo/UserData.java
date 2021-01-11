package com.example.gogo;

public class UserData {
    private String user_pid;
    private String code_pid;
    private String nickname;
    private String ref_name;
    private String post_pid;
    private String enroll_pid;
    private String category_name;
    private String food_name;
    private String icon;
    private String food_icon;
    private String shot_Day;
    private String[] result;

    public String getUserpid() {
        return user_pid;
    }
    public String getCodepid() {
        return code_pid;
    }
    public String getNickname() {
        return nickname;
    }
    public String getRefname() {
        return ref_name;
    }
    public String getPost_pid() {
        return post_pid;
    }
    public String getEnroll_pid() {
        return enroll_pid;
    }
    public String getCategory_name() {
        return category_name;
    }
    public String getFood_name() {
        return food_name;
    }
    public String getIcon() {
        return icon;
    }
    public String getFood_icon()  {
        return food_icon;
    }
    public String getShot_Day() {
        return shot_Day;
    }


    public void setUserpid(String user_pid) {
        this.user_pid = user_pid;
    }
    public void setCode_pid(String code_pid) {
        this.code_pid = code_pid;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public void setRefname(String ref_name) {
        this.ref_name = ref_name;
    }
    public void setPost_pid(String post_pid) { this.post_pid = post_pid; }
    public void setEnroll_pid(String enroll_pid) { this.enroll_pid = enroll_pid; }
    public void setCategory_name(String category_name) { this.category_name = category_name; }
    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }
    public void setIcon(String icon) {
        this.icon = icon;
    }
    public void setFood_icon(String food_icon) { this.food_icon = food_icon; }
    public void setShot_Day(String shot_Day) {
        this.shot_Day = shot_Day;
    }


    private static UserData instance = null;
    public static synchronized UserData getInstance(){
        if(null==instance){
            instance = new UserData();
        }
        return instance;
    }

}