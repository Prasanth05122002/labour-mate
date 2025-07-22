package com.labour.mate.recruiter.service;

import com.labour.mate.recruiter.config.JobServiceClient;
import com.labour.mate.recruiter.model.JobDto;
import com.labour.mate.recruiter.model.Recruiter;
import com.labour.mate.recruiter.repository.RecruiterRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecruiterService {

    private final RecruiterRepo recruiterRepo;
    private final JobServiceClient jobServiceClient;
    @Autowired
    public RecruiterService(RecruiterRepo recruiterRepo, JobServiceClient jobServiceClient) {
        this.recruiterRepo = recruiterRepo;
        this.jobServiceClient = jobServiceClient;
    }

    public Recruiter registerRecruiter(Recruiter recruiter) {
        return recruiterRepo.save(recruiter);
    }

    public Recruiter updateRecruiter(Long recruiterId, Recruiter recruiter) {
        if (!recruiterRepo.existsById(recruiterId)) {
            throw new IllegalArgumentException("Recruiter with ID " + recruiterId + " does not exist.");
        }
        recruiter.setId(recruiterId);
        return recruiterRepo.save(recruiter);
    }

    public Recruiter getRecruiterById(Long recruiterId) {
        return recruiterRepo.findById(recruiterId)
                .orElseThrow(() -> new IllegalArgumentException("Recruiter with ID " + recruiterId + " does not exist."));
    }
    public JobDto createJobForRecruiter(Long recruiterId, JobDto jobDetails) {
        // 1. Optional: Check if the recruiter actually exists
        recruiterRepo.findById(recruiterId)
                .orElseThrow(() -> new EntityNotFoundException("Recruiter not found with id: " + recruiterId));

        // 2. Set the recruiterId on the job DTO
        jobDetails.setRecruiterId(recruiterId);

        // 3. Call the Job Service using the Feign client
        return jobServiceClient.createJob(jobDetails);
    }

    public JobDto getJobByRecruiterId(Long recruiterId) {
        return jobServiceClient.getJobById(recruiterId);

    }

    public JobDto updateJob(Long jobId, JobDto jobDto) {
        return jobServiceClient.updateJob(jobId, jobDto);
    }
}
