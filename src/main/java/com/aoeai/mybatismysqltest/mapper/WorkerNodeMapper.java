package com.aoeai.mybatismysqltest.mapper;

import com.aoeai.mybatismysqltest.entity.WorkerNode;

import java.util.List;
import java.util.Map;

/**
 * DB WorkerID Assigner for UID GeneratorMapper
 *
 */
public interface WorkerNodeMapper {

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
	List<WorkerNode> selectList(Map<String,Object> params);

    /**
     * 查询列表总数
     */
    long selectCount(Map<String, Object> params);

	/**
	 * 查询数据
	 */
	WorkerNode selectByPrimaryKey(long id);

}
