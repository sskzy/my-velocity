package com.example.demo. service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.domain.Activity;
import com.example.demo.mapper.ActivityMapper;
import com.example.demo.service.ActivityService;
import org.springframework.stereotype.Service;

/**
 * @author : songtc
 * @since : 2023-12-27 11:34:22
 */
@Service
public class ActivityServiceImpl extends ServiceImpl<ActivityMapper, Activity>
        implements ActivityService {

}
