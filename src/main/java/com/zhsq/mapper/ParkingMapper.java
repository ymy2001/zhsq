package com.zhsq.mapper;
 
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhsq.pojo.Parking;
import org.apache.ibatis.annotations.Mapper;
/**
 * 停车位表(Parking)表数据库访问层
 *
 * @author makejava
 * @since 2023-09-11 08:45:47
 */
@Mapper
public interface ParkingMapper extends BaseMapper<Parking> {
 
}
