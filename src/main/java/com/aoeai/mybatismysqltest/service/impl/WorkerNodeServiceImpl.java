package com.aoeai.mybatismysqltest.service.impl;

import com.aoeai.common.utils.Page;
import com.aoeai.common.utils.PageHelper;
import com.aoeai.common.utils.Pagination;
import com.aoeai.mybatismysqltest.entity.WorkerNode;
import com.aoeai.mybatismysqltest.mapper.WorkerNodeMapper;
import com.aoeai.mybatismysqltest.service.WorkerNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * DB WorkerID Assigner for UID Generator服务
 *
 */
@Service
public class WorkerNodeServiceImpl implements WorkerNodeService {

    @Autowired
    private WorkerNodeMapper workerNodeMapper;

    /**
	 * 添加数据
	 */
    @Override
    public int save(WorkerNode workerNode){
        return workerNodeMapper.save(workerNode);
    }

	/**
	 * 更新数据
	 */
    @Override
    public int update(WorkerNode workerNode){
        return workerNodeMapper.update(workerNode);
    }

	/**
	 * 查询列表(分页)
	 */
    @Override
    public Pagination<WorkerNode> selectList(Map<String,Object> params){
        long totalCount = selectCount(params);
        Page page = new Page(Long.parseLong(params.get("pageSize").toString()), totalCount);
        params.put("offset", page.getOffset());
        params.put("pageable", "true");

        List records = workerNodeMapper.selectList(params);

        return PageHelper.buildPagination(page, records);
    }

    /**
     * 查询列表总数
     */
    @Override
    public long selectCount(Map<String, Object> params){
        return workerNodeMapper.selectCount(params);
    }

    /**
	 * 查询数据
	 */
    @Override
    public WorkerNode selectByPrimaryKey(long id){
        return workerNodeMapper.selectByPrimaryKey(id);
    }


}
