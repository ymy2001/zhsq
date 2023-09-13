package com.zhsq.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhsq.mapper.GoodsMapper;
import com.zhsq.pojo.Goods;
import com.zhsq.service.GoodsService;
import com.zhsq.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
 
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
    @Autowired
    private GoodsMapper goodsMapper;
 
     /**
   * 分页查询
   * @param page 查询页数
   * @param pageSize 一页显示条数
   * @return ·
   */
   @GetMapping("/page")
   public R<Page<Goods>> getAllByPage(@RequestParam(defaultValue = "1") int page,
                                      @RequestParam(defaultValue = "5") int pageSize){
   	Page<Goods> goodsPage = new Page<>(page, pageSize);
   	LambdaQueryWrapper<Goods> queryWrapper = new LambdaQueryWrapper<>();
       Long count = goodsMapper.selectCount(queryWrapper);
       //执行查询
   	goodsService.page(goodsPage);
   	return R.success(goodsPage,count);
   }
}
