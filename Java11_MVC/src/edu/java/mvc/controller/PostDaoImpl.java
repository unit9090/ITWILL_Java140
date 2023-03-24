package edu.java.mvc.controller;

import java.time.LocalDateTime;

import edu.java.mvc.model.Post;

public class PostDaoImpl implements PostDao {
	// singleton
	private static PostDaoImpl instance = null;
	
	private PostDaoImpl() {};
	
	public static PostDaoImpl getInstance() {
		if(instance == null) {
			instance = new PostDaoImpl();
		}
		
		return instance;
	}
	
	// fields
	private static final int MAX_LENGTH = 5;
	private Post[] posts = new Post[MAX_LENGTH];
	private int count = 0;

	// methods
	/**
	 * Post[]에 저장할 수 있는지 확인
	 * @return boolean
	 */
	public boolean isMemoryAvailable() {
		return count < MAX_LENGTH;
	}
	
	/**
	 * Post[]에 저장된 개수를 넘어서지 않는지 확인
	 * @param index
	 * @return boolean
	 */
	public boolean isValidIndex(int index) {
		return (index >= 0) && (index < count);
	}
	
	// CURD methods
	
	@Override
	public int create(Post p) {
		if(!isMemoryAvailable()) {
			return 0;
		}
		
		LocalDateTime now = LocalDateTime.now();
		
		posts[count] = p;
		posts[count].setCreatedTime(now);
		count++;
		
		return 1;
	}

	@Override
	public Post[] read() {
		Post[] array = new Post[count];
		
		for(int i = 0; i < count; i++) {
			array[i] = posts[i];
		}
		
		return array;
	}

	@Override
	public Post read(int index) {
		if(!isValidIndex(index)) {
			return null;
		}
		
		return posts[index];
	}

	@Override
	public int update(int index, Post p) {
		if(!isValidIndex(index)) {
			return 0;
		}
		
		LocalDateTime now = LocalDateTime.now();
		
		posts[index] = p;
		posts[index].setModifiedTime(now);
		
		return 1;
	}

	@Override
	public int delete(int index) {
		if(!isValidIndex(index)) {
			return 0;
		}
		
		for(int i = index; i < count - 1; i++) {
			posts[i] = posts[i + 1];
		}
		
		posts[count - 1] = null;
		count--;
		
		return 1;
	}

}
