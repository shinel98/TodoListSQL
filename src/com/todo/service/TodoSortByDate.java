package com.todo.service;
import java.util.Comparator;

import com.todo.dao.TodoItem;
// TodoList를 date에 따라 오름차순으로 정렬해주는 메소드 
public class TodoSortByDate implements Comparator<TodoItem> {
    @Override
    public int compare(TodoItem o1, TodoItem o2) {
        return o1.getCurrent_date().compareTo(o2.getCurrent_date());

    }
}
