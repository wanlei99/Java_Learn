package com.wl.service;

import com.wl.dao.BookMapper;
import com.wl.pojo.Books;

import java.util.List;

/**
 * @author WL
 * @description: BookService业务接口的实现类
 * @date 2021/9/23 16:56
 */
public class BookServiceImpl implements BookService{

	/**
	 *调用dao层的操作方法，设置一个set接口，方便spring管理
	 */
	private BookMapper bookMapper;

	public void setMapper(BookMapper bookMapper) {
		this.bookMapper = bookMapper;
	}
	@Override
	public int addBook(Books book) {
		return bookMapper.addBook(book);
	}

	@Override
	public int deleteBook(int id) {
		return bookMapper.deleteBook(id);
	}

	@Override
	public int updateBook(Books books) {
		return bookMapper.updateBook(books);
	}

	@Override
	public Books queryBookById(int id) {
		return bookMapper.queryBookById(id);
	}

	@Override
	public List<Books> queryBook() {
		return bookMapper.queryBook();
	}
}
