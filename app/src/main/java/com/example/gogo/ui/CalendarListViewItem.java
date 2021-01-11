package com.example.gogo.ui;

public class CalendarListViewItem {
    private String enroll_pid;
    private String category;
    private String food_name ;
    private String food_exp ;

    public void setEnroll_pid(String enroll_pid) {
        this.enroll_pid = enroll_pid ;
    }
    public void setCategory(String category) { this.category = category ; }
    public void setFood_name(String food_name) { this.food_name = food_name ; }
    public void setFood_exp(String food_exp) { this.food_exp = food_exp ; }

    public String getEnroll_pid() { return enroll_pid ; }
    public String getCategory() { return category ; }
    public String getFood_name() {
        return food_name ;
    }
    public String getFood_exp() { return food_exp ; }
}
