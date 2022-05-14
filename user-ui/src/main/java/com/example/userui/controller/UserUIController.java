package com.example.userui.controller;

import com.example.goodscommon.pojo.User;
import com.example.goodscommon.vo.ResultVo;
import com.example.userui.feign.UserUIFeign;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserUIController {

    @Resource
    private UserUIFeign userUIFeign;

    /**
     * 查询所有
     */
    @RequestMapping("/findAll")
    public List<User> findAll(){
        return userUIFeign.findAll();
    }

    /**
     * 根据id查询
     */
    @GetMapping("/findById/{id}")
    public ResultVo findById(@PathVariable("id") Integer id) {
        return userUIFeign.findById(id);
    }

}
