package com.example.userui.feign.impl;

import com.example.goodscommon.pojo.User;
import com.example.goodscommon.vo.ResultVo;
import com.example.userui.feign.UserUIFeign;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserUIFeignImpl implements UserUIFeign {
    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public ResultVo findById(Integer id) {
        return ResultVo.wrong("feign的服务降级响应");
    }
}
