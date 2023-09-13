package com.zhsq.controller;
 
 
 
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhsq.pojo.Goods;
import com.zhsq.service.GoodsService;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import com.zhsq.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import java.io.Serializable;
import java.util.List;
 
/**
 * (Goods)表控制层
 *
 * @author makejava
 * @since 2023-09-13 14:45:42
 */
@RestController
@Slf4j
@CrossOrigin
@RequestMapping("/goodss")
public class GoodsController {
    /**
     * 服务对象
     */
    @Autowired
    private GoodsService goodsService;
 
     /**
   * 分页查询
   * @param page 查询页数
   * @param size 一页显示条数
   * @return ·
   */
   @GetMapping("/page")
   public R<Page<Goods>> getAllByPage(int page, int size){
   	Page<Goods> goodsPage = new Page<>(page, size);
   	LambdaQueryWrapper<Goods> queryWrapper = new LambdaQueryWrapper<>();
   	//TODO 查询条件定制
   
   	//执行查询
   	goodsService.page(goodsPage);
   	return R.success(goodsPage);
   }
}
