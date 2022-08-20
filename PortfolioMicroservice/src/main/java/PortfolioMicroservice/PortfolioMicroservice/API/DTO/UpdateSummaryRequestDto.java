package PortfolioMicroservice.PortfolioMicroservice.API.DTO;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;

public class UpdateSummaryRequestDto {

    @Column(nullable = false)
    private Integer id;

    @Column(nullable = false)
    @Length(min = 3, max = 1000)
    private String summary;

    public Integer getId() {
        return id;
    }

    public String getSummary() {
        return summary;
    }

}
