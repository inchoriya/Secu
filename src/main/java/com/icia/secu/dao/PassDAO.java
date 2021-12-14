package com.icia.secu.dao;

import com.icia.secu.dto.PassMail;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PassDAO {
    int pss(PassMail passmail);

    PassMail pss2(String mail);
}
