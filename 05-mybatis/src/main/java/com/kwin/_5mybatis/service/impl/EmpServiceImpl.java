package com.kwin._5mybatis.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.kwin._5mybatis.mapper.EmpMapper;
import com.kwin._5mybatis.pojo.BusinessException;
import com.kwin._5mybatis.pojo.Emp;
import com.kwin._5mybatis.pojo.EmpPageDTO;
import com.kwin._5mybatis.pojo.PageResult;
import com.kwin._5mybatis.service.EmpService;
import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

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
        PageResult pageResult = new PageResult(page);
        return pageResult;
    }

    @Override
    @Transactional
    public String add(Emp emp) {
        System.out.println(emp.getSalary());
        if (emp.getSalary() == 0) {
            throw new BusinessException("薪资不能为空");
        }
        String id = UUID.randomUUID().toString();
        emp.setId(id);
        int insert = empMapper.insert(emp);
        if (insert > 0) {
            return id;
        } else {
            return null;
        }
    }

    @Override
    public void addBatch(List<Emp> empList) {

    }
}
