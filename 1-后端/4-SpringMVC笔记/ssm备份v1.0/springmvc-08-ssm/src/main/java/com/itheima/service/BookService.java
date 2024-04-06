package com.itheima.service;

import com.itheima.pojo.Book;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface BookService {
    /**
     * 拿到所有图书
     * @return
     */
    List<Book> getBookAll();

    /**
     * 根据id拿到图书
     * @param id
     * @return
     */
    Book getBookById(Integer id);

    /**
     * 修改图书
     * @param book
     * @return
     */
    boolean update(Book book);

    /**
     * 删除图书
     * @param id
     * @return
     */
    boolean delete(Integer id);

    /**
     * 新增图书
     * @param book
     * @return
     */
    boolean save(Book book);
}
