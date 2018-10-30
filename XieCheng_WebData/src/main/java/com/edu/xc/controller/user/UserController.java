package com.edu.xc.controller.user;

import com.edu.mm.common.qo.QueryParam;
import com.edu.mm.common.util.RUtils;
import com.edu.mm.common.vo.R;
import com.edu.xc.pojo.user.User;
import com.edu.xc.service.user.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {
    @Autowired
    private UserService userService;

    //注册
    @ApiOperation(value = "注册用户", notes = "可以实现用户的新增")
    @PostMapping("/usersave.do")
    public R save(User user) {
        return userService.register(user);
    }

    //校验
    @ApiOperation(value = "忘记密码校验手机号和验证码", notes = "可以实现忘记密码功能的手机号验证")
    @PostMapping("/usercheckphone.do")
    public R check(String phone, String code) {
        //校验--验证码
        //校验--手机号是否正确
        return RUtils.setOK("手机号存在");
    }

    //忘记密码
    @ApiOperation(value = "忘记密码的重置密码", notes = "在忘记密码的情况下，进行密码的重置")
    @PostMapping("/userforget.do")
    public R forget(String phone, String password) {
        //校验--验证码
        QueryParam<String> queryParam = new QueryParam<>();
        queryParam.put("phone", phone);
        queryParam.put("password", password);

        R r = userService.forgetPass(queryParam);

        //移除当前登录信息
        //记录操作日志

        return r;
    }
}
