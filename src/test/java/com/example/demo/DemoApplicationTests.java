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
        generation.setTableName("activity");
        generation.setAuthorName("songtc");
        generation.setModuleName("");
        generation.setPackageName("com.example.demo");

        GenerationUtils.getInstance(generation).execute(".\\src\\main\\resources\\generation\\");
    }
}
