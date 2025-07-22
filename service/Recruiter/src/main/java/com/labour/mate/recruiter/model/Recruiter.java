package com.labour.mate.recruiter.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
@Entity
@Table(name="recruiters")
public class Recruiter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "First name must not be blank")
    @Size(max = 50, message = "First name must not exceed 50 characters")
    @Column(nullable = false)
    private String firstName;

    @NotBlank(message = "Last name must not be blank")
    @Size(max = 50, message = "Last name must not exceed 50 characters")
    @Column(nullable = false)
    private String lastName;

    @NotBlank(message = "Email must not be blank")
    @Email(message = "Email should be valid")
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank(message = "Password must not be blank")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    @Column(nullable = false)
    private String password;
    @NotBlank(message = "Company name must not be blank")
    @Size(max = 100, message = "Company name must not exceed 100 characters")
    @Column(nullable = false)
    private String companyName;
    @NotNull(message = "Rating must not be null")
    private Double rating;

    public Recruiter() {
    }

    public Recruiter(String firstName, Long id, String lastName, String email, String password, Double rating, String companyName) {
        this.firstName = firstName;
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.rating = rating;
        this.companyName = companyName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
}
