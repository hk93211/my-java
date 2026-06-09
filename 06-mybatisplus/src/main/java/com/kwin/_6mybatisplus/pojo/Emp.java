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
    private Integer age;
    private String job;
    private Integer managerId;
    private Integer deptId;
    private Integer salary;
    private LocalDate enterdate;

    @TableField(exist = false)
    private List<EmpExpr> empExprList;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
