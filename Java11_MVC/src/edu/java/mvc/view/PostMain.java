package edu.java.mvc.view;

import java.util.Scanner;

import edu.java.mvc.controller.PostDaoImpl;
import edu.java.mvc.menu.Menu;
import edu.java.mvc.model.Post;

public class PostMain {

	private final Scanner sc = new Scanner(System.in);
	private final PostDaoImpl dao = PostDaoImpl.getInstance();
	
    public static void main(String[] args) {
    	System.out.println("*** 블로그 프로그램 ***");
    	
    	PostMain app = new PostMain();
    	
    	boolean run = true;
		while (run) {
			int n  = app.showMainMenu();
			Menu menu = Menu.getValue(n);
			switch(menu) {
			case QUIT:
				run = false;
				break;
				
			case CREATE:
				app.insertNewPost();
				break;
				
			case READ_ALL:
				app.selectAllPosts();
				break;
				
			case READ_BY_INDEX:
				app.selectPostsByIndex();
				break;
				
			case UPDATE:
				app.updatePost();
				break;
				
			case DELETE:
				app.deletePost();
				break;
				
			default:
				System.out.println("메인 메뉴 번호를 확인하세요.");
			}
		}
		
		System.out.println("*** 프로그램 종료 ***");

    }
    
    // 정수입력 오류
 	private int inputNumber() {
 		while(true) {
 			try {
 				int n = Integer.parseInt(sc.nextLine());
 				return n;
 				
 			} catch (NumberFormatException e) {
 				System.out.print("정수 입력>> ");
 				
 			}
 		}
 	}

    // 메인 메뉴 show
	private int showMainMenu() {
		System.out.println();
		System.out.println("---------------------------------------------------------");
		System.out.println("[0] 종료 [1] 새 Post [2] 전체 목록 [3] 검색 [4] 수정 [5] 삭제");
		System.out.println("---------------------------------------------------------");
		System.out.print("선택> ");
		int n = inputNumber();
		
		return n;
	}

	// 새로운 Post 등록
	private void insertNewPost() {
		System.out.println("\n----- 새로운 Post 저장 -----");
		
		if(!dao.isMemoryAvailable()) {
			System.out.println(">>> 메모리 용량 부족");
			return;
		}
		
		System.out.print("제목>> ");
		String title = sc.nextLine();
		System.out.print("내용>> ");
		String content = sc.nextLine();
		System.out.print("작성자>> ");
		String author = sc.nextLine();
		
		Post post = new Post(0, title, content, author);
		
		int result = dao.create(post);
		
		if(result == 1) {
			System.out.println(">> 새로운 Post 등록 완료");
		} else {
			System.out.println(">> 새로운 Post 등록 실패");
		}
	}

	// 등록되어 있는 post들 나열
	private void selectAllPosts() {
		System.out.println("\n----- Post 전체 목록 -----");
		
		Post[] posts = dao.read();
		
		for(Post p : posts) {
			System.out.println(p);
		}
		
	}

	private void selectPostsByIndex() {
		System.out.println("\n----- 인덱스 검색 -----");
		System.out.print("검색할 Post 인덱스 입력> ");
		int index = inputNumber();
		
		Post post = dao.read(index);
		
		if(post != null) {
			System.out.println(post);
		} else {
			System.out.println("해당 인덱스에 저장되어 있는 Post가 없음.");
		}
	}

	private void updatePost() {
		System.out.println("\n----- Post 업데이트 -----");
		System.out.print("수정할 Post 인덱스 입력> ");
		int index = inputNumber();
		
		if(!dao.isValidIndex(index)) {
			System.out.println(">>> 해당 인덱스에는 Post 정보가 없음.");
			return;
		}
		
		Post before = dao.read(index);
		System.out.println(">>> 수정 전: " + before);
		
		System.out.print("제목>> ");
		String title = sc.nextLine();
		System.out.print("내용>> ");
		String content = sc.nextLine();
		System.out.print("작성자>> ");
		String author = sc.nextLine();
		
		Post after = new Post(0, title, content, author, before.getCreatedTime(), before.getModifiedTime());
		
		int result = dao.update(index, after);
		
		if(result == 1) {
			System.out.println(">> Post 수정 완료");
		} else {
			System.out.println(">> Post 수정 실패");
		}
		
	}

	private void deletePost() {
		System.out.println("\n----- 인덱스 검색 -----");
		System.out.print("삭제할 Post 인덱스 입력> ");
		int index = inputNumber();
		
		if(!dao.isValidIndex(index)) {
			System.out.println(">>> 해당 인덱스에는 Post 정보가 없음.");
			return;
		}
		
		int result = dao.delete(index);
		
		if(result == 1) {
			System.out.println(">> Post 삭제 완료");
		} else {
			System.out.println(">> Post 삭제 실패");
		}
		
	}

}
