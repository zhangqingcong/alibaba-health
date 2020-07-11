package com.itheima.dao;

import com.itheima.pojo.Member;

public interface MemberDao {
    /**
     * 根据手机号查询判断时候为会员
     * @param telephone
     * @return
     */
    Member findByTelephone(String telephone);

    /**
     * 注册会员
     * @param member
     */
    void add(Member member);

    /**
     * 根据月份查询会员数量
     * @param month
     * @return
     */
    Integer findMemberCountBeforeDate(String month);

    /**
     * 查询当日会员数
     * @param today
     * @return
     */
    Integer findMemberCountByDate(String today);

    /**
     * 查询总会员数
     * @return
     */
    Integer findMemberTotalCount();

    /**
     * 本月新增会员数
     * @param firstDay4ThisMonth
     * @return
     */
    Integer findMemberCountAfterDate(String firstDay4ThisMonth);
}
