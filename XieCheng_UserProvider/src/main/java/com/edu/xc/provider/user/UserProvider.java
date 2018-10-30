package com.edu.xc.provider.user;

import com.edu.mm.common.qo.QueryParam;
import com.edu.mm.common.util.RUtils;
import com.edu.mm.common.vo.R;
import com.edu.xc.mapper.user.AddressLogsMapper;
import com.edu.xc.mapper.user.UserLogsMapper;
import com.edu.xc.mapper.user.UserMapper;
import com.edu.xc.pojo.user.User;
import com.edu.xc.pojo.user.UserLogs;
import com.edu.xc.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
public class UserProvider implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserLogsMapper userLogsMapper;

    @Autowired
    private AddressLogsMapper addressLogsMapper;

    @Transactional//使用事务
    @Override
    public R register(User user) {
        //密码加密
        userMapper.insert(user);
        UserLogs logs = new UserLogs();
        logs.setMsg("新增用户：" + user.getPhone());
        logs.setType(7010);
        logs.setNo(user.getNo());
        userLogsMapper.insert(logs);
        return RUtils.setOK("新增用户成功");
    }

    @Override
    public R forgetPass(QueryParam<String> params) {
        String phone = params.get("phone");
        String code = params.get("code");

        return RUtils.getR(userMapper.updatePassword(params));
    }

    @Override
    public R updatePass(String phone, String password) {
        QueryParam<String> param = new QueryParam<>();
        param.put("phone", phone);
        param.put("password", password);
        return RUtils.getR(userMapper.updatePassword(param));
    }

    @Override
    public User login(String phone, String password) {
        User user = userMapper.selectByPhone(phone);
        if (user != null) {
            if (Objects.equals(user.getPassword(), password)) {
                return user;
            }
        }
        return null;
    }
}
