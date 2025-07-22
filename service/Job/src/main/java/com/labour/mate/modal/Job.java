package com.labour.mate.modal;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;


@Data
@Table(name = "jobs")
@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jobId;
    private String jobTitle;
    private String jobDescription;
    private String jobLocation;
    private Double wage;
    @ElementCollection
    @CollectionTable(name = "job_skills", joinColumns = @JoinColumn(name = "job_id"))
    @Column(name = "skill")
    private List<String> skillsRequired;
    private Date postedDate;
    private Date closingDate;
    private Integer vacancies;
    private Integer applicationsReceived;
    private Integer selectedCandidates;
    private String status;
    private Long recruiterId;

    public Job(Long jobId, String jobTitle, String jobDescription, String jobLocation, List<String> skillsRequired, Double wage, Date postedDate, Date closingDate, Integer applicationsReceived, Integer selectedCandidates, Long recruiterId, String status, Integer vacancies) {
        this.jobId = jobId;
        this.jobTitle = jobTitle;
        this.jobDescription = jobDescription;
        this.jobLocation = jobLocation;
        this.skillsRequired = skillsRequired;
        this.wage = wage;
        this.postedDate = postedDate;
        this.closingDate = closingDate;
        this.applicationsReceived = applicationsReceived;
        this.selectedCandidates = selectedCandidates;
        this.recruiterId = recruiterId;
        this.status = status;
        this.vacancies = vacancies;
    }

    public Job() {

    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getJobLocation() {
        return jobLocation;
    }

    public void setJobLocation(String jobLocation) {
        this.jobLocation = jobLocation;
    }

    public Double getWage() {
        return wage;
    }

    public void setWage(Double wage) {
        this.wage = wage;
    }

    public List<String> getSkillsRequired() {
        return skillsRequired;
    }

    public void setSkillsRequired(List<String> skillsRequired) {
        this.skillsRequired = skillsRequired;
    }

    public Date getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(Date postedDate) {
        this.postedDate = postedDate;
    }

    public Date getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(Date closingDate) {
        this.closingDate = closingDate;
    }

    public Integer getVacancies() {
        return vacancies;
    }

    public void setVacancies(Integer vacancies) {
        this.vacancies = vacancies;
    }

    public Integer getApplicationsReceived() {
        return applicationsReceived;
    }

    public void setApplicationsReceived(Integer applicationsReceived) {
        this.applicationsReceived = applicationsReceived;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getSelectedCandidates() {
        return selectedCandidates;
    }

    public void setSelectedCandidates(Integer selectedCandidates) {
        this.selectedCandidates = selectedCandidates;
    }

    public Long getRecruiterId() {
        return recruiterId;
    }

    public void setRecruiterId(Long recruiterId) {
        this.recruiterId = recruiterId;
    }
}
