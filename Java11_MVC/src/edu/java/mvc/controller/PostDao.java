package edu.java.mvc.controller;

import edu.java.mvc.model.Post;

public interface PostDao {
	/**
	 * 새 피드 저장 기능.
	 * @param Post p
	 * @return 배열에 저장 성공하면 1, 실패하면 0
	 */
	int create(Post p);
	
	/**
	 * 연락처 전체 목록 보기
	 * @return Post[] posts
	 */
	Post[] read();
	
	/**
	 * 인덱스 검색.
	 * @param int index
	 * @return Post p
	 */
	Post read(int index);
	
	/**
	 * 인덱스 수정 기능.
	 * @param int index
	 * @param Post p
	 * @retrun int
	 */
	int update(int index, Post p);
	
	/**
	 * 연락처 삭제 기능.
	 * @param int index
	 * @return int
	 */
	int delete(int index);
}
