package PortfolioMicroservice.PortfolioMicroservice.API.DTO;

import javax.persistence.Column;

public class DeleteHabilityRequestDto {

    @Column(nullable = false)
    private Integer id;

    public Integer getId() {
        return id;
    }

}
