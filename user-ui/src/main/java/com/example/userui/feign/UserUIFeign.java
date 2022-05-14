package com.example.userui.feign;

import com.example.goodscommon.pojo.User;
import com.example.goodscommon.vo.ResultVo;
import com.example.userui.feign.impl.UserUIFeignImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "user-provider",fallback = UserUIFeignImpl.class)
public interface UserUIFeign {

    @GetMapping("/user/findAll")
    List<User> findAll();

    @GetMapping("/user/findById")
    ResultVo findById(@RequestParam("id") Integer id);
}
