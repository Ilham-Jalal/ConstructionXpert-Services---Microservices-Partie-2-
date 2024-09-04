package com.constructionxpert.tache_service.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "project-service")
public interface ProjectClient {

    @GetMapping("/api/projects/{projectId}")
    Project getProjectById(@PathVariable Long projectId);
}
