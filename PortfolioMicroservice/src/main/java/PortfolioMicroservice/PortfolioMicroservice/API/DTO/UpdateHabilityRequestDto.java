package PortfolioMicroservice.PortfolioMicroservice.API.DTO;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;

public class UpdateHabilityRequestDto {

    @Column(nullable = false)
    private Integer id;

    @Column(nullable = false)
    @Length(min = 2, max = 100)
    private String name;

    @Column(nullable = false)
    private Integer percentage;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getPercentage() {
        return percentage;
    }

}
