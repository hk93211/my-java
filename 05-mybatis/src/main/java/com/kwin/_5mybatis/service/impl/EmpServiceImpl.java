package com.kwin._5mybatis.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.kwin._5mybatis.mapper.EmpMapper;
import com.kwin._5mybatis.pojo.Emp;
import com.kwin._5mybatis.pojo.EmpPageDTO;
import com.kwin._5mybatis.pojo.PageResult;
import com.kwin._5mybatis.service.EmpService;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    final EmpMapper empMapper;

    public EmpServiceImpl(EmpMapper empMapper) {
        this.empMapper = empMapper;
    }

    @Override
    public List<Emp> selectAll() {
        return empMapper.selectAll();
    }

    @Override
    public PageResult page(EmpPageDTO empPageDTO) {
        PageHelper.startPage(
                empPageDTO.getPageNumber(),
                empPageDTO.getPageSize()
        );

        Page<Emp> page = empMapper.page(empPageDTO);
        long total = page.getTotal();
        List<Emp> list = page.getResult();
        return new PageResult(total, list);
    }
}
