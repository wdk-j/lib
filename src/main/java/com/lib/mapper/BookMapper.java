package com.lib.mapper;

import com.lib.bean.Book;
import com.lib.bean.BookBorrowing;
import com.lib.bean.BookHistory;
import org.apache.ibatis.annotations.Delete;
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

    /**
     * 图书借阅
     */
    @Insert("insert into book_borrowing(bid,bname,uid,username,name,startdate,enddate)" +
            "values(#{bid},#{bname},#{uid},#{username},#{name},#{startdate},#{enddate})")
    void insertBorrowingBook(BookBorrowing bookBorrowing);

    /**
     * 根据username查询图书
     *
     * @return
     */
    @Select("select * from book_borrowing where username=#{username}")
    List<BookBorrowing> selectBookByUsername(String username);

    /**
     * 查询借阅记录
     */
    @Select("select * from book_borrowing")
    List<BookBorrowing> selectAllBookBorrowing();

    /**
     * 根据number查询借阅记录
     */
    @Select("select * from book_borrowing where number = #{number}")
    BookBorrowing selectBookBorrowingByNumber(Integer number);

    /**
     * 图书归还：删除借阅记录
     */
    @Delete("delete from book_borrowing where number=#{number}")
    void deleteBookBorrowingByNumber(Integer number);

    /**
     * 图书归还：添加借阅历史
     */
    @Insert("insert into book_history(bid,bname,uid,username,name,startdate,enddate,truedate,fine)" +
            "values(#{bid},#{bname},#{uid},#{username},#{name},#{startdate},#{enddate},#{truedate},#{fine})")
    void insertBookHistory(BookHistory bookHistory);

    /**
     * 借阅服务/借阅历史（根据用户查询借阅历史）
     */
    @Select("select * from book_history where username=#{username}")
    List<BookHistory> selectBookHistoryByUsername(String username);

    /**
     * 获得借阅历史
     */
    @Select("select * from book_history ")
    List<BookHistory> selectBookHistoryAll();

    /**
     * 缴纳罚金/修改罚金
     */
    @Update("update book_history set fine=#{fine} where number=#{number}")
    void updateFineById(Double fine, Integer number);

    /**
     * 借阅服务/借阅历史（根据id获得借阅历史）
     */
    @Select("select * from book_history where number=#{number}")
    BookHistory selectBookHistoryByNumber(Integer number);
}
