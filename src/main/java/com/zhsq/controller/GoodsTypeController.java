package com.zhsq.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhsq.mapper.GoodsTypeMapper;
import com.zhsq.pojo.GoodsType;
import com.zhsq.service.GoodsTypeService;
import com.zhsq.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
 
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
    @Autowired
    private GoodsTypeMapper goodsTypeMapper;
 
     /**
   * 分页查询
   * @param page 查询页数
   * @param pageSize 一页显示条数
   * @return ·
   */
   @GetMapping("/page")
   public R<Page<GoodsType>> getAllByPage(@RequestParam(defaultValue = "1") int page,
                                          @RequestParam(defaultValue = "20") int pageSize){
   	Page<GoodsType> goodsTypePage = new Page<>(page, pageSize);
   	LambdaQueryWrapper<GoodsType> queryWrapper = new LambdaQueryWrapper<>();
       Long count = goodsTypeMapper.selectCount(queryWrapper);

   	//执行查询
   	goodsTypeService.page(goodsTypePage);
   	return R.success(goodsTypePage,count);
   }
}
