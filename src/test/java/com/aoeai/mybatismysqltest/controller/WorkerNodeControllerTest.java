package com.aoeai.mybatismysqltest.controller;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.servlet.MockMvc;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class WorkerNodeControllerTest extends AbstractTestNGSpringContextTests {

    @LocalServerPort
    private int port;

    @Autowired
    private MockMvc mockMvc;

    /**
     * 服务器地址
     */
    private String URL;

    @BeforeClass
    private void init() {
        URL = "http://localhost:" + port;
    }

    @Test
    public void saveTest() throws Exception {
        String port = "2";
        String hostName = "主机";
        String type = "1";

        mockMvc.perform(post(URL + "/workerNode")
                .param("port", port)
                .param("hostName", hostName)
                .param("type", type))
                .andDo(print())
                .andExpect(status().is(CREATED.value()))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.length()").value(7))
                .andExpect(jsonPath("$.id").isNotEmpty())
                .andExpect(jsonPath("$.port").value(port))
                .andExpect(jsonPath("$.hostName").value(hostName))
                .andExpect(jsonPath("$.type").value(type));
    }

    /**
     * 更新测试-正常
     * @throws Exception
     */
    @Test
    public void updateTest() throws Exception {
        String id = "1";
        String port = "26";
        String hostName = "主机6";
        String type = "16";

        mockMvc.perform(patch(URL + "/workerNode")
                .param("id", id)
                .param("port", port)
                .param("hostName", hostName)
                .param("type", type))
                .andDo(print())
                .andExpect(status().is(CREATED.value()))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.length()").value(7))
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.port").value(port))
                .andExpect(jsonPath("$.hostName").value(hostName))
                .andExpect(jsonPath("$.type").value(type));
    }

    /**
     * 更新测试-不传主键时返回异常
     * @throws Exception
     */
    @Test
    public void updateTest1() throws Exception {
        String port = "26";
        String hostName = "主机6";
        String type = "16";

        mockMvc.perform(patch(URL + "/workerNode")
                .param("port", port)
                .param("hostName", hostName)
                .param("type", type))
                .andDo(print())
                .andExpect(status().is(BAD_REQUEST.value()));
    }

    /**
     * 正常数据测试
     * @throws Exception
     */
    @Test
    public void selectByPrimaryKeyTest() throws Exception {
        String id = "1";

        // http://localhost:8080/workerNode/1
        mockMvc.perform(get(URL + "/workerNode/" + id))
                .andDo(print())
                .andExpect(status().isOk());
    }

    /**
     * 不存在数据测试
     * @throws Exception
     */
    @Test
    public void selectByPrimaryKeyTest1() throws Exception {
        String id = "-1";

        // http://localhost:8080/workerNode/1
        mockMvc.perform(get(URL + "/workerNode/" + id))
                .andDo(print())
                .andExpect(status().is(NOT_FOUND.value()));
    }

    @Test
    public void recordsTest() throws Exception {
        String pageSize = "10";
        String pageNum = "1";

        // http://localhost:8080/workerNode?pageSize=10&pageNum=1
        mockMvc.perform(get(URL + "/workerNode")
                .param("pageSize", pageSize)
                .param("pageNum", pageNum))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
