package com.example.demo.generation.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.generation.domain.Table;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : songtc
 * @since : 2023/12/26 10:59
 */
@Mapper
public interface TableMapper extends BaseMapper<Table> {
    List<Table> getTableInfo(@Param("tableName") String tableName);
}
