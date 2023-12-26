package com.example.demo.generation.domain;

import lombok.Data;

/**
 * @author : songtc
 * @since : 2023/12/26 10:57
 */
@Data
public class Table {
    private String columnName;
    private String dataType;
    private String columnComment;
    private String columnKey;
    private String extra;
    private String characterMaximumLength;
    private String isNullable;
    private String columnDefault;
}
