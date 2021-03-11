package com.dotwww.luckydraw;

import com.dotwww.luckydraw.mapper.RecordMapper;
import com.dotwww.luckydraw.model.Record;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

//指定为Spring环境中的单元测试
@RunWith(SpringRunner.class)
//指定为SpringBoot环境的单元测试，Application为启动类
@SpringBootTest(classes = LuckyDrawApplication.class)
//使用事务，在SpringBoot的单元测试中会自动回滚
@Transactional
public class RecordMapperTest {

    @Autowired
    private RecordMapper recordMapper;

    @Test
    public void query(){
        Record r = recordMapper.selectByPrimaryKey(3);
        System.out.println(r);
    }
}