package com.itheima.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.itheima.constant.MessageConstant;
import com.itheima.entity.Result;
import com.itheima.service.MemberService;
import com.itheima.service.SetmealService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 统计报表数据
 */
@RestController
@RequestMapping("/report")
public class ReportController {

    @Reference
    private MemberService memberService;
    @Reference
    private SetmealService setmealService;

    /**
     * 查询会员信息折线表
     * @return
     */
    @RequestMapping("/getMemberReport")
    public Result getMemberReport() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -12);//获得当前日期之前12个月的日期
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            calendar.add(calendar.MONTH, 1);
            list.add(new SimpleDateFormat("yyyy.MM").format(calendar.getTime()));
        }
        Map<String, Object> map = new HashMap<>();
        map.put("months", list);
        List<Integer> memberCount = memberService.findMemberCountByMonth(list);
        map.put("memberCount",memberCount);

        return new Result(true, MessageConstant.GET_MEMBER_NUMBER_REPORT_SUCCESS,map);
    }

    /**
     * 各套餐预约人数占比
     * @return
     */
    @RequestMapping("/getSetmealReport")
    public Result getSetmealReport(){

        try {

            List<Map<String,Object>> setmealCount = setmealService.findSetmealCount();//查询setmealCount的值
            Map<String,Object> map = new HashMap<>();//res.data.data 返回的第二个data 构造为map
            map.put("setmealCount",setmealCount);//把setmealCount的值放进map里
            List<String> setmealNames = new ArrayList<>();
            for (Map<String,Object> m :setmealCount){
                String name = (String) m.get("name");
                setmealNames.add(name);
            }
            map.put("setmealNames",setmealNames);//把遍历得到的setmealNames集合放进map里
            return new Result(true,MessageConstant.GET_SETMEAL_COUNT_REPORT_SUCCESS,map);
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,MessageConstant.GET_SETMEAL_COUNT_REPORT_FAIL);
        }
    }

}
