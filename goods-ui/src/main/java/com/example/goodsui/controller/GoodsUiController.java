package com.example.goodsui.controller;

import com.example.goodscommon.pojo.Book;
import com.example.goodscommon.vo.ResultVo;
import com.example.goodsui.service.GoodsUiService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/ui")
public class GoodsUiController {

    @Resource
    private GoodsUiService goodsUiService;

    @RequestMapping("/test")
    public String test(){
        goodsUiService.testGoodsProvider();
        return "success";
    }

    /**
     * 查询所有图书
     */
    @RequestMapping("/findAll")
    public List<Book> findAll(){
        return goodsUiService.findAll();
    }

    /**
     * 根据id查询
     */
    @RequestMapping("/findById/{id}")
    public ResultVo findById(@PathVariable("id") Integer id){
        return goodsUiService.findById(id);
    }

    /**
     * 添加
     */
    @PostMapping("/insert")
    public String insert(@RequestBody Book book){
        return goodsUiService.insert(book);
    }

}
