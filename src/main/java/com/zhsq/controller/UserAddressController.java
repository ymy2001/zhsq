package com.zhsq.controller;
 
 
 
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhsq.context.BaseContext;
import com.zhsq.mapper.UserAddressMapper;
import com.zhsq.pojo.Result;
import com.zhsq.pojo.UserAddress;
import com.zhsq.pojo.dto.UserAddrDTO;
import com.zhsq.service.UserAddressService;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import com.zhsq.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import java.io.Serializable;
import java.util.List;
 
/**
 * 用户地址管理(UserAddress)表控制层
 *
 * @author makejava
 * @since 2023-09-09 10:13:33
 */
@RestController
@Slf4j
@CrossOrigin
@RequestMapping("/userAddresss")
public class UserAddressController {
    /**
     * 服务对象
     */
    @Autowired
    private UserAddressService userAddressService;
    @Autowired
    private UserAddressMapper userAddressMapper;
     /**
   * 分页查询
   * @param page 查询页数
   * @param pageSize 一页显示条数
   * @return ·
   */
   @GetMapping("/info")
   public R<Page<UserAddress>> getAllByPage(
           @RequestParam(defaultValue = "1") int page,
           @RequestParam(defaultValue = "4") int pageSize){
    Integer currentId = BaseContext.getCurrentId();
    LambdaQueryWrapper<UserAddress> queryWrapper = new LambdaQueryWrapper<>();
    queryWrapper.eq(UserAddress::getUserId,currentId);
    long total = userAddressMapper.selectCount(queryWrapper);
   	//执行查询
    Page<UserAddress> userAddressPage = new Page<>(page, pageSize, total);
    List<UserAddress> userAddressList = userAddressMapper.selectPage(userAddressPage, queryWrapper).getRecords();
    userAddressPage.setRecords(userAddressList);
    return R.success(userAddressPage, total);
   }
   /*
   * 用户添加地址*/
    @PostMapping("/add")
   public Result addToAddr(@RequestBody UserAddrDTO userAddrDTO){
        UserAddress userAddress=new UserAddress();
        BeanUtils.copyProperties(userAddrDTO,userAddress);
        log.info("用户地址插入：{}",userAddress);
        userAddressService.addToAddr(userAddress);
        return Result.success("执行成功");
   }
}
