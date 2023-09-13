package com.zhsq.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhsq.mapper.NoticeMapper;
import com.zhsq.pojo.Notice;
import com.zhsq.service.NoticeService;
import com.zhsq.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
 
/**
 * 通知(Notice)表控制层
 *
 * @author makejava
 * @since 2023-09-09 10:13:33
 */
@RestController
@Slf4j
@CrossOrigin
@RequestMapping("/notices")
public class NoticeController {
    /**
     * 服务对象
     */
    @Autowired
    private NoticeService noticeService;
    @Autowired
    private NoticeMapper noticeMapper;
 
     /**
   * 分页查询
   * @param page 查询页数
   * @param pageSize 一页显示条数
   * @return ·
   */
   @GetMapping("/notice")
   public R<Page<Notice>> getAllByPage(@RequestParam(defaultValue = "1") int page,
                                       @RequestParam(defaultValue = "4") int pageSize,
                                        Integer noticeId){
   	Page<Notice> noticePage = new Page<>(page, pageSize);
   	LambdaQueryWrapper<Notice> queryWrapper = new LambdaQueryWrapper<>();
       long total = noticeMapper.selectCount(queryWrapper);
   	//查询条件定制
       queryWrapper.orderByDesc(Notice::getCreateTime)
               .eq(noticeId!=null,Notice::getId,noticeId);
   	//执行查询
   	noticeService.page(noticePage,queryWrapper);
   	return R.success(noticePage,total);
   }
}
