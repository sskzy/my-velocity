package com.example.demo;

import com.example.demo.generation.domain.Table;
import com.example.demo.generation.mapper.TableMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class DemoApplicationTests {

    @Resource
    TableMapper tableMapper;

    @Test
    void contextLoads() {
        for (Table activity : tableMapper.getTableInfo("activity")) {
            System.out.println(activity);
        }
    }
}
