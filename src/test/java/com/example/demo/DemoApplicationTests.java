package com.example.demo;

import com.example.demo.generation.utils.Generation;
import com.example.demo.generation.utils.GenerationUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Test
    public void contextLoad() {
        Generation generation = new Generation();
        generation.setAuthorName("songtc");
        generation.setEntityName("ActivityLimited");
        generation.setPackageName("com.ccspeed.desktop");
        generation.setModuleName("order");

        GenerationUtils.getInstance(generation).execute(".\\src\\main\\resources\\generation\\");
    }
}
