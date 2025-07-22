package com.labour.mate.repository;

import com.labour.mate.modal.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepo extends JpaRepository<Job, Long> {
    List<Job> findByRecruiterId(Long recruiterId);
}
