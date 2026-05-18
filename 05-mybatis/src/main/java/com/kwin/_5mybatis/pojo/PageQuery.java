package com.kwin._5mybatis.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageQuery {
    private int pageSize;
    private int pageNumber;
}
