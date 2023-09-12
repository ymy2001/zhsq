package com.zhsq.service.impl;
 
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhsq.mapper.HospitalMapper;
import com.zhsq.pojo.Hospital;
import com.zhsq.service.HospitalService;
import org.springframework.stereotype.Service;
 
/**
 * 医院表(Hospital)表服务实现类
 *
 * @author makejava
 * @since 2023-09-11 08:49:41
 */
@Service
public class HospitalServiceImpl extends ServiceImpl<HospitalMapper, Hospital> implements HospitalService {
 
}
