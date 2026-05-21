package com.kwin._6mybatisplus.service;

import com.kwin._6mybatisplus.pojo.Emp;
import com.kwin._6mybatisplus.pojo.EmpExpr;
import com.kwin._6mybatisplus.pojo.EmpPageDTO;
import com.kwin._6mybatisplus.pojo.PageResult;

import java.util.List;

public interface EmpService {
    List<Emp> selectAll();

    PageResult page(EmpPageDTO empPageDTO);

    String add(Emp emp);

    void addBatch(List<Emp> empList);

    void addEmpExprBatch(List<EmpExpr> exprList);

    void delete(String id);

    String deleteBatch(List<String> ids);

    void edit(Emp emp);

    Object getDeptAndEmps(String id);
}
