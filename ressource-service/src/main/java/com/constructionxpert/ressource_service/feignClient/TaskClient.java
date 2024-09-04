package com.constructionxpert.ressource_service.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "tache-service")
public interface TaskClient {
    @GetMapping("api/tasks/{taskId}")
    Task getTaskId(@PathVariable Long taskId);
}
