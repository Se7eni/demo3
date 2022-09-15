package com.example.demo.mapper;

import com.example.demo.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DemoMapper {

   // @Select("select id,user_id userId ,user_name userName from p_user limit 10")
    List<User> queryInfo();

}
