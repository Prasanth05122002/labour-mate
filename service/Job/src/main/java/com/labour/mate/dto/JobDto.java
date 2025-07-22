package com.labour.mate.dto;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.List;

@Slf4j
@Data
public class JobDto {
    private Long jobId;
    private String jobTitle;
    private String jobDescription;
    private String jobLocation;
    private Double wage;
    private List<String> skillsRequired;
    private Date postedDate;
    private Date closingDate;
    private Integer vacancies;
    private Integer applicationsReceived;
    private Integer selectedCandidates;
    private String status;
    private Long recruiterId;
    public JobDto() {
    }
    public JobDto(Long jobId,String jobDescription, String jobTitle, String jobLocation, Double wage, List<String> skillsRequired, Date postedDate, Date closingDate, Integer vacancies, Integer applicationsReceived, Integer selectedCandidates, String status,Long recruiterId) {
        this.jobId = jobId;
        this.jobDescription = jobDescription;
        this.jobTitle = jobTitle;
        this.jobLocation = jobLocation;
        this.wage = wage;
        this.skillsRequired = skillsRequired;
        this.postedDate = postedDate;
        this.closingDate = closingDate;
        this.vacancies = vacancies;
        this.applicationsReceived = applicationsReceived;
        this.selectedCandidates = selectedCandidates;
        this.status = status;
        this.recruiterId = recruiterId;
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

    public Date getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(Date postedDate) {
        this.postedDate = postedDate;
    }

    public Double getWage() {
        return wage;
    }

    public void setWage(Double wage) {
        this.wage = wage;
    }

    public String getJobLocation() {
        return jobLocation;
    }

    public void setJobLocation(String jobLocation) {
        this.jobLocation = jobLocation;
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

    public Integer getSelectedCandidates() {
        return selectedCandidates;
    }

    public void setSelectedCandidates(Integer selectedCandidates) {
        this.selectedCandidates = selectedCandidates;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<String> getSkillsRequired() {
        return skillsRequired;
    }

    public void setSkillsRequired(List<String> skillsRequired) {
        this.skillsRequired = skillsRequired;
    }

    public Long getRecruiterId() {
        return recruiterId;
    }

    public void setRecruiterId(Long recruiterId) {
        this.recruiterId = recruiterId;
    }
}
