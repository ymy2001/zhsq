package com.zhsq.fileupload;

import com.zhsq.context.BaseContext;
import com.zhsq.mapper.UserMapper;
import com.zhsq.pojo.Result;
import com.zhsq.pojo.User;
import com.zhsq.service.UserService;
import com.zhsq.utils.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@CrossOrigin
public class FileController {
    @Autowired
    private AliOSSUtils aliOSSUtils;
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;
    /*
    * 头像修改上传*/
    @PostMapping("user/avatar")
    public Result upload(MultipartFile userImage) throws IOException {
        log.info("文件上传{}",userImage.getOriginalFilename());
        //文件大小验证
        long size = userImage.getSize();
        if (size>=3 * 1024 * 1024){
            return Result.error("文件上传失败");
        }
        //调用阿里云oss上传文件
        String url = aliOSSUtils.upload(userImage);
        log.info("文件上传完成:url：{}",url);
        //获取当前用户id,查询需要修改的用户
        Integer currentId = BaseContext.getCurrentId();
        User user = userService.getById(currentId);
        user.setUserImage(url);
        userMapper.updateById(user);
        BaseContext.removeCurrentId();
        return Result.success("修改成功",url);
    }
    /*
    * 动态说说发表上传*/
    @PostMapping("/chatMomentss/upload")
    public Result<List<String>> chatPublic(MultipartFile[] publicImage) throws IOException{
        List<String> imgList=new ArrayList<>();
        //获取图片数组的长度
        int length = publicImage.length;
        if (length>5){
            return Result.error("图片数量超限");
        }
        for (MultipartFile image : publicImage) {
            log.info("文件上传{}",image.getOriginalFilename());
            //文件大小验证
            long size = image.getSize();
            if (size>=10 * 1024 * 1024){
                return Result.error("文件上传失败,大小超限");
            }
            //调用阿里云oss上传文件
            String url = aliOSSUtils.upload(image);
            log.info("文件上传完成:url：{}",url);
            //添加保存链接并返回
            imgList.add(url);
        }
        if (imgList.size()!=length){
            return Result.error("图片上传失败");
        }
        return Result.success(imgList);
    }

}
