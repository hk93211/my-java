package com.kwin._5mybatis.mapper;

import com.github.pagehelper.Page;
import com.kwin._5mybatis.pojo.Emp;
import com.kwin._5mybatis.pojo.EmpPageDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmpMapper {
    @Select("select * from emp")
    public List<Emp> selectAll();

    public Page<Emp> page(EmpPageDTO empPageDTO);
}
