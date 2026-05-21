package com.kwin._6mybatisplus.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Dept {
    private String id;
    private String name;

    private List<Emp> empList;
}
