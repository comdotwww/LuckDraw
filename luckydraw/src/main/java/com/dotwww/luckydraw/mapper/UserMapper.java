package com.dotwww.luckydraw.mapper;

import com.dotwww.luckydraw.bean.BaseOperationMapper;
import com.dotwww.luckydraw.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseOperationMapper<User> {
    /**
     * 根据username进行查询
     */
    User selectByUsername(String username);
}
