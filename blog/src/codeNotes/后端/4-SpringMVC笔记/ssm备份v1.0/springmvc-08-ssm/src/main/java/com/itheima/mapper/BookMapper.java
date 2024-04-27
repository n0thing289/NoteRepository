package com.itheima.mapper;

import com.itheima.pojo.Book;

import java.util.List;

/**
 * Book的crud接口
 *      黑马在这里用注解写sql
 */
public interface BookMapper {
    /**
     * 查询所有图书
     *
     * @return
     */
    List<Book> selectBookAll();

    /**
     * 根据id查询一本图书
     *
     * @param id
     * @return
     */
    Book selectBookById(Integer id);

    /**
     * 传入新的图书对象(旧id)来修改图书
     *
     * @param book
     * @return
     */
    int updateBook(Book book);

    /**
     * 根据id删除一本图书
     *
     * @param id
     * @return
     */
    int deleteBookById(Integer id);

    /**
     * 新增图书
     *
     * @param book
     * @return
     */
    int saveBook(Book book);
}
