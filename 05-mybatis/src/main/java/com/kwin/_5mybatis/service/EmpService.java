package com.kwin._5mybatis.service;

import com.github.pagehelper.Page;
import com.kwin._5mybatis.pojo.Emp;
import com.kwin._5mybatis.pojo.EmpPageDTO;
import com.kwin._5mybatis.pojo.PageResult;

import java.util.List;

public interface EmpService {
    List<Emp> selectAll();

    PageResult page(EmpPageDTO empPageDTO);

    String add(Emp emp);

    void addBatch(List<Emp> empList);
}
