package PortfolioMicroservice.PortfolioMicroservice.API.DTO;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;

public class CreateHabilityRequestDto {

    @Column(nullable = false)
    @Length(min = 3, max = 100)
    private String name;

    @Column(nullable = false)
    private Integer percentage;

    public String getName() {
        return name;
    }

    public Integer getPercentage() {
        return percentage;
    }
}
