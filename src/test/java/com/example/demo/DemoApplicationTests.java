package com.example.demo;

import com.example.demo.generation.utils.Generation;
import com.example.demo.generation.utils.GenerationUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
        Generation generation = new Generation();
        generation.setTableName("activity"); // 指定表名
        generation.setAuthorName("songtc"); // 指定作者
        generation.setModuleName(""); // 指定模块
        generation.setPackageName("com.example.demo"); // 指定基础包名
        // 指定生成路径
        GenerationUtils.getInstance(generation).execute(".\\src\\main\\resources\\generation\\");
    }
}
