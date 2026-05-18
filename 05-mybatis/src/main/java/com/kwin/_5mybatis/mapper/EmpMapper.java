package com.kwin._5mybatis.mapper;

import com.github.pagehelper.Page;
import com.kwin._5mybatis.annotation.AutoFill;
import com.kwin._5mybatis.annotation.OperationType;
import com.kwin._5mybatis.pojo.Emp;
import com.kwin._5mybatis.pojo.EmpPageDTO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmpMapper {
    @Select("select * from emp")
    List<Emp> selectAll();

    Page<Emp> page(EmpPageDTO empPageDTO);

    // @AutoFill(value = OperationType.INSERT)
    // 因为ai说不要切面dao层，应该切面service层
    int insert(Emp emp);

    void addBatch(@Param("empList") List<Emp> empList);

    @Delete("delete from emp where id = #{id}")
    int delete(String id);

    int deleteBatch(@Param("ids") List<String> ids);
}
