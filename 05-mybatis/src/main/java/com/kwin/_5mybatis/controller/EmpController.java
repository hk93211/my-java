package com.kwin._5mybatis.controller;

import com.kwin._5mybatis.pojo.Emp;
import com.kwin._5mybatis.pojo.EmpPageDTO;
import com.kwin._5mybatis.pojo.Result;
import com.kwin._5mybatis.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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
        return Result.success(empService.selectAll());
    }

    @PostMapping("/page")
    public Result page(@RequestBody EmpPageDTO empPageDTO) {
        return Result.success(empService.page(empPageDTO));
    }

    @PostMapping("/add")
    public Result add(@RequestBody Emp emp) {
        return Result.success(empService.add(emp));
    }


    @PostMapping("addBatch")
    public Result addBatch(@RequestBody List<Emp> empList) {
        empService.addBatch(empList);
        return Result.success("添加成功");
    }

    @DeleteMapping("delete/{id}")
    public Result delete(@PathVariable("id") String id) {
        empService.delete(id);
        return Result.success("删除成功");
    }

    @PostMapping("delete")
    public Result delete(@RequestBody Emp emp) {
        String id = emp.getId();
        empService.delete(id);
        return Result.success("删除成功");
    }

    @PostMapping("deleteBatch")
    public Result deleteBatch(@RequestBody List<String> ids) {
        System.out.println(ids);
        String s = empService.deleteBatch(ids);
        return Result.success(s);
    }
}
