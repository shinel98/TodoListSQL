package com.todo.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

public class TodoItem {
    private String title;
    private String desc;
    //private Date current_date;
    private String current_date;
    private String category;
    private String due_date;
    private int index;

    // TodoItem의 title, desc, date를 초기화해주는 생성자 
    public TodoItem(String title, String desc){
        this.title=title;
        this.desc=desc;
        //this.current_date=new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  kk:mm:ss");
        this.current_date = sdf.format(new Date());
    }
    public TodoItem(String title, String desc, String category, String due_date){
        this.title=title;
        this.desc=desc;
        //this.current_date=new Date();
        this.category = category;
        this.due_date = due_date;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  kk:mm:ss");
        this.current_date = sdf.format(new Date());
    }
    
    public TodoItem(String strFromFile){
    	StringTokenizer st = new StringTokenizer(strFromFile , "##");
		this.category = st.nextToken();
		this.title = st.nextToken();
		this.desc = st.nextToken();
		this.due_date = st.nextToken();
		this.current_date= st.nextToken();
    }
    
    public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
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
    public String getCurrent_date() {
        return current_date;
    }
    // current_date를 입력에 따라 초기화해주는 메소드 
    public void setCurrent_date(String current_date) {
        this.current_date = current_date;
    }
    public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDue_date() {
		return due_date;
	}
	public void setDue_date(String due_date) {
		this.due_date = due_date;
	}
	public String toSaveString() {
    	return category + "##" + title + "##" + desc + "##" + due_date + "##" +current_date + "\n";
    }
	@Override
	public String toString() {
		return "[" + category + "]" + " " + title + " - " +desc +  " - " +due_date + "-" + current_date;
	}
	
    
}

