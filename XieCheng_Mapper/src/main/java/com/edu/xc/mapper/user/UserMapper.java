package com.edu.xc.mapper.user;

import com.edu.mm.common.qo.QueryParam;
import com.edu.xc.pojo.user.User;

public interface UserMapper {
    int insert(User record);

    //修改密码
    int updatePassword(QueryParam<String> param);

    //查询
    User selectByPhone(String phone);

}