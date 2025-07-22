package com.labour.mate.recruiter.repository;

import com.labour.mate.recruiter.model.Recruiter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecruiterRepo extends JpaRepository<Recruiter, Long> {

}
