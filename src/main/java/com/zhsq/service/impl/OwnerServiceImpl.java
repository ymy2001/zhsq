package com.zhsq.service.impl;
 
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhsq.mapper.OwnerMapper;
import com.zhsq.pojo.Owner;
import com.zhsq.service.OwnerService;
import org.springframework.stereotype.Service;
 
/**
 * 业主表(Owner)表服务实现类
 *
 * @author makejava
 * @since 2023-09-11 08:49:41
 */
@Service
public class OwnerServiceImpl extends ServiceImpl<OwnerMapper, Owner> implements OwnerService {
 
}
