package PortfolioMicroservice.PortfolioMicroservice.BLL;

import PortfolioMicroservice.PortfolioMicroservice.API.DTO.ITaskGetByExperienceResponseDto;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

public interface ITaskService {

    public List<ITaskGetByExperienceResponseDto> getByExperience(Integer experienceId) throws HttpClientErrorException;

}
