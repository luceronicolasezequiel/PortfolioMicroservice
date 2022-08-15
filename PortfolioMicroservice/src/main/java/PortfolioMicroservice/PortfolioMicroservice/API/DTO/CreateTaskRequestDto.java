package PortfolioMicroservice.PortfolioMicroservice.API.DTO;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;

public class CreateTaskRequestDto {
    @Column(nullable = false, length = 100)
    @Length(min = 3, max = 100)
    private String name;

    @Column(nullable = false)
    private Integer experienceId;

    public String getName() {
        return name;
    }

    public Integer getExperienceId() {
        return experienceId;
    }
}
