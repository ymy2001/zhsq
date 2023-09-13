package com.zhsq.controller;
 
 
 
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhsq.pojo.GoodsType;
import com.zhsq.service.GoodsTypeService;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import com.zhsq.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import java.io.Serializable;
import java.util.List;
 
/**
 * 商品类表(GoodsType)表控制层
 *
 * @author makejava
 * @since 2023-09-13 14:45:42
 */
@RestController
@Slf4j
@CrossOrigin
@RequestMapping("/goodsTypes")
public class GoodsTypeController {
    /**
     * 服务对象
     */
    @Autowired
    private GoodsTypeService goodsTypeService;
 
     /**
   * 分页查询
   * @param page 查询页数
   * @param size 一页显示条数
   * @return ·
   */
   @GetMapping("/page")
   public R<Page<GoodsType>> getAllByPage(int page, int size){
   	Page<GoodsType> goodsTypePage = new Page<>(page, size);
   	LambdaQueryWrapper<GoodsType> queryWrapper = new LambdaQueryWrapper<>();
   	//TODO 查询条件定制
   
   	//执行查询
   	goodsTypeService.page(goodsTypePage);
   	return R.success(goodsTypePage);
   }
}
