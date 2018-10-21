package com.aoeai.helper;

import com.aoeai.common.utils.Page;

import java.util.Map;

/**
 * 服务类助手
 */
public class ServiceHelper {

    /**
     * 创建分页对象
     * @param totalCount 总记录数
     * @param params 查询条件
     * @return
     */
    public static final Page buildPage(long totalCount, Map<String,Object> params){
        Page page = new Page(Long.parseLong(params.get("pageSize").toString()), totalCount);
        page.setPageNum(Long.parseLong(params.get("pageNum").toString()));
        params.put("offset", page.getOffset());
        params.put("pageable", "true");

        return page;
    }
}
