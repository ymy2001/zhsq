package com.zhsq.service.impl;

import com.zhsq.mapper.FeeMapper;
import com.zhsq.service.FeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
@SpringBootTest
class FeeServiceImplTest {
    @Autowired
    private FeeMapper feeMapper;
    @Autowired
    private FeeService feeService;
    @Test
    public void getByDate() throws ParseException {
        DateFormat parseFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");
        Date date = parseFormat.parse("2019-03-16 00:00:00");
        System.out.println(date);

    }

}