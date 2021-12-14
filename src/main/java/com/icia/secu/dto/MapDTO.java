package com.icia.secu.dto;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("daumMap")
public class MapDTO {
    String storeName;
    Double getLat;
    Double getLng;
}
