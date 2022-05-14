package com.example.userprovider.controller;

import com.example.goodscommon.pojo.User;
import com.example.goodscommon.vo.ResultVo;
import com.example.userprovider.mapper.userMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private userMapper userMapper;

    @RequestMapping("/findAll")
    public List<User> findAll(){
        return userMapper.findAll();
    }

    @GetMapping("/findById")
    public ResultVo findById(@RequestParam("id") Integer id) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        User user = userMapper.findById(id);
        return ResultVo.success(user);
    }

}
