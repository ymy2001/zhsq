package com.zhsq.service.impl;
 
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhsq.mapper.CompanyMapper;
import com.zhsq.pojo.Company;
import com.zhsq.service.CompanyService;
import org.springframework.stereotype.Service;
 
/**
 * 公司表(Company)表服务实现类
 *
 * @author makejava
 * @since 2023-09-11 08:49:41
 */
@Service
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper, Company> implements CompanyService {
 
}
