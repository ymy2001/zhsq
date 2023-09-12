package com.zhsq.service.impl;
 
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhsq.mapper.ParkingMapper;
import com.zhsq.pojo.Parking;
import com.zhsq.service.ParkingService;
import org.springframework.stereotype.Service;
 
/**
 * 停车位表(Parking)表服务实现类
 *
 * @author makejava
 * @since 2023-09-11 08:49:41
 */
@Service
public class ParkingServiceImpl extends ServiceImpl<ParkingMapper, Parking> implements ParkingService {
 
}
