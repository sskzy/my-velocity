package com.example.demo.base;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : songtc
 * @since : 2023/12/26 11:30
 */
@RestController
public abstract class AbsController<T> {

    @Autowired
    protected IService<T> service;

    /**
     * 根据 ID 查询
     *
     * @param id 主键ID
     */
    @GetMapping("/getById")
    public T getById(Long id) {
        return service.getById(id);
    }

    /**
     * 插入一条记录
     *
     * @param t 实体对象
     */
    @GetMapping("/save")
    public Boolean save(T t) {
        return service.save(t);
    }

    /**
     * 根据 ID 选择修改
     *
     * @param t 实体对象
     */
    @GetMapping("/updateById")
    public Boolean updateById(T t) {
        return service.updateById(t);
    }

    /**
     * 根据 ID 删除
     *
     * @param id 主键ID
     */
    @GetMapping("/removeById")
    public Boolean removeById(Long id) {
        return service.removeById(id);
    }

}
