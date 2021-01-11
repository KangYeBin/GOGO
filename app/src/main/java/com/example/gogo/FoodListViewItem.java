package com.example.gogo;

public class FoodListViewItem {

    private String enroll_pid ;
    private String category ;
    private String foodname ;
    private String exp_end ;

    public void setEnroll_pid(String enroll_pid) {
        this.enroll_pid = enroll_pid ;
    }
    public void setCategory(String category) {
        this.category = category ;
    }
    public void setFoodname(String foodname) { this.foodname = foodname ; }
    public void setExp_end(String exp_end) {
        this.exp_end = exp_end ;
    }

    public String getEnroll_pid() {
        return enroll_pid ;
    }
    public String getCategory() {
        return category ;
    }
    public String getFoodname() {
        return foodname ;
    }
    public String getExp_end() {
        return exp_end ;
    }


}
