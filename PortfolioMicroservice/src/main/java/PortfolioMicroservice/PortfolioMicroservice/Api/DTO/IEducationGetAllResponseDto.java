package PortfolioMicroservice.PortfolioMicroservice.Api.DTO;

import java.util.Date;

public interface IEducationGetAllResponseDto {
    Integer getId();
    String getOrganization();
    String getTitle();
    Date getPeriodFrom();
    Date getPeriodTo();
}
