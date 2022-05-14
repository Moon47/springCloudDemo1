package com.example.goodsui.service;

import com.example.goodscommon.pojo.Book;
import com.example.goodscommon.vo.ResultVo;

import java.util.List;

public interface GoodsUiService {

     void testGoodsProvider();

    List<Book> findAll();

    ResultVo findById(Integer id);

    String insert(Book book);
}
