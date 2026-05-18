package com.kwin._5mybatis.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emp {
    private String id;
    private String name;
    private int age;
    private String job;
    private int managerId;
    private int deptId;
    private int salary;
    private LocalDate enterdate;

    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
