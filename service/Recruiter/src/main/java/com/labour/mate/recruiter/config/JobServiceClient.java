package com.labour.mate.recruiter.config;

import com.labour.mate.recruiter.model.JobDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "job-service", url = "${job.service.url}")
public interface JobServiceClient {

    // This defines a POST request to the base URL (http://localhost:8083/api/jobs)
    @PostMapping
    JobDto createJob(@RequestBody JobDto jobDto);
    @GetMapping("/{jobId}")
    JobDto getJobById(@PathVariable("jobId") Long jobId);
    @PutMapping("/{jobId}")
    JobDto updateJob(@PathVariable("jobId") Long jobId, @RequestBody JobDto jobDto);
}