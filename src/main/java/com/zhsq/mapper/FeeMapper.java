package com.zhsq.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhsq.pojo.Fee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * 费用(Fee)表数据库访问层
 *
 * @author makejava
 * @since 2023-09-11 08:45:46
 */
@Mapper
public interface FeeMapper extends BaseMapper<Fee> {
    /*
    * 查询总的费用*/
    @Select("select sum(fee) as allFee from fee where fee<0 and user_id=#{currentId}")
    Double selectAll(Integer currentId);
    /*
     * 查询当天费用*/
    @Select("select sum(fee) as dayFee from fee " +
            "where fee<0 and user_id=#{id} " +
            "and fee_time < #{endTime} and fee_time>#{beginTime}")
    Double getDayFee(LocalDateTime beginTime, LocalDateTime endTime, Integer id);
    /*
    * 查询单个类型费用*/
    @Select("select sum(fee) from fee where fee<0 and fee_type=#{type} and user_id=#{id};")
    Double getOneFee(Integer type,Integer id);

    /*
    * 条件查询*/
    List<Fee> selectFeeDetail(Date begin, Date last, Integer id, Integer feeType);
}
