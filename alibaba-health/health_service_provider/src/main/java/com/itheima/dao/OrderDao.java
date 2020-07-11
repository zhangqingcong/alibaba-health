package com.itheima.dao;

import com.itheima.pojo.Order;

import java.util.List;
import java.util.Map;

public interface OrderDao {
    /**
     *
     * @param order
     * @return
     */
    List<Order> findByCondition(Order order);

    /**
     *
     * @param order
     */
    void add(Order order);

    /**
     * 根据id查询预约详细信息
     * @param id
     * @return
     */
    Map findById4Detail(Integer id);

    /**
     * 今日预约数
     * @param today
     * @return
     */
    Integer findOrderCountByDate(String today);


    /**
     * 某天之后的新增人数
     * @param thisWeekMonday
     * @return
     */
    Integer findOrderCountAfterDate(String thisWeekMonday);

    /**
     * 某天到诊数
     * @param today
     * @return
     */
    Integer findVisitsCountByDate(String today);

    /**
     * 某天之后到诊数
     * @param thisWeekMonday
     * @return
     */
    Integer findVisitsCountAfterDate(String thisWeekMonday);

    /**
     * 热门套餐
     * @return
     */
    List<Map> findHotSetmeal();
}
