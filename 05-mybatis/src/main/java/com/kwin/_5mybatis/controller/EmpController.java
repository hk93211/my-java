package com.kwin._5mybatis.controller;

import com.kwin._5mybatis.pojo.Emp;
import com.kwin._5mybatis.pojo.EmpPageDTO;
import com.kwin._5mybatis.pojo.PageResult;
import com.kwin._5mybatis.pojo.Result;
import com.kwin._5mybatis.service.EmpService;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/emp")
public class EmpController {
    final EmpService empService;

    public EmpController(EmpService empService) {
        this.empService = empService;
    }

    @GetMapping("/all")
    public Result all() {
        List<Emp> empList = empService.selectAll();

        return Result.success(empList);
    }

    @GetMapping("page")
    public PageResult page(@NonNull EmpPageDTO empPageDTO) {
        return empService.page(empPageDTO);
    }
}
