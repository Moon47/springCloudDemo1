package com.example.goodsprovider.service.impl;

import com.example.goodscommon.pojo.Book;
import com.example.goodsprovider.mapper.GoodsProviderMapper;
import com.example.goodsprovider.service.GoodsProviderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsProviderServiceImpl implements GoodsProviderService {

    @Resource
    private GoodsProviderMapper goodsProviderMapper;

    @Override
    public List<Book> findAll() {
        return goodsProviderMapper.findAll();
    }

    @Override
    public Book findById(Integer id) {
        return goodsProviderMapper.findById(id);
    }

    @Override
    public void insert(Book book) {
        goodsProviderMapper.insert(book);
    }
}
