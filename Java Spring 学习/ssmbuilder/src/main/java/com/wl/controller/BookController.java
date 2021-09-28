package com.wl.controller;

import com.wl.pojo.Books;
import com.wl.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author WL
 * @description: book控制器
 * @date 2021/9/24 10:56
 */
@Controller
@RequestMapping("/book")
public class BookController {
	@Autowired
	@Qualifier("BookServiceImpl")
	private BookService bookService;
	@RequestMapping("/allBook")
	public String list(Model model){
		List<Books> list = bookService.queryBook();
		model.addAttribute("listBook",list);
		return "showBook";
	}
	/**
	 * 跳转到增加书籍页面
	 * @author wl
	 */
	@RequestMapping("/toAddBook")
	public String toAddPaper(){
		return "addBook";
	}
	/**
	 *添加书籍
	 */
	@RequestMapping("/addBook")
	public String addBook(Books books){
		System.out.println("添加"+books);
		bookService.addBook(books);
		return "redirect:/book/allBook";
	}
	/**
	 * 跳转到修改页面
	 */
	@RequestMapping("/toUpdateBook")
	public String toUpdateBook(Model model,int id){
		Books book = bookService.queryBookById(id);
		model.addAttribute("book",book);
		return "updateBook";
	}
	/**
	 *修改书本信息
	 */
	@RequestMapping("/updateBook")
	public String updateBook(Model model,Books book){
		System.out.println("修改书籍"+book.getBookName());
		bookService.updateBook(book);
		Books bookUpdate = bookService.queryBookById(book.getBookID());
		model.addAttribute("book",bookUpdate);
		return "redirect:/book/allBook";
	}
	/**
	 *
	 * 删除书籍
	 */
	@RequestMapping("/deleteBook/{bookID}")
	public String deleteBook(@PathVariable("bookID") int id){
		bookService.deleteBook(id);
		return "redirect:/book/allBook";
	}


}
