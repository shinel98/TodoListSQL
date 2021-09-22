package com.todo.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.*;

import com.todo.dao.TodoItem;
import com.todo.dao.TodoList;

public class TodoUtil {
	// 새로운 TodoList 를 파라미터로 받아서, title과 desc를 입력해서 title이 중복되지 않으면, 리스트에 추가해주는 static 메소드 
	public static void createItem(TodoList list) {
		
		String title, desc;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\n"
				+ "========== 새로운 할일 작성\n"
				+ "항목을 입력해주세요.\n");
		
		//title = sc.next();
		title = sc.nextLine();
		
		if (list.isDuplicate(title)) {
			System.out.printf("항목은 중복될 수 없습니다.");
			return;
		}
		
		System.out.println("내용을 입력해주세요.");
		//desc = sc.next();
		desc = sc.nextLine();
		
		TodoItem t = new TodoItem(title, desc);
		list.addItem(t);
	}
	// list 를 파라미터로 받고 user가 title 을 입력하면, list에 있는 title과 일치하면 리스트에서 삭제해주는 메소드 
	public static void deleteItem(TodoList l) {
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("\n"
				+ "========== 할일 삭제\n"
				+ "삭제할 항목을 입력해주세요.\n"
				+ "\n");
		String title = sc.next();
		for (TodoItem item : l.getList()) {
			if (title.equals(item.getTitle())) {
				l.deleteItem(item);
				break;
			}
		}
	}

	/* list를 파라미터로 받아서, 바꾸고싶은 title을 user에게 입력받고, title이 리스트에 존재는지 않는지 체크 , 새로운 title을 입력받아, 리스트에 중복되는지 체크
	중복이 모두 안되면 리스트에 추가  */ 
	public static void updateItem(TodoList l) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\n"
				+ "========== 할일 수정\n"
				+ "수정하고 싶은 항목을 입력해주세요.\n"
				+ "\n");
		String title = sc.nextLine().trim();
		if (!l.isDuplicate(title)) {
			System.out.println("그런 항목은 존재하지 않습니다.");
			return;
		}
		
		System.out.println("새로운 항목을 입력해주세요.");
		String new_title = sc.nextLine().trim();
		if (l.isDuplicate(new_title)) {
			System.out.println("이미 동일한 항목이 존재합니다.");
			return;
		}
		
		System.out.println("새로운 설명을 입력해주세요. ");
		String new_description = sc.nextLine().trim();
		for (TodoItem item : l.getList()) {
			if (item.getTitle().equals(title)) {
				l.deleteItem(item);
				TodoItem t = new TodoItem(new_title, new_description);
				l.addItem(t);
				System.out.println("할일이 수정되었습니다.");
			}
		}

	}
	// 리스트에서 TodoItem의 title과 desc를 하나씩 출력 
	public static void listAll(TodoList l) {
		/*if(l.isEmpty()) {
			System.out.println("저장된 내용이 없습니다.");
		}*/
		for (TodoItem item : l.getList()) {
			System.out.println("[항목]: " + item.getTitle() + "  [내용]: " + item.getDesc() + "  [날짜]: " + item.getCurrent_date());
		}
	}
	
	public static void saveList(TodoList l, String filename) {
		try {
			Writer fw = new FileWriter(filename);
			for(TodoItem i : l.getList()) {
				fw.write(i.toSaveString());
			}
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void loadList(TodoList l, String filename) {
		try {
			String line;
			StringTokenizer st;
			BufferedReader br = new BufferedReader(new FileReader(filename));
			while((line = br.readLine()) != null) {
				st = new StringTokenizer(line, "##");
				TodoItem t = new TodoItem(st.nextToken(), st.nextToken());
				t.setCurrent_date(st.nextToken());
				l.addItem(t);
			}
			
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("파일이 존재하지 않습니다.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			System.out.println(l.getList().size() + "개의 항목을 파일에서 읽어왔습니다.");
		}
	}
}