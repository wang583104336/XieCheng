package com.edu.xc.service.sso;

import com.edu.mm.common.vo.R;

import javax.servlet.http.HttpServletResponse;

public interface SSOService {

    R login(String phone, String password, HttpServletResponse response);

    R CheckLogin(String token);

    R loginOut(String token, HttpServletResponse response);
}
