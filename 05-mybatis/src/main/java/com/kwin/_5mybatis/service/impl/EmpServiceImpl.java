package com.kwin._5mybatis.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.kwin._5mybatis.mapper.EmpMapper;
import com.kwin._5mybatis.pojo.BusinessException;
import com.kwin._5mybatis.pojo.Emp;
import com.kwin._5mybatis.pojo.EmpPageDTO;
import com.kwin._5mybatis.pojo.PageResult;
import com.kwin._5mybatis.service.EmpService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
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
        validate(emp);
        String id = fillField(emp);
        empMapper.insert(emp);
        return id;
    }

    @Override
    public void addBatch(List<Emp> empList) {
        for (Emp emp : empList) {
            validate(emp);
            fillField(emp);
        }
        empMapper.addBatch(empList);
    }

    @Override
    public void delete(String id) {
        int rows = empMapper.delete(id);
        if (rows == 0) {
            throw new BusinessException("数据不存在");
        }
    }

    @Override
    public String deleteBatch(List<String> ids) {
        int total = ids.size();

        int rows = empMapper.deleteBatch(ids);
        return "成功" + rows + "行, " + "失败" + (total - rows) + "行.";
    }

    public void validate(Emp emp) {
        if (emp.getSalary() == 0) {
            throw new BusinessException("薪资不能为空");
        }
    }
    public String fillField(Emp emp) {
        String id = UUID.randomUUID().toString();
        LocalDateTime now = LocalDateTime.now();
        emp.setId(id);
        emp.setCreateTime(now);
        emp.setUpdateTime(now);
        return id;
    }
}
