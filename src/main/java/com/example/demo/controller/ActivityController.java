package com.example.demo.controller;

import com.example.demo.base.AbsController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.domain.Activity;

/**
 * @author : songtc
 * @since : 2023-12-27 11:30:17
 */
@RestController
@RequestMapping("/activity")
public class ActivityController extends AbsController<Activity> {

}
