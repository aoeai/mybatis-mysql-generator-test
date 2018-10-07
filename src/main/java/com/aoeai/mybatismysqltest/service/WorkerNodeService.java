package com.aoeai.mybatismysqltest.service;

import com.aoeai.common.utils.Pagination;
import com.aoeai.mybatismysqltest.entity.WorkerNode;

import java.util.Map;

/**
 * DB WorkerID Assigner for UID Generator服务
 *
 */
public interface WorkerNodeService {

    /**
	 * 添加数据
	 */
    int save(WorkerNode workerNode);

	/**
	 * 更新数据
	 */
    int update(WorkerNode workerNode);

	/**
	 * 查询列表
	 */
	Pagination<WorkerNode> selectList(Map<String,Object> params);

    /**
     * 查询列表总数
     */
    long selectCount(Map<String, Object> params);

    /**
	 * 查询数据
	 */
    WorkerNode selectByPrimaryKey(long id);

}
