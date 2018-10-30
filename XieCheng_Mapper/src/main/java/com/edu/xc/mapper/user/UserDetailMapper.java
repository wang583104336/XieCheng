package com.edu.xc.mapper.user;

import com.edu.xc.pojo.user.UserDetail;

public interface UserDetailMapper {

    int insert(UserDetail record);


    UserDetail selectByNo(String no);

    int updateByPrimaryKey(UserDetail record);
}