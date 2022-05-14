package com.example.userprovider.mapper;

import com.example.goodscommon.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface userMapper {

    List<User> findAll();

    void insert(User user);

    void deleteBatch(@Param("ids") Integer[] ids);

    User findById(Integer id);

    void deleteById(Integer id);

    void updateById(@Param("id") Integer id,@Param("user") User user);
}
