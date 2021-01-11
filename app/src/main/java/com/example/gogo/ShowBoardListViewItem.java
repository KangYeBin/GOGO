package com.example.gogo;
public class ShowBoardListViewItem {
    private String comment_pid;
    private String comment_userpid;
    private String comment_writer;
    private String comment_content;
    private String comment_time;
    private String img_commentwriter;


    public String getComment_pid() { return comment_pid; }
    public void setComment_pid(String comment_pid) { this.comment_pid = comment_pid; }

    public String getComment_userpid() { return comment_userpid; }
    public void setComment_userpid(String comment_userpid) { this.comment_userpid = comment_userpid; }

    public String getComment_writer() { return comment_writer; }
    public void setComment_writer(String comment_writer) {
        this.comment_writer = comment_writer;
    }

    public String getComment_icon() {
        return img_commentwriter;
    }
    public void setComment_icon(String img_commentwriter) {
        this.img_commentwriter = img_commentwriter;
    }

    public String getComment_time() { return comment_time; }
    public void setComment_time(String comment_time) {
        this.comment_time = comment_time;
    }

    public String getComment_content() {
        return comment_content;
    }
    public void setComment_content(String comment_content) { this.comment_content = comment_content; }
}
