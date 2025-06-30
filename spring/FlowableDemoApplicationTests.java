package com.boge.flow;

import org.flowable.engine.ProcessEngine;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.repository.Deployment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FlowableDemoApplicationTests {

    @Autowired
    ProcessEngine processEngine;

    /**
     * 流程部署操作
     *
     */
    @Test
    void deployFlow() {
        RepositoryService repositoryService = processEngine.getRepositoryService();

        Deployment deploy = repositoryService.createDeployment()
                // 一次部署操作可以部署多个流程定义
                .addClasspathResource("process/01-基础篇/FirstFlow.bpmn20.xml")
                .name("第一个流程图")
                .deploy();// 部署的方法
        System.out.println(deploy);
    }

}
