package com.lib;

import com.lib.bean.Book;
import com.lib.mapper.BookMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class LibApplicationTests {

    @Autowired
    private BookMapper bookMapper;
    @Test
    void contextLoads() {
        List<Book> list = bookMapper.list();
        System.out.println(list);
    }

}
