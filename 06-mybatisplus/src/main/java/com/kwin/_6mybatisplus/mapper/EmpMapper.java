package com.kwin._6mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kwin._6mybatisplus.pojo.Emp;
import com.kwin._6mybatisplus.pojo.EmpExpr;
import com.kwin._6mybatisplus.pojo.EmpPageDTO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmpMapper extends BaseMapper<Emp> {

    Object getDeptAndEmps(String id);
}
