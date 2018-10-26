package com.edu.mm.common.util;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.crypto.AesCipherService;
import org.apache.shiro.crypto.hash.Md5Hash;

import java.security.Key;

public class PassUtil {
    //md5
    public static String md5(String pass, String slat, int count) {
        return new Md5Hash(pass, slat, count).toBase64();
    }
    public static String md5(String pass) {
        return md5(pass, "edu", 1024);
    }


    public static String base64EN(String value) {
        return Base64.encode(value.getBytes()).toString();
    }
    public static String base64DE(String value) {
        return Base64.decode(value).toString();
    }

    //生成AES秘钥
    public static Key createKey() {
        AesCipherService aesCipherService = new AesCipherService();
        aesCipherService.setKeySize(128);
        return aesCipherService.generateNewKey();
    }

    //加密
    public static String AesEN(Key key, String pass) {
        return new AesCipherService().encrypt(pass.getBytes(), key.getEncoded()).toString();
    }

    //解密
    public static String AesDE(Key key, String pass) {
        return new AesCipherService().decrypt(base64DE(pass).getBytes(), key.getEncoded()).toString();
    }

}
