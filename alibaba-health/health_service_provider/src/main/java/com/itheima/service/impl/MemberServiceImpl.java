package com.itheima.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.itheima.dao.MemberDao;
import com.itheima.pojo.Member;
import com.itheima.service.MemberService;
import com.itheima.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service(interfaceClass = MemberService.class)
@Transactional
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberDao memberDao;

    /**
     * 根据手机号查询会员
     *
     * @param telephone
     * @return
     */
    @Override
    public Member findByTelephone(String telephone) {
        return memberDao.findByTelephone(telephone);
    }

    /**
     * 新增会员
     *
     * @param member
     */
    @Override
    public void add(Member member) {
        if (member.getPassword() != null) {
            member.setPassword(MD5Utils.md5(member.getPassword()));
        }
        memberDao.add(member);
    }

    /**
     * 根据月份查询会员人数
     * @param months
     * @return
     */
    @Override
    public List<Integer> findMemberCountByMonth(List<String> months) {
        List<Integer> counList = new ArrayList<>();
        for (String month : months) {
            month = month + ".31";
            Integer count = memberDao.findMemberCountBeforeDate(month);
            counList.add(count);
        }
        return counList;
    }
}
