package com.zhsq.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhsq.pojo.Owner;
import com.zhsq.pojo.Result;
import com.zhsq.pojo.vo.FeeOwnerVO;
import com.zhsq.service.OwnerService;
import com.zhsq.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 业主表(Owner)表控制层
 *
 * @author makejava
 * @since 2023-09-09 10:13:33
 */
@RestController
@Slf4j
@CrossOrigin
@RequestMapping("/owners")
public class OwnerController {
    /**
     * 服务对象
     */
    @Autowired
    private OwnerService ownerService;
    /*
    * 业主信息查询*/
    @GetMapping("/msg")
    public Result<FeeOwnerVO> owner(String ownerId){
        log.info("业主信息查询：{}",ownerId);
        FeeOwnerVO fv=new FeeOwnerVO();
        LambdaQueryWrapper<Owner> lqw=new LambdaQueryWrapper<Owner>()
                .eq(Owner::getOwnerId,ownerId);
        Owner one = ownerService.getOne(lqw);
        if (one==null){
            return Result.error("null");
        }
        String ownerAddress = one.getOwnerAddress();
        String ownerName = one.getOwnerName();
        String maskedAddress = maskAddress(ownerAddress);

        String name = maskLastCharacter(ownerName);
        log.info("业主姓名：{}",name);
        log.info("业主地址：{}",maskedAddress);
        one.setOwnerName(name);
        one.setOwnerAddress(maskedAddress);
        BeanUtils.copyProperties(one,fv);
        return Result.success(fv);
    }
    public static String maskLastCharacter(String name) {
        return name.substring(0, name.length() - 1) + "*";
    }
    public static String maskAddress(String address) {
        Pattern pattern = Pattern.compile(".{2}(区|单元|楼)");
        Matcher matcher = pattern.matcher(address);
        return matcher.replaceAll("**$1");
    }

     /**
   * 分页查询
   * @param page 查询页数
   * @param size 一页显示条数
   * @return ·
   */
   @GetMapping("/page")
   public R<Page<Owner>> getAllByPage(int page, int size){
   	Page<Owner> ownerPage = new Page<>(page, size);
   	LambdaQueryWrapper<Owner> queryWrapper = new LambdaQueryWrapper<>();
   	//TODO查询条件定制
   
   	//执行查询
   	ownerService.page(ownerPage);
   	return R.success(ownerPage);
   }
}
