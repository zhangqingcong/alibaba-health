package com.itheima.service;

import com.itheima.pojo.Member;

import java.util.List;

public interface MemberService {
    /**
     * 根据手机号查询会员表判断是否已注册
     * @param telephone
     * @return
     */
    Member findByTelephone(String telephone);

    /**
     * 注册新会员
     * @param member
     */
    void add(Member member);

    /**
     * 查询相应月份会员数
     * @param months
     * @return
     */
    List<Integer> findMemberCountByMonth(List<String> months);
}
