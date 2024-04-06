package com.itheima.controller;

import com.itheima.pojo.Book;
import com.itheima.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    @Qualifier("bookServiceImpl")
    private BookService bookService;

    @GetMapping
    public List<Book> getBookAll() {
        return bookService.getBookAll();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Integer id) {
        return bookService.getBookById(id);
    }

    @PutMapping
    public boolean update(@RequestBody Book book) {
        bookService.update(book);
        return true;
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id) {
        bookService.delete(id);
        return true;
    }

    @PostMapping
    public boolean save(@RequestBody Book book) {
        bookService.save(book);
        return true;
    }
}
/**
 * Rest 风格开发
 * 业务层接口(junit)和表现层接口(postman)开发完后都要进行测试
 */
