package com.aoeai.mybatismysqltest.controller;

import com.aoeai.common.utils.Pagination;
import com.aoeai.helper.ControllerHelper;
import com.aoeai.mybatismysqltest.entity.WorkerNode;
import com.aoeai.mybatismysqltest.service.WorkerNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping(value="workerNode")
public class WorkerNodeController {

    @Autowired
    private WorkerNodeService workerNodeService;

    @PostMapping
    public ResponseEntity save(@Validated WorkerNode workerNode, BindingResult bindingResult){
        workerNode.setId(null);
        workerNode.setCreated(new Date());
        workerNode.setLaunchDate(workerNode.getCreated());
        workerNode.setModified(workerNode.getCreated());

        StringBuilder errors = ControllerHelper.getErrorMessage(bindingResult);
        if (errors != null){
            return ResponseEntity.badRequest().body(errors);
        }

        int result = workerNodeService.save(workerNode);
        if (result == 1){
            return ResponseEntity.status(HttpStatus.CREATED).body(workerNode);
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("保存失败");
    }

    @PatchMapping
    public ResponseEntity update(@Validated WorkerNode workerNode, BindingResult bindingResult){
        if (workerNode.getId() == null){
            return ResponseEntity.badRequest().body("id 不能为空");
        }
        StringBuilder errors = ControllerHelper.getErrorMessage(bindingResult);
        if (errors != null){
            return ResponseEntity.badRequest().body(errors);
        }

        int result = workerNodeService.update(workerNode);
        if (result == 1){
            return ResponseEntity.status(HttpStatus.CREATED).body(workerNodeService.selectByPrimaryKey(workerNode.getId()));
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("更新失败");
    }

    @GetMapping
    public ResponseEntity records(Map<String,Object> params, int pageSize, int pageNum){
        params.put("pageSize", pageSize);
        params.put("pageNum", pageNum);

        Pagination<WorkerNode> pagination = workerNodeService.selectList(params);

        return ResponseEntity.ok(pagination);
    }

}
