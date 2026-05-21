package com.kwin._6mybatisplus.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpPageDTO extends PageQuery{
    private String id;
    private List<String> ids;
    private String name;
    private int age;
    private int deptId;

    private LocalDateTime createTimeStart;
    private LocalDateTime createTimeEnd;
    private LocalDate enterdate;
}
