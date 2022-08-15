package PortfolioMicroservice.PortfolioMicroservice.BLL;

import PortfolioMicroservice.PortfolioMicroservice.API.DTO.GetByExperienceTaskRequestDto;
import PortfolioMicroservice.PortfolioMicroservice.API.DTO.ITaskGetByExperienceResponseDto;
import PortfolioMicroservice.PortfolioMicroservice.DAL.Model.Experience;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

public interface ITaskService {

    public List<ITaskGetByExperienceResponseDto> getByExperience(GetByExperienceTaskRequestDto request) throws HttpClientErrorException;

}
