package com.itheima.service.impl;

import com.itheima.mapper.BookMapper;
import com.itheima.pojo.Book;
import com.itheima.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service("bookServiceImpl")
public class BookServiceImpl implements BookService {
    //spring帮你注入, mybatis自动代理生成的实现类对象
    @Autowired//自动装配到这里,目前是没有BookMapper的bean,只有启动自动代理后才有
    private BookMapper bookMapper;

    @Override
    public List<Book> getBookAll() {
        return bookMapper.selectBookAll();
    }

    @Override
    public Book getBookById(Integer id) {
        return bookMapper.selectBookById(id);
    }

    @Override
    public boolean update(Book book) {
        bookMapper.updateBook(book);
        return true;
    }

    @Override
    public boolean delete(Integer id) {
        bookMapper.deleteBookById(id);
        return true;
    }

    @Override
    public boolean save(Book book) {
        bookMapper.saveBook(book);
        return true;
    }
}
