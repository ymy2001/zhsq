package com.zhsq.controller;
 
 
 
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhsq.pojo.Company;
import com.zhsq.pojo.Result;
import com.zhsq.service.CompanyService;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import com.zhsq.utils.R;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
 
/**
 * 公司表(Company)表控制层
 *
 * @author makejava
 * @since 2023-09-09 10:13:33
 */
@RestController
@Slf4j
@CrossOrigin
@RequestMapping("/companys")
public class CompanyController {
    /**
     * 服务对象
     */
    @Autowired
    private CompanyService companyService;
    /*
    * 公司查询回显*/
    @GetMapping("/type")
    public Result<List<Company>> getCompany(Integer type){
        List<Company> companyList=companyService.getByType(type);
        return Result.success(companyList);
    }
     /**
   * 分页查询
   * @param page 查询页数
   * @param size 一页显示条数
   * @return ·
   */
   @GetMapping("/page")
   public R<Page<Company>> getAllByPage(int page, int size){
   	Page<Company> companyPage = new Page<>(page, size);
   	LambdaQueryWrapper<Company> queryWrapper = new LambdaQueryWrapper<>();
   	//TODO查询条件定制
   
   	//执行查询
   	companyService.page(companyPage);
   	return R.success(companyPage);
   }
}
