package com.example.gogo;

public class BoardListViewItem {
    private String title ;
    private String nickname ;
    private String date_time ;
    private String post_pid;
    private String rep_count;

    public void setTitle(String title) {
        this.title = title ;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname ;
    }
    public void setDate_time(String date_time) {
        this.date_time = date_time ;
    }
    public void setPost_pid(String post_pid) {
        this.post_pid = post_pid;
    }
    public void setRep_count(String rep_count) {
        this.rep_count = rep_count;
    }

    public String getTitle() {
        return title ;
    }
    public String getNickname() {
        return nickname ;
    }
    public String getDate_time() { return date_time ; }
    public String getPost_pid() { return post_pid; }
    public String getRep_count() { return rep_count; }

}
