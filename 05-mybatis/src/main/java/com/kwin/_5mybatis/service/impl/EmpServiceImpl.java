package com.kwin._5mybatis.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.kwin._5mybatis.mapper.EmpMapper;
import com.kwin._5mybatis.pojo.*;
import com.kwin._5mybatis.service.EmpService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class EmpServiceImpl implements EmpService {
    final EmpMapper empMapper;

    public EmpServiceImpl(EmpMapper empMapper) {
        this.empMapper = empMapper;
    }

    @Override
    public List<Emp> selectAll() {
        List<Emp> empList = empMapper.selectAll();
        List<String> empIdList = empList.stream()
                .map(Emp::getId)
                .distinct()
                .collect(Collectors.toList());
        List<EmpExpr> empExprList = empMapper.selectExprListByEmpIds(empIdList);

        Map<String, List<EmpExpr>> map = empExprList.stream()
                .collect(Collectors.groupingBy(EmpExpr::getEmpId));
        for (Emp emp : empList) {
            // emp.setEmpExprList(map.get(emp.getId())); // 没数据返回null
            emp.setEmpExprList(map.getOrDefault(emp.getId(), new ArrayList<>())); // 没数据返回空数组[]
        }
        return empList;
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
        empMapper.add(emp);
        List<EmpExpr> empExprList = emp.getEmpExprList();
        System.out.println(CollUtil.isNotEmpty(empExprList));
        if (CollUtil.isNotEmpty(empExprList)) {
            for (EmpExpr empExpr : empExprList) {
                String exprId = UUID.randomUUID().toString();
                empExpr.setId(exprId);
                empExpr.setEmpId(id);
            }
            this.addEmpExprBatch(empExprList);
        }

        return id;
    }

    @Override
    public void addBatch(List<Emp> empList) {
        ArrayList<EmpExpr> empExprs = new ArrayList<>();
        for (Emp emp : empList) {
            validate(emp);
            String empId = fillField(emp);
            List<EmpExpr> empExprList = emp.getEmpExprList();
            if (CollUtil.isNotEmpty(empExprList)) {
                for (EmpExpr empExpr : empExprList) {
                    String id = UUID.randomUUID().toString();
                    empExpr.setId(id);
                    empExpr.setEmpId(empId);
                    empExprs.add(empExpr);
                }
            }
        }

        empMapper.addBatch(empList);
        empMapper.addExprBatch(empExprs);
    }

    @Override
    public void addEmpExprBatch(List<EmpExpr> exprList) {
        empMapper.addExprBatch(exprList);
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

    @Override
    public void edit(Emp emp) {
        if (StrUtil.isBlank(emp.getId())) {
            throw new BusinessException("未传入id");
        }
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.edit(emp);
    }

    @Override
    public Object getDeptAndEmps(String id) {
        return empMapper.getDeptAndEmps(id);
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
