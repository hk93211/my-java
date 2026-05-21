package com.kwin._6mybatisplus.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageQuery {
    private int pageSize = 30;
    private int pageNumber = 1;
}
