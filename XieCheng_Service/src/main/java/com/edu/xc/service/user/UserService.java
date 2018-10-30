package com.edu.xc.service.user;

import com.edu.mm.common.qo.QueryParam;
import com.edu.mm.common.vo.R;
import com.edu.xc.pojo.user.User;

public interface UserService {
    //新增
    R register(User user);
    //忘记密码
    R forgetPass(QueryParam<String> params);
    //修改密码
    R updatePass(String phone, String password);
    //登录
    User login(String phone, String password);
}
