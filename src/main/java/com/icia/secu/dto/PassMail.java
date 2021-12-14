package com.icia.secu.dto;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("passmail")
public class PassMail {

    String pw;
    String mail;

}
