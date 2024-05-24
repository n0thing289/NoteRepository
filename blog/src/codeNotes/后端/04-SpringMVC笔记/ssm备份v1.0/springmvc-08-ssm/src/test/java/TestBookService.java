import com.itheima.config.SpringConfig;
import com.itheima.pojo.Book;
import com.itheima.service.BookService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class TestBookService {
    @Test
    public void testGetBookById() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);
        BookService bookService = ac.getBean("bookServiceImpl", BookService.class);
        Book book = bookService.getBookById(11);
        System.out.println(book);
    }

    @Test
    public void testGetBookAll() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);
        BookService bookService = ac.getBean("bookServiceImpl", BookService.class);
        List<Book> books = bookService.getBookAll();
        books.forEach(book -> {
            System.out.println(book);
        });

    }
}
