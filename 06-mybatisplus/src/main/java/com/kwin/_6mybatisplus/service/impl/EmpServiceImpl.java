package com.kwin._6mybatisplus.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kwin._6mybatisplus.mapper.EmpMapper;
import com.kwin._6mybatisplus.pojo.*;
import com.kwin._6mybatisplus.service.EmpExprService;
import com.kwin._6mybatisplus.service.EmpService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EmpServiceImpl
        extends ServiceImpl<EmpMapper, Emp>
        implements EmpService {
    final EmpMapper empMapper;
    final EmpExprService empExprService;

    public EmpServiceImpl(
            EmpMapper empMapper,
            EmpExprService empExprService
    ) {
        this.empMapper = empMapper;
        this.empExprService = empExprService;
    }

    @Override
    public List<Emp> selectAll() {
        List<Emp> empList = this.list();
        List<String> empIdList = empList.stream()
                .map(Emp::getId)
                .distinct()
                .collect(Collectors.toList());

        LambdaQueryWrapper<EmpExpr> wrapper = new LambdaQueryWrapper<>();
        wrapper.in(EmpExpr::getEmpId, empIdList);
        List<EmpExpr> empExprList = empExprService.list(wrapper);
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
        Page<Emp> page = new Page<>(
                empPageDTO.getPageNumber(),
                empPageDTO.getPageSize()
        );

        LambdaQueryWrapper<Emp> wrapper = new LambdaQueryWrapper<>();

        // id
        wrapper.eq(
                StrUtil.isNotBlank(empPageDTO.getId()),
                Emp::getId,
                empPageDTO.getId()
        );

        // ids in
        wrapper.in(
                CollUtil.isNotEmpty(empPageDTO.getIds()),
                Emp::getId,
                empPageDTO.getIds()
        );

        // name/job 模糊
        wrapper.like(
                StrUtil.isNotBlank(empPageDTO.getName()),
                Emp::getName,
                empPageDTO.getName()
        );

        // age
        wrapper.like(
                empPageDTO.getAge() != 0,
                Emp::getAge,
                empPageDTO.getAge()
        );

        // deptId
        wrapper.eq(
                empPageDTO.getDeptId() != 0,
                Emp::getDeptId,
                empPageDTO.getDeptId()
        );

        // createTimeStart
        wrapper.like(
                empPageDTO.getCreateTimeStart() != null,
                Emp::getCreateTime,
                empPageDTO.getCreateTimeStart()
        );

        // createTimeEnd
        wrapper.le(
                empPageDTO.getCreateTimeEnd() != null,
                Emp::getCreateTime,
                empPageDTO.getCreateTimeEnd()
        );

        // 排序
        wrapper.orderByAsc(Emp::getId);

        Page<Emp> empPage = this.page(page, wrapper);
        return new PageResult(empPage);
    }

    @Override
    @Transactional
    public String add(Emp emp) {
        validate(emp);
        String id = fillField(emp);

        this.save(emp);
        List<EmpExpr> empExprList = emp.getEmpExprList();
        if (CollUtil.isNotEmpty(empExprList)) {
            for (EmpExpr empExpr : empExprList) {
                String exprId = UUID.randomUUID().toString();
                empExpr.setId(exprId);
                empExpr.setEmpId(id);
            }
        }
        empExprService.saveBatch(empExprList);
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

        this.saveBatch(empList);
        empExprService.saveBatch(empExprs);
    }

    @Override
    public void delete(String id) {
        boolean b = this.removeById(id);
        if (!b) {
            throw new BusinessException("数据不存在");
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String deleteBatch(List<String> ids) {
        LambdaQueryWrapper<EmpExpr> wrapper = new LambdaQueryWrapper<>();
        wrapper.in(EmpExpr::getEmpId, ids);

        empExprService.remove(wrapper);

        // boolean b = this.removeByIds(ids); // service只返回true/false, mapper能返回影响行数
        int i = empMapper.deleteByIds(ids);
        int total = ids.size();

        return "成功" + i + "行, " + "失败" + (total - i) + "行.";
    }

    @Override
    public void edit(Emp emp) {
        if (StrUtil.isBlank(emp.getId())) {
            throw new BusinessException("未传入id");
        }
        emp.setUpdateTime(LocalDateTime.now());
        this.updateById(emp);
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
