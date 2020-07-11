package com.itheima.service;

import java.util.Map;

public interface ReportService {
    /**
     * 从数据库中查询的数据封装成一个map集合 K为string v是复杂的所以用object
     * @return
     */
    Map<String, Object> getBusinessReportData() throws Exception;
}
