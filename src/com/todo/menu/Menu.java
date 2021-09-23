package com.todo.menu;
public class Menu {
	// 선택지를 출력해주는 static 메소드 
    public static void displaymenu()
    {
        System.out.println();
        System.out.println("1. 새로운 할일 추가 ( add )");
        System.out.println("2. 할일 삭제 ( del )");
        System.out.println("3. 할일 수정 ( edit )");
        System.out.println("4. 할일 목록 보기 ( ls )");
        System.out.println("5. 이름에 따라 오름차순 정렬 ( ls_name_asc )");
        System.out.println("6. 이름에 따라 내림차순 정렬 ( ls_name_desc )");
        System.out.println("7. 날짜에 따라 정렬 ( ls_date )");
        System.out.println("8. 종료 ( exit )");
        //System.out.println("Enter your choice >");
        
    }
    public static void prompt()
    {	
    	System.out.println();
    	System.out.println("옵션을 선택하세요. (커맨드 보기 : help)");
    	System.out.print(">");
    }
}
