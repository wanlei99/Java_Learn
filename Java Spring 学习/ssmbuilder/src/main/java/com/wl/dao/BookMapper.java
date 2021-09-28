package com.wl.dao;

import com.wl.pojo.Books;
import java.util.List;

/**
 * @author 98710
 */
public interface BookMapper {
	/**
	 * 添加一个book
	 * @author wl
	 * @date 2021/9/23 16:31
	 * @return int
	 * @param book
	 */
	int addBook(Books book);
	/**
	 * 删除一个book
	 * @author wl
	 * @date 2021/9/23 16:32
	 * @param id
	 * @return int
	 */
	int deleteBook(int id);
	/** 
	 * 更新book
	 * @author wl
	 * @date 2021/9/23 16:30
	 * @param books
	 * @return int 
	 */
	int updateBook(Books books);
	/**
	 * 根据Id查询book
	 * @author wl
	 * @date 2021/9/23 16:34
	 * @param id
	 * @return Books
	 */
	Books queryBookById(int id);
	/**
	 * 查询书籍
	 * @author wl
	 * @date 2021/9/23 16:35
	 * @return List<Books> list集合
	 */
	List<Books> queryBook();
}
