package com.labour.mate.controller;

import com.labour.mate.dto.JobDto;
import com.labour.mate.modal.Job;
import com.labour.mate.service.JobService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/jobs")
public class JobController {

    private final JobService jobService;
    private final ModelMapper modelMapper;
    @Autowired
    public JobController(JobService jobService, ModelMapper modelMapper) {
        this.jobService = jobService;
        this.modelMapper = modelMapper;
    }
    @PostMapping()
    public ResponseEntity<JobDto> createJob(@RequestBody JobDto jobDto) {
        Job job = modelMapper.map(jobDto, Job.class);
        Job savedJob = jobService.createJob(job);
        JobDto savedJobDto = modelMapper.map(savedJob, JobDto.class);
        return ResponseEntity.status(201).body(savedJobDto);
    }
    @GetMapping
    public ResponseEntity<List<Job>> getAllJobs() {
       // log.info("Fetching all jobs");
        return ResponseEntity.ok(jobService.getAllJobs());
    }
    @GetMapping("/{jobId}")
    public ResponseEntity<JobDto> getJobById(@PathVariable Long jobId) {
        Job job = jobService.getJobById(jobId);
        if (job == null) {
            return ResponseEntity.notFound().build();
        }
        JobDto jobDto = modelMapper.map(job, JobDto.class);
        return ResponseEntity.ok(jobDto);
    }
    @GetMapping("/recruit/{recruiterId}")
    public ResponseEntity<List<JobDto>> getJobsByRecruiterId(@PathVariable Long recruiterId) {
        List<Job> jobs = jobService.getJobsByRecruiterId(recruiterId);
        if (jobs.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        List<JobDto> jobDtos = jobs.stream()
                .map(job -> modelMapper.map(job, JobDto.class))
                .toList();
        return ResponseEntity.ok(jobDtos);
    }
    @PutMapping("/{jobId}")
    public ResponseEntity<JobDto> updateJob(@PathVariable Long jobId, @RequestBody JobDto jobDto) {
        Job job = modelMapper.map(jobDto, Job.class);
        job.setJobId(jobId);
        Job updatedJob = jobService.updateJob(job);
        if (updatedJob == null) {
            return ResponseEntity.notFound().build();
        }
        JobDto updatedJobDto = modelMapper.map(updatedJob, JobDto.class);
        return ResponseEntity.ok(updatedJobDto);
    }
    @PutMapping("/{jobId}/close")
    public ResponseEntity<String> closeJob(@PathVariable Long jobId) {
        Job job = jobService.getJobById(jobId);
        if (job == null) {
            return ResponseEntity.notFound().build();
        }
        job.setStatus("CLOSED");
        jobService.updateJob(job);
        return ResponseEntity.ok("Job with ID " + jobId + " has been closed successfully.");
    }

}
