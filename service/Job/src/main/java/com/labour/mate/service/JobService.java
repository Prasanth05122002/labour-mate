package com.labour.mate.service;

import com.labour.mate.dto.JobDto;
import com.labour.mate.modal.Job;
import com.labour.mate.repository.JobRepo;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class JobService {

    private final JobRepo jobRepository;


    @Autowired
    public JobService(JobRepo jobRepository) {
        this.jobRepository = jobRepository;
    }


    public Job createJob(Job job) {
        return jobRepository.save(job);
    }

    public List<Job> getAllJobs() {
        List<Job> jobs = jobRepository.findAll();
        if (jobs.isEmpty()) {
            //log.warn("No jobs found");
            return List.of();
        }
        return jobs;
    }

    public Job getJobById(Long jobId) {
        return jobRepository.findById(jobId)
                .orElseThrow(() -> new IllegalArgumentException("Job with ID " + jobId + " does not exist."));
    }

    public List<Job> getJobsByRecruiterId(Long recruiterId) {
        List<Job> jobs = jobRepository.findByRecruiterId(recruiterId);
        if (jobs.isEmpty()) {
            //log.warn("No jobs found for recruiter with ID " + recruiterId);
            return List.of();
        }
        return jobs;
    }

    public Job updateJob(Job job) {
        if (!jobRepository.existsById(job.getJobId())) {
            throw new IllegalArgumentException("Job with ID " + job.getJobId() + " does not exist.");
        }
        return jobRepository.save(job);
    }
}
