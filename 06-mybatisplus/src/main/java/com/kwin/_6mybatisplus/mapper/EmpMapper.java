package com.kwin._6mybatisplus.mapper;

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
public interface EmpMapper {
    @Select("select * from emp")
    List<Emp> selectAll();

    List<EmpExpr> selectExprListByEmpIds(@Param("ids") List<String> ids);

    Page<Emp> page(EmpPageDTO empPageDTO);

    // @AutoFill(value = OperationType.INSERT)
    // 因为ai说不要切面dao层，应该切面service层
    int add(Emp emp);

    void addBatch(@Param("empList") List<Emp> empList);

    @Delete("delete from emp where id = #{id}")
    int delete(String id);

    int deleteBatch(@Param("ids") List<String> ids);

    void edit(Emp emp);

    Object getDeptAndEmps(String id);

    void addExprBatch(@Param("exprList") List<EmpExpr> exprList);
}
