package com.zhsq.service;
 
import com.baomidou.mybatisplus.extension.service.IService;
import com.zhsq.pojo.Company;

import java.util.List;

/**
 * 公司表(Company)表服务接口
 *
 * @author makejava
 * @since 2023-09-09 10:08:32
 */
public interface CompanyService extends IService<Company> {

    /*
    * 根据公司类型查询公司*/
    List<Company> getByType(Integer type);
}
