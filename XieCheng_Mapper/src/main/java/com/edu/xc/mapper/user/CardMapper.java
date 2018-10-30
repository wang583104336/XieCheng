package com.edu.xc.mapper.user;

import com.edu.xc.pojo.user.Card;

public interface CardMapper {

    int insert(Card record);


    Card selectByUno(String uno);

    int updateByrimaryKey(Card record);
}