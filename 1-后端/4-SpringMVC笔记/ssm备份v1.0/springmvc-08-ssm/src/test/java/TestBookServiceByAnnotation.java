import com.itheima.config.SpringConfig;
import com.itheima.pojo.Book;
import com.itheima.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class TestBookServiceByAnnotation {
    @Autowired
    private BookService bookService;

    @Test
    public void testGetBookById(){
        Book book = bookService.getBookById(11);
        System.out.println(book);
    }

    @Test
    public void testGetBookAll(){
        List<Book> books = bookService.getBookAll();
        books.forEach(book -> {
            System.out.println(book);
        });
    }
}
