package com.lib.mapper;

import com.lib.bean.Book;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Book持久层
 **/
public interface BookMapper {
    /**
     * 查询出所有图书
     *
     * @return
     */
    @Select("select * from book")
    List<Book> list();

    /**
     * 添加图书
     *
     * @param book
     */
    @Insert("insert into book(bname,baddress,bauthor,bdate,bprice,bindate,binnumber,bnumber) " +
            "values(#{bname},#{baddress},#{bauthor},#{bdate},#{bprice},#{bindate},#{binnumber},#{bnumber})")
    void insertBook(Book book);

    /**
     * 根据id查询图书
     *
     * @param bid
     * @return
     */
    @Select("select * from book where bid=#{bid}")
    Book selectBookById(Integer bid);

    /**
     * 更新图书信息
     *
     * @param b
     * @param bid
     */
    @Update("update book set bname=#{b.bname},baddress=#{b.baddress},bauthor=#{b.bauthor},bprice=#{b.bprice},bnumber=#{b.bnumber} where bid=#{bid}")
    void updateBookById(Book b, Integer bid);

}
