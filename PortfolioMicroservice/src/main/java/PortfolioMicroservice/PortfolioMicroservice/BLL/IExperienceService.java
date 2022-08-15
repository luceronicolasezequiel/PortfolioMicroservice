package PortfolioMicroservice.PortfolioMicroservice.BLL;

import PortfolioMicroservice.PortfolioMicroservice.API.DTO.CreateExperienceRequestDto;
import PortfolioMicroservice.PortfolioMicroservice.API.DTO.UpdateExperienceRequestDto;
import PortfolioMicroservice.PortfolioMicroservice.DAL.Model.Experience;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

public interface IExperienceService {

    public List<Experience> getAll();

    public Experience create(CreateExperienceRequestDto request) throws HttpClientErrorException;

    public Experience update(UpdateExperienceRequestDto request) throws HttpClientErrorException;

    public Experience save(Experience experience);

}
