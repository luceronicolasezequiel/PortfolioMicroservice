package PortfolioMicroservice.PortfolioMicroservice.API.DTO;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public interface IExperienceGetAllResponseDto {
    Integer getId();
    String getPosition();
    String getOrganization();
    @Temporal(TemporalType.TIMESTAMP)
    Date getPeriodFrom();
    @Temporal(TemporalType.TIMESTAMP)
    Date getPeriodTo();
}
