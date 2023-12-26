package com.example.demo.generation.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.generation.domain.Table;
import com.example.demo.generation.mapper.TableMapper;
import com.example.demo.generation.service.TableService;
import org.springframework.stereotype.Service;

/**
 * @author : songtc
 * @since : 2023/12/26 11:02
 */
@Service
public class TableServiceImpl extends ServiceImpl<TableMapper, Table> implements TableService {

}
