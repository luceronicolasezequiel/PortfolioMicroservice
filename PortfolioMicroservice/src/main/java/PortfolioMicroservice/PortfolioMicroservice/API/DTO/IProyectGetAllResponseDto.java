package PortfolioMicroservice.PortfolioMicroservice.API.DTO;

import java.util.Date;

public interface IProyectGetAllResponseDto {
    Integer getId();
    String getName();
    Date getDateRealization();
    String getDescription();
    String getUrls();
}
