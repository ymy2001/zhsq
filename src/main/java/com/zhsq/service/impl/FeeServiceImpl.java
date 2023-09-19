package com.zhsq.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.toolkit.Db;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhsq.mapper.FeeMapper;
import com.zhsq.pojo.Company;
import com.zhsq.pojo.Fee;
import com.zhsq.pojo.dto.FeeDetailDTO;
import com.zhsq.pojo.dto.FeePayDTO;
import com.zhsq.pojo.vo.FeePageVO;
import com.zhsq.pojo.vo.FeeVO;
import com.zhsq.service.FeeService;
import com.zhsq.utils.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 费用(Fee)表服务实现类
 *
 * @author makejava
 * @since 2023-09-11 08:49:41
 */
@Service
@Slf4j
public class FeeServiceImpl extends ServiceImpl<FeeMapper, Fee> implements FeeService {
    @Autowired
    FeeMapper baseMapper = getBaseMapper();
    /*
    * 查询欠费*/
    @Override
    public FeeVO getByTime(LocalDateTime dayTime, Integer currentId) {
        log.info("时间参数：{}",dayTime);
        FeeVO feeVO=new FeeVO();
        Double allFee=baseMapper.selectAll(currentId);
        feeVO.setAllFee(allFee);
        LocalDateTime beginTime = LocalDateTime.of(LocalDate.from(dayTime), LocalTime.MIN);
        LocalDateTime endTime = LocalDateTime.of(LocalDate.from(dayTime), LocalTime.MAX);
        log.info("开始时间：{}，结束时间：{}",beginTime,endTime);
        Double dayFee=baseMapper.getDayFee(beginTime,endTime,currentId);
        feeVO.setDayFee(dayFee);
        //费用明细查询：1代表水费 2代表电费 3代表煤气费 4代表物业费 5代表停车费 6代表宽带费
        Double water=baseMapper.getOneFee(1,currentId);
        Double electricity=baseMapper.getOneFee(2,currentId);
        Double gas=baseMapper.getOneFee(3,currentId);
        Double property=baseMapper.getOneFee(4,currentId);
        Double parking=baseMapper.getOneFee(5,currentId);
        Double broadband=baseMapper.getOneFee(6,currentId);
        feeVO.setWater(water);
        feeVO.setElectricity(electricity);
        feeVO.setGas(gas);
        feeVO.setProperty(property);
        feeVO.setParking(parking);
        feeVO.setBroadband(broadband);
        return feeVO;
    }
    /*
     * 支付订单详情页*/
    public List<FeeDetailDTO> getDetailByTimeAndType(LocalDateTime detailTime, Integer feeType, Integer id) {
        //构建单个月的日期限制条件
        LocalDateTime firstTime = detailTime.with(TemporalAdjusters.firstDayOfMonth());
        LocalDateTime lastTime=detailTime.with(TemporalAdjusters.lastDayOfMonth());
        firstTime=LocalDateTime.of(LocalDate.from(firstTime), LocalTime.MIN);
        lastTime=LocalDateTime.of(LocalDate.from(lastTime), LocalTime.MAX);
        lastTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        firstTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        log.info("获取当前月份最后一天：{},第一天：{}",lastTime,firstTime);
        Date begin = DateUtils.toDate(firstTime);
        Date last = DateUtils.toDate(lastTime);
        List<Fee> feeList = baseMapper.selectFeeDetail(begin,last,id,feeType);
        return feeList.stream()
                .map(fee -> {
                    FeeDetailDTO feeDetailDTO = new FeeDetailDTO();
                    BeanUtils.copyProperties(fee, feeDetailDTO);
                    return feeDetailDTO;
                })
                .collect(Collectors.toList());
    }
    /*
    * 实现用户缴费*/
    public Fee userPayment(FeePayDTO feePayDTO) {
        Fee fee=new Fee();
        String companyId = feePayDTO.getCompanyId();
        Company one = Db.lambdaQuery(Company.class).eq(Company::getCompanyId, companyId).one();
        BeanUtils.copyProperties(feePayDTO,fee);
        fee.setFeeType(one.getFeeType());
        fee.setPayStatus(1);
        save(fee);
        Integer id = fee.getId();
        log.info("返回id测试：{}",id);
        return fee;
    }

    /*
    * 分页缴费记录实现*/
    public FeePageVO getByAll(Integer page, Integer pageSize, LocalDateTime detailTime, Integer feeType, Integer currentId) {
        //设置分页参数
        PageHelper.startPage(page,pageSize);
        //构建单个月的日期限制条件
        LocalDateTime firstTime = detailTime.with(TemporalAdjusters.firstDayOfMonth());
        LocalDateTime lastTime=detailTime.with(TemporalAdjusters.lastDayOfMonth());
        firstTime=LocalDateTime.of(LocalDate.from(firstTime), LocalTime.MIN);
        lastTime=LocalDateTime.of(LocalDate.from(lastTime), LocalTime.MAX);
        lastTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        firstTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        log.info("获取当前月份最后一天：{},第一天：{}",lastTime,firstTime);
        Date begin = DateUtils.toDate(firstTime);
        Date last = DateUtils.toDate(lastTime);
        List<Fee> feeList = baseMapper.selectFeeDetail(begin,last,currentId,feeType);
        List<FeeDetailDTO> collect = feeList.stream()
                .map(fee -> {
                    FeeDetailDTO feeDetailDTO = new FeeDetailDTO();
                    BeanUtils.copyProperties(fee, feeDetailDTO);
                    return feeDetailDTO;
                })
                .collect(Collectors.toList());
        //获取分页信息
        PageInfo<FeeDetailDTO> pageInfo = new PageInfo<>(collect);
        //封装结果
        return new FeePageVO(pageInfo.getTotal(),pageInfo.getList());
    }
}
