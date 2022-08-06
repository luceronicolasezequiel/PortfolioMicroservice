package PortfolioMicroservice.PortfolioMicroservice.Api.DTO;

import java.util.Date;

public interface IProyectGetAllResponseDto {
    Integer getId();
    String getName();
    Date getDateRealization();
    String getDescription();
    String getUrls();
}
