package com.example.demo.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

/**
 * @author : songtc
 * @since : 2023-12-27 11:30:17
 */
@Setter
@Getter
public class Activity{
    /**
     * 活动id
     */
    @TableId(type = IdType.AUTO)
    @ApiModelProperty("活动id")
    private Long id;
    /**
     * 活动名称
     */
    @ApiModelProperty("活动名称")
    private String name;
    /**
     * 活动状态
     */
    @ApiModelProperty("活动状态")
    private Integer status;
    /**
     * 开始时间
     */
    @ApiModelProperty("开始时间")
    private LocalDateTime startDateTime;
    /**
     * 结束时间
     */
    @ApiModelProperty("结束时间")
    private LocalDateTime endDateTime;
    /**
     * 活动类型(1:抽奖活动)
     */
    @ApiModelProperty("活动类型(1:抽奖活动)")
    private Integer type;
}
