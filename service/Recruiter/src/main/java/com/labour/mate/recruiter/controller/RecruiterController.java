package com.labour.mate.recruiter.controller;

import com.labour.mate.recruiter.dto.RecruiterDTO;
import com.labour.mate.recruiter.model.JobDto;
import com.labour.mate.recruiter.model.Recruiter;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.labour.mate.recruiter.service.RecruiterService;

@RestController
@RequestMapping("/api/recruiters")
@Validated
public class RecruiterController {
    @Autowired
    private RecruiterService recruiterService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/register")
    public ResponseEntity<RecruiterDTO> registerRecruiter(@Valid @RequestBody RecruiterDTO recruiterDTO){
        Recruiter recruiter = modelMapper.map(recruiterDTO, Recruiter.class);
        Recruiter savedRecruiter = recruiterService.registerRecruiter(recruiter);
        RecruiterDTO savedRecruiterDTO = modelMapper.map(savedRecruiter, RecruiterDTO.class);
        return ResponseEntity.status(201).body(savedRecruiterDTO);
    }

    @PutMapping("/{recruiterId}")
    public ResponseEntity<RecruiterDTO> updateRecruiterProfile(
            @PathVariable Long recruiterId,
            @Valid @RequestBody RecruiterDTO recruiterDTO) {
        Recruiter recruiter = modelMapper.map(recruiterDTO, Recruiter.class);
        Recruiter updatedRecruiter = recruiterService.updateRecruiter(recruiterId, recruiter);
        RecruiterDTO updatedRecruiterDTO = modelMapper.map(updatedRecruiter, RecruiterDTO.class);
        return ResponseEntity.ok(updatedRecruiterDTO);
    }

    @GetMapping("/{recruiterId}")
    public ResponseEntity<RecruiterDTO> getRecruiterProfile(@PathVariable Long recruiterId) {
        Recruiter recruiter = recruiterService.getRecruiterById(recruiterId);
        RecruiterDTO recruiterDTO = modelMapper.map(recruiter, RecruiterDTO.class);
        return ResponseEntity.ok(recruiterDTO);
    }
    @PostMapping("/createJob/{recruiterId}")
    public ResponseEntity<String> createJob(@RequestBody JobDto jobDto, @PathVariable Long recruiterId) {
        JobDto createdJob = recruiterService.createJobForRecruiter(recruiterId, jobDto);
        if (createdJob != null) {
            return ResponseEntity.status(201).body("Job created successfully for with jobID: " + createdJob.getJobId());
        } else {
            return ResponseEntity.status(400).body("Failed to create job");
        }

    }
    @GetMapping("/getJob/{jobId}")
    public ResponseEntity<JobDto> getJobByJobId(@PathVariable Long jobId) {
        JobDto jobDto = recruiterService.getJobByRecruiterId(jobId);
        if (jobDto != null) {
            return ResponseEntity.ok(jobDto);
        } else {
            return ResponseEntity.notFound().build();
        }

    }
    @PutMapping("/updateJob/{jobId}")
    public ResponseEntity<JobDto> updateJob(@PathVariable Long jobId, @RequestBody JobDto jobDto) {
        JobDto updatedJob = recruiterService.updateJob(jobId, jobDto);
        if (updatedJob != null) {
            return ResponseEntity.ok(updatedJob);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/closeJob/{jobId}")
    public ResponseEntity<String> closeJob(@PathVariable Long jobId) {
        String closedJob = recruiterService.closeJob(jobId);
        if (closedJob != null) {
            return ResponseEntity.ok(closedJob);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
