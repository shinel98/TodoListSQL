package com.todo.dao;

import java.util.Date;

public class TodoItem {
    private String title;
    private String desc;
    private Date current_date;

    // TodoItem의 title, desc, date를 초기화해주는 생성자 
    public TodoItem(String title, String desc){
        this.title=title;
        this.desc=desc;
        this.current_date=new Date();
    }
    // title을 반환해주는 메소드 
    public String getTitle() {
        return title;
    }
    // title을 초기화해주는 메소드 
    public void setTitle(String title) {
        this.title = title;
    }
    // desc를 반환해주는 메소드 
    public String getDesc() {
        return desc;
    }
    // desc를 초기화해주는 메소드 
    public void setDesc(String desc) {
        this.desc = desc;
    }
    // current_date를 반환해주는 메소드 
    public Date getCurrent_date() {
        return current_date;
    }
    // current_date를 입력에 따라 초기화해주는 메소드 
    public void setCurrent_date(Date current_date) {
        this.current_date = current_date;
    }
}

