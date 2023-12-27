package com.example.demo.generation.domain;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author : songtc
 * @since : 2023/12/26 10:57
 */
@Data
public class Table {
    /**
     * 字段名
     */
    private String columnName;
    /**
     * 字段类型
     */
    private String dataType;
    /**
     * 字段描述
     */
    private String columnComment;
    /**
     * 是否主键
     */
    private String columnKey;
    /**
     *
     */
    private String extra;
    /**
     *
     */
    private String characterMaximumLength;
    /**
     * 是否允许空值
     */
    private String isNullable;
    /**
     *
     */
    private String columnDefault;
}
