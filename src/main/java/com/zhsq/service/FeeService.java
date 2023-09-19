package com.zhsq.service;
 
import com.baomidou.mybatisplus.extension.service.IService;
import com.zhsq.pojo.Fee;
import com.zhsq.pojo.dto.FeeDetailDTO;
import com.zhsq.pojo.dto.FeePayDTO;
import com.zhsq.pojo.vo.FeePageVO;
import com.zhsq.pojo.vo.FeeVO;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 费用(Fee)表服务接口
 *
 * @author makejava
 * @since 2023-09-09 10:08:32
 */
public interface FeeService extends IService<Fee> {

    /*
    * 查询欠费记录并统计*/
    FeeVO getByTime(LocalDateTime dayTime, Integer currentId);
    /*
    * 支付订单详情页*/
    List<FeeDetailDTO> getDetailByTimeAndType(LocalDateTime detailTime, Integer feeType, Integer id);

    /*
    * 支付各种费用*/
    Fee userPayment(FeePayDTO feePayDTO);

    /*
    * 分页缴费记录查询*/
    FeePageVO getByAll(Integer page, Integer pageSize, LocalDateTime detailTime, Integer feeType, Integer currentId);
}
