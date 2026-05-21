package com.kwin._6mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.kwin._6mybatisplus.pojo.EmpExpr;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

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

    @TableField(exist = false)
    private List<EmpExpr> empExprList;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
