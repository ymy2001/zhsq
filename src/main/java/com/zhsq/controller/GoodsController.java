package com.zhsq.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhsq.mapper.GoodsMapper;
import com.zhsq.pojo.Goods;
import com.zhsq.pojo.GoodsType;
import com.zhsq.service.GoodsService;
import com.zhsq.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

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
                                      @RequestParam(defaultValue = "5") int pageSize,
                                      Integer type,Integer priceType){
       LambdaQueryWrapper<Goods> queryWrapper = new LambdaQueryWrapper<>();
       Long count = goodsMapper.selectCount(queryWrapper);
       QueryWrapper<Goods> ew=new QueryWrapper<>();
       ew.select("IFNULL(sum(soldCount),0) AS giveCount,min(discount) AS minDiscount");
       Map<String, Object> map = goodsService.getMap(ew);
       Object allCount = map.get("giveCount");
       Object minDiscount = map.get("minDiscount");
       log.info("价格类型：{}",priceType);
       if (type<=3){
            if (type==1){
                LambdaQueryWrapper<Goods> lqw=new LambdaQueryWrapper<Goods>()
                        .lt(Goods::getDiscount,1);
                return getPageType(page, pageSize, allCount, minDiscount, lqw,priceType);
            }
            else if (type==2){
                LambdaQueryWrapper<Goods> lqw=new LambdaQueryWrapper<Goods>()
                        .eq(Goods::getIsnewyearselection,1);
                return getPageType(page, pageSize, allCount, minDiscount, lqw,priceType);
            }else if (type==3){
                LambdaQueryWrapper<Goods> lqw=new LambdaQueryWrapper<Goods>()
                        .eq(Goods::getIsbrandselection,1);
                return getPageType(page, pageSize, allCount, minDiscount, lqw,priceType);
            }
       }
       else {
           LambdaQueryWrapper<Goods> lqw=new LambdaQueryWrapper<Goods>()
                   .eq(Goods::getTypeid,type);
           return getPageType(page, pageSize, allCount, minDiscount, lqw,priceType);
       }
       Page<Goods> goodsPage = getGoodsPage(page, pageSize,type,priceType);
       //执行查询
   	return R.success(goodsPage,count,allCount,minDiscount);
   }

   /*
   * 获取分类查询分页*/
    private R<Page<Goods>> getPageType(int page, int pageSize, Object allCount, Object minDiscount, LambdaQueryWrapper<Goods> lqw,Integer priceType) {
        if (priceType==1){
            lqw.orderByAsc(Goods::getOriginalprice);
        } else if (priceType==0) {
            lqw.orderByDesc(Goods::getOriginalprice);
        } else if (priceType==3) {
            Page<Goods> goodsPage = new Page<>(page, pageSize);
            List<Goods> goods1 = goodsMapper.selectPage(goodsPage, lqw).getRecords();
            Long count1 = goodsMapper.selectCount(lqw);
            goodsPage.setRecords(goods1);
            return R.success(goodsPage, count1, allCount, minDiscount);
        }
        Page<Goods> goodsPage = new Page<>(page, pageSize);
        List<Goods> goods1 = goodsMapper.selectPage(goodsPage, lqw).getRecords();
        Long count1 = goodsMapper.selectCount(lqw);
        goodsPage.setRecords(goods1);
        return R.success(goodsPage, count1, allCount, minDiscount);
    }

    private Page<Goods> getGoodsPage(Integer page, Integer pageSize,Integer type ,Integer priceType) {
        Page<Goods> goodsPage = new Page<>(page, pageSize);
        goodsService.page(goodsPage);
        return goodsPage;
    }
}
