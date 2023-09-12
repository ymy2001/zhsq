package com.zhsq.service.impl;
 
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhsq.mapper.UserMapper;
import com.zhsq.pojo.User;
import com.zhsq.service.UserService;
import org.springframework.stereotype.Service;
 
/**
 * 用户表(User)表服务实现类
 *
 * @author makejava
 * @since 2023-09-11 08:49:41
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
 
}
