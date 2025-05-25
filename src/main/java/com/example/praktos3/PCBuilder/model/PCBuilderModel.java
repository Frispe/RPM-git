package com.example.praktos3.PCBuilder.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
@Table(name = "PCBuilder")
public class PCBuilderModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "Last name is required")
    private String lastName;

    @NotBlank(message = "First name is required")
    private String firstName;

    private String middleName;

    @PositiveOrZero(message = "Experience must be positive or zero")
    private int experience;

    @PositiveOrZero(message = "Salary must be positive or zero")
    private double salary;

    public PCBuilderModel() {
    }

    public PCBuilderModel(long id, String lastName, String firstName, String middleName, int experience, double salary) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.experience = experience;
        this.salary = salary;
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getMiddleName() { return middleName; }
    public void setMiddleName(String middleName) { this.middleName = middleName; }
    public int getExperience() { return experience; }
    public void setExperience(int experience) { this.experience = experience; }
    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }
}