package com.zhsq.service.impl;
 
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhsq.mapper.ActivityMapper;
import com.zhsq.pojo.Activity;
import com.zhsq.service.ActivityService;
import org.springframework.stereotype.Service;
 
/**
 * 活动表(Activity)表服务实现类
 *
 * @author makejava
 * @since 2023-09-11 08:49:40
 */
@Service
public class ActivityServiceImpl extends ServiceImpl<ActivityMapper, Activity> implements ActivityService {
 
}
