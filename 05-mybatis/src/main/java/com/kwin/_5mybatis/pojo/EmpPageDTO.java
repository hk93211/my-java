package com.kwin._5mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpPageDTO extends PageQuery{
    private int id;
    private String name;
    private int age;
    private int deptId;
    private LocalDate enterdate;
}
