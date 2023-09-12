package com.zhsq.controller;
 
 
 
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhsq.context.BaseContext;
import com.zhsq.mapper.UserMapper;
import com.zhsq.pojo.Result;
import com.zhsq.pojo.User;
import com.zhsq.pojo.vo.UserInfoVO;
import com.zhsq.pojo.vo.UserUpVO;
import com.zhsq.service.UserService;
import com.zhsq.utils.JwtUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import com.zhsq.utils.R;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户表(User)表控制层
 *
 * @author makejava
 * @since 2023-09-09 10:13:33
 */
@RestController
@Slf4j
@CrossOrigin
public class UserController {
    /**
     * 服务对象
     */
    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;
    /*
    * login登录验证*/
    @PostMapping("/login")
    public Result<Object> Login(@RequestBody User user){
        log.info("用户登录:{}",user);
        String password = user.getPassword();
        password= DigestUtils.md5DigestAsHex(password.getBytes());
        log.info("加密后：{}",password);
        user.setPassword(password);
        String phone= user.getPhoneNumber();
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("phone_number", phone).eq("password", password);
        User one = userService.getOne(wrapper);
        //登录成功下发令牌
        if (one!=null){
            Map<String, Object> claims=new HashMap<>();
            claims.put("user",one.getUser());
            claims.put("id",one.getId());
            claims.put("phone",one.getPhoneNumber());
            String jwt = JwtUtils.generateJwt(claims);//当前员工信息
            log.info("生成jwt——token：{}",jwt);
            return Result.success("success",jwt);
        }
        return Result.error("登录失败！");
    }
     /**
   * 分页查询
   * @param page 查询页数
   * @param size 一页显示条数
   * @return ·
   */
   @GetMapping("/page")
   public R<Page<User>> getAllByPage(int page, int size){
   	Page<User> userPage = new Page<>(page, size);
   	LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
   	//TODO 查询条件定制
   
   	//执行查询
   	userService.page(userPage);
   	return R.success(userPage);
   }
   /*
   * 用户主页信息*/
    @GetMapping("user/info")
    public Result<UserInfoVO> getUserInfo(){
        log.info("用户主页信息");
        String phone = BaseContext.getCurrentPhone();
        Integer id =BaseContext.getCurrentId();
        log.info("当前用户账号：{}+id:{}",phone,id);
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("phone_number", phone);
        User one = userService.getOne(wrapper);
        UserInfoVO userInfoVO=new UserInfoVO();
        BeanUtils.copyProperties(one,userInfoVO);
        BaseContext.removeCurrentId();
        BaseContext.removeCurrentPhone();
        return Result.success(userInfoVO);
    }
    @PostMapping("/user/revise")
    public Result<Object> update(@RequestBody User user){
        log.info("用户信息修改");
        String phone = BaseContext.getCurrentPhone();
        Integer id =BaseContext.getCurrentId();
        log.info("当前用户账号：{}+id{}",phone,id);
        String phoneNumber = user.getPhoneNumber();
        String username = user.getUsername();
        String password = user.getPassword();
        password= DigestUtils.md5DigestAsHex(password.getBytes());
        log.info("加密后：{}",password);
        user.setPassword(password);
        log.info("修改信息：{}，{}，{}",phoneNumber,username,password);
        //构造条件
        if (phoneNumber==null){
            phoneNumber=phone;
        }
        QueryWrapper<User> wrapper=new QueryWrapper<>();
        wrapper.lambda().eq(phoneNumber!=null,User::getPhoneNumber,phoneNumber);
        User users = userService.getOne(wrapper);
        if (users==null||username!=null||password!=null){
            UpdateWrapper<User> updatePhone= new UpdateWrapper<>();
            updatePhone
                    .lambda()
                    .set(phoneNumber!=null,User::getPhoneNumber,phoneNumber)
                    .set(username!=null,User::getUsername,username)
                    .set(password!=null,User::getPassword,password)
                    .eq(User::getId,id);
            userMapper.update(null, updatePhone);
            UserUpVO userUpVO=new UserUpVO();
            userUpVO.setUsername(username);
            userUpVO.setPhoneNumber(phoneNumber);
            BaseContext.removeCurrentId();
            BaseContext.removeCurrentPhone();
            return Result.success("修改成功",userUpVO);
        }
        BaseContext.removeCurrentId();
        BaseContext.removeCurrentPhone();
        return Result.error("修改失败");

    }


}
