package com.edu.mm.common.util;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *@Author feri
 *@Date Created in 2018/7/25 15:08
 */
public class CookieUtil {
    //获取Cookie
    public static String getCk(HttpServletRequest request,String name){
        Cookie[] arrc=request.getCookies();
        if(arrc!=null) {
            for (Cookie c : arrc) {
                if (c.getName().equals(name)) {
                    return c.getValue();
                }
            }
        }
        return null;
    }
    //设置Cookie
    public static void setCK(HttpServletResponse response,String name,String value){
        Cookie cookie=new Cookie(name,value);
        cookie.setMaxAge(-1);
        cookie.setDomain("localhost");
        cookie.setPath("/");
        response.addCookie(cookie);
    }
    //删除Cookie
    public static void delCK(HttpServletResponse response,String name){
        Cookie cookie=new Cookie(name,"");
        cookie.setMaxAge(0);
        cookie.setDomain("localhost");
        cookie.setPath("/");
        response.addCookie(cookie);
    }
}
