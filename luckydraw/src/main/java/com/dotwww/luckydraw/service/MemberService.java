package com.dotwww.luckydraw.service;

import com.dotwww.luckydraw.mapper.MemberMapper;
import com.dotwww.luckydraw.mapper.SettingMapper;
import com.dotwww.luckydraw.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberMapper memberMapper;

    @Autowired
    private SettingMapper settingMapper;

    /**
     * @param id
     * @return
     */
    public List<Member> queryBySettingId(Integer id) {

        return memberMapper.selectBySettingId(id);
    }

    /**
     * @param member
     * @return
     */
    public int updateByMember(Member member) {

        return memberMapper.updateByPrimaryKeySelective(member);
    }

    /**
     * @param id
     * @return
     */
    public int deleteById(Integer id) {

        return memberMapper.deleteByPrimaryKey(id);
    }
}
