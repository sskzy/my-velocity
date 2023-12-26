package com.example.demo.generation.utils;

import lombok.Data;

/**
 * @author : songtc
 * @since : 2023/12/26 15:37
 */
@Data
public class Generation {
    /**
     * 作者
     */
    private String authorName;
    /**
     * 实体
     */
    private String entityName;
    /**
     * 包名
     */
    private String packageName;
    /**
     * 模块名
     */
    private String moduleName;
}
