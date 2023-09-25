package com.zhsq.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhsq.pojo.ShopStore;
import com.zhsq.service.ShopStoreService;
import com.zhsq.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
 
/**
 * 社区商店(ShopStore)表控制层
 *
 * @author makejava
 * @since 2023-09-25 14:29:52
 */
@RestController
@Slf4j
@CrossOrigin
@RequestMapping("/shopStores")
public class ShopStoreController {
    /**
     * 服务对象
     */
    @Autowired
    private ShopStoreService shopStoreService;
 
     /**
   * 分页查询
   * @param page 查询页数
   * @param pageSize 一页显示条数
   * @return ·
   */
   @GetMapping("/page")
   public R<Page<ShopStore>> getAllByPage(
           @RequestParam(defaultValue = "1") int page,
           @RequestParam(defaultValue = "5") int pageSize,
           Integer type
   ){
   	Page<ShopStore> shopStorePage = new Page<>(page, pageSize);
       if (type==1){
           LambdaQueryWrapper<ShopStore> queryWrapper = new LambdaQueryWrapper<ShopStore>();
           queryWrapper.orderByAsc(ShopStore::getDistance);
           shopStoreService.page(shopStorePage,queryWrapper);
           return R.success(shopStorePage);
       }
       if (type==2){
           LambdaQueryWrapper<ShopStore> queryWrapper = new LambdaQueryWrapper<>();
           queryWrapper.orderByDesc(ShopStore::getStar);
           shopStoreService.page(shopStorePage,queryWrapper);
           return R.success(shopStorePage);
       }
       if (type==3){
           LambdaQueryWrapper<ShopStore> queryWrapper = new LambdaQueryWrapper<>();
           queryWrapper.orderByDesc(ShopStore::getCount);
           shopStoreService.page(shopStorePage,queryWrapper);
           return R.success(shopStorePage);
       }
       else {
           //执行查询
           shopStoreService.page(shopStorePage);
           return R.success(shopStorePage);
       }

   }
}
