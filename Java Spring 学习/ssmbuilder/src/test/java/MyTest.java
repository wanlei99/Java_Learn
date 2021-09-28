import com.wl.pojo.Books;
import com.wl.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author WL
 * @description:
 * @date 2021/9/24 13:51
 */
public class MyTest {
	@Test
	public void test(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		BookService bookService = (BookService) context.getBean("BookServiceImpl");
		for (Books books : bookService.queryBook()){
			System.out.println(books);
		}
	}
}
