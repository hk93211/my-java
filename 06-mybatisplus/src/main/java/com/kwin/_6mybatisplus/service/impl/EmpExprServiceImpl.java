package com.kwin._6mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kwin._6mybatisplus.mapper.EmpExprMapper;
import com.kwin._6mybatisplus.pojo.EmpExpr;
import com.kwin._6mybatisplus.service.EmpExprService;
import org.springframework.stereotype.Service;

@Service
public class EmpExprServiceImpl
        extends ServiceImpl<EmpExprMapper, EmpExpr>
        implements EmpExprService {
}
